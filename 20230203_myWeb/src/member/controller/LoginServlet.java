package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import first.common.JDBCTemplate;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginurl")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * request.setCharacterEncoding("UTF-8");
		 * response.setContentType("text/html; charset=UTF-8");
		 * 
		 * PrintWriter out = response.getWriter();
		 * 
		 * out.append("Served at: ").append(request.getContextPath());
		 * out.append("<h1><b>  추가  /</b></h1>");
		 */
		
		JDBCTemplate.getConnection();
		
		//response.sendRedirect(request.getContextPath()+"/?a=aaa");
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("loginurl - doPost");
		String id = request.getParameter("n1");
		String pw = request.getParameter("n2");
		int result =1;
		if(result ==1) {
			response.sendRedirect(request.getContextPath() + "/");
			System.out.println(id +"          "+ pw);
		}
	}

}
