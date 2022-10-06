<%@page import="java.util.LinkedList"%>
<%@page import="entites.Clase"%> 
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
	    claseUtil c =new claseUtil();
	    Clase laclase=c.getByid(id1);
	%>

 	<div class = "conteiner">
		<h1>Modificar clase</h1> 
		<hr>

		<form action="" method= "post" class = "form-control" style = "width: 500 px; height: 400 px">
				TOTAL CUPO:
				<input type = "text" name= "txtTotal_cupo" class = "form-control" value="<%=laclase.getTotal_cupo() %>"/>	
				<br>
				ID:
				<input type = "text" name= "txtId" class = "form-control" value="<%= laclase.getId() %>"/>		
				<br>
				NOMBRE:
				<input type = "text" name = "txtNombre" class = "form-control" value="<%= laclase.getNombre() %>"/>
				<br>
				ACTUAL CUPOS:
				<input type = "text" name = "txtActual_cupos" class = "form-control" value="<%= laclase.getActual_cupos()%>"/>
				<br>
				DIA:
				<input type = "text" name = "txtDia" class = "form-control" value="<%= laclase.getDia() %>"/>
				<br>
				HORA:
				<input type = "text" name = "txtHora" class = "form-control" value="<%= laclase.getHora() %>"/>
				<br>
				LEGAJO PROFESIONAL:
				<input type = "text" name = "txtLegajo_prof" class = "form-control" value="<%= laclase.getLegajo_prof() %>"/>
				<br>
				DESCRIPCION:
				<input type = "text" name = "txtDescripcion" class = "form-control" value="<%= laclase.getDescripcion() %>"/>
				<br>
				<br>
				<br>
				<input type = "Submit" value= "Guardar" class = "btn btn-primary btn-lg"/>
				<br>
				<br>
				<a href= "clases-tabla.jsp"> Regresar</a>				
           <%
            String nombre, descripcion, total_cupo, id, actual_cupo, dia, hora, legajo_prof; 
            
            total_cupo = request.getParameter("txtTotal_cupo");
			id = request.getParameter("txtId");
			nombre = request.getParameter ("txtNombre");
			actual_cupo = request.getParameter ("txtActual_cupos");
			dia = request.getParameter("txtDia");
			hora = request.getParameter("txtHora");
			legajo_prof = request.getParameter("txtLegajo_prof");
			descripcion = request.getParameter("txtDescripcion");
			
       
			
			if (total_cupo!= "" && id!= "" && nombre!= "" && actual_cupo!= "" && dia!= "" && hora!= "" && legajo_prof!= "" &&  descripcion!= "" )
			{
				laclase.setId(Integer.parseInt(id));
				laclase.setTotal_cupo(Integer.parseInt(total_cupo));
				laclase.setNombre(nombre);
				laclase.setActual_cupos(Integer.parseInt(actual_cupo));
				laclase.setDia(dia);
				laclase.setHora(hora);
				laclase.setLegajo_prof(Integer.parseInt(legajo_prof));
				laclase.setDescripcion(descripcion);
				
				c.modClase(laclase, id1);
				response.sendRedirect("clases-tabla.jsp");
			}
			
			
			else
				
			{
				out.print("Rellenar todos los campos");

			}
			
%>
		</form> 
	</div>
</body>
</html>




