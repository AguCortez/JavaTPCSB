
<%@page import="java.util.LinkedList"%>
<%@page import="entites.Profesional"%>
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
	<div class = "conteiner">
		<h1>Agregar nuevo profesional</h1>	
		<hr>
		<form action="" method= "post" class = "form-control" style = "width: 500 px; height: 400 px">
				DNI:
				<input type = "text" name= "txtDNI" class = "form-control"/>
				<br>
				CONTRASE:
				<input type = "text" name = "txtcontra" class = "form-control"/>
				<br>
				NOMBRE:
				<input type = "text" name = "txtNombre" class = "form-control"/>
				<br>
				APELLIDO:
				<input type = "text" name = "txtApellido" class = "form-control"/>
				<input type = "Submit" value= "Guardar" class = "btn btn-primary btn-lg"/>
				<br>
				<br>
				<a href= "profesional-tabla.jsp"> Regresar</a>				
		
		
		</form>
	</div>
</body>
</html>
<%	profesionalUtil p =new profesionalUtil();


	String  dni,contrase, tipo, nom, ape;

	dni = request.getParameter("txtDNI");
	tipo = request.getParameter("txtTipo");
	nom = request.getParameter ("txtNombre");
	contrase = request.getParameter ("txtcontra");
	ape = request.getParameter ("txtApellido");
	
	if (nom!= null && tipo != null && contrase != null && ape != null )
	{
		p.altaProfesional(nom, ape,Integer.parseInt(dni), contrase);


		response.sendRedirect("profesional-tabla.jsp");
	}
	%>