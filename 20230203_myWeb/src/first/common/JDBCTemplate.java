package first.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

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
		Properties prop = new Properties();
		
		
		//try ~ 문에서는 변수를 선언 하지 않는다.
		try {
			
//			prop.load(new BufferedReader(new FileReader(new File("C:\\Users\\user1\\git\\NukNim2023\\20230203_myWeb\\src\\first\\common\\driver.properties"))));
			
			String currentPath = JDBCTemplate.class.getResource("").getPath();
			prop.load(new BufferedReader(new FileReader(new File(currentPath+"driver.properties"))));
			
			
//			URL url =JDBCTemplate.class.getResource("");
//			System.out.println("url : " + url);
//			System.out.println(" 갯 리소스 =     "+JDBCTemplate.class.getResource(""));
//			System.out.println(" ./ =     "+JDBCTemplate.class.getResource("./"));
//			System.out.println(" ../ =     "+JDBCTemplate.class.getResource("../"));
			
			System.out.println("1 : " +prop.getProperty("driver"));
			
			//문자열 형태로 전달된 클래스를 JVM으로 로드해주는 기능
			//Oracle JDBC 드라이버를 지정해 로드하여 DriverManager에 등록이 되도록 하는 코드
			Class.forName(prop.getProperty("driver"));
			
			
			con = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("pwd"));
			
		} catch (ClassNotFoundException e) {
			System.out.println("==== ojdbc.jar 가 없어요! ====");
			e.printStackTrace();
			
		} catch (SQLException e) {
			System.out.println("====== 연결 실패 ======");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(con == null) {
				System.out.println("====== 연결 실패 ======123");
			}
		}
		
		
		//DB counnecion 생성 반대 순서로 close
		
		
		
		
		return con;
		
	}
	
	
	public static void close(Connection conn) {
		
		try {
			if(conn !=null && !conn.isClosed()) {
				conn.close();				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void commit(Connection conn) {
		
		try {
			if(conn !=null && !conn.isClosed()) {
			conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void rollback(Connection conn) {
		
		try {
			if(conn !=null && !conn.isClosed()) {
			conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt !=null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			if(rs !=null && !rs.isClosed()) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
