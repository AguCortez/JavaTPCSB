
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entites.*"%>
<%@page import="util.profesionalUtil"%>
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
		<label>Profesionales</label>
	</header>
<%
		HttpSession sesion = request.getSession();
		Usuario usu = (Usuario) sesion.getAttribute("usuario");
		response.setContentType("text/html");
		PrintWriter mostrar = response.getWriter();
		
		if (usu==null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("invalid.jsp");
			rd.forward(request, response);
		} else {
	profesionalUtil p =new profesionalUtil();
	LinkedList<Profesional> profesionales=new LinkedList<Profesional>();
	Profesional elProf= new Profesional(); 
%>
	<br>
	<br>
	<div class="container">
	
		
		
	</div>
	<br>
	<div class="container">
	<h1>Lista de Profesionales</h1>
	<hr>
	<form class="form">
	<table>
		<tr>
			<td><a class = "btn btn-success btn-lg" href="tablaNuevoProf.jsp">Nuevo Profesional</a></td>
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
		String legajo= request.getParameter("txtbuscar");
 		if(legajo== null || legajo.equals("")){
 			profesionales= p.getAll();
			
		
		}else{
			int legajo2= Integer.parseInt(legajo);
			elProf= p.getBylegajo(legajo2);}
 		
			%>
		<br>
		<br>
		<br>	
		<table class="table table-bordered">
			<tr>
				<th class="text-center">LEGAJO</th>
				<th class="text-center">Nombre</th>
				<th class="text-center">Apellido</th>

			</tr>
			<%
			for (Profesional pr: profesionales){
			%>
			<tr>
				<td class="text-center"><%=pr.getLegajo() %></td>
				<td class="text-center"><%=pr.getNombre() %></td>
				<td class="text-center"><%=pr.getApellido() %></td>
				<td>
				<a href="editarProfesional.jsp?dni=<%=pr.getLegajo() %>"class="btn btn-warning btn-sm">Editar</a>
			
				<a href="borraProfesional.jsp?dni=<%=pr.getLegajo() %>" class= "btn btn-danger btn-sm">Eliminar</a>
				</td>
			</tr>
			<%}
			}%>
			
		</table>
	</div>
</body>
</html>