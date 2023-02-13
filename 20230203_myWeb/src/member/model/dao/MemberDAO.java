package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import first.common.JDBCTemplate;

public class MemberDAO {
	
	public int login(Connection conn, String id, String pw) {
		int result = -1;
		
		String query = "select count(*) AS cnt from test_member where id ='"+id+"'  and passwd = '"+pw+"'";
		String query1 = "select count(*) AS cnt from test_member where id =?  and passwd = ?";
		
		System.out.println(query);
		
			Statement stmt = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ResultSet rs1 = null;
			try {
				stmt = conn.createStatement();
				
				
				//selete 할때 사용
				rs = stmt.executeQuery(query);
				
				if(rs.next()) {
				//result = rs.getInt("cnt");
					
				}
				
				pstmt = conn.prepareStatement(query1);
				pstmt.setString(1, id);
				pstmt.setString(2, pw);
				
				rs1 = pstmt.executeQuery();
				
				if(rs1.next()) {
					result = rs1.getInt("cnt");	
				}else {
					result =0;
				}


				//insert update delete 할떄 사용
				//stmt.executeUpdate(sql)
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {

				JDBCTemplate.close(stmt);
				JDBCTemplate.close(pstmt);
				JDBCTemplate.close(rs);
				JDBCTemplate.close(rs1);
			}
			


		
		return result;
	}

	public int DupCheck(Connection conn, String id) {
		int result = -1;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "select count(*) AS cnt from test_member where id =?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("cnt");	
			}else {
				result =0;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		return result;
	}

}
