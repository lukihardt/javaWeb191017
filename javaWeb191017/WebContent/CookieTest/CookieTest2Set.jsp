<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CookieTest2.jsp</title>
</head>
<body>
	<%-- <%
		Cookie cookie = new Cookie( "username01984k", "passwordalksj923");
		cookie.setMaxAge(1000);
		out.println( cookie.getName() + ": " + cookie.getValue());
	%> --%>
	
	<%
		Cookie cookie = new Cookie( "username01984k", "passwordalksj923");
		cookie.setMaxAge(-1);
		cookie.setDomain("google.com");
		cookie.setPath("/");
		response.addCookie(cookie);
		
		request.getRequestDispatcher("/CookieTest/CookieTest2Get.jsp").forward(request, response);
	%>
</body>
</html>