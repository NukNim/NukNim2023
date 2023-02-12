package member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.member.vo.MemberVo;
import member.model.service.MemberService;

/**
 * Servlet implementation class MemberListController
 */
@WebServlet("/memberlist")
public class MemberListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//login check
		try {
			Object obj = request.getSession().getAttribute("loginss");
			String loginss = (String)obj;
			if(loginss.equals("Y")) {
				List<MemberVo> volist = new MemberService().selectMemberList();
				request.setAttribute("memberlist", volist);
				request.getRequestDispatcher("/WEB-INF/memberlist.jsp").forward(request, response);
				return;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		response.sendRedirect(request.getContextPath()+"/");
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
