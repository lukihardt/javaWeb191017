<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session191024.JSP</title>
</head>
<body>
	<%
		session = request.getSession(true);
		session.setAttribute("loginTime", new Date());
		Thread.sleep(5000);
		out.println("登录时间为： " + session.getAttribute("loginTime") + "<br>");
		out.println("现在时间为： " + new Date());
	%>
</body>
</html>