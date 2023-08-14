<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entites.*"%>
<%@page import="util.*"%>
<%@ include file="../menu-header.jsp"%>
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

		ejercicioUtil ej =new ejercicioUtil();
		LinkedList<Ejercicio> ejers=new LinkedList<Ejercicio>();
%>
	<br>
	<br>
	<div class="container">
	
	
		
	</div>
	<br>
	<div class="container">
	<h1>Lista de Ejercicios</h1>
	<hr>
	<form class="form">
	<table>
		<tr>
			<td><a class = "btn btn-success btn-lg" href="ejercicio-nuevo.jsp">Nuevo Ejercicio</a></td>
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
					ejers= ej.buscaDesc(nombuscar);
					System.out.print(nombuscar);
				}else{
					ejers= ej.getAll();
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
				
				<th class="text-center">descripcion</th>
				<th class="text-center">idtipo</th>

			</tr>
			<%
			for (Ejercicio e: ejers){
			%>
			<tr>
				
				<td class="text-center"><%=e.getDescripcion() %></td>
				<td class="text-center"><%=e.getIdtipo()%></td>
				
				<td>
				<a href="ejercicio-editar.jsp?idEj=<%=e.getIdtipo()%>"class="btn btn-warning btn-sm">Editar</a>
			
				<a href="ejercicio-borrar.jsp?idEj=<%=e.getIdtipo() %>" class= "btn btn-danger btn-sm">Eliminar</a>
				</td>
			</tr>
			<%    }    %>
			
		</table>
	<%@ include file="../menu-foot.jsp" %>