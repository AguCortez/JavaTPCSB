
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" 
 integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
 <title>Main Menu</title>
</head>

<body>
	<div class="container-fluid">
	
	
 	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
 	
  	<div class="container-fluid">
    
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="menu-main.jsp">Home</a>
        </li>
        
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Administrar Entidad
          </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdown">
            <a class="dropdown-item" href="clases-tabla.jsp">Clases</a>
            <a class="dropdown-item" href="ejercicio-tabla.jsp">Ejercicio</a>
            <a class="dropdown-item" href="profesional-tabla.jsp">Profesional</a>
            <a class="dropdown-item" href="reservas-tabla.jsp">Reservas</a>
            <a class="dropdown-item" href="socio-tabla.jsp">Socios</a>
            <a class="dropdown-item" href="rutina-tabla.jsp">Rutina</a>

         
          </div>
        </li>
        <li class="nav-item">
          <a class="nav-link disabled" href="#"> Mis Rutinas </a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="inscripcion.jsp"> Inscribirse a una clase </a>
        </li>
        
        <li class="nav-item">
        <a class= "nav-link active" href='index.jsp?cerrar=true'> <h5>Cerrar Sesion </h5></a>"
         </li>l
      </ul>

    </div>
  	</div>
	</nav>