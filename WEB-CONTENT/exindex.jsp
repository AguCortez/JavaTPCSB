<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    	               "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>Uso de Sesión con JSP</title>
  </head>
  <% 
  if (session.isNew()!=false)
  {
	  String msg= (String)session.getAttribute("mensajeError");
	  if (msg!=null)
	  {
		  out.print("Estado: "+msg);
	  }
  }
  
  %>
  <body>
  <form action="menu2.jsp" method="post">
  <table align=center>
    <caption>Ingreso de usuario</caption>
    <tr><td align=center>Usuario</td><td align=center><input type="text" size=30 name="txtNombre"></input></td></tr>
     <tr><td align=center>Contraseña</td><td align=center><input type="password" size=30 name="txtPass"></input></td></tr>
 	<tr><td align=center><button type="reset" title="Limpiar">Borrar</button></td><td align=center><button type="submit" title="Enviar">Enviar</button></td></tr>
  </table>
  </form>
  </body>
</html> 
