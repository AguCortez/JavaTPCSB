
<%@page import="util.*" %>
<%@page import= "entites.*" %>
<%@page import="java.util.LinkedList" %>
<%@include file="../menu-header.jsp" %>
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
<%

    claseUtil c =new claseUtil();
	LinkedList<Clase> clase=new LinkedList<Clase>();
%>
	<br>
	<br>
	<div class="container">
	
		
		
	</div>
	<br>
	<div class="container">
	<h1>Lista de Clase</h1>
	<hr>
	<form class="form">
	<table>
		<tr>
			<td><a class = "btn btn-success btn-lg" href="clases-nuevo.jsp">Nueva Clase</a></td>
			<td></td>
			<td></td>
			<td></td>
			<form class="form-inline">
				<input class="form-control" type="search" name="txtbuscar">
				<input class="btn btn-out" type="submit" name = "accion" value="Buscar">	
			</form>
			<%
				String nombuscar=request.getParameter("txtbuscar");
				if (nombuscar!=null ){
					clase = c.buscaNom(nombuscar);
					System.out.print(nombuscar);
				}else{
					clase= c.getAll();
				}
				
			
			%>
		</tr>
	</table>
	</form>	

		<br>
		<br>
		<br>	
		<table class="table table-bordered">
			<tr>
				<th class="text-center">Id</th>
				<th class="text-center">Total_cupo</th>
				<th class="text-center">Dia</th>
				<th class="text-center">Hora</th>
				<th class="text-center">Legajo_prof</th>
				<th class="text-center">ID tipo de clase</th>
				
			</tr>
			<%
			for ( Clase a: clase){
			%>
			<tr>
				<td class="text-center"><%=a.getCodigo() %></td>
				<td class="text-center"><%=a.getTotal_cupo() %></td>
				<td class="text-center"><%=a.getDia() %></td>
				<td class="text-center"><%=a.getHora() %></td>
				<td class="text-center"><%=a.getLegajo_prof() %></td>
				<td class="text-center"><%=a.getidtipo_clase() %></td>
				
				<td>
				<a href="clases-editar.jsp?id=<%=a.getCodigo() %>"class="btn btn-warning btn-sm">Editar</a>
			
				<a href="clases-borrar.jsp?id=<%=a.getCodigo() %>" class= "btn btn-danger btn-sm">Eliminar</a>
				</td>
			</tr>
			<%	}	%>
			
			
		</table>
<%@ include file="../menu-foot.jsp" %>