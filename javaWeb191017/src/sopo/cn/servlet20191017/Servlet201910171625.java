package sopo.cn.servlet20191017;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet201910171625
 */
public class Servlet201910171625 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet201910171625() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().println("");

		/*
		 * //Ç°ÕßÊä³öÔÚ¿ØÖÆÌ¨£¬ºóÕßÊä³öÔÚÍøÒ³ // System.out.println(this.getServletName());
		 * response.getWriter().println(this.getServletName());
		 * 
		 * //getInitParameter() // ServletConfig servletConfig = getServletConfig(); //
		 * System.out.println(servletConfig.getInitParameter("passWord"));
		 * response.getWriter().println(getInitParameter("passWord"));
		 * 
		 * // System.out.println(gotten); //
		 * System.out.println(getInitParameter("userName")); //
		 * System.out.println(getServletConfig().getInitParameter("userName"));
		 */

		System.out.println(getServletName());
		response.getWriter().println(getServletName());
		
		System.out.println(getInitParameter("initPara1"));
		response.getWriter().println(getInitParameter("initPara1"));
		
		Enumeration<String> enumeration = getInitParameterNames();
		while (enumeration.hasMoreElements()) {
			String name = enumeration.nextElement();
			System.out.println(name + " = " + getInitParameter(name));
			response.getWriter().println(name + " = " + getInitParameter(name));
		}
		
		// 获取单个的Context里面的初始化参数
		ServletContext servletContext = getServletContext();
		String contextPara = servletContext.getInitParameter("userName");
		//输出
		System.out.println(contextPara);
		response.getWriter().println(contextPara);
		
		System.out.println("------------------");
		
		Enumeration<String> enumeration2 = servletContext.getInitParameterNames();
		String[] strings = new String[10];
		int i = 0;
		while (enumeration2.hasMoreElements()) {
			String string = servletContext.getInitParameter(enumeration2.nextElement());
			
			
			strings[i] = string;
			i++;
		}
		
		for (int v = 0; strings[v] != null; v++) {
			System.out.print(strings[v]);
			if (v == 0) {
				System.out.print("@");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
