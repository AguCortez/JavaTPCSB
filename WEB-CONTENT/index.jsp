<!DOCTYPE html>
<%@page import="util.UsuarioUtil"%>
<%@page import="java.net.*" %>
<%@page session="true" %>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=
no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
	<link rel="stylesheet" href="css/estilo.css">
	<link href="https://unpkg.com/ionicons@4.5.10-0/dist/css/ionicons.min.css" rel="stylesheet">
<title>Log In</title>
<style type="text/css">
body {
	background-image:
		url("file:///C:/Users/Angelina/Downloads/UTN.jpg");
	background-repeat: no-repeat;
	background-position: center;
	background-size: cover;
}

.centrado {
	text-align: center;
}
</style>

  
</head>

<body>
	<form name="form" action="index.jsp" method="POST" >
	<div class="container">
		<table  >
			<tr>
			<label id="Label2"><strong>Bienvenidos!</strong></label>
				
			</tr>

			<tr>
				<td align=center>Dni</td>
				<td align=center><input type="text" size=30 name="dniUsu"></input></td>
			</tr>

			<tr>
				<td align=center>Password</td>
				<td align=center><input type="password" size=30 name="passUsu"></input></td>
			</tr>
			<tr>
				<td align=right><button class="btn btn-primary btn-sml"
						type="submit" title="Iniciar Sesion" name="btnIniciar">Iniciar Sesion</button></td>
			</tr>
			<tr>
				<td align=right><a class="centrado" href="Quelastima.jsp">Olvidaste
						tu contrasenia?</a></td>
			</tr>
		</table>
		</div>
	</form>
	<%
	int dni=0;
	String pass="";
				
		UsuarioUtil uu=new UsuarioUtil();
		if (request.getParameter("btnIniciar")!=null){
			pass=request.getParameter("passUsu");
			dni= Integer.parseInt(request.getParameter("dniUsu"));
			String sdni=request.getParameter("dniUsu");
		    HttpSession sesion=request.getSession();
			int lvl=uu.nivellogin(dni, pass);
		    switch(lvl){
			case 1: sesion.setAttribute("usuario", sdni);
					sesion.setAttribute("nivel", "1");
				
					response.sendRedirect("menu-main.jsp");
				break;
			default:
				out.print("Usuario o contrasenia incorrectos");
				break;
				}
			}
		if(request.getParameter("cerrar")!=null){
			session.invalidate();
		}
	%>
</body>

</html>