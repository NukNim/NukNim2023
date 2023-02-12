package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import first.common.JDBCTemplate;
import member.model.service.MemberService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginurl")
public class LoginExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginExamServlet() {
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
		
		MemberService ms = new MemberService();
		
		int result = ms.login(id, pw);
		
		System.out.println(result);
		
		if(result ==1) {
			
			request.getSession().setAttribute("loginss", "Y");
			request.getSession().setAttribute("loginssGrade", "3");
			
			request.setAttribute("msg", id+"님 로그인 완료");
		}else if(result == -1){
			request.setAttribute("msg", "로그인실패");
		}else {
			request.setAttribute("msg", "아이디 없음");
		}
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

}
