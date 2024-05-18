<%@page import="java.util.LinkedList"%>
<%@page import="entites.Cuota"%>
<%@page import="util.cuotaUtil"%>
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
		<h1>Agregar nueva cuota</h1>	
		<hr>
		<form action="" method= "post" class = "form-control" style = "width: 500 px; height: 400 px">
				MES:
				<input type = "text" name = "txtMes" class = "form-control"/>
				<br>
				PRECIO:
				<input type = "text" name = "txtPrecio" class = "form-control"/>
				<br>
				IDCUOTA:
				<input type = "text" name= "txtIdcuota" class = "form-control"/>		
				<br>
				DNI:
				<input type = "text" name= "txtDni" class = "form-control"/>		
				<br>
				ANIO:
				<input type = "text" name= "txtAnio" class = "form-control"/>		
				<br>
				FECHA PAGO:
				<input type = "text" name = "txtFecha_pago" class = "form-control"/>
				<br>
				<br>
				<input type = "Submit" value= "Guardar" class = "btn btn-primary btn-lg"/>
				<br>
				<br>
				<a href= "cuotas-tabla.jsp"> Regresar</a>				
		
		
		</form>
	</div>
</body>
</html>
<%	


if ( null !=request.getParameter("Guardar") )
{
	cuotasUtil c =new cuotasUtil();		
	UsuarioUtil usuarioUtil = new UsuarioUtil();
	String  mes, precio, idcuota, dni, anio, fecha_pago;


	mes = request.getParameter ("txtMes");
	precio = request.getParameter ("txtPrecio");
    idcuota = request.getParameter("txtIdcuota");
	dni = request.getParameter ("txtDni");
	anio = request.getParameter("txtAnio");
	fecha_pago = request.getParameter ("txtFecha_pago");
	
	if (mes != ""  && precio != "" &&  idcuota!= ""  && dni != ""  && anio!= ""  && fecha_pago != "")
	{

		c.altaCuota(Integer.parseInt(mes),Integer.parseInt(precio),Integer.parseInt(idcuota),Integer.parseInt(dni), Integer.parseInt(anio), fecha_pago);
		response.sendRedirect("cuotas-tabla.jsp");
	}
	
	else
		
	{
		out.print("Rellenar todos los campos");

	}
    }
	
	
	%>