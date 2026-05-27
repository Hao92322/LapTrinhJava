package data;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import domain.KHOA;

public class JdbdKhoa {
	private final String SQL_INSERT = "INSERT INTO KHOA(MAKHOA,TENKHOA,NGTLAP,TRGKHOA) VALUE(?,?,?,?)";
	private final String SQL_UPDATE = "UPDATE KHOA SET TENKHOA=?,NGTLAP=?,TRGKHOA=? WHERE MAKHOA=?";
	private final String SQL_DELETE = "DELETE FROM KHOA WHERE MAKHOA = ?";
	private final String SQL_SELECT = "SELECT * FROM KHOA";
	public int update(KHOA khoa) {
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    int rows = 0; //affected rows
	    
	    try {
	        conn = JavaConnectionKhoa.getConnection();
	        stmt = conn.prepareStatement(SQL_UPDATE);
	        stmt.setString(4, khoa.getMaKhoa());
			stmt.setString(1, khoa.getTenKhoa());
			stmt.setObject(2, khoa.getNgTlap());
			stmt.setString(3, khoa.getTrgKhoa());
	        System.out.println("Executing query: " + SQL_UPDATE);
	        rows = stmt.executeUpdate();
	        System.out.println("Affected records: " + rows);
	        
	    } catch (SQLException e) {
	        e.printStackTrace(System.out);
	    } finally {
	        JavaConnectionKhoa.close(stmt);
	        JavaConnectionKhoa.close(conn);
	    }
	    return rows;
	}
	public int delete(String Makhoa) {
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    int rows = 0; //affected rows
	    
	    try {
	        conn = JavaConnectionKhoa.getConnection();
	        stmt = conn.prepareStatement(SQL_DELETE);
	        //Set parameter
	        stmt.setString(1, Makhoa);
	        System.out.println("Executing query: " + SQL_DELETE);
	        rows = stmt.executeUpdate();
	        System.out.println("Affected records: " + rows);
	        
	    } catch (SQLException e) {
	        e.printStackTrace(System.out);
	    } finally {
	        JavaConnectionKhoa.close(stmt);
	        JavaConnectionKhoa.close(conn);
	    }
	    return rows;
	}
	public void Insert(KHOA khoa) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			System.out.println("Kết nối đến MYSQL");
			conn = JavaConnectionKhoa.getConnection();
			System.out.println("Kết nối thành công !!!");
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, khoa.getMaKhoa());
			stmt.setString(2, khoa.getTenKhoa());
			stmt.setObject(3, LocalDate.now());
			stmt.setString(4, khoa.getTrgKhoa());
			stmt.execute();
			System.out.println("Them khoa thanh cong");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally {
			JavaConnectionKhoa.close(stmt);
			JavaConnectionKhoa.close(conn);
		}
	}
	public List<KHOA> Select() {
		Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    List<KHOA> ALLKHOA = new ArrayList<>();
	    
	    try {
	        conn = JavaConnectionKhoa.getConnection();
	        stmt = conn.prepareStatement(SQL_SELECT);
	        
	        System.out.println("Executing query: " + SQL_SELECT);
	        rs = stmt.executeQuery();
	        
	        while (rs.next()) {
	            String idKhoa = rs.getString("MAKHOA");
	            String name = rs.getString("TENKHOA");
	            Date Ngtlap = rs.getDate("NGTLAP");
	            String TrgKhoa = rs.getString("TRGKHOA");
	            
	            // Tạo đối tượng Person và thêm vào danh sách
	            KHOA khoa = new KHOA(idKhoa, name,Ngtlap.toString(),TrgKhoa);
	            ALLKHOA.add(khoa);
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace(System.out);
	    } finally {
	        // Đóng thêm ResultSet để tránh rò rỉ bộ nhớ
	        if (rs != null) {
	            try {
	                rs.close();
	            } catch (SQLException e) {
	                e.printStackTrace(System.out);
	            }
	        }
	        JavaConnectionKhoa.close(stmt);
	        JavaConnectionKhoa.close(conn);
	    }
	    return ALLKHOA;
	}
}
