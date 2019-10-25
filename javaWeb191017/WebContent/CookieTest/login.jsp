<%@page import="sopo.cn.service20191023.UserService"%>
<%@page import="sopo.cn.model20191023.User"%>
<%@page import="sopo.cn.utils20191023.CookieUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login.jsp</title>
</head>
<body>
	<%
		String username = request.getParameter("username");
		username = username == null ? "" : username;
		String password = request.getParameter("password");
		password = password == null ? "" : password;
		String expireDays = request.getParameter("selectValue");
		System.out.println("~"+expireDays);
		Cookie[] cookies = request.getCookies();
		
		// 测试用：输出cookies
		for(Cookie coo : cookies){
			System.out.println( "cookie的名字: " + coo.getName() + "  " + "cookie的值: " + coo.getValue());
			out.println("cookie的名字: " + coo.getName() + "  " + "cookie的值: " + coo.getValue());
		}
		
		boolean login = false;
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
					System.out.println("=="+ssid);
				}
			}
		}

		if (account != null && ssid != null) {
			login = ssid.equals(CookieUtils.md5Encrypt(account));//☆☆☆☆☆☆这里account原来是username,这是不对的, 再次访问login.jsp页面时username为空.debug成功！
		}

		System.out.println("login: " + login);

		if (!login) {
			User user = UserService.login(username, password);

			if (user != null) {
				expireDays = expireDays == null ? "" : expireDays;

				switch (expireDays) {
				case "7":
					CookieUtils.createCookie(username, request, response, 7 * 24 * 60 * 60);
					break;
				case "30":
					CookieUtils.createCookie(username, request, response, 30 * 24 * 60 * 60);
					break;
				case "100":
					CookieUtils.createCookie(username, request, response, Integer.MAX_VALUE);
					break;
				default:
					CookieUtils.createCookie(username, request, response, -1);
					break;
				}

				request.getRequestDispatcher("/CookieTest/main.jsp").forward(request, response);
			} else {
				request.setAttribute( "note", "用户名或者密码是错误的！");//暂时还没用到
				request.getRequestDispatcher("/CookieTest/error.jsp").forward(request, response);
			}
		} else{
			request.getRequestDispatcher("/CookieTest/main.jsp").forward(request, response);
		}
	%>
</body>
</html>