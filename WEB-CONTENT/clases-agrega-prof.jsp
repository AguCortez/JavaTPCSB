<%@page import="util.sociosUtil"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entites.*"%>
<%@page import="util.*"%>
<%@ include file="menu-header.jsp"%>
<body>	
<%
	profesionalUtil p =new profesionalUtil();
	LinkedList<Profesional> profes=new LinkedList<Profesional>();
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
	<div class="container">
	<h1>Seleccione el profesional que prefiere para la clase</h1>
	<hr>
	
	<%
	profes= p.getAll();
	%>	
	<%
			for (Profesional pr: profes){
			%>
		<table class="table table-bordered">
			<tr>
				<th class="text-center">Nombre y Apellido</th>
			</tr>
		
			<tr>
				<td class="text-center"><%=pr.getNombre() +" "+pr.getApellido() %></td>
		
		</td>
		<a href="clases-nuevo.jsp?dni=<%=pr.getDni() %>"class="btn btn-info btn-sm">Seleccionar</a>
	
		<%} %>
				
			
		</table>
<%@ include file="menu-foot.jsp" %>