package DBCon;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbconnect {

	// connect method connects to database and returns Connection
	public Connection connect() {
		Connection con;
		try {
//			Class.forName("org.postgresql.Driver");
//			con = DriverManager.getConnection("jdbc:postgresql://192.168.110.48/postgres", "plf_training_admin",
//					"pff123");
//			System.out.println("Connection Established");
			
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","1234");
			return con;
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		return null;
	}
}