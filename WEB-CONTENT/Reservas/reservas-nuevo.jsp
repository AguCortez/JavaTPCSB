
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
		
				Clase que desea reservar:
				
			<div class="input-group mb-3">
  				<form action="" method= "post" class = "form-control" style = "width: 500 px; height: 400 px">	
				ID Clase: 
					<input type = "text" name= "txtIdClase" class = "form-control"/>	
				<br>
				DNI:
					<input type = "text" name= "txtDni" class = "form-control"/>		
				<br>
				ID RESERVA:
					<input type = "text" name = "txtId_reserva" class = "form-control"/>
				<br>
			
				<br>  
				<input type = "Submit" value= "Guardar" class = "btn btn-primary btn-lg"/>
				<br>
				<br>
				<a href= "reservas-tabla.jsp"> Regresar</a>	
				</form>			
		</div>
		
		
	</div>
</body>
</html>
<%	reservaUtil r =new reservaUtil();

	String codigo,dni, id_reserva, fecha;

	codigo = request.getParameter("txtIdClase");
	dni = request.getParameter("txtDni");
	id_reserva = request.getParameter ("txtId_reserva");
	
	if ( null !=request.getParameter("Guardar") ){
	if (codigo!= ""  && dni != ""  && id_reserva != ""  )
	{	r.altaReserva(Integer.parseInt(id_reserva),Integer.parseInt(dni), codigo);
		response.sendRedirect("reservas-tabla.jsp");
	}
	
else
		
	{
		out.print("Rellenar todos los campos");

	}
	}
	
	%>