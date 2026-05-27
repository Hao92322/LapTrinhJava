package data;

import java.sql.*;

public class JavaConnectionKhoa {
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/quanlygiaovien";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASS = "yourpassword";
	private static Driver driver;
	//Lay chuoi ket noi
	public static synchronized Connection getConnection() throws SQLException{

		if(driver == null) {
			try {
				Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
				driver = (Driver) jdbcDriverClass.newInstance();
				DriverManager.registerDriver(driver);
			}catch(Exception e) {
				e.printStackTrace(System.out);
			}
		}
		return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);
	}
	public static void close(ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
		}catch(SQLException sqle) {
			sqle.printStackTrace(System.out);
		}
	}
	//Dong preparedStatement
	public static void close(PreparedStatement stmt) {
		try {
			if(stmt !=null) {
				stmt.close();
			}
		}catch(SQLException sqle) {
			sqle.printStackTrace(System.out);
		}
	}
	//Dong connection
	public static void close(Connection conn) {
		try {
			if(conn !=null) {
				conn.close();
			}
		}catch(SQLException sqle) {
			sqle.printStackTrace(System.out);
		}
	}
}
