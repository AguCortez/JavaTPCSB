<%@page import="java.util.LinkedList"%>
<%@page import="entites.*"%>
<%@page import="java.sql.*" %>
<%@page import="util.*"%>
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
<% 
	HttpSession sesion= request.getSession();
	String user, lvl;	
if(sesion.getAttribute("usuario")!=null && sesion.getAttribute("nivel")!=null)
	{
	user=sesion.getAttribute("usuario").toString();
	lvl=sesion.getAttribute("nivel").toString();

	}
else{
	out.print("<script>location.replace('../index.jsp');</script>"); 
}
%>
<%	
tipoclaseUtil c =new tipoclaseUtil();
%>
<body>
	<div class = "conteiner">
		<h1>Agregar nueva clase </h1>	
		<hr>
		<form action="" method= "post" class = "form-control" style = "width: 500 px; height: 400 px">				
				<br>
				<br>
				Nombre:
				<input type = "text" name= "txtNombre" class = "form-control"/>		
				<br>
				Descripcion:
				<input type = "text" name = "txtDescripcion" class = "form-control"/>

				<br>
				<br>
				<input type = "Submit" value= "Guardar" class = "btn btn-primary btn-lg" name = "Guardar"/>
				<br>
				<br>
		</form>
	</div>
</body>

<%

if ( null !=request.getParameter("Guardar") )
{
	
		String  nombre, descripcion; 
	
		nombre = request.getParameter ("txtNombre");
		descripcion = request.getParameter("txtDescripcion");
		
		
		if (nombre!= "" && descripcion!= "")
			{
				c.altaTipoClase( nombre, descripcion);
				response.sendRedirect("tipoclases-tabla.jsp");
			}
		else
			
		{
			out.print("Rellenar todos los campos");
		}
	}
	%>