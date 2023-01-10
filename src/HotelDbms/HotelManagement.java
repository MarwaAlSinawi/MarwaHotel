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
	
 String sql = "SELECT * FROM Guests \r\n"
 		+ "WHERE guest_name LIKE '%E'";

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
 }
 catch (Exception ex) {
System.out.println(ex);
 }
}}
 

	

public static void PayingMore() {
	String url = "jdbc:sqlserver://localhost:1433;databaseName=hotelsystemm;encrypt=true;trustServerCertificate=true";
	String user = "sa";
    String pass = "root";
    Connection con = null;
{

String sql = "SELECT * FROM Guests \r\n"
		+ "		Where guest_payment_amount >'1000' ";

try {
 Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
 DriverManager.registerDriver(driver);
 con = DriverManager.getConnection(url, user, pass);
 Statement st = con.createStatement();

	ResultSet result = st.executeQuery(sql);
	while (result.next()) {
		
		//String guest_payment_amount = result.getString("guest_payment_amount");
		//System.out.println(guest_payment_amount);
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
				+ "Guest Ohone Number is :" + guest_phone + "||" + " " +  "\n " + "Guest Accompanying Members is :"
				+ guest_accompanying_members + "||" + " " + "Guest Payment Amount is :" + guest_payment_amount
				+ "||" + " " + "Room ID is :" + room_id + "||" + " " + "Hotel ID is :" + hotel_id + "||" + " " + "\n "
				+ "Created Date is  :" + create_date + "||" + " " + "Updated date is : " + update_date + "||"
				+ "\n " + "The activation of the user is: " + is_Active);
 }}
catch (Exception ex) {
 System.out.println(ex);
}
}
}



public  static void delux() {
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
				
				String roomTypeName = result.getString(1 );
				

				System.out.println("Total DELUXE ROOM is :"+" "+ roomTypeName);
	     }
	 }
	 catch (Exception ex) {
	System.out.println(ex);
	
	
}
}
}
}

