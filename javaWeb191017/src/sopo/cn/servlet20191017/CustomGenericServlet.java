package sopo.cn.servlet20191017;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CustomGenericServlet implements Servlet, ServletConfig {

	private ServletConfig servletConfig;

	@Override
	public String getInitParameter(String name) {
		// TODO Auto-generated method stub
		return getServletConfig().getInitParameter(name);
	}

	@Override
	public Enumeration<String> getInitParameterNames() {
		// TODO Auto-generated method stub
		return getServletConfig().getInitParameterNames();
	}

	@Override
	public ServletContext getServletContext() {
		// TODO Auto-generated method stub
		return getServletConfig().getServletContext();
	}

	@Override
	public String getServletName() {
		// TODO Auto-generated method stub
		return getServletConfig().getServletName();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return this.servletConfig;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return this.getServletInfo();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.servletConfig = config;
		this.init();

	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
	}

	public void init() throws ServletException {
	}

}
