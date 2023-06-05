<%@page import="java.util.LinkedList"%>
<%@page import="entites.*"%> 
<%@page import="util.*"%>
<%@page import="java.sql.*" %>
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
		int id1= Integer.parseInt(request.getParameter("id"));
	    tipoclaseUtil c =new tipoclaseUtil();
	    TipoClase laclase= c.getByid(id1);
	%>

 	<div class = "conteiner">
		<h1>Modificar clase</h1> 
		<hr>

		<form action="" method= "post" class = "form-control" style = "width: 500 px; height: 400 px">
				ID:
				<input type = "text" name= "txtId" class = "form-control" value="<%= laclase.getIdtipo_clase() %>"/>		
				Nombre de la Clase:
				<input type = "text" name = "txtNombre" class = "form-control" value="<%= laclase.getNombre_clase() %>"/>
				<br>
				Descripcion de la  Clase:
				<input type = "text" name = "txtDescripcion" class = "form-control" value="<%= laclase.getDescripcion() %>"/>
				<br>
				<br>
				<input type = "Submit" value= "Editar" class = "btn btn-primary btn-lg" name = "Editar"/>
				<br>
				<br>
				<a href= "clases-tabla.jsp"> Regresar</a>				
           <%
            String nombre, descripcion, id; 
            
            nombre = request.getParameter("txtNombre");
			id = request.getParameter("txtId");
			descripcion = request.getParameter("txtDescripcion");

			if ( null !=request.getParameter("Editar") )
			{
			
			if ( id!= "")
			{
				laclase.setIdtipo_clase(id1);
				laclase.setNombre_clase(nombre);
				laclase.setDescripcion(descripcion);
		
				c.modClase(laclase, id1);
				response.sendRedirect("tipoclases-tabla.jsp");
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




	


	
