<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entites.*"%>
<%@page import="util.rutinaUtil"%>
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
		<label>Rutinas</label>
	</header>
<%
		HttpSession sesion = request.getSession();
		Usuario usu = (Usuario) sesion.getAttribute("usuario");
		response.setContentType("text/html");
		PrintWriter mostrar = response.getWriter();
		rutinaUtil r =new rutinaUtil();
		LinkedList<Rutina> rutinas=new LinkedList<Rutina>();
%>
	<br>
	<br>
	<div class="container">
	
		
		
	</div>
	<br>
	<div class="container">
	<h1>Lista de Rutinas</h1>
	<hr>
	<form class="form">
	<table>
		<tr>
			<td><a class = "btn btn-success btn-lg" href="tablaNuevaRutina.jsp">Nuevo Socio</a></td>
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
		String idbuscar= request.getParameter("txtbuscar");
 		if(idbuscar== null || idbuscar.equals("")){
 			rutinas= r.getAll();
			
		
		}else{rutinas=r.getByidRutina(idbuscar);}
 		
			%>
		<br>
		<br>
		<br>	
		<table class="table table-bordered">
			<tr>
				<th class="text-center">ID rutina</th>
				<th class="text-center">DIA</th>
				<th class="text-center">DNI</th>
				<th class="text-center">LEGAJO</th>
			</tr>
			<%
			for (Rutina r: rutinas){
			%>
			<tr>
				<td class="text-center"><%=r.getIdRutina() %></td>
				<td class="text-center"><%=r.getDia() %></td>
				<td class="text-center"><%=r.getDni() %></td>
				<td class="text-center"><%=r.getLegajo() %></td>
				
				<td>
				<a href="editarRutina.jsp?dni=<%=r.getIdRutina() %>"class="btn btn-warning btn-sm">Editar</a>
			
				<a href="borraRutina.jsp?dni=<%=r.getIdRutina() %>" class= "btn btn-danger btn-sm">Eliminar</a>
				</td>
			</tr>
			<%}
			}%>
			
		</table>
	</div>
</body>
</html>