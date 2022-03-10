<%@page import="java.util.LinkedList"%>
<%@page import="entites.*"%>
<%@page import="util.tiporutinaUtil"%>
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
		int id= Integer.parseInt(request.getParameter("id_tipo"));
		tiporutinaUtil tr =new tiporutinaUtil();
		TipoRutina tipo = tr.getByID(id);
	%>

 	<div class = "conteiner">
		<h1>Modificar tipo </h1>
		<hr>

		<form action="" method= "post" class = "form-control" style = "width: 500 px; height: 400 px">
				ID:
				<input type = "text" name= "txtID" class = "form-control" value="<%=tipo.getId_tipo() %>"/>	
				<br>
				Descripcion:
				<input type = "text" name= "txtDescripcion" class = "form-control" value="<%= tipo.getDescripcion() %>"/>		
				<br>
				
				<input type = "Submit" value= "Guardar" class = "btn btn-primary btn-lg"/>
				<br>
				<br>
				<a href= "tipoRutina-tabla.jsp"> Regresar</a>				
           <%
            String id_tip, desc;
            id_tip= request.getParameter("txtID");
			desc = request.getParameter("txtDescripcion");		
			
			if (id_tip!= null && desc != null)
			{
				tipo.setId_tipo(Integer.parseInt(id_tip));
				tipo.setDescripcion(desc);
				tr.modTiporutina(tipo,id);
				response.sendRedirect("tipoRutina-tabla.jsp");
			}
%>
		</form> 
	</div>
</body>
</html>




