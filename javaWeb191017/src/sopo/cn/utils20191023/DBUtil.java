package sopo.cn.utils20191023;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import sopo.cn.model20191023.Book;

public class DBUtil {
	public static Book findBookById(String id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		Book book = new Book();
		
		try {
			connection = getConnectionDM();
			String sql = "select * from book where id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				book.setId(rs.getInt(1));
				book.setB_name(rs.getString(2));
				book.setB_price(rs.getDouble(3));
				book.setAuthor_id(rs.getInt(4));
				book.setPublish_date(rs.getDate(5));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			rs.close();
			preparedStatement.close();
			connection.close();
		}
		return book;
	}

	public static Connection getConnectionDM() throws IOException, ClassNotFoundException, SQLException {

		Properties properties = new Properties();
		InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
		properties.load(inputStream);
		
		String driverClass = properties.getProperty("driverClass");
		String jdbcurl = properties.getProperty("jdbcurl");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		
		// 2019/10/24 11:44 
		Class.forName(driverClass);
		return DriverManager.getConnection(jdbcurl, user, password);
	}
	
	public static Connection getConnectionC3p0() {
		Connection connection = null;
		DataSource dataSource = new ComboPooledDataSource("mysql");
		
		try {
			connection = dataSource.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return connection;
	}
}
