package data;
import domain.Person;
import java.sql.*;
import java.util.*;
//Class chua method SELECT INSERT UPDATE Va delete cho ban person
public class JdbcPerson {
	private final String SQL_INSERT = "INSERT INTO person(name) VALUES(?)";
	private final String SQL_UPDATE = "UPDATE person SET name=? WHERE id_person=?";
	private final String SQL_DELETE = "DELETE FROM person WHERE id_person = ?";
	private final String SQL_SELECT = "SELECT * FROM person";
	public int insert(String name) {
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    int rows = 0; //affected rows
	    
	    try {
	        conn = JavaConnection.getConnection();
	        stmt = conn.prepareStatement(SQL_INSERT);
	        stmt.setString(1, name);//param 1 => ? name
	        System.out.println("Executing query:" + SQL_INSERT);
	        rows = stmt.executeUpdate();
	        System.out.println("Affected records:" + rows);
	        
	    } catch (SQLException e) {
	        e.printStackTrace(System.out);
	    } finally {
	        JavaConnection.close(stmt);
	        JavaConnection.close(conn);
	    }
	    return rows;
	}
	public int update(int id_person, String name) {
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    int rows = 0; //affected rows
	    
	    try {
	        conn = JavaConnection.getConnection();
	        stmt = conn.prepareStatement(SQL_UPDATE);
	        stmt.setString(1, name);
	        stmt.setInt(2, id_person);
	        
	        System.out.println("Executing query: " + SQL_UPDATE);
	        rows = stmt.executeUpdate();
	        System.out.println("Affected records: " + rows);
	        
	    } catch (SQLException e) {
	        e.printStackTrace(System.out);
	    } finally {
	        JavaConnection.close(stmt);
	        JavaConnection.close(conn);
	    }
	    return rows;
	}
	public int delete(int id_person) {
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    int rows = 0; //affected rows
	    
	    try {
	        conn = JavaConnection.getConnection();
	        stmt = conn.prepareStatement(SQL_DELETE);
	        stmt.setInt(1, id_person);
	        
	        System.out.println("Executing query: " + SQL_DELETE);
	        rows = stmt.executeUpdate();
	        System.out.println("Affected records: " + rows);
	        
	    } catch (SQLException e) {
	        e.printStackTrace(System.out);
	    } finally {
	        JavaConnection.close(stmt);
	        JavaConnection.close(conn);
	    }
	    return rows;
	}
	public List<Person> select() {
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    List<Person> people = new ArrayList<>();
	    
	    try {
	        conn = JavaConnection.getConnection();
	        stmt = conn.prepareStatement(SQL_SELECT);
	        
	        System.out.println("Executing query: " + SQL_SELECT);
	        rs = stmt.executeQuery();
	        
	        while (rs.next()) {
	            int idPerson = rs.getInt("id_person");
	            String name = rs.getString("name");
	            
	            // Tạo đối tượng Person và thêm vào danh sách
	            Person person = new Person(idPerson, name);
	            people.add(person);
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
	        JavaConnection.close(stmt);
	        JavaConnection.close(conn);
	    }
	    return people;
	}
}
