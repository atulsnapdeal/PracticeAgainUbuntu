package connectionpool;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
	
	public boolean connectionAvailable;
	
	
	public Connection() {
		ConnectionWithDataBase();
		
	}
	
	public void closeConnection() {
		this.connectionAvailable = true;
	}

	private void ConnectionWithDataBase() {
		try {
			java.sql.Connection con =DriverManager.getConnection("", "", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
