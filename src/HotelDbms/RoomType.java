package HotelDbms;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class RoomType {

public static boolean Room_Type() {
		
		String url = "jdbc:sqlserver://localhost:1433;databaseName=hotelsystem;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		String sqlDB = "CREATE TABLE Room_Type " + "(id INTEGER PRIMARY KEY  , " + " room_type_name VARCHAR(50) NOT NULL, "
				+ "created_date  date, " + " updated_date date , " +  "is_Active  BIT NOT NULL )";
		Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, user, pass);
			Statement st = conn.createStatement();
			int m = st.executeUpdate(sqlDB);
			if (m >= 0) {
				System.out.println("Created table in given database...");
				return true;
			} else {
				System.out.println(" table already Created in given database...");
			}
			conn.close();
		}
		catch (Exception ex) {
			System.err.println(ex);
		}
	return false;
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
