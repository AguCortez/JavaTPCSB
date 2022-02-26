<%@page import="java.util.LinkedList"%>
<%@page import="entites.Socio"%>
<%@page import="util.sociosUtil"%>
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
	out.print("<script>location.replace('index.jsp');</script>"); 
}
%>
<body>
	<%
		int dni1= Integer.parseInt(request.getParameter("dni"));
		sociosUtil s =new sociosUtil();
		Socio elsocio=s.getBydni(dni1);
	%>

 	<div class = "conteiner">
		<h1>Modificar socio</h1>
		<hr>

		<form action="" method= "post" class = "form-control" style = "width: 500 px; height: 400 px">
				DNI:
				<input type = "text" name= "txtDNI" class = "form-control" value="<%=elsocio.getDni() %>"/>	
				<br>
				TIPO:
				<input type = "text" name= "txtTipo" class = "form-control" value="<%= elsocio.getTipo() %>"/>		
				<br>
				CONTRASE:
				<input type = "text" name = "txtcontra" class = "form-control" value="<%= elsocio.getContrasenia() %>"/>
				<br>
				NOMBRE:
				<input type = "text" name = "txtNombre" class = "form-control" value="<%= elsocio.getNombre_soc()%>"/>
				<br>
				APELLIDO:
				<input type = "text" name = "txtApellido" class = "form-control" value="<%= elsocio.getApellido_soc() %>"/>
				<br>
				CELULAR:
				<input type = "text" name = "txtCelular" class = "form-control" value="<%= elsocio.getCelu() %>"/>				
				<br>
				<br>
				<input type = "Submit" value= "Guardar" class = "btn btn-primary btn-lg"/>
				<br>
				<br>
				<a href= "socio-tabla.jsp"> Regresar</a>				
           <%
            String dni, contrase, tipo, nom, ape, cel;
            dni = request.getParameter("txtDNI");
			tipo = request.getParameter("txtTipo");
			nom = request.getParameter ("txtNombre");
			contrase = request.getParameter ("txtcontra");
			ape = request.getParameter ("txtApellido");
			cel = request.getParameter ("txtCelular");
			
            
			
							
			
			
			
			if (nom!= null && tipo != null && contrase != null && ape != null && cel != null)
			{
				elsocio.setDni(Integer.parseInt(dni));
				elsocio.setTipo(tipo);
				elsocio.setApellido_soc(ape);
				elsocio.setContrasenia(contrase);
				elsocio.setNombre_soc(nom);
				elsocio.setCelu(cel);
				s.modSocio(elsocio, dni1);
				response.sendRedirect("socio-tabla.jsp");
			}
%>
		</form> 
	</div>
</body>
</html>




