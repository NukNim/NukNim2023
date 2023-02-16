package com.kh.board.boardwrite;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.boardDTO.BoardDto;

/**
 * Servlet implementation class BoardWriteController
 */
@WebServlet("/write")
public class BoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDto dto = new BoardDto();
		dto = (BoardDto)request.getSession().getAttribute("userinfo");
		
		request.getRequestDispatcher("/WEB-INF/view/BoardWrite.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDto dto = new BoardDto();
		BoardDto sdto = new BoardDto();
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("boardid");
		String bTitle = request.getParameter("boardtitle");
		String bContent = request.getParameter("bContext");
		String pw = request.getParameter("boardpw");

		dto.setUserId(id);
		dto.setUserPw(pw);
		dto.setTitle(bTitle);
		dto.setContent(bContent);
		
		BoardWriteService bws = new BoardWriteService();
		
		int result = bws.insertBoard(dto);
		
		sdto.setUserId(id);
		sdto.setUserPw(pw);
		
		if(result == 1) {
			request.getSession().setAttribute("userinfo", sdto);
			response.sendRedirect(request.getContextPath()+"/list");
		}else {
			response.sendRedirect(request.getContextPath()+"/");
		}

	}

}
