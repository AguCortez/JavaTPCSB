
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entites.*"%>
<%@page import="util.sociosUtil"%>
<%@ include file="../menu-header.jsp"%>
<body>	
<%
	sociosUtil s =new sociosUtil();
	LinkedList<Socio> socios=new LinkedList<Socio>();
%>	
<% 
	HttpSession sesion= request.getSession();
	String user, lvl;	
if(sesion.getAttribute("usuario")!=null && sesion.getAttribute("nivel")!=null)
	{
	user=sesion.getAttribute("usuario").toString();
	lvl=sesion.getAttribute("nivel").toString();

	}
else{
	out.print("<script>location.replace('index.jsp');</script>"); 
}
%>	
	<div class="container">
	<h1>Lista de Socios</h1>
	<hr>
	<form class="form">
	<table>
		<tr>
			<td><a class = "btn btn-success btn-lg" href="socio-nuevo.jsp">Nuevo Socio</a></td>
			<td></td>
			<td></td>
			<td></td>
			
			<td>
			<input class="form-control" type="text" name="txtbuscar">
			</td>
			<td>
			<input class="btn btn" type="submit" value="Buscar">	
			</td>
		</tr>
	</table>
	</form>	
	<%
	socios= s.getAll();
	%>	
			
		<table class="table table-bordered">
			<tr>
				<th class="text-center">DNI</th>
				<th class="text-center">Tipo Socio</th>
				<th class="text-center">Nombre</th>
				<th class="text-center">Apellido</th>
				<th class="text-center">Celular</th>
			</tr>
			<%
			for (Socio a: socios){
			%>
			<tr>
				<td class="text-center"><%=a.getDni() %></td>
				<td class="text-center"><%=a.getTipo() %></td>
				<td class="text-center"><%=a.getNombre_soc() %></td>
				<td class="text-center"><%=a.getApellido_soc() %></td>
				<td class="text-center"><%=a.getCelu() %></td>
				<td>
				<a href="socio-editar.jsp?dni=<%=a.getDni() %>"class="btn btn-warning btn-sm">Editar</a>
			
				<a href="socio-borrar.jsp?dni=<%=a.getDni() %>" class= "btn btn-danger btn-sm">Eliminar</a>
				</td>
			</tr>
			<%	}	%>
			
		</table>
<%@ include file="../menu-foot.jsp" %>
