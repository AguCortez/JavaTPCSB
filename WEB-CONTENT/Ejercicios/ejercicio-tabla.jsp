<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entites.*"%>
<%@page import="util.*"%>
<%@ include file="menu-header.jsp"%>
<%
		ejercicioUtil ej =new ejercicioUtil();
		LinkedList<Ejercicio> ejers=new LinkedList<Ejercicio>();
%>
	<br>
	<br>
	<div class="container">
	
		
		
	</div>
	<br>
	<div class="container">
	<h1>Lista de Ejercicios</h1>
	<hr>
	<form class="form">
	<table>
		<tr>
			<td><a class = "btn btn-success btn-lg" href="ejercicio-rutina.jsp">Nuevo Ejercicio</a></td>
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
			ejers= ej.getAll();
		
	%> 
		<br>	
		<table class="table table-bordered">
			<tr>
				<th class="text-center">repeticiones</th>
				<th class="text-center">peso</th>
				<th class="text-center">series</th>
				<th class="text-center">descripcion</th>
				<th class="text-center">nombre maquina</th>
				<th class="text-center">id ejercicio</th>

			</tr>
			<%
			for (Ejercicio e: ejers){
			%>
			<tr>
				<td class="text-center"><%=e.getRepeticiones() %></td>
				<td class="text-center"><%=e.getPeso() %></td>
				<td class="text-center"><%=e.getSeries() %></td>
				<td class="text-center"><%=e.getDescripcion() %></td>
				<td class="text-center"><%=e.getNombre_maquina()%></td>
				<td class="text-center"><%=e.getIdEjercicio()%></td>
				
				<td>
				<a href="ejercicio-editar.jsp?dni=<%=e.getIdEjercicio()%>"class="btn btn-warning btn-sm">Editar</a>
			
				<a href="ejercicio-borrar.jsp?dni=<%=e.getIdEjercicio() %>" class= "btn btn-danger btn-sm">Eliminar</a>
				</td>
			</tr>
			<%
			}%>
			
		</table>
	<%@ include file="menu-foot.jsp" %>