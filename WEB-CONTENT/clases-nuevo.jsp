
<%@page import="java.util.LinkedList"%>
<%@page import="entites.Reserva"%>
<%@page import="util.reservaUtil"%>
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
		<h1>Agregar nueva reserva </h1>	
		<hr>
		<form action="" method= "post" class = "form-control" style = "width: 500 px; height: 400 px">
				CODIGO:
				<input type = "text" name= "txtCodigo" class = "form-control"/>
				<br>
				DNI:
				<input type = "text" name= "txtDni" class = "form-control"/>		
				<br>
				ID RESERVA:
				<input type = "text" name = "txtId_reserva" class = "form-control"/>
				<br>
				FECHA:
				<input type = "text" name = "txtFecha" class = "form-control"/>
				<br>
				<br>
				<input type = "Submit" value= "Guardar" class = "btn btn-primary btn-lg"/>
				<br>
				<br>
				<a href= "reservas-tabla.jsp"> Regresar</a>				
		
		
		</form>
	</div>
</body>
</html>
<%	reservaUtil r =new reservaUtil();


String codigo;
Integer dni, id_reserva, fecha;

codigo = request.getParameter("txtCodigo");
dni = request.getParameter("txtDni");
id_reserva = request.getParameter ("txtId_reserva");
fecha = request.getParameter ("txtFecha");


	if (codigo!= null && dni != null && id_reserva != null && fecha != null)
	{
		r.altaReserva(Integer.parseInt(id_reserva), codigo, dni, fecha);
		response.sendRedirect("reservas-tabla.jsp");
	}
	%>