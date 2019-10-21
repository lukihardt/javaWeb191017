package sopo.cn.servlet20191017;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestFourObjectAttr_Get
 */
@WebServlet("/TestFourObjectAttr_Get")
public class TestFourObjectAttr_Get extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestFourObjectAttr_Get() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").println(request.getContextPath());
		//servlet中无法得到pageContext对象
		String requestAttr = (String) request.getAttribute( "requestAttr");
		String sessionAttr = (String) request.getSession().getAttribute( "sessionAttr");
		String applicationAttr = (String) getServletContext().getAttribute( "applicationAttr");
		
		PrintWriter out = response.getWriter();
		System.out.println("requestAttr: " + requestAttr); out.println(requestAttr);
		System.out.println("sessionAttr: " + sessionAttr); out.println(sessionAttr);
		System.out.println("applicationAttr: " + applicationAttr); out.println(applicationAttr);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
