<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entites.*"%>
<%@page import="util.*"%>
<%@include file="menu-header.jsp" %>

<%

	cuotaUtil c =new cuotaUtil();
	LinkedList<Cuota> cuotas =new LinkedList<Cuota>();
%>
	<br>
	<br>
	<div class="container">
	
		
		
	</div>
	<br>
	<div class="container">
	<h1>Lista de Cuotas</h1>
	<hr>
	<form class="form">
	<table>
		<tr>
			<td><a class = "btn btn-success btn-lg" href="cuotas-nuevo.jsp">Nueva Cuota</a></td>
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
			
 			cuotas= c.getAll();
			
		
		
 		
			%>
		<br>
		<br>
		<br>	
		<table class="table table-bordered">
			<tr>
				<th class="text-center">IdCuota</th>
				<th class="text-center">Anio</th>
				<th class="text-center">Mes</th>
				<th class="text-center">Precio</th>
				<th class="text-center">Fecha_pago</th>
			</tr>
			<%
			for (Cuota a: cuotas){
			%>
			<tr>
				<td class="text-center"><%=a.getIdCuota() %></td>
				<td class="text-center"><%=a.getAnio() %></td>
				<td class="text-center"><%=a.getMes() %></td>
				<td class="text-center"><%=a.getPrecio() %></td>
				<td class="text-center"><%=a.getFecha_pago() %></td>
				<td>
				<a href="cuotas-editar.jsp?dni=<%=a.getIdCuota() %>"class="btn btn-warning btn-sm">Editar</a>
			
				<a href="cuotas-borrar.jsp?dni=<%=a.getIdCuota() %>" class= "btn btn-danger btn-sm">Eliminar</a>
				</td>
			</tr>
			<%	}	%>
			
		</table>
<%@ include file="menu-foot.jsp" %>

