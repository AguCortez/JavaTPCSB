
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entites.*"%>
<%@page import="util.tiporutinaUtil"%>
<%@ include file="menu-header.jsp"%>
<body>	
<%
	tiporutinaUtil tr =new tiporutinaUtil();
	LinkedList<TipoRutina> tipos=new LinkedList<TipoRutina>();
%>	
	<div class="container">
	<h1>Tipo de Rutinas</h1>
	<hr>
	<form class="form">
	<table>
		<tr>
			<td><a class = "btn btn-success btn-lg" href="socio-nuevo.jsp">Nuevo Tipo de rutina</a></td>
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
	tipos= tr.getAll();
	%>	
			
		<table class="table table-bordered">
			<tr>
				<th class="text-center">ID tipo rutina</th>
				<th class="text-center">Descripcion</th>
			</tr>
			<%
			for (TipoRutina t: tipos){
			%>
			<tr>
				<td class="text-center"><%=t.getId_tipo() %></td>
				<td class="text-center"><%=t.getDescripcion() %></td>
		

				<td>
				<a href="tipoRutina-editar.jsp?id_tipo=<%=t.getId_tipo() %>"class="btn btn-warning btn-sm">Editar</a>
			
				<a href="tipoRutina-borrar.jsp?id_tipo=<%=t.getId_tipo() %>" class= "btn btn-danger btn-sm">Eliminar</a>
				</td>
			</tr>
			<%	}	%>
			
		</table>
<%@ include file="menu-foot.jsp" %>
