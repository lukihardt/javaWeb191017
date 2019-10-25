<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signIn.jsp</title>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies();
		String account = null;
		String ssid = null;
		if (cookies != null && cookies.length > 0) {
			for (Cookie coo : cookies) {
				if (coo.getName().equals("userKey")) {
					account = coo.getValue();
					System.out.println(account);
				}

				if (coo.getName().equals("ssid")) {
					ssid = coo.getValue();
					System.out.println("==" + ssid);
				}
			}
		}

		if (account != null && ssid != null) {
			request.getRequestDispatcher("/CookieTest/main.jsp").forward(request, response);
		}
	%>
	<form action="login.jsp">
		userName:<input type="text" name="username" /><br> password:<input
			type="password" name="password" /><br> expireDays: <select
			name="selectValue">
			<option value="7">7Days</option>
			<option value="30">30Days</option>
			<option value="100">Forever</option>
			<option value="-1">不记住</option>
		</select> <input type="submit">
	</form>
</body>
</html>