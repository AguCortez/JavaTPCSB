<!DOCTYPE html>
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
<% if (session.isNew()!=false)
{
	  String msg= (String)session.getAttribute("mensajeError");
	  if (msg!=null)
	  {
		  out.print("Estado: "+msg);
	  }
}
%>
<body>
	<form action="tablasocio.jsp" method="post">
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
				<td align=center>Contraseña</td>
				<td align=center><input type="password" size=30 name="passUsu"></input></td>
			</tr>
			<tr>
				<td align=right><button class="btn btn-primary btn-sml"
						type="submit" title="Iniciar Sesion">Iniciar Sesion</button></td>
			</tr>
			<tr>
				<td align=right><a class="centrado" href="Quelastima.jsp">Olvidaste
						tu contrasenia?</a></td>
			</tr>
		</table>
	</form>
</body>

</html>