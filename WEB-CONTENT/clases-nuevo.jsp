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
	out.print("<script>location.replace('index.jsp');</script>"); 
}
%>
<%	
claseUtil c =new claseUtil();
String dniprof="";
profesionalUtil pu=new profesionalUtil();
%>
<body>
	<div class = "conteiner">
		<h1>Agregar nueva clase </h1>	
		<hr>
		<form action="" method= "post" class = "form-control" style = "width: 500 px; height: 400 px">
				
				TOTAL CUPO:
				<input type = "text" name= "txtTotal_cupo" class = "form-control"/>
				<br>
				ID:
				<input type = "text" name= "txtId" class = "form-control"/>		
				<br>
				NOMBRE:
				<input type = "text" name = "txtNombre" class = "form-control"/>
				<br>
				ACTUAL CUPOS:
				<input type = "text" name = "txtActual_cupos" class = "form-control"/>
				<br>
				DIA:
				<input type = "text" name = "txtDia" class = "form-control"/>
				<br>
				HORA:
				<input type = "text" name = "txtHora" class = "form-control"/>
				<br>
						
				<br>
				
				DESCRIPCION:
				<input type = "text" name = "txtDescripcion" class = "form-control"/>
				<br>
				<br>
				
				<input type = "Submit" value= "Guardar" class = "btn btn-primary btn-lg"/>
				<br>
				<br>
			
				Ingrese un DNI de profesional vlaido.
			
				<a href= "clases-tabla.jsp"> Regresar</a>				
		
		
		</form>
	</div>
</body>

<%	

String nombre, descripcion, dia, total_cupo, id, actual_cupo,  hora, legajo_prof; 

total_cupo = request.getParameter("txtTotal_cupo");
id = request.getParameter("txtId");
nombre = request.getParameter ("txtNombre");
actual_cupo = request.getParameter ("txtActual_cupos");
dia = request.getParameter("txtDia");
hora = request.getParameter("txtHora");

descripcion = request.getParameter("txtDescripcion");



if (total_cupo!= null && id!= null && nombre!= null && actual_cupo!= null && dia!= null && hora!= null &&  descripcion!= null)
	{
		c.altaClase(Integer.parseInt(id), Integer.parseInt(total_cupo), nombre,	Integer.parseInt(actual_cupo), dia, hora, descripcion, 2);
		response.sendRedirect("clases-tabla.jsp");
	}
	%>