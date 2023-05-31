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




<body>
	<%
		int id_reserva1= Integer.parseInt(request.getParameter("id_reserva"));
		reservaUtil r =new reservaUtil();
	    Reserva lareserva=r.getByIdreserva(id_reserva1);
	%>

 	<div class = "conteiner">
		<h1>Modificar reserva</h1>
		<hr>

		<form action="" method= "post" class = "form-control" style = "width: 500 px; height: 400 px">
				CODIGO:
				<input type = "text" name= "txtCodigo" class = "form-control" value="<%= lareserva.getCodigo() %>"/>	
				<br>
				DNI:
				<input type = "text" name= "txtDni" class = "form-control" value="<%= lareserva.getDni() %>"/>		
				<br>
				ID RESERVA:
				<input type = "text" name = "txtId_reserva" class = "form-control" value="<%= lareserva.getId_reserva() %>"/>
				<br>
				FECHA:
				<input type = "text" name = "txtFecha" class = "form-control" value="<%= lareserva.getDate() %>"/>
				<br>
				<br>
				<input type = "Submit" value= "Editar" class = "btn btn-primary btn-lg" name = "Editar"/>
				<br>
				
				<br>
				<a href= "reservas-tabla.jsp"> Regresar</a>				
           <%
            String codigo,dni,fecha,id_reserva;            
          
           codigo = request.getParameter("txtCodigo");
			dni = request.getParameter("txtDni");
			id_reserva = request.getParameter ("txtId_reserva");
			fecha = request.getParameter("txtFecha");
			
			if ( null !=request.getParameter("Editar") )
			{
			
			if (codigo!= ""  && dni != ""  && id_reserva != "" && fecha != "" )
			{
				lareserva.setCodigo(Integer.parseInt(codigo));
				lareserva.setDni(Integer.parseInt(dni));
				lareserva.setId_reserva(Integer.parseInt(id_reserva));
				lareserva.setFecha(fecha);
				
				
				r.modReserva(lareserva, id_reserva1);
				response.sendRedirect("reservas-tabla.jsp");
			}
			
			else
				
			{
				out.print("Rellenar todos los campos");

			}
			}
			
			
			
%>
		</form> 
	</div>
</body>
</html>




