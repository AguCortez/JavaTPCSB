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
				<input type = "text" name= "txtIDejer" class = "form-control" value="<%=elejer.getIdEjercicio() %>"/>
				<br>
				ID RUTINA:
				<input type = "text" name= "txtIDrutina" class = "form-control" value="<%=elejer.getIdrutina() %>"/>		
				<br>
				REPETICIONES:
				<input type = "text" name = "txtRepeticiones" class = "form-control" value="<%=elejer.getRepeticiones() %>"/>
				<br>
				PESO:
				<input type = "text" name = "txtPeso" class = "form-control" value="<%=elejer.getPeso() %>"/>
				<br>
				SERIES:
				<input type = "text" name = "txtSeries" class = "form-control" value="<%=elejer.getSeries() %>"/>
				<br>
				DESCRIPCION:
				<input type = "text" name = "txtDescripcion" class = "form-control" value="<%=elejer.getDescripcion() %>"/>				
				<br>
				NOMBRE MAQUINA:
				<input type = "text" name = "txtNombreMaq" class = "form-control" value="<%=elejer.getNombre_maquina() %>"/>
				<br>
				<input type = "Submit" value= "Editar" class = "btn btn-primary btn-lg" name = "Editar"/>
				<br>
				<br>
				<a href= "ejercicio-tabla.jsp"> Regresar</a>				
		<%
           
        String idEj, idRutina,repeteciones,  peso, series;
       	String descripcion , nombre_maq;

       	idEj = request.getParameter("txtIDejer");
       	idRutina = request.getParameter("txtIDrutina");
       	repeteciones = request.getParameter ("txtRepeticiones");
       	peso = request.getParameter ("txtPeso");
       	series = request.getParameter ("txtSeries");
       	descripcion = request.getParameter ("txtDescripcion");
       	nombre_maq = request.getParameter ("txtNombreMaq");

       	
       	if ( null !=request.getParameter("Editar") )
		{					
			
			
			
    	if (idEj!= "" && idRutina != "" && repeteciones != "" && peso != "" && nombre_maq != "" && series != "" && descripcion!= "" )
			{
    		elejer.setIdEjercicio(Integer.parseInt(idEj));
    		elejer.setRepeticiones(Integer.parseInt(repeteciones));
    		elejer.setPeso(Integer.parseInt(peso));
    		elejer.setSeries(Integer.parseInt(series));
    		elejer.setDescripcion(descripcion);
    		elejer.setNombre_maquina(nombre_maq);
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

