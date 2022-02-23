<!DOCTYPE html>
<%@page import="util.UsuarioUtil"%>
<%@page import="java.net.http.*" %>
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
.gim {
	background-image:
		url("https://scontent.fros8-1.fna.fbcdn.net/v/t39.30808-6/265297748_5203088276386853_7818040945558415977_n.jpg?_nc_cat=105&ccb=1-5&_nc_sid=730e14&_nc_eui2=AeFIbdbLKOYU86oWBTy0y7DpwfYx7nWkuWvB9jHudaS5a5mDV1RAoKWEnD_53JAlM05f9UcPuQk7ZyP9rnBlxaRb&_nc_ohc=nJ0TtEggW-kAX94aYvL&_nc_ht=scontent.fros8-1.fna&oh=00_AT9GGoDMTfHkB71WcUkPWD95nOoRQjQ5sglc1WPyJRU6Fg&oe=61BD51C6");
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
	<form action="menu-main.jsp" method="post">
<!-- 	<form action="tablasocio.jsp" method="post"> -->
		<table align=center>
			<tr>
				<p class="centrado">
					&nbsp;<label id="Label2"><strong>Bienvenidos!</strong></label>
				</p>
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
						type="submit" title="Iniciar Sesion" naem="btnIniciar">Iniciar Sesion</button></td>
			</tr>
			<tr>
				<td align=right><a class="centrado" href="Quelastima.jsp">Olvidaste
						tu contrasenia?</a></td>
			</tr>
		</table>
	</form>
	<%
		String nombre="";
		
		UsuarioUtil uu=new UsuarioUtil();
		if (request.getParameter("btnIniciar")!=null){
			String pass=request.getParameter("passUsu");
			int dni= Integer.parseInt(request.getParameter("dniUsu"));
			
		    HttpSession sesion=request.getSession();
			
		    switch(uu.nivellogin(dni, pass)){
			case 1: sesion.setAttribute("usuario", nombre);
					sesion.setAttribute("nivel", "1");
					response.sendRedirect("main-menu.jsp");
				break;
			default:
				out.write("Usuario o contrasenia incorrectos");
				break;
				}
			}
	%>
</body>

</html>