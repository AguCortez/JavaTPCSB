<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entites.*"%>
<%@page import="util.ejercicioUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" 
 integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
</head>

<body>
	<header>
		<label>Ejercicios</label>
	</header>
<%
		HttpSession sesion = request.getSession();
		Ejercicio ejer = (Ejercicio) sesion.getAttribute("ejercicio");
		response.setContentType("text/html");
		PrintWriter mostrar = response.getWriter();
		
		if (ejer==null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("ejercicio-error.jsp");
			rd.forward(request, response);
			} else {
		ejercicioUtil ej =new ejercicioUtil();
		LinkedList<Ejercicio> ejers=new LinkedList<Ejercicio>();
%>
	<br>
	<br>
	<div class="container">
	
		
		
	</div>
	<br>
	<div class="container">
	<h1>Lista de Socios</h1>
	<hr>
	<form class="form">
	<table>
		<tr>
			<td><a class = "btn btn-success btn-lg" href="ejercicio-nuevo.jsp">Nuevo Ejercicio</a></td>
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
		int idbuscar=Integer.parseInt(request.getParameter("txtbuscar"));
		if(idbuscar== null ){ 
			ejers= ej.getAll();
		}
		else{ejers=ej.buscabyID(idbuscar);} 
	%> -
		<br>
		<br>
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
			<%}
			}%>
			
		</table>
	</div>
</body>
</html>