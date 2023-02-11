package com.kh.board.boardDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.board.boardDTO.BoardDto;
import com.kh.jdbc.JdbcConnect;

public class BoardDao {
	
	public BoardDao() {
		// TODO Auto-generated constructor stub
	}
	
	public List<BoardDto> BorderList(Connection conn){
		List<BoardDto> blist = new ArrayList<BoardDto>();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String query = "SELECT ID, TITLE ,CONTENT, USER_ID, USER_PW ,CREATE_DATE ,MODI_DATE ,DEL_FLAG ,CATEGORY FROM BOARD";
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					BoardDto b = new BoardDto();
					b.setId(rs.getInt("id"));
					b.setTitle(rs.getString("title"));
					b.setContent(rs.getString("content"));
					b.setUserId(rs.getString("user_id"));
					b.setUserPw(rs.getString("user_pw"));
					b.setDelFlag(rs.getString("del_flag"));
					b.setCreateDate(rs.getDate("create_date"));
					b.setModifyDate(rs.getDate("modi_date"));
					b.setCategoryId(rs.getInt("category"));
					
					blist.add(b);

				} while (rs.next());
			}
		System.out.println("========================");	
		System.out.println(blist.size());
		System.out.println("========================");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcConnect.close(rs);
			JdbcConnect.close(pstmt);	
		}

		return blist;
	}
	
}
