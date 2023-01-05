package HotelDbms;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Hotels {
	public static boolean tableHotels() {

		String url = "jdbc:sqlserver://localhost:1433;databaseName=hotelsystem;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";

		String sqlDB = "CREATE TABLE Hotels " + "(id INTEGER PRIMARY KEY  , " + " hotel_name VARCHAR(50) NOT NULL, "
				+ "hotel_location  VARCHAR(50), " + " created_date date NOT NULL, " + "updated_date date , "
				+ "is_Active  BIT NOT NULL )";
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
		} catch (Exception ex) {
			System.err.println(ex);
		}

		return false;

	}

	public static void insertIntoTable(int insert) {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=hotelsystem;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		Scanner sa = new Scanner(System.in);
	;
		String hotel_name = "Bustan";
		String hotel_location = "Ruwi";
		String created_date = "2022-06-26";
		String updated_date = "2023-06-26";
		boolean is_Active = true;
		Random rn = new Random();
		Integer numberToAdd = rn.nextInt(100);
		for (int i = 0; i <= insert; i++) {
			String sql = "insert into Hotels values (" + i + numberToAdd + ", '" + hotel_name + i + "', '"
					+ hotel_location + i + "', '" + created_date + "', '" + updated_date + "', '" + is_Active + "')";
			Connection con = null;
			try {
				Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
				DriverManager.registerDriver(driver);
				con = DriverManager.getConnection(url, user, pass);
				Statement st = con.createStatement();
				int m = st.executeUpdate(sql);
				if (m >= 0)
					System.out.println("insert data successfully");
				else
					System.out.println("faild inserted ");
				con.close();
			} catch (Exception ex) {
				System.err.println(ex);
			}
		}

	}

	public static void makeIsActiveFalseById() {
		
	    	
	    	String url = "jdbc:sqlserver://localhost:1433;databaseName=hotelsystem;encrypt=true;trustServerCertificate=true";
	        String user = "sa";
	        String pass = "root";
	        Connection con = null;
	        try {
	            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	            DriverManager.registerDriver(driver);
	            con = DriverManager.getConnection(url, user, pass);
	            Statement st = con.createStatement();
	            Scanner sa=new Scanner(System.in);
	        	System.out.println("Enter id that you want to unactived: ");
	            int idinput =sa.nextInt();
	            int count=0;
	            String sql = "UPDATE Hotels SET is_Active = 'false' "+" WHERE id <= '"+idinput+"'";
	            ResultSet rs=st.executeQuery(sql);
	            }
	        catch (Exception ex) {
	            System.err.println(ex);
	        }
	        }public static void makeIsActivTrueById() {
	    		
		    	
		    	String url = "jdbc:sqlserver://localhost:1433;databaseName=hotelsystem;encrypt=true;trustServerCertificate=true";
		        String user = "sa";
		        String pass = "root";
		        Connection con = null;
		        try {
		            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
		            DriverManager.registerDriver(driver);
		            con = DriverManager.getConnection(url, user, pass);
		            Statement st = con.createStatement();
		            Scanner sa=new Scanner(System.in);
		        	System.out.println("Enter id that you want to unactived: ");
		            int idinput =sa.nextInt();
		            int count=0;
		            String sql = "UPDATE Hotels SET is_Active = 'true' "+" WHERE id <= '"+idinput+"'";
		            ResultSet rs=st.executeQuery(sql);
		            }
		        catch (Exception ex) {
		            System.err.println(ex);
		        }
		 	
		 
		 
		 

	}

	public static void updateById() throws Throwable {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=hotelsystem;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";

		String sql = "UPDATE Hotels SET hotel_name = ?, hot"
				+ "el_location = ?,created_date = ?, updated_date = ? WHERE id = ?";
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the id of the row to update: ");
		int id = sc.nextInt();
		Connection con = null;

		try {
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);
			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);
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
				System.out.println(id + " " + hotelName + " " + hotelLocation + " " + createdDate + " " + updatedDate
						+ " " + isActive);
			}
		} catch (Exception e) {

			System.out.println(e);
		}
	}

	public static void readFromTable(int insert) throws SQLException {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=hotelsystem;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		Scanner sa = new Scanner(System.in);

		System.out.println("Enter How many Rows you want to see ?");
		insert = sa.nextInt();

		int count = 0;
		String sql = "SELECT * FROM Hotels";

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
				String Mname = result.getString("hotel_name");
				String Mlocation = result.getString("hotel_location");
				Date m = result.getDate("created_date");
				Date s = result.getDate("updated_date");
				boolean Activated = result.getBoolean("is_Active");

				System.out.println(id + " " + Mname + " " + Mlocation + " " + m + " " + s + " " + Activated);
				count++;

			}
			con.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}

	}
	
	public static void readFromTableUserInput() throws SQLException {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=hotelsystem;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		Scanner sa = new Scanner(System.in);

		System.out.println("Enter How many Rows you want to see ?");
		int insert = sa.nextInt();

		int count = 0;
		String sql = "SELECT * FROM Hotels";

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
				String Mname = result.getString("hotel_name");
				String Mlocation = result.getString("hotel_location");
				Date m = result.getDate("created_date");
				Date s = result.getDate("updated_date");
				boolean Activated = result.getBoolean("is_Active");

				System.out.println(id + " " + Mname + " " + Mlocation + " " + m + " " + s + " " + Activated);
				count++;

			}
			con.close();
		} catch (Exception ex) {
			System.err.println(ex);
		}

	}


	public static void getById() {
		String url = "jdbc:sqlserver://localhost:1433;databaseName=hotelsystem;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "root";
        Connection con = null;
        try {
            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            DriverManager.registerDriver(driver);
            con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            Scanner sa=new Scanner(System.in);
        	System.out.println("Enter id  that you want search about it ? ");
            int idinput =sa.nextInt();
            int count=0;
            String sql="select * from Hotels where id='"+idinput+"'";
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()&&count<=idinput) {
            	 int id=rs.getInt("id");
                 String hotelname=rs.getString("hotel_name");
                 String hotellocation= rs.getString("hotel_location");
                 Date createddate= rs.getDate("created_date");
                 Date updateddate= rs.getDate("updated_date");
                 String isActive=rs.getString("is_Active");
                 System.out.println(id +" "+hotelname+" "+hotellocation+" "+createddate+" "+updateddate+" " +isActive);
                 count++;
            }}
        catch (Exception ex) {
            System.err.println(ex);
        }	
	}
	public static void deleteById() {
		
		String url = "jdbc:sqlserver://localhost:1433;databaseName=hotelsystem;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "root";
        Connection con = null;
        try {
            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            DriverManager.registerDriver(driver);
            con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();
            Scanner sa=new Scanner(System.in);
        	System.out.println("Enter id that you want to delete: ");
            int idinput =sa.nextInt();
            int count=0;
            String sql ="DELETE FROM Hotels WHERE id = '"+idinput+"'";
            ResultSet rs=st.executeQuery(sql);
            }
        catch (Exception ex) {
            System.err.println(ex);
        }
        }
		
		
}

	


