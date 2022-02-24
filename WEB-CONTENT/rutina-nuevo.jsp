
<%@page import="java.util.LinkedList"%>
<%@page import="entites.Rutina"%>
<%@page import="util.rutinaUtil"%>
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
		<h1>Agregar nueva rutina</h1>	
		<hr>
		<<form action="" method= "post" class = "form-control" style = "width: 500 px; height: 400 px">
				dia:
				<input type = "text" name= "txtDIA" class = "form-control" value="<%=laRutina.getDia() %>"/>	
				<br>
				ID Rutina:
				<input type = "text" name= "txtID" class = "form-control" value="<%= laRutina.getIdRutina() %>"/>		
				<br>
				DNI:
				<input type = "text" name = "txtDNI" class = "form-control" value="<%= laRutina.getDni() %>"/>
				<br>
				LEGAJO:
				<input type = "text" name = "txtLEGAJO" class = "form-control" value="<%= laRutina.getLegajo()%>"/>
				<br>
			
				<input type = "Submit" value= "Guardar" class = "btn btn-primary btn-lg"/>
				<br>
				<br>
				<a href= "rutina-tabla.jsp"> Regresar</a>
		</form>
	</div>
</body>
</html>
<%	rutinaUtil ru =new rutinaUtil();

String dia,idr,dni,legajo;
idr=request.getParameter("txtID");
dni=request.getParameter("txtDNI");
legajo=request.getParameter("txtLEGAJO");
dia=request.getParameter("txtDIA");			

if (idr!= null && dni != null && legajo != null && dia != null )
	{
	 ru.altaRutina(dia, Integer.parseInt(idr), Integer.parseInt(dni), Integer.parseInt(legajo));
		
		response.sendRedirect("rutina-tabla.jsp");
	}
	%>