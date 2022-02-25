<%@page import="java.util.LinkedList"%>
<%@page import="entites.Clase"%> 
<%@page import="util.claseUtil"%>
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
	<%
		int id1= Integer.parseInt(request.getParameter("id"));
	    claseUtil c =new claseUtil();
	    Clase laclase=c.getbyCodigo(codigo1);
	%>

 	<div class = "conteiner">
		<h1>Modificar clase</h1> 
		<hr>

		<form action="" method= "post" class = "form-control" style = "width: 500 px; height: 400 px">
				TOTAL CUPO:
				<input type = "text" name= "txtTotal_cupo" class = "form-control" value="<%=laclase.getTotal_cupo() %>"/>	
				<br>
				ID:
				<input type = "text" name= "txtId" class = "form-control" value="<%= laclase.getId() %>"/>		
				<br>
				NOMBRE:
				<input type = "text" name = "txtNombre" class = "form-control" value="<%= laclase.getNombre() %>"/>
				<br>
				ACTUAL CUPOS:
				<input type = "text" name = "txtActual_cupos" class = "form-control" value="<%= laclase.getActual_cupos()%>"/>
				<br>
				DIA:
				<input type = "text" name = "txtDia" class = "form-control" value="<%= laclase.getDia() %>"/>
				<br>
				HORA:
				<input type = "text" name = "txtHora" class = "form-control" value="<%= laclase.getHora() %>"/>
				<br>
				LEGAJO PROFESIONAL:
				<input type = "text" name = "txtLegajo_prof" class = "form-control" value="<%= laclase.getLegajo_prof() %>"/>
				<br>
				DESCRIPCION:
				<input type = "text" name = "txtDescripcion" class = "form-control" value="<%= laclase.getDescripcion() %>"/>
				<br>
				<br>
				<br>
				<input type = "Submit" value= "Guardar" class = "btn btn-primary btn-lg"/>
				<br>
				<br>
				<a href= "clases-tabla.jsp"> Regresar</a>				
           <%
            String nombre, descripcion;
            Integer total_cupo, id, actual_cupo, dia, hora, legajo_prof; 
            
            total_cupo = request.getParameter("txtTotal_cupo");
			id = request.getParameter("txtId");
			nombre = request.getParameter ("txtNombre");
			actual_cupos = request.getParameter ("txtActual_cupos");
			dia = request.getParameter("txtDia");
			hora = request.getParameter("txtHora");
			legajo_prof = request.getParameter("txtLegajo_prof");
			descripcion = request.getParameter("txtDescripcion");
			
			if (total_cupo!= null && id!= null && nombre!= null && actual_cupos!= null && dia!= null && hora!= null && legajo_prof!= null &&  descripcion!= null &&)
			{
				lacuota.setId(Integer.parseInt(id));
				lacuota.setTotal_cupos(total_cupos);
				lacuota.setNombre(nombre);
				lacuota.setActual_cupos(actual_cupos);
				lacuota.setDia(dia);
				lacuota.setHora(hora);
				lacuota.setLegajo_prof(legajo_prof);
				lacuota.setDescripcion(descripcion);
				
				c.modClase(laclase, id1);
				response.sendRedirect("clases-tabla.jsp");
			}
%>
		</form> 
	</div>
</body>
</html>




