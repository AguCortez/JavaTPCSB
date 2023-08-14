<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="servlet.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type"  charset="ISO-8859-1">
	
<title>Formulario de prueba</title>
</head>
<body>
<h1>Datos del cliente</h1>
<form action="SvUsuarios.java" method="POST">
	<p><label>Dni:</label><input type="text" name="dni"></p>
	<p><label>Nombre:</label><input type="text" name="Nombre"></p>
	<button type="submit">Enviar</button>
</form>
</body>
</html>