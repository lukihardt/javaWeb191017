<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TestFourObjectAttr_Set.jsp</title>
</head>
<body>
	<%
		pageContext.setAttribute( "pageContextAttr", "pageContextAttr's value");
		request.setAttribute( "requestAttr", "requestAttr's value");
		session.setAttribute( "sessionAttr", "sessionAttr's value");
		application.setAttribute( "applicationAttr", "applicationAttr's value");
	%>
	setAttribute completely
</body>
</html>