<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CookieTest2Get.jsp</title>
</head>
<body>
	这是CookieTest2Get.jsp<br>
	<%
		// System.out.print(request.getCookies());
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie coo : cookies) {
				System.out.println("cookie的名字: " + coo.getName() + "  " + "cookie的值: " + coo.getValue());
				out.println("cookie的名字: " + coo.getName() + "  " + "cookie的值: " + coo.getValue());
				out.println("<br>");
			}
		}
	%>
</body>
</html>