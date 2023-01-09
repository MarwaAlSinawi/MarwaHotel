package HotelDbms;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Guests {

public static void Guests() {
		
		String url = "jdbc:sqlserver://localhost:1433;databaseName=hotelsystemm;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		 String sql = "CREATE TABLE Guests " + "(id INTEGER PRIMARY KEY IDENTITY(1,1), " + " guest_name VARCHAR(50) NOT NULL, "
				+ " guest_phone VARCHAR(50) NOT NULL, " + " guest_accompanying_members INTEGER NOT NULL, " + " guest_payment_amount INTEGER NOT NULL,"
						+ " room_id INTEGER FOREIGN KEY REFERENCES Rooms(id), "
						+ " hotel_id INTEGER FOREIGN KEY REFERENCES Hotels(id), "+" created_date date NOT NULL, "+" updated_date date, "+" is_Active tinyint NOT NULL)";
		
		Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, user, pass);
			Statement st = conn.createStatement();
			int m = st.executeUpdate(sql);
			if (m >= 0) {
				System.out.println("Created table in given database...");
			
			} else {
				System.out.println(" table already Created in given database...");
			}
			conn.close();
		}
		catch (Exception ex) {
			System.err.println(ex);
		}
	
}
	public static void insertIntoTable(Integer insert){
    	String url = "jdbc:sqlserver://localhost:1433;databaseName=hotelsystemm;encrypt=true;trustServerCertificate=true";
		String user = "sa";
	    String pass = "root";
	   
    Scanner scanner = new Scanner(System.in);
   
  
    String guest_name = "meme" ;
    String guest_phone = "968-12345678";
    int guest_accompanying_members = 19;
    int guest_payment_amount = 222;
    int room_id = 15;
    int hotel_id = 16;
    String created_date = "2023-01-05";
    String updated_date = "2027-01-09";
    int is_Active = 1;
   
    System.out.print("How many num of rows you be insert in Guests data  ? ");
     insert = scanner.nextInt();
	Random rn = new Random();
	Integer numberToAdd = rn.nextInt(100);
   
 // Inserting data using SQL query
    for(int i=0; i<=insert;i++) {
    String sqlData = "insert into Guests values('"+ guest_name +"' ,'" + guest_phone + "', "+guest_accompanying_members+", "+guest_payment_amount+", "+room_id+" , "+hotel_id+", '"+created_date+"','"+updated_date+"' , "+is_Active+")";
    Connection con = null;
   
   
    try {
        Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
        DriverManager.registerDriver(driver);
        con = DriverManager.getConnection(url, user, pass);
        Statement st = con.createStatement();
       
     // Executing query
        int m = st.executeUpdate(sqlData);
        if (m >=  0)
            System.out.println(
                    "inserted successfully : " + sqlData);
        else
            System.out.println("insertion failed");
        // Closing the connections
        con.close();
    }
   
    catch (Exception ex) {
        // Display message when exceptions occurs
        System.err.println(ex);
    }
   
    }}

	

	}

