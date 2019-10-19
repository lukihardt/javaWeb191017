package sopo.cn.servlet20191017;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ReadPropertiesFile")
public class ReadPropertiesFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReadPropertiesFile() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		Properties properties = new Properties();
		out.println("");
//		System.out.println(getServletContext().getRealPath("config.properties"));
		properties.load(new FileReader(getServletContext().getRealPath("config.properties")));
		System.out.print(properties.getProperty("username"));
		System.out.print("@");
		System.out.println(properties.getProperty("password"));
		
		//输出在网页
		out.print(properties.getProperty("username"));
		out.print("@");
		out.println(properties.getProperty("password"));
		
		System.out.println(getServletContext().getContextPath());
		
		//通过req，获取请求url地址
		System.out.println("request.getRequestURI(): " + request.getRequestURI());;
		out.println("request.getRequestURI(): " + request.getRequestURI());
		
		System.out.println("request.getMethod(): " + request.getMethod());
		out.println("request.getMethod(): " + request.getMethod());
		
		System.out.println("request.getQueryString(): " + request.getQueryString());
		out.print("request.getQueryString(): " + request.getQueryString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
