<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entites.*"
%>
<%@page import="util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ingreso</title>
</head>
<body>
<%
String dni = request.getParameter("dniUsu");
String pass= request.getParameter("passUsu");
sociosUtil su=new sociosUtil();
int intdni;
if(su.validaSocio(Integer.parseInt(dni), pass)){
	Usuario usu= new Usuario(Integer.parseInt(dni), pass);
	HttpSession sesion= request.getSession();
	sesion.setAttribute("usuario", usu);
	RequestDispatcher rd= request.getRequestDispatcher("tablasocio.jsp");
		rd.forward(request, response);
}
else
	{
		RequestDispatcher rd=request.getRequestDispatcher("invalid.jsp");
		rd.forward(request, response);
	}
%>
</body>
</html>