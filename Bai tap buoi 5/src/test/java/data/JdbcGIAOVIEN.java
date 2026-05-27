package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.GIAOVIEN;

public class JdbcGIAOVIEN {
	private final String SQL_INSERT = "INSERT INTO GIAOVIEN(MAGV,HOTEN,HOCVI,HOCHAM,GIOITINH,HESO,MUCLUONG,MAKHOA) VALUE(?,?,?,?,?,?,?,?)";
	private final String SQL_UPDATE = "UPDATE GIAOVIEN SET HOTEN=?,HOCVI=?,HOCHAM=?,GIOITINH=?,HESO=?,MUCLUONG=?,MAKHOA=? WHERE MAGV=?";
	private final String SQL_DELETE = "DELETE FROM GIAOVIEN WHERE MAGV = ?";
	private final String SQL_SELECT = "SELECT * FROM GIAOVIEN";
	public int update(GIAOVIEN gv) {
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    int rows = 0; //affected rows
	    
	    try {
	        conn = JavaConnectionKhoa.getConnection();
	        stmt = conn.prepareStatement(SQL_UPDATE);
	        stmt.setString(8, gv.getMAGV());
			stmt.setString(1, gv.getTENGV());
			stmt.setString(2, gv.getHOCVI());
			stmt.setString(3, gv.getHOCHAM());
			stmt.setInt(4, gv.getGIOITINH());
			stmt.setInt(5, gv.getHESO());
			stmt.setDouble(6, gv.getMUCLUONG());
			stmt.setString(7, gv.getMAKHOA());
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
	public int delete(String Magv) {
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    int rows = 0; //affected rows
	    
	    try {
	        conn = JavaConnectionKhoa.getConnection();
	        stmt = conn.prepareStatement(SQL_DELETE);
	        //Set parameter
	        stmt.setString(1, Magv);
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
	public void Insert(GIAOVIEN gv) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JavaConnectionKhoa.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, gv.getMAGV());
			stmt.setString(2, gv.getTENGV());
			stmt.setString(3, gv.getHOCVI());
			stmt.setString(4, gv.getHOCHAM());
			stmt.setInt(5, gv.getGIOITINH());
			stmt.setInt(6, gv.getHESO());
			stmt.setDouble(7, gv.getMUCLUONG());
			stmt.setString(8, gv.getMAKHOA());
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
	public List<GIAOVIEN> Select() {
		Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    List<GIAOVIEN> ALLGIAOVIEN = new ArrayList<>();
	    
	    try {
	        conn = JavaConnectionKhoa.getConnection();
	        stmt = conn.prepareStatement(SQL_SELECT);
	        
	        System.out.println("Executing query: " + SQL_SELECT);
	        rs = stmt.executeQuery();
	        
	        while (rs.next()) {
	            String idGV = rs.getString("MAGV");
	            String name = rs.getString("HOTEN");
	            String HV = rs.getString("HOCVI");
	            String HOCHAM = rs.getString("HOCHAM");
	            int GIOITINH = rs.getInt("GIOITINH");
	            int HESO = rs.getInt("HESO");
	            double MUCLUONG = rs.getDouble("MUCLUONG");
	            String idkhoa = rs.getString("MAKHOA");
	            GIAOVIEN gv = new GIAOVIEN(idGV,name,HV,HOCHAM,GIOITINH,HESO,MUCLUONG,idkhoa);
	            ALLGIAOVIEN.add(gv);
	           
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
	    return ALLGIAOVIEN;
	}
}
