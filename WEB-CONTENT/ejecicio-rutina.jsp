<%@page import="util.sociosUtil"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.LinkedList"%>
<%@page import="entites.*"%>
<%@page import="util.*"%>
<%@ include file="menu-header.jsp"%>
<body>	
<%
	rutinaUtil r =new rutinaUtil();
	LinkedList<Rutina> rutinas=new LinkedList<Rutina>();
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
	<h1>Seleccione a que rutina quiere añadirle el ejercicio </h1>
	<hr>
	
	<%
	rutinas= r.getAll();
	%>	
			
		<table class="table table-bordered">
			<tr>
				<th class="text-center">Socio</th>
				<th class="text-center">dia</th>
				<th class="text-center">id-Rutina</th>
				<th class="text-center"> Profesional</th>
			</tr>
			<%
			for (Rutina ru: rutinas){
			%>
			<tr>
				<%Socio s=new Socio();
					sociosUtil su=new sociosUtil();
					s=su.getBydni(ru.getDni());   %>
				<td class="text-center"><%=s.getNombre_soc()+" "+s.getApellido_soc() %></td>
				<td class="text-center"><%=ru.getDia() %></td>
				<td class="text-center"><%=ru.getIdRutina() %></td>
				<%Profesional p=new Profesional();
					profesionalUtil pu=new profesionalUtil();
					p=pu.getBylegajo(ru.getLegajo());   %>
				<td class="text-center"><%=p.getNombre()+" "+p.getApellido() %></td>
				<td>
				<a href="ejercicio-nuevo.jsp?idrutina=<%=ru.getIdRutina()%>"class="btn btn-info btn-sm">Seleccionar</a>
			
				</td>
			</tr>
			<%	}	%>
			
		</table>
<%@ include file="menu-foot.jsp" %>