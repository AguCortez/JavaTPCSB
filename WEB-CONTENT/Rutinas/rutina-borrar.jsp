<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="entites.*"%>
<%@page import="util.rutinaUtil"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Borrando</title>
</head>
<body>
<%
	int id=Integer.parseInt(request.getParameter("id"));
	rutinaUtil ru= new rutinaUtil();
	ru.bajaRutina(id);	
	response.sendRedirect("rutina-tabla.jsp");

%>
</body>
</html>
