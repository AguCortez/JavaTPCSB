
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entites.*"%>
<%@page import="util.sociosUtil"%>
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
		<label>Socios</label>
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
	sociosUtil s =new sociosUtil();
	LinkedList<Socio> socios=new LinkedList<Socio>();
%>
	<br>
	<br>
	<div class="container">
	
		
		<%
		String nombuscar= request.getParameter("txtbuscar");
 		if(nombuscar== null || nombuscar.equals("")){
 			socios= s.getAll();
			
		
		}else{socios=s.buscabyNombre(nombuscar);}
 		
			%>
	</div>
	<br>
	<div class="container">
	<h1>Lista de Socios</h1>
	<hr>
	<form>
	<table>
		<tr>
			<td><a class = "btn btn-success btn-lg" href="tablanuevosoc.jsp">Nuevo Socio</a></td>
			<td>
			<input class="form-control" type="text" name="txtbuscar"></td>
			<td>
			<input class="btn btn" type="submit" value="Buscar">	
			</td>
		</tr>
	</table>
	</form>	
		<br>
		<br>
		<br>	
		<table class="table table-bordered">
			<tr>
				<th class="text-center">Nombre</th>
				<th class="text-center">Apellido</th>
				<th class="text-center">Celular</th>
				<th class="text-center">DNI</th>
				<th class="text-center">Tipo Socio</th>
			</tr>
			<%
			for (Socio a: socios){
			%>
			<tr>
				<td class="text-center"><%=a.getNombre_soc() %></td>
				<td class="text-center"><%=a.getApellido_soc() %></td>
				<td class="text-center"><%=a.getCelu() %></td>
				<td class="text-center"><%=a.getDni() %></td>
				<td class="text-center"><%=a.getTipo() %></td>
				<td>
				<a href="editarSocio.jsp"class="btn btn-warning btn-sm">Editar</a>
			
				<a class= "btn btn-danger btn-sm">Eliminar</a>
				</td>
			</tr>
			<%}
			}%>
			
		</table>
	</div>
</body>
</html>