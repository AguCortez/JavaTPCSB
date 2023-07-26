
<%@page import="util.*" %>
<%@page import= "entites.*" %>
<%@page import="java.util.LinkedList" %>
<%@include file="../menu-header.jsp" %>
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
<%
	tipoclaseUtil c =new tipoclaseUtil();
	LinkedList<TipoClase> clase=new LinkedList<TipoClase>();
%>
	<br>
	<br>
	<div class="container">
	
		
		
	</div>
	<br>
	<div class="container">
	<h1>Lista de tipos de Clases</h1>
	<hr>
	<form class="form">
	<table>
		<tr>
			<td><a class = "btn btn-success btn-lg" href="tipoclases-nuevo.jsp">Nueva Clase</a></td>
			<td></td>
			<td></td>
			<td></td>
			<form class="form-inline">
				<input class="form-control" type="search" name="txtbuscar">
				<input class="btn btn-out" type="submit" name = "accion" value="Buscar">	
			</form>
			<%
				String nombuscar=request.getParameter("txtbuscar");
				if (nombuscar!=null ){
					clase = c.buscaNom(nombuscar);
					System.out.print(nombuscar);
				}else{
					clase = c.getAll();
				}
				
			
			%>
		</tr>
	</table>
	</form>	

		<br>
		<br>
		<br>	
		<table class="table table-bordered">
			<tr>
				<th class="text-center">Id tipo</th>
				<th class="text-center">Nombre Clase</th>
				<th class="text-center">Descripcion </th>
				
			</tr>
			<%
			for ( TipoClase a: clase){
			%>
			<tr>
				<td class="text-center"><%=a.getIdtipo_clase() %></td>
				<td class="text-center"><%=a.getNombre_clase() %></td>
				<td class="text-center"><%=a.getDescripcion() %></td>				
				<td>
				<a href="tipoclases-editar.jsp?id=<%=a.getIdtipo_clase() %>"class="btn btn-warning btn-sm">Editar</a>
			
				<a href="tipoclases-borrar.jsp?id=<%=a.getIdtipo_clase() %>" class= "btn btn-danger btn-sm">Eliminar</a>
				</td>
			</tr>
			<%	}	%>
			
			
		</table>
<%@ include file="../menu-foot.jsp" %>