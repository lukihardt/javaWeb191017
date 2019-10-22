package sopo.cn.servlet20191017;

import java.io.IOException; 
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
//		response.setCharacterEncoding("UTF-8");
		response.getWriter().append("Served at: ").println(request.getContextPath()+"<br>");
		ServletContext servletContext = getServletContext();
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("");
		
		String usn = request.getParameter("username");
		String pwd = request.getParameter("password");
		
		out.println("username: " + usn);
		System.out.println("username: " + usn);
		
		out.println("password: " + pwd);
		System.out.println("password: " + pwd);
		out.println("<br>");
		
		String usnData = servletContext.getInitParameter("userName");
		String pwdData = servletContext.getInitParameter("password");
		
		System.out.println(usnData + "@" + pwdData);
		
		if (usnData.equals(usn) && pwdData.equals(pwd)) {
			out.println("登陆成功!");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
