<%@page import="sopo.cn.model20191023.Book"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.mysql.cj.xdevapi.PreparableStatement"%>
<%@page import="sopo.cn.utils20191023.DBUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
</head>
<body>

	<%
		session.setAttribute("boughtCar", null);
	%>

	<%
		Connection connection = DBUtil.getConnectionC3p0();
		String sql = "select * from book";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet rs = preparedStatement.executeQuery();

		while (rs.next()) {
			Book book = new Book();
			book.setId(rs.getInt(1));
			book.setB_name(rs.getString(2));
			book.setB_price(rs.getDouble(3));
			book.setAuthor_id(rs.getInt(4));
			book.setPublish_date(rs.getDate(5));
	%>
	<table>
		<tr>
			<td><%=book.getId()%></td>
			<td><%=book.getB_name()%></td>
			<td><%=book.getB_price()%></td>
			<td><%=book.getAuthor_id()%></td>
			<td><%=book.getPublish_date()%></td> 
		</tr>
	</table>

	<%
		}
	%>


	<br><br>
	<form
		action="<%=getServletContext().getContextPath()%>/BookBookServlet">
		nameId<input type="text" name="id" /> <input type="submit" />
	</form>

	<br><br>
	<form action="<%=getServletContext().getContextPath()%>/ShowBoughtCar">
		<input type="submit" name="SBC" value="显示购物车内容">
	</form>

</body>
</html>