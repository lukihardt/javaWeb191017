<%@page import="sopo.cn.utils20191023.Captcha"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>checkCode.jsp</title>
</head>
<body>
	<%
		Captcha.getInstance().drawCheckCode(request, response);
	
		out.clear();                               // 这两行很关键，解决了getOutputStream() has already been called for this response异常
		out = pageContext.pushBody();              // 参考网址：https://blog.csdn.net/wangchaoqi1985/article/details/81259469
	%>
</body>
</html>