
<%@page import="java.util.LinkedList"%>
<%@page import="entites.*"%>
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
<body>



	<div class = "conteiner">
		<h1>Agregar nuevo tipo de rutina</h1>	
		<hr>
		<form action="" method= "post" class = "form-control" style = "width: 500 px; height: 400 px">
				ID:
				<input type = "text" name= "txtID" class = "form-control"/>	
				<br>
				Descripcion:
				<input type = "text" name= "txtDescripcion" class = "form-control"/>	
				<br>
				<br>
				<input type = "Submit" value= "Guardar" class = "btn btn-primary btn-lg"/>
				<br>
				<br>
				<a href= "tipoRutina-tabla.jsp"> Regresar</a>
		</form>
	</div>
</body>
</html>
		<% tiporutinaUtil tr =new tiporutinaUtil();
		
		String id,descripcion;
		
		id=request.getParameter("txtID");
		descripcion=request.getParameter("txtDescripcion");


		if (id!= "" && descripcion != "" )
			{
			TipoRutina ntipo= new TipoRutina();
			ntipo.setDescripcion(descripcion);
			ntipo.setId_tipo(Integer.parseInt(id));
			tr.altaTiporutina(ntipo);
			 response.sendRedirect("tipoRutina-tabla.jsp");
			}
		
		
		else
			
		{
			out.print("Rellenar todos los campos");

		}
		
		
		
			%>