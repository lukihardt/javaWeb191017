package sopo.cn.servlet20191024;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UUIDServlet
 */
@WebServlet("/UUIDServlet")
public class UUIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UUIDServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType( "text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.getWriter().append("Served at: ").println(request.getContextPath());
		
		String reqUUID = request.getParameter("uuid");
		HttpSession session = request.getSession();
		String sessUID = (String) session.getAttribute("uuid");
		session.removeAttribute("uuid");
		
		if (reqUUID.equals(sessUID)) {
			response.sendRedirect(request.getContextPath() + "/uuid/login_success.jsp");
			System.out.println("已经登陆过了");
		} else {
			request.setAttribute( "errormsg", "重复登陆");
			request.getRequestDispatcher("uuid/uuid.jsp").forward( request, response);
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
