
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entites.*"%>
<%@page import="util.*"%>

<%@ include file="../menu-header.jsp"%>
<body>	
<%
	rutinaUtil r =new rutinaUtil();
	LinkedList<Rutina> rutinas=new LinkedList<Rutina>();
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
	<h1>Lista de Rutinas</h1>
	<hr>
	<form class="form">
	<table>
		<tr>
			<td><a class = "btn btn-success btn-lg" href="Rutinas/laRutina.jsp">Mis Rutinas</a></td>
			<td><a class = "btn btn-success btn-lg" href="rutina-nuevo.jsp">Nueva Rutina</a></td>
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
	rutinas= r.getAll();
	%>	
			
		<table class="table table-bordered">
			<tr>
				<th class="text-center">DNI del socio</th>
				<th class="text-center">dia</th>
				<th class="text-center">id-Rutina</th>
				<th class="text-center"> Profesional</th>
				
			</tr>
			<%
			for (Rutina ru: rutinas){
			%>
			<tr>
				<td class="text-center"><%=ru.getDni() %></td>
				<td class="text-center"><%=ru.getDia() %></td>
				<td class="text-center"><%=ru.getIdRutina() %></td>
				<td class="text-center"><%=ru.getLegajo() %></td>
				
				<% Rutina ri=new Rutina();
					rutinaUtil ra=new rutinaUtil();
					ri=ra.getByidRutina(ru.getIdtiporutina());   %>
				
				
				<td>
				<a href="rutina-editar.jsp?id=<%=ru.getDni() %>"class="btn btn-warning btn-sm">Editar</a>
			
				<a href="rutina-borrar.jsp?id=<%=ru.getIdRutina() %>" class= "btn btn-danger btn-sm">Eliminar</a>
				</td>
			</tr>
			<%	}	%>
			
		</table>
<%@ include file="../menu-foot.jsp" %>