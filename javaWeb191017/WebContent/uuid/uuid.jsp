<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.UUID" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>uuid.jsp</title>
</head>
<body>
	<%
		String uuid = UUID.randomUUID().toString();
		session.setAttribute("uuid", uuid);
	%>
	
	${ errormsg}
	
	<script type="text/javascript">
		window.onload = function(){
			//获取按钮的对象
			var btn = document.getElementById("btn");
			//为按钮绑定单击响应函数
			btn.onclick = function(){
				//点击以后按钮不可用
				this.disable = true;
				//当将提交按钮设置为不可用时, 会自动取消它的默认行为
				//手动提交表单
				this.parentNode.submit();
			};
		};
	</script>
	
	<form action="${ pageContext.request.contextPath}/UUIDServlet">
		<input type ="text" name="uuid" value="<%= uuid%>" />
		user:<input type="text" name="username"/>
		password:<input type="password" name="pwd">
		<input type="submit" value="提交 " >
	</form>
</body>
</html>