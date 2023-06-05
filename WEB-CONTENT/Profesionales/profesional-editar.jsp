<%@page import="java.util.LinkedList"%>
<%@page import="entites.Profesional"%>
<%@page import="util.profesionalUtil"%>
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

Profesional Pro=new Profesional();
int dni1= Integer.parseInt(request.getParameter("dni"));
profesionalUtil p =new profesionalUtil();
Pro=p.getBylegajo(dni1);
%>
</head>
<body>
	<div class = "conteiner">
		<h1>Modificar profesional</h1>	
		<hr>
		<form action="" method= "post" class = "form-control" style = "width: 500 px; height: 400 px">
				DNI:
				<input type = "text" name= "txtDNI" class = "form-control" value="<%=Pro.getDni() %>"/>
				<br>
				CONTRASE:
				<input type = "text" name = "txtcontra" class = "form-control" value="<%=Pro.getContrasenia() %>"/>
				<br>
				NOMBRE:
				<input type = "text" name = "txtNombre" class = "form-control" value="<%=Pro.getNombre() %>"/>
				<br>
				APELLIDO:
				<input type = "text" name = "txtApellido" class = "form-control" value="<%=Pro.getApellido() %>"/>
				<br>
				<br>
				<input type = "Submit" value= "Editar" class = "btn btn-primary btn-lg" name = "Editar"/>
				<br>
				<br>
				<a href= "profesional-tabla.jsp"> Regresar</a>				
		

<%
	
	String  dni,contrase, tipo, nom, ape;
	
	dni = request.getParameter("txtDNI");
	nom = request.getParameter ("txtNombre");
	contrase = request.getParameter ("txtcontra");
	ape = request.getParameter ("txtApellido");
	
	if ( null !=request.getParameter("Editar") )
	{
	if (dni!= "" && nom!= ""  && contrase != "" && ape != "" )
	{
	
		
		
		Pro.setDni(Integer.parseInt(dni));
		Pro.setNombre(nom);
		Pro.setApellido(ape);
		Pro.setContrasenia(contrase);
		
		p.modProfesional(Pro, dni1);
		response.sendRedirect("profesional-tabla.jsp");
	}
	
else 
		
	{
		out.print("Rellenar todos los campos");

	}}
	
	
	
%>
		</form> 
	</div>
</body>
</html>