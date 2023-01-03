package HotelDbms;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Hotels {
	public static boolean tableHotels() {
		
		String url = "jdbc:sqlserver://localhost:1433;databaseName=hotelsystem;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		
		String sqlDB = "CREATE TABLE Hotels " + "(id INTEGER PRIMARY KEY  , " + " hotel_name VARCHAR(50) NOT NULL, "
				+ "hotel_location  VARCHAR(50), " + " created_date date NOT NULL, " + "updated_date date , " + "is_Active  BIT NOT NULL )";
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
	public  static void insertIntoTable(){
		String url = "jdbc:sqlserver://localhost:1433;databaseName=hotelsystem;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "root";
        Scanner sa=new Scanner(System.in);
    	System.out.println("How many numbers of rows to be inserted");
        int insert =sa.nextInt();
        String hotel_name="Bustan";
        String hotel_location="Ruwi";
        String created_date="2022-06-26";
        String updated_date="2023-06-26";
        boolean is_Active=true;
        Random rn = new Random();
        Integer numberToAdd = rn.nextInt(100);
        for(int i=1; i<=insert;i++) {
        	String sql = "insert into Hotels values ("+i+numberToAdd+", '"+hotel_name+i+"', '"+hotel_location+i+"', '"+created_date+"', '"+updated_date+"', '"+is_Active+"')";
        Connection con = null;
        try {
            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            DriverManager.registerDriver(driver);
            con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            int m = st.executeUpdate(sql);
            if (m >=0)
                System.out.println( "insert data successfully");
            else
                System.out.println("faild inserted ");
            con.close();
        }
        catch (Exception ex) {
            System.err.println(ex);
        }
        }
		
		}
	
		

	}


