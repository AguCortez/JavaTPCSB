<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entites.*"%>
<%@page import="util.*"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Añandiendo ejercicios</title>
</head>
<body>
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
				<a href="ejercicio-editar.jsp?idEj=<%=e.getIdEjercicio()%>"class="btn btn-warning btn-sm">Editar</a>
			
				<a href="ejercicio-borrar.jsp?idEj=<%=e.getIdEjercicio() %>" class= "btn btn-danger btn-sm">Eliminar</a>
				</td>
			</tr>
			<%
			}%>
</body>
</html>