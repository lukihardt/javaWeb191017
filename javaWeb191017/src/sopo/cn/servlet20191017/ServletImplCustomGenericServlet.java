package sopo.cn.servlet20191017;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	@WebServlet("/ServletImplCustomGenericServlet")
	public class ServletImplCustomGenericServlet extends CustomGenericServlet {
	       
		private static final String METHOD_GET = "GET";
		private static final String METHOD_POST = "POST";
		
		
	    @Override
		public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
			// TODO Auto-generated method stub
			
	    	HttpServletRequest request = (HttpServletRequest) servletRequest;
	    	HttpServletResponse response = (HttpServletResponse) servletResponse;
	    	service(request, response);
		}
	    
	    protected void service(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
	    	// 根据请求方式,决定使用的方法
	    	String method = httpServletRequest.getMethod();
	    	
	    	if (method.equalsIgnoreCase(METHOD_GET)) {
				doGet(httpServletRequest, httpServletResponse);
			} else if (method.equalsIgnoreCase(METHOD_POST)) {
				doPost(httpServletRequest, httpServletResponse);
			}
	    }

		/**
	     * @see HttpServlet#HttpServlet()
	     */
	    public ServletImplCustomGenericServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			response.getWriter().append("Served at: ").println(request.getContextPath());
			System.out.println("========CustomServlet");
			response.getWriter().println("========CustomServlet");
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}

	}
