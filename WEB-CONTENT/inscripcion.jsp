<%@page import="util.*" %>
<%@page import= "entites.*" %>
<%@page import="java.util.LinkedList" %>
<%@include file="menu-header.jsp" %>

<%
	String nombre="";
	reservaUtil ru=new reservaUtil();
	
    claseUtil c =new claseUtil();
	profesionalUtil pu= new profesionalUtil();
	LinkedList<Clase> clase=new LinkedList<Clase>();
%>
	<br>
	<br>
	<div class="container">
	
		
		
	</div>
	<br>
	<div class="container">
	<h1>Clases con cupo</h1>
	<hr>

	<%
			
	      clase= c.getAllconcupo();
					
			%>			
		<table class="table table-bordered">
			<tr>
				<th class="text-center">Id</th>
				<th class="text-center">Nombre</th>
				<th class="text-center">Dia</th>
				<th class="text-center">Hora</th>
				<th class="text-center">Profesor</th>
				<th class="text-center">Descripcion</th>
				
			</tr>
			<%
			for ( Clase a: clase){
				Profesional prof=pu.getBylegajo(a.getLegajo_prof());
				nombre=prof.getNombre()+" "+prof.getApellido() ;
				
			%>
			<tr>
				
				<td class="text-center"><%=a.getId() %></td>
				<td class="text-center"><%=a.getNombre() %></td>				
				<td class="text-center"><%=a.getDia() %></td>
				<td class="text-center"><%=a.getHora() %></td>
				<td class="text-center"><%=nombre %></td>
				<td class="text-center"><%=a.getDescripcion() %></td>
				
				<td>
				<%
				if() %>
				<a href="clases-editar.jsp?idclase=<%=a.getId() %>"class="btn btn-info btn-sm">Reservar cupo</a>
							
				</td>
			</tr>
			<%	}	%>
			
		</table>
<%@ include file="menu-foot.jsp" %>