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
		BoardDto bdto = new BoardDto();
		dto = (BoardDto)request.getSession().getAttribute("userinfo");
		if(dto != null) {
			bdto.setUserId(dto.getUserId());
			bdto.setUserPw(dto.getUserPw());
			request.getSession().setAttribute("userinfo", bdto);
		}
		
		
		request.getRequestDispatcher("/WEB-INF/view/BoardWrite.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
