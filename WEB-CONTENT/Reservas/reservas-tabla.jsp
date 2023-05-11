
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entites.*"%>
<%@page import="util.reservaUtil"%>
<%@ include file="../menu-header.jsp"%>s
<body>	
<%

    reservaUtil r =new reservaUtil();
	LinkedList<Reserva> reserva=new LinkedList<Reserva>();
%>
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
	<br>
	<br>
	<div class="container">
	
		
		
	</div>
	<br>
	<div class="container">
	<h1>Lista de Reservas</h1>
	<hr>
	<form class="form">
	<table>
		<tr>
			<td><a class = "btn btn-success btn-lg" href="reservas-nuevo.jsp">Nueva Reserva</a></td>
			<td></td>
			<td></td>
			<td></td>
			
			<td>
			<input class="form-control" type="text" name="txtbuscar">
			</td>
			<td>
			<input class="btn btn" type="submit" value="Buscar">	
			</td>
		</tr>
	</table>
	</form>	
	<%
			
	      reserva= r.getAll();
	%>
		<br>
		<br>
		<br>	
		<table class="table table-bordered">
			<tr>
				<th class="text-center">Id reserva</th>
				<th class="text-center">Fecha</th>
				<th class="text-center">DNI</th>
				<th class="text-center">Codigo</th>
				
				
			</tr>
			<%
			for (Reserva a: reserva){
			%>
			<tr>
				<td class="text-center"><%=a.getId_reserva() %></td>
				<td class="text-center"><%=a.getDate() %></td>
				<td class="text-center"><%=a.getDni() %></td>
				<td class="text-center"><%=a.getCodigo() %></td>
				
				
				<td>
				<a href="editarSocio.jsp?dni=<%=a.getDni() %>"class="btn btn-warning btn-sm">Editar</a>
			
				<a href="borraSocio.jsp?dni=<%=a.getDni() %>" class= "btn btn-danger btn-sm">Eliminar</a>
				</td>
			</tr>
			<%	}	%>
			
		</table>
<%@ include file="../menu-foot.jsp" %>