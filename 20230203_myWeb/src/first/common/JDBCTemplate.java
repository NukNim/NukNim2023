package first.common;

import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTemplate {
	
	private static JDBCTemplate instance;
	
	public JDBCTemplate() {}
	
	
	public static JDBCTemplate getInstance() {
		if(instance == null) {
			instance = new JDBCTemplate();
		}
		return instance;
	}
	
	public static Connection getConnection() {
		Connection con =null;
		
		//try ~ 문에서는 변수를 선언 하지 않는다.
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KH","KH");
			
		} catch (ClassNotFoundException e) {
			System.out.println("==== ojdbc.jar 가 없어요! ====");
			e.printStackTrace();
			
		} catch (SQLException e) {
			System.out.println("====== 연결 실패 ======");
			e.printStackTrace();
		} finally {
			if(con == null) {
				System.out.println("====== 연결 실패 ======123");
			}
		}
		
		
		
		
		return con;
		
	}

}
