package HotelDbms;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class Employee_Type {
public static boolean Employee_Type() {
		
		String url = "jdbc:sqlserver://localhost:1433;databaseName=hotelsystemm;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";
		String Sql = "CREATE TABLE Employee_Type " + "(id INTEGER PRIMARY KEY IDENTITY(1,1), " + " employee_type_name VARCHAR(50) NOT NULL, "
				+ " created_date date NOT NULL, " + " updated_date date, " + " is_Active tinyint NOT NULL)";
		
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
		}
		catch (Exception ex) {
			System.err.println(ex);
		}
	return false;
	}

	


	}


