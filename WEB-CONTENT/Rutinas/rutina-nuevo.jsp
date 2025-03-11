
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
<%
sociosUtil su= new sociosUtil();
LinkedList<Socio> Socios = new LinkedList<Socio>();
Socios= su.getAll();
profesionalUtil pu= new profesionalUtil();
LinkedList<Profesional> Profes = new LinkedList<Profesional>();
Profes= pu.getAll();


%>


	<div class = "conteiner">
		<h1>Agregar nueva rutina</h1>	
		<hr>
		<form action="" method= "post" class = "form-control" style = "width: 500 px; height: 400 px">
				ID RUTINA:
				<input type = "text" name= "txtID" class = "form-control"/>		
				<br>
				DIA:
				<input type = "text" name= "txtDIA" class = "form-control"/>	
				<br>
				SOCIO:
				<select name="Socio">
				<%
					for (Socio soc: Socios){			
				%>	
				
				<option value= "<%= soc.getDni() %>"><%= soc.getApellido_soc() %></option>
				<% } %>
				</select> 
				<br>
				PROFESIONAL:
				<select name="Prof">
				<%
					for (Profesional prof: Profes){			
				%>	
				
				<option value= "<%= prof.getDni() %>"><%= prof.getApellido()+" "+prof.getNombre() %></option>
				<% } %>
				</select> 
				
				<br>
				<a href= "rutina-ejercicios.jsp"> AGREGAR EJERCICIOS</a>
				<br>
				<br>
				<br>
				<br>
				<input type = "Submit" value= "Guardar" class = "btn btn-primary btn-lg"/>
				<br>
				<br>
				<a href= "rutina-tabla.jsp"> Regresar</a>
		</form>
	</div>
</body>
</html>
		<%
		String series, rep,dia,idr;
		String dniSoc, dniProf, idEj;
		
		idr=request.getParameter("txtID");
		dniSoc=request.getParameter("Socio");
		dniProf=request.getParameter("Prof");
		dia=request.getParameter("txtDIA");
		idEj = "3";
		series=request.getParameter("txtSERIES");
        rep=request.getParameter("txtREPETICIONES");
        System.out.println(dniSoc+" 10000000000000000023 "+dniProf);
		
        if ( null !=request.getParameter("Guardar") )
		{
			rutinaUtil ru =new rutinaUtil();
		  
		
			if (idr!= "" && dniSoc != "" && dniProf != "" && dia != "" && idEj != "" )
			{
				System.out.println(dniSoc+" 10000000000023 "+dniProf);
			 ru.altaRutina(Integer.parseInt(idEj),dia, Integer.parseInt(idr), Integer.parseInt(dniSoc), Integer.parseInt(dniProf),Integer.parseInt(series),Integer.parseInt(rep));
			 response.sendRedirect("rutina-tabla.jsp");
			}
		
		
		else
			
		{
			out.print("Rellenar todos los campos");

		}
		
		}
		
		
			%>