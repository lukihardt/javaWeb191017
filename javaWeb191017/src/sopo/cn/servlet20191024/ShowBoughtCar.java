package sopo.cn.servlet20191024;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sopo.cn.model20191023.Book;

/**
 * Servlet implementation class ShowBoughtCar
 */
@WebServlet("/ShowBoughtCar")
public class ShowBoughtCar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowBoughtCar() {
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
		response.setContentType("text/jsp;charset=utf-8");
		response.getWriter().append("Served at: ").println(request.getContextPath());
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		List<Book> list = (List<Book>) session.getAttribute("boughtCar");
		System.out.println(list);
		
		if (list == null) {
			out.println("你什么都没买呢");
			response.setHeader("refresh", "2;url="+ getServletContext().getContextPath() +"/sessionBook/showBoughtCar.jsp");
		} else {
			for (Book book : list) {
				out.println(book.toString());
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
