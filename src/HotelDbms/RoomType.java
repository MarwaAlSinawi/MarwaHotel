package HotelDbms;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class RoomType {

public static boolean Room_Type() {
		
		String url = "jdbc:sqlserver://localhost:1433;databaseName=hotelsystemm;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		String sqlDB = "CREATE TABLE Room_Type " + "(id INTEGER PRIMARY KEY  IDENTITY(1,1) , " + " room_type_name VARCHAR(50) NOT NULL, "
				+ "created_date  date, " + " updated_date date , " +  "is_Active  tinyint NOT NULL )";
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
	}public static void insertIntoTable() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=hotelsystemm;encrypt=true;trustServerCertificate=true";
		String user = "sa";
	    String pass = "root";
	   
	    Scanner scanner = new Scanner(System.in);
	   
	    String room_type_name = "Single" ;
	    String created_date = "2026-12-12";
	    String updated_date = "2029-01-08";
	    int is_Active = 1;
	   
	   
	    System.out.print("How many num of rows you be insert ? ");
	    Integer insert = scanner.nextInt();
		Random rn = new Random();
		Integer numberToAdd = rn.nextInt(100);
		
		
		 // Inserting data using SQL query
	    for(int i=0; i<=insert;i++) {
        String sqlData = "insert into Room_Type values('"+ room_type_name+"' , '"+created_date+"','"+updated_date+"' , "+is_Active+")";
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
	    }
	
	}

	

	}


