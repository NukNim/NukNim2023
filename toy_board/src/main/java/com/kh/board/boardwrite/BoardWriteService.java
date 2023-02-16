package com.kh.board.boardwrite;

import java.sql.Connection;

import com.kh.board.boardDAO.BoardDao;
import com.kh.board.boardDTO.BoardDto;
import com.kh.jdbc.JdbcConnect;

public class BoardWriteService {

	public int insertBoard(BoardDto dto) {
		Connection conn = JdbcConnect.getConnection();
		BoardDao dao = new BoardDao();
		int result = -1;
		
		result = dao.insertBoard(conn, dto);

		
		JdbcConnect.close(conn);
		
		return result;
	}

}
