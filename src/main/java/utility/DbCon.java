package utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbCon {
	public static Connection getCon()
	{
		Connection cn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/doctor","root","Meta@123");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return cn;
	}
}
