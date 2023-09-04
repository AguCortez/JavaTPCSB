<%@page import="java.util.LinkedList"%>
<%@page import="entites.Rutina"%>
<%@page import="util.rutinaUtil"%>
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
		int id= Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
   	   rutinaUtil r =new rutinaUtil();
		Rutina laRutina= r.getByidRutina(id);
	%>

 	<div class = "conteiner">
		<h1>Modificar rutina</h1>
		<hr>

		<form action="" method= "post" class = "form-control" style = "width: 500 px; height: 400 px">
				dia:
				<input type = "text" name= "txtDIA" class = "form-control" value="<%=laRutina.getDia() %>"/>	
				<br>
				ID Rutina:
				<input type = "text" name= "txtID" class = "form-control" value="<%= laRutina.getIdRutina() %>"/>		
				<br>
				DNI:
				<input type = "text" name = "txtDNI" class = "form-control" value="<%= laRutina.getDni() %>"/>
				<br>
				DNI P:
				<input type = "text" name = "txtDNIP" class = "form-control" value="<%= laRutina.getDniP()%>"/>
				<br>
				Id tipo ej:
				<input type = "text" name = "txtIDTIPOEJ" class = "form-control" value="<%= laRutina.getIdtipoej()%>"/>
				<br>
				Series:
				<input type = "text" name = "txtSERIES" class = "form-control" value="<%= laRutina.getSeries() %>"/>
				<br>
				Repeticiones:
				<input type = "text" name = "txtREPETICIONES" class = "form-control" value="<%= laRutina.getRepeticiones() %>"/>
				<br>
				<br>
				<input type = "Submit" value= "Editar" class = "btn btn-primary btn-lg" name= "Editar"/>
				<br>
				<br>
				<a href= "rutina-tabla.jsp"> Regresar</a>				
           <%
          

            String dia,idr,dni,dniP,idtipoej,series,repeticiones;
           
            dia=request.getParameter("txtDIA");	
            idr=request.getParameter("txtID");
            dni=request.getParameter("txtDNI");
            dniP=request.getParameter("txtDNIP");
            idtipoej=request.getParameter("txtIDTIPOEJ");
            series=request.getParameter("txtSERIES");
            repeticiones=request.getParameter("txtREPETICIONES");
			
			
            if ( null !=request.getParameter("Editar") )
    		{	
            
			if (dia!= "" && idr != "" && dni != "" &&  dniP != "" &&  idtipoej != "" &&  series != "" &&  repeticiones != "" )
			{
				laRutina.setDia(dia);
				laRutina.setDni(Integer.parseInt(idr));
				laRutina.setIdRutina(Integer.parseInt(dni));
				laRutina.setDniP(Integer.parseInt(dniP));
				laRutina.setIdtipoej(Integer.parseInt(idtipoej));
				laRutina.setSeries(Integer.parseInt(series));
				laRutina.setRepeticiones(Integer.parseInt(repeticiones));
				
				
				r.modRutina(laRutina,(id));
				response.sendRedirect("rutina-tabla.jsp");
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


