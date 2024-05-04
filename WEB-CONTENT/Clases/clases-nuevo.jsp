<%@page import="java.util.LinkedList"%>
<%@page import="entites.*"%>
<%@page import="java.sql.*" %>
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
	<div class = "conteiner">
		<h1>Agregar nueva clase </h1>	
		<hr>
		<form action="" method= "post" class = "form-control" style = "width: 500 px; height: 400 px">
		
				<br>
				TOTAL CUPO:
				<input type = "text" name= "txtTotal_cupo" class = "form-control"/>
				<br>
				
				ACTUAL CUPOS:
				<input type = "text" name = "txtActual_cupos" class = "form-control"/>
				<br>
				Profesional:
				<% 
				profesionalUtil prof = new profesionalUtil();
				LinkedList<Profesional> Profesional = new LinkedList<Profesional>();
				Profesional= prof.getAll();		
				%>
				<select name="Profesional" class = "form-control">
				<%
					for (Profesional pro: Profesional){			
				%>					
				<option value= "<%= pro.getDni() %>">
					<%= pro.getNombre()+" "+pro.getApellido() %></option>
				<% } %>
				</select>
				<br>
				DIA:
				<input type = "text" name = "txtDia" class = "form-control"/>
				<br>
				HORA:
				<input type = "text" name = "txtHora" class = "form-control"/>
				<br>
				DESCRIPCION:
				<input type = "text" name = "txtDescripcion" class = "form-control"/>
				<br>
				Tipo de Clase:
				<% 
				tipoclaseUtil tcu = new tipoclaseUtil();
				LinkedList<TipoClase> TipoClase = new LinkedList<TipoClase>();
				TipoClase= tcu.getAll();
				
				%>
				<select name="TipoClase" class = "form-control">
				<%
					for (TipoClase tipo: TipoClase){			
				%>					
				<option value= "<%= tipo.getIdtipo_clase() %>">
					<%= tipo.getNombre_clase() %></option>
				<% } %>
				</select>
				
				<br>
				<br>
				
				<input type = "Submit" value= "Guardar" class = "btn btn-primary btn-lg" name = "Guardar"/>
				<br>
				<br>
				
				
		</form>
	</div>
</body>

<%

if ( null !=request.getParameter("Guardar") )
{
	

	Clase cla=new Clase();
	claseUtil cu =new claseUtil();

	String descripcion, dia, total_cupo, id, actual_cupo,  hora, legajo_prof, tipoClase; 
	
	total_cupo = request.getParameter("txtTotal_cupo");
	actual_cupo = request.getParameter ("txtActual_cupos");
	dia = request.getParameter("txtDia");
	hora = request.getParameter("txtHora");
	legajo_prof = request.getParameter("Profesional");
	descripcion = request.getParameter("txtDescripcion");
	tipoClase =  request.getParameter("TipoClase");
	//System.out.println( "Clase nuevo"+dia+   hora+ legajo_prof);


if (total_cupo!= ""  && actual_cupo!= "" && dia!= "" && hora!= "" &&  descripcion!= "")
	{
		cu.altaClase(
				Integer.parseInt(total_cupo), 
				Integer.parseInt(actual_cupo),
				dia,
				hora, 
				descripcion,
				Integer.parseInt(legajo_prof),
				Integer.parseInt(tipoClase));
		response.sendRedirect("clases-tabla.jsp");
	
	}



else
	
{
	out.print("Rellenar todos los campos");

}
}

	%>