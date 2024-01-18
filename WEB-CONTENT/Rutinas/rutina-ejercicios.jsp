<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entites.*"%>
<%@page import="util.*"%>   
<!DOCTYPE html>
<html> TABLA CON TODOS LOS EJERCICIOS, AL AÑADIR PINTAR EJERCICIO DE VERDE, PUEDE INCLUIR NUEVO EJERCICIO
<head>
<meta charset="ISO-8859-1">
<title>Añandiendo ejercicios</title>
</head>
<body>
<%

ejercicioUtil eu = new ejercicioUtil();
LinkedList<Ejercicio> Ejercicios = eu.getAll();
				
%> 
		<br>	
		<table class="table table-bordered">
			<tr>
				<th class="text-center">repeticiones</th>


			</tr>
			<%
			for (Ejercicio e: Ejercicios){
			%>
			<tr>
				<td class="text-center"><%=e.getDescripcion() %></td>
			
				<td>
				<a href="ejercicio-editar.jsp?idEj=<%=e.getIdtipo() %>"class="btn btn-warning btn-sm">+</a>
			
				
				</td>
			</tr>
			<%
			}%>
</body>
</html>