package member.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import first.common.JDBCTemplate;

public class MemberDAO {
	
	public int login(Connection conn, String id, String pw) {
		int result = 0;
		
		String query = "select count(*) from test_member where id ="+id+"  and pw = "+pw;
		
			Statement stmt;
			try {
				stmt = conn.createStatement();
				
				
				//selete 할때 사용
				ResultSet rs = stmt.executeQuery(query);
				
				if(rs.next()) {
					
				}
				
				
				
				//insert update delete 할떄 사용
				//stmt.executeUpdate(sql)
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			


		
		return result;
	}

}
