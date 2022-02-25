
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entites.*"%>
<%@page import="util.rutinaUtil"%>
<%@ include file="menu-header.jsp"%>s
<body>	
<%
	rutinaUtil r =new rutinaUtil();
	LinkedList<Rutina> rutinas=new LinkedList<Rutina>();
%>	
	
	<div class="container">
	<h1>Lista de Rutinas</h1>
	<hr>
	<form class="form">
	<table>
		<tr>
			<td><a class = "btn btn-success btn-lg" href="rutina-nuevo.jsp">Nueva Rutina</a></td>
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
	rutinas= r.getAll();
	%>	
			
		<table class="table table-bordered">
			<tr>
				<th class="text-center">DNI</th>
				<th class="text-center">dia</th>
				<th class="text-center">idRutina</th>
				<th class="text-center"> LEGAJO</th>
			</tr>
			<%
			for (Rutina ru: rutinas){
			%>
			<tr>
				<td class="text-center"><%=ru.getDni() %></td>
				<td class="text-center"><%=ru.getDia() %></td>
				<td class="text-center"><%=ru.getIdRutina() %></td>
				<td class="text-center"><%=ru.getLegajo() %></td>
				<td>
				<a href="rutina-editar.jsp?dni=<%=ru.getDni() %>"class="btn btn-warning btn-sm">Editar</a>
			
				<a href="rutina-borrar.jsp?dni=<%=ru.getDni() %>" class= "btn btn-danger btn-sm">Eliminar</a>
				</td>
			</tr>
			<%	}	%>
			
		</table>
<%@ include file="menu-foot.jsp" %>