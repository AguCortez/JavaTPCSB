
<%@page import="java.util.LinkedList"%>
<%@page import="entites.Reserva"%>
<%@page import="util.reservaUtil"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.Date"%>

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
%>
</head>
<body>
	<div class = "conteiner">
		<h1>Agregar nueva reserva </h1>	
		<hr>
		<form action="" method= "post" class = "form-control" style = "width: 500 px; height: 400 px">
				CODIGO DE CLASE:
				<input type = "text" name= "txtCodigo" class = "form-control"/>
				<br>
				DNI:
				<input type = "text" name= "txtDni" class = "form-control"/>		
				<br>
				FECHA:
				<input type = "text" name= "txtFecha" class = "form-control"/>		
				<br>
				<br>
				<input type = "Submit" value= "Guardar" class = "btn btn-primary btn-lg" name = "Guardar"/>
				<br>
				<br>
				<a href= "reservas-tabla.jsp"> Regresar</a>				
		
		
		</form>
	</div>
</body>
</html>
<%	reservaUtil r =new reservaUtil();

	String codigo,dni,fecha ;

	codigo = request.getParameter("txtCodigo");
	dni = request.getParameter("txtDni");
	fecha = request.getParameter("txtFecha");
  
	
	
	if ( null !=request.getParameter("Guardar") )
		
	{	
		//reservaUtil.altaReserva(Integer.parseInt(dni), //contrase);
		r.altaReserva(Integer.parseInt(dni), codigo, fecha);
		response.sendRedirect("reservas-tabla.jsp");
	}
	
else
		
	{
		out.print("Rellenar todos los campos");

	}
	
	
	%>