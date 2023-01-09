package HotelDbms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ReadRoomTable {

	public static void readFromTableRoomType() throws IOException {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=hotelsystemm;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		Scanner sa = new Scanner(System.in);

		System.out.println("Enter How many Rows you want to see From Room_Type?");
		 int insert = sa.nextInt();

		int count = 0;
		String sql = "SELECT * FROM Room_Type";

		Connection con = null;

		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);
			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);
			Statement st = con.createStatement();

			ResultSet result = st.executeQuery(sql);
			while (result.next() && count < insert) {
				int id = result.getInt("id");
				String Mname = result.getString("room_type_name");
				Date m = result.getDate("created_date");
				Date s = result.getDate("updated_date");
				boolean Activated = result.getBoolean("is_Active");

				System.out.println(id + " " + Mname + "  " + m + " " + s + " " + Activated);
				count++;

			}
			con.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}

	}

}
