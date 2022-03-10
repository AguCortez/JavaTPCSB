
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
		<h1>Agregar nuevo socio</h1>	
		<hr>
		<form action="" method= "post" class = "form-control" style = "width: 500 px; height: 400 px">
				DNI:
				<input type = "text" name= "txtDNI" class = "form-control"/>
				<br>
				TIPO:
				<input type = "text" name= "txtTipo" class = "form-control"/>		
				<br>
				CONTRASE:
				<input type = "text" name = "txtcontra" class = "form-control"/>
				<br>
				NOMBRE:
				<input type = "text" name = "txtNombre" class = "form-control"/>
				<br>
				APELLIDO:
				<input type = "text" name = "txtApellido" class = "form-control"/>
				<br>
				CELULAR:
				<input type = "text" name = "txtCelular" class = "form-control"/>				
				<br>
				<br>
				<input type = "Submit" value= "Guardar" class = "btn btn-primary btn-lg"/>
				<br>
				<br>
				<a href= "socio-tabla.jsp"> Regresar</a>				
		
		
		</form>
	</div>
</body>
</html>
<%	sociosUtil s =new sociosUtil();
	UsuarioUtil usuarioUtil = new UsuarioUtil();
	String dni;
	String  contrase, tipo, nom, ape, cel;

	dni = request.getParameter("txtDNI");
	tipo = request.getParameter("txtTipo");
	nom = request.getParameter ("txtNombre");
	contrase = request.getParameter ("txtcontra");
	ape = request.getParameter ("txtApellido");
	cel = request.getParameter ("txtCelular");
	if (nom!= null && tipo != null && contrase != null && ape != null && cel != null)
	{
		
		usuarioUtil.altaSocioU(Integer.parseInt(dni), contrase);
		s.altaSocio(Integer.parseInt(dni), tipo, contrase, nom, ape, cel);
		response.sendRedirect("socio-tabla.jsp");
	}
	%>