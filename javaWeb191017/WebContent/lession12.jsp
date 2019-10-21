<%@page import="org.apache.catalina.connector.Response"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lession12.jsp</title>
</head>
<body>
<%
	response.getWriter().println("hello<br>");//这里ln不起作用
	response.getWriter().write("hello<br>");
	test();
	
%>

<%="haha" %>

<%!
	public void test(){
	System.out.println("testMethod");
} %>
<%-- JSP特有的注释--%>
<%-- 现在时间是<%=(new java.util.Date()).toLocalString()%> --%>
</body>
</html>