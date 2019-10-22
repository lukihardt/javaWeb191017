<%@page import="java.awt.Window"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lession14RelaySevlet1.2.JSP</title>
</head>
<body>
	<%
		String value = request.getParameter("inputAttribute");
		request.setAttribute("reqAttr", value);
	%>
	jumping to Lession14RelaySevlet2.2...
	<%
		//Thread.sleep(3000);
		
		RequestDispatcher rd = request.getRequestDispatcher("Lession14RelaySevlet2.2.jsp");
		rd.forward(request, response);
	%>
	
</body>
</html>