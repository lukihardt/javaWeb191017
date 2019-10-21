<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TestFourObjectAttr_Get.jsp</title>
</head>
<body>
	<%
		String pageContextAttr = (String) pageContext.getAttribute("pageContextAttr");
		String requestAttr = (String) request.getAttribute( "requestAttr");
		String sessionAttr = (String) session.getAttribute( "sessionAttr");
		String applicationAttr = (String) application.getAttribute( "applicationAttr");
	%>
	pageContextAttr:<%=pageContextAttr %><br>
	requestAttr:<%=requestAttr %><br>
	sessionAttr:<%=sessionAttr %><br>
	applicationAttr:<%=applicationAttr %><br>

</body>
</html>