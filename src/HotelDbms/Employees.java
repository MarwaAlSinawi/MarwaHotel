package HotelDbms;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Employees {
	public static boolean Employees() {

		String url = "jdbc:sqlserver://localhost:1433;databaseName=hotelsystemm;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		String Sql = "CREATE TABLE Employees " + "(id INTEGER PRIMARY KEY IDENTITY(1,1), "
				+ " employee_type_id INTEGER FOREIGN KEY REFERENCES Employee_Type(id), "
				+ " room_id INTEGER FOREIGN KEY REFERENCES Rooms(id), " + " created_date date NOT NULL, "
				+ " updated_date date, " + " is_Active tinyint NOT NULL)";

		Connection conn = null;
		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection(url, user, pass);
			Statement st = conn.createStatement();
			int m = st.executeUpdate(Sql);
			if (m >= 0) {
				System.out.println("Created table in given database...");
				return true;
			} else {
				System.out.println(" table already Created in given database...");
			}
			conn.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}

		return false;
	}

	public static void insertIntoTableEmployees(Integer insert) {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=hotelsystemm;encrypt=true;trustServerCertificate=true";
		String user = "sa";
	    String pass = "root";
	   
	   
	    Scanner scanner = new Scanner(System.in);
	   
		  
	    int employee_type_id = 1 ;
	    int room_id = 17;
	    String created_date = "2023-08-03";
	    String updated_date = "2029-09-06";
	    int is_Active = 1;
	   
	   
	    System.out.print("How many num of rows you be insert Employees data ? ");
	    insert = scanner.nextInt();
		Random rn = new Random();
		Integer numberToAdd = rn.nextInt(100);
		
		 // Inserting data using SQL query
	    for(int i=0; i<=insert;i++) {
        String sqlData = "insert into Employees values('"+ employee_type_id +"','"+room_id+"' ,'"+created_date+"','"+updated_date+"' , "+is_Active+")";
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