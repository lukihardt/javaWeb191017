<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CookieTest.jsp</title>
</head>
<body>
<%
	Cookie[] cookies = request.getCookies();

	if( cookies != null && cookies.length > 0){
		for(Cookie coo : cookies){
			System.out.println( "cookie的名字: " + coo.getName() + "  " + "cookie的值: " + coo.getValue());
			out.println("cookie的名字: " + coo.getName() + "  " + "cookie的值: " + coo.getValue());
		}
	} else{
		Cookie cookie1 = new Cookie( "uuid92ui349", "password21348ka");
		Cookie cookie2 = new Cookie( "uuid22uiasd", "password3t4yhjls");
		response.addCookie(cookie1);
		response.addCookie(cookie2);
	}
%>
</body>
</html>