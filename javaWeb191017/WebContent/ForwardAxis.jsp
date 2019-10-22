<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ForwardAxis.jsp</title>
</head>
<body>
	<%
		String value = request.getParameter("reqAttr");
		request.setAttribute("reqAttr", value);
		
		RequestDispatcher rd = request.getRequestDispatcher("ForwardFinal.jsp");
		rd.forward(request, response);
	%>
</body>
</html>