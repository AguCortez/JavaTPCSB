
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entites.*"%>
<%@page import="util.profesionalUtil"%>
<%@ include file="menu-header.jsp"%>
<%		
	profesionalUtil p =new profesionalUtil();
	LinkedList<Profesional> profesionales=new LinkedList<Profesional>();
	Profesional elProf= new Profesional(); 
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
	<h1>Lista de Profesionales</h1>
	<hr>
	<form class="form">
	<table>
		<tr>
			<td><a class = "btn btn-success btn-lg" href="profesional-nuevo.jsp">Nuevo Profesional</a></td>
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
	<%profesionales= p.getAll();
		/*String legajo= request.getParameter("txtbuscar");
 		if(legajo== null || legajo.equals("")){
 			
			
		
		}else{
			int legajo2= Integer.parseInt(legajo);
			elProf= p.getBylegajo(legajo2);}
 		*/
			%>
		<br>
		<br>
		<br>	
		<table class="table table-bordered">
			<tr>
				<th class="text-center">Dni</th>
				<th class="text-center">Nombre</th>
				<th class="text-center">Apellido</th>

			</tr>
			<%
			for (Profesional pr: profesionales){
			%>
			<tr>
				<td class="text-center"><%=pr.getDni()%></td>
				<td class="text-center"><%=pr.getNombre()%></td>
				<td class="text-center"><%=pr.getApellido()%></td>
				<td>
				<a href="profesional-editar.jsp?dni=<%=pr.getDni() %>"class="btn btn-warning btn-sm">Editar</a>
			
				<a href="profesional-borrar.jsp?dni=<%=pr.getDni() %>" class= "btn btn-danger btn-sm">Eliminar</a>
				</td>
			</tr>
			<%}			%>
			
		</table>
	<%@ include file="menu-foot.jsp" %>