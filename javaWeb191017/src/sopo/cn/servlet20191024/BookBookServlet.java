package sopo.cn.servlet20191024;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sopo.cn.model20191023.Book;
import sopo.cn.utils20191023.DBUtil;

/**
 * Servlet implementation class BookBookServlet
 */
@WebServlet("/BookBookServlet")
public class BookBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/jsp;charset=UTF-8");
		response.getWriter().append("Served at: ").println(request.getContextPath());
		String bookid = request.getParameter("id");
		Book book = new Book();
		try {
			book = DBUtil.findBookById(bookid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		
		List<Book> list = (List<Book>) session.getAttribute("boughtCar");
		
		if (list == null) {
			list = new ArrayList<Book>();
		}
		System.out.println(book);
		list.add(book);
		
		session.setAttribute( "boughtCar", list);
		
		PrintWriter out = response.getWriter();
		out.println( "添加购物车成功!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
