package connexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection {
//on va déclarer variable de type Connection de type java.sql 
	private static Connection connection;
	//class pour établir la connection
	static{
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			//établir la connection
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/uas","root","");
		    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Connection getConnection() {
		return connection;
	}
	
}
