package communityuni.com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ConnectionDatabase {
	private static String DB_URL = "jdbc:mysql://localhost:3306/quanlyhanghoa";;
	private static String User_Name="root";
	private static String User_Password = "Haonolove1236540@";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Dang thu ket noi den mysql ...");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL,User_Name,User_Password);
			System.out.println("Ket noi thanh cong");
			String sqlquery = "Select * From hanghoa";
			PreparedStatement pr = conn.prepareStatement(sqlquery);
			ResultSet r1 = pr.executeQuery();
			while(r1.next()) {
				System.out.print(r1.getInt("ma_hang")+ " | ");
				System.out.print(r1.getString("ten_hang")+ " | ");
				System.out.print(r1.getDouble("gia_ban")+ " | ");
				System.out.print(r1.getInt("so_luong")+"\n");
			}
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
