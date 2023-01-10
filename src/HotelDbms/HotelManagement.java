package HotelDbms;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class HotelManagement {

	public static void FindingE() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=hotelsystemm;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		Connection con = null;
		{

			String sql = "SELECT * FROM Guests \r\n" + "WHERE guest_name LIKE '%E'";

			try {
				Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
				DriverManager.registerDriver(driver);
				con = DriverManager.getConnection(url, user, pass);
				Statement st = con.createStatement();

				ResultSet result = st.executeQuery(sql);
				while (result.next()) {

					String roomName = result.getString("guest_name");

					System.out.println(roomName);
				}
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
	}

	public static void PayingMore() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=hotelsystemm;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		Connection con = null;
		{

			String sql = "SELECT * FROM Guests \r\n" + "		Where guest_payment_amount >'1000' ";

			try {
				Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
				DriverManager.registerDriver(driver);
				con = DriverManager.getConnection(url, user, pass);
				Statement st = con.createStatement();

				ResultSet result = st.executeQuery(sql);
				while (result.next()) {

					// String guest_payment_amount = result.getString("guest_payment_amount");
					// System.out.println(guest_payment_amount);
					int id = result.getInt(1);
					String guest_name = result.getString(2);
					String guest_phone = result.getString(3);
					int guest_accompanying_members = result.getInt(4);
					int guest_payment_amount = result.getInt(5);
					int room_id = result.getInt(6);
					int hotel_id = result.getInt(7);
					Date create_date = result.getDate(8);
					Date update_date = result.getDate(9);
					String is_Active = result.getString(10);
					System.out.println("Id :" + id + "||" + " " + "Guest name is  :" + guest_name + "||" + " "
							+ "Guest Ohone Number is :" + guest_phone + "||" + " " + "\n "
							+ "Guest Accompanying Members is :" + guest_accompanying_members + "||" + " "
							+ "Guest Payment Amount is :" + guest_payment_amount + "||" + " " + "Room ID is :" + room_id
							+ "||" + " " + "Hotel ID is :" + hotel_id + "||" + " " + "\n " + "Created Date is  :"
							+ create_date + "||" + " " + "Updated date is : " + update_date + "||" + "\n "
							+ "The activation of the user is: " + is_Active);
				}
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
	}

	public static void delux() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=hotelsystemm;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		Connection con = null;

		{
			String sql = "SELECT COUNT (room_type_name) AS Total_DELUXE_ROOM  FROM Room_Type \r\n"
					+ "		where room_type_name = 'DELUXE'";
			try {
				Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
				DriverManager.registerDriver(driver);
				con = DriverManager.getConnection(url, user, pass);
				Statement st = con.createStatement();

				ResultSet result = st.executeQuery(sql);
				while (result.next()) {

					String roomTypeName = result.getString(1);

					System.out.println("Total DELUXE ROOM is :" + " " + roomTypeName);
				}
			} catch (Exception ex) {
				System.out.println(ex);

			}
		}
	}

	public static void FindingA() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=hotelsystemm;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		Connection con = null;

		{

			String sql = "SELECT * FROM Guests \r\n" + "WHERE guest_name LIKE '%A%'";

			try {
				Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
				DriverManager.registerDriver(driver);
				con = DriverManager.getConnection(url, user, pass);
				Statement st = con.createStatement();

				ResultSet result = st.executeQuery(sql);
				while (result.next()) {

					String roomName = result.getString("guest_name");

					System.out.println(roomName);
				}
			} catch (Exception ex) {
				System.out.println(ex);

			}
		}
	}

	public static void isActive0() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=hotelsystemm;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		Scanner scanner1 = new Scanner(System.in);
		Connection con = null;
		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);
			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);
			// Creating a statement
			Statement st = con.createStatement();
			String Sql = "Select * from Rooms where room_type_id=2 AND is_Active=0";
			ResultSet result = st.executeQuery(Sql);
			while (result.next()) {
				int Rid = result.getInt("id");
				String Rtype = result.getString("room_type_id");
				String Rhtype = result.getString("hotel_id");
				Date CD = result.getDate("created_date");
				Date UD = result.getDate("updated_date");
				boolean Activated = result.getBoolean("is_Active");
				System.out.println(Rid + " " + Rtype + " " + Rhtype + " " + CD + " " + UD + " " + Activated);
			}
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}
	public static void HotelsH() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=hotelsystemm;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		Scanner scanner1 = new Scanner(System.in);
		Connection con = null;
		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);
			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);
			// Creating a statement
			Statement st = con.createStatement();
			String Sql ="SELECT room_type_name FROM Room_Type JOIN Rooms ON Room_Type.id = Rooms.room_type_id JOIN Hotels ON Rooms.hotel_id = Hotels.id WHERE Hotels.hotel_name LIKE '%H%' OR (Hotels.is_Active = 1 AND Rooms.id >5)";
					
			ResultSet result = st.executeQuery(Sql);
			while (result.next()) {
		
				String roomTypeName = result.getString("room_type_name");
				System.out.println(roomTypeName);
			}
		} catch (Exception ex) {
			System.err.println(ex);
		}
	}
}
	
