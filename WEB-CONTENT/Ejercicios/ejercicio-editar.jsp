<%@page import="java.util.LinkedList"%>
<%@page import="entites.Ejercicio"%>
<%@page import="util.ejercicioUtil"%>
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
		int id= Integer.parseInt(request.getParameter("idEj"));
		ejercicioUtil e =new ejercicioUtil();
		Ejercicio elejer= e.getByID(id); 
	%>

 	<div class = "conteiner">
		<h1>Modificar ejercicio</h1>
		<hr>

		<form action="" method= "post" class = "form-control" style = "width: 500 px; height: 400 px">
				ID EJERCICIO:
				<input type = "text" name= "txtIdtipo" class = "form-control" value="<%=elejer.getIdtipo() %>"/>
				<br>
				DESCRIPCION:
				<input type = "text" name = "txtDescripcion" class = "form-control" value="<%=elejer.getDescripcion() %>"/>				
				<br>
				
				<br>
				<input type = "Submit" value= "Guardar" class = "btn btn-primary btn-lg"/>
				<br>
				<br>
				<a href= "tablaejercicio.jsp"> Regresar</a>					
		<%
           
        String idEj,descripcion ;

       	idEj = request.getParameter("txtIDejer");
       	descripcion = request.getParameter ("txtDescripcion");
       
       	
    	if ( null !=request.getParameter("Guardar") )
		{	
			
			
    	if (idEj!= "" &&  descripcion!= "" )
			{
    		elejer.setIdtipo(Integer.parseInt(idEj));
    		elejer.setDescripcion(descripcion);
    		
    		e.modEjercicio(elejer, Integer.parseInt(idEj));
			response.sendRedirect("ejercicio-tabla.jsp");
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

