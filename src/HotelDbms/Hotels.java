package HotelDbms;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        for(int i=0; i<=insert;i++) {
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
	public static  void makeIsActiveFalseById() {
		//Scanner sa=new Scanner(System.in);
    	//System.out.println("Enter the ID you want to make it unactive");
        //int insert =sa.nextInt();
        
       // String sql ="UPDATE Hotels WHERE SET is_Active= False WHERE id=?  ";
        
		
		
	}
	public static void updateById()throws Throwable {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=hotelsystem;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "root";
		
        String sql = "UPDATE Hotels SET hotel_name = ?, hotel_location = ?,created_date = ?, updated_date = ? WHERE id = ?";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the id of the row to update: ");
        int id = sc.nextInt();
         Connection con = null;
	

        try {
        	   Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	            // Registering drivers
	            DriverManager.registerDriver(driver);
	            // Reference to connection interface
	            con = DriverManager.getConnection(url, user,
	                    pass);
	            PreparedStatement pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, "Jannat");
	            pstmt.setString(2, "AlAmerat");
	            pstmt.setDate(3, new Date(System.currentTimeMillis()));
	            pstmt.setDate(4, new Date(System.currentTimeMillis()));
	            pstmt.setInt(5, id);
	            pstmt.executeUpdate();
	         
	         
	            String sql2 = "SELECT * FROM Hotels WHERE id = ?";
	            PreparedStatement pstmt2 = con.prepareStatement(sql2);
	            pstmt2.setInt(1, id);
	            ResultSet rs = pstmt2.executeQuery();
	            if (rs.next()) {
	                String hotelName = rs.getString("hotel_name");
	                String hotelLocation = rs.getString("hotel_location");
	                Date createdDate = rs.getDate("created_date");
	                Date updatedDate = rs.getDate("updated_date");
	                boolean isActive = rs.getBoolean("is_Active");
	                System.out.println(id + " " + hotelName + " " + hotelLocation + " " + createdDate + " " + updatedDate + " " + isActive);
	            }
        } catch (Exception e) {
        	
        	System.out.println(e);
        	}
        }
		}

	
		

	


