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
		int idcuota1= Integer.parseInt(request.getParameter("idcuota"));
		cuotaUtil c =new cuotaUtil();
		Cuota lacuota=c.getbyID(idcuota1);
	%>

 	<div class = "conteiner">
		<h1>Modificar cuota</h1>
		<hr>

		<form action="" method= "post" class = "form-control" style = "width: 500 px; height: 400 px">
				IDCUOTA:
				<input type = "text" name= "txtIDCUOTA" class = "form-control" value="<%=lacuota.getIdCuota() %>"/>	
				<br>
				ANIO:
				<input type = "text" name= "txtAnio" class = "form-control" value="<%= lacuota.getAnio() %>"/>		
				<br>
				MES:
				<input type = "text" name = "txtMes" class = "form-control" value="<%= lacuota.getMes() %>"/>
				<br>
				PRECIO:
				<input type = "text" name = "txtPrecio" class = "form-control" value="<%= lacuota.getPrecio()%>"/>
				<br>
				FECHA PAGO:
				<input type = "text" name = "txtFecha_pago" class = "form-control" value="<%= lacuota.getFecha_pago() %>"/>
				<br>
				<br>
				<input type = "Submit" value= "Editar" class = "btn btn-primary btn-lg"/>
				<br>
				<br>
				<a href= "tabla-cuota.jsp"> Regresar</a>				
           <%
            String mes, precio , idcuota , dni , anio , fecha_pago;
           
            mes = request.getParameter ("txtMes");
            precio = request.getParameter ("txtPrecio");
            idcuota = request.getParameter("txtIdcuota");
            dni = request.getParameter("txtDni");
			anio = request.getParameter("txtAnio");
			fecha_pago = request.getParameter ("txtFecha_pago");
						
			if ( null !=request.getParameter("Editar") )
			{	
			if (mes != ""  && precio != "" &&  idcuota!= ""  && dni != ""  && anio!= ""  && fecha_pago != "")
			{
				
				lacuota.setMes(Integer.parseInt(mes));
				lacuota.setPrecio(Integer.parseInt(precio));
				lacuota.setIdCuota(Integer.parseInt(idcuota));
				lacuota.setDni(Integer.parseInt(dni));
				lacuota.setAnio(Integer.parseInt(anio));
				lacuota.setFecha_pago(fecha_pago);
				
				c.modCuota(lacuota, idcuota1);
				response.sendRedirect("cuotas-tabla.jsp");
			}
			
			
			else
				
			{
				out.print("Rellenar todos los campos");

			}}
%>
		</form> 
	</div>
</body>
</html>






