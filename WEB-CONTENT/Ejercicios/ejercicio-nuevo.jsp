
<%@page import="java.util.LinkedList"%>
<%@page import="entites.Ejercicio"%>
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
<% 
	HttpSession sesion= request.getSession();
	String user, lvl;	
if(sesion.getAttribute("usuario")!=null && sesion.getAttribute("nivel")!=null)
	{
	user=sesion.getAttribute("usuario").toString();
	lvl=sesion.getAttribute("nivel").toString();

	}
else{
	out.print("<script>location.replace('index.jsp');</script>"); 
}

ejercicioUtil ej =new ejercicioUtil();
String descripcion; 
%>




<body>
	<div class = "conteiner">
		<h1>Agregar nuevo ejercicio </h1>	
		<hr>
		<form action="" method= "post" class = "form-control" style = "width: 500 px; height: 400 px">
				
				Descripcion:
				<input type = "text" name = "txtDescripcion" class = "form-control"/>				
				<br>
				<br>
				<br>
				<br>
				<input type = "Submit" value= "Guardar" class = "btn btn-primary btn-lg" name = "Guardar"/>
				<br>
				<br>
				<a href= "ejercicio-tabla.jsp"> Regresar</a>				
		
		
		</form>
	</div>
</body>
</html>

<%
if ( null !=request.getParameter("Guardar") )
{
		
	    
		descripcion = request.getParameter("txtDescripcion");	
Ejercicio e = new Ejercicio();
e.setDescripcion(descripcion);


	if ( descripcion!= "" )
		
	{
		ej.NuevoEjercicio(e);
		response.sendRedirect("ejercicio-tabla.jsp");
	}
	
	
	else
		
	{
		out.print("Rellenar el campo");

	}
}
	
	%>