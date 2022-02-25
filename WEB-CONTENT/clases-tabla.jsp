
<%@page import="util.*" %>
<%@page import= "entites.*" %>
<%@page import="java.util.LinkedList" %>
<%@include file="menu-header.jsp" %>

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
			<td><a class = "btn btn-success btn-lg" href="tablanuevosoc.jsp">Nueva  Clase</a></td>
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
			
	      clase= c.getAll();
			
		
		
 		
			%>
		<br>
		<br>
		<br>	
		<table class="table table-bordered">
			<tr>
				<th class="text-center">Total_cupo</th>
				<th class="text-center">Id</th>
				<th class="text-center">Nombre</th>
				<th class="text-center">Actual_cupos</th>
				<th class="text-center">Dia</th>
				<th class="text-center">Hora</th>
				<th class="text-center">Legajo_prof</th>
				<th class="text-center">Descripcion</th>
				
			</tr>
			<%
			for ( Clase a: clase){
			%>
			<tr>
				<td class="text-center"><%=a.getTotal_cupo() %></td>
				<td class="text-center"><%=a.getId() %></td>
				<td class="text-center"><%=a.getNombre() %></td>
				<td class="text-center"><%=a.getActual_cupos() %></td>
				<td class="text-center"><%=a.getDia() %></td>
				<td class="text-center"><%=a.getHora() %></td>
				<td class="text-center"><%=a.getLegajo_prof() %></td>
				<td class="text-center"><%=a.getDescripcion() %></td>
				
				<td>
				<a href="clases-editar.jsp?dni=<%=a.getId() %>"class="btn btn-warning btn-sm">Editar</a>
			
				<a href="clases-borrar.jsp?dni=<%=a.getId() %>" class= "btn btn-danger btn-sm">Eliminar</a>
				</td>
			</tr>
			<%	}	%>
			
		</table>
<%@inlcude file="menu-foot.jsp" %>