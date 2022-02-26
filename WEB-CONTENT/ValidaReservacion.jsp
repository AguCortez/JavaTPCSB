<%@page import="util.*" %>
<%@page import= "entites.*" %>
<%@page import="java.util.LinkedList" %>
<%@include file="menu-header.jsp" %>
<title>Reserva un cupo</title>
<% 
	HttpSession sesion= request.getSession();
	String user="", lvl;	
if(sesion.getAttribute("usuario")!=null && sesion.getAttribute("nivel")!=null)
	{
	user=sesion.getAttribute("usuario").toString();
	lvl=sesion.getAttribute("nivel").toString();

	}
else{
	out.print("<script>location.replace('index.jsp');</script>"); 
}
	reservaUtil ru=new reservaUtil();
	claseUtil cu=new claseUtil();
	Reserva r=new Reserva();
	int Idr=(int)(Math.random()*1000+1);
	String idclase=request.getParameter("idclase");
	int dni=Integer.parseInt(user);
	ru.altaReserva(Idr, dni, idclase);
	cu.modcupo(Integer.parseInt(idclase));
	response.sendRedirect("inscripcion.jsp");
%>


<%@ include file="menu-foot.jsp" %>
