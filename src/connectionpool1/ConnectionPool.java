package connectionpool1;

import java.nio.channels.NoConnectionPendingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;


public class ConnectionPool {
	
	private BlockingQueue<Connection> queue;
	private int initialSize;
	private int maxSize;
	private int currentPoolSize;
	private String dbUrl;
	private String dbUser;
	private String dbPassword;
	
	public ConnectionPool(int initialPoolSize, int maxSize,String driverClassName,
			String dbUserName, String password, String url) throws SQLException {
		this.initialSize = initialPoolSize;
		this.maxSize = maxSize;
		this.dbUrl = url;
		this.dbUser = dbUserName;
		this.dbPassword = password;
		queue = new LinkedBlockingDeque<Connection>(maxSize);
		
		initConnectionPool(maxSize);

}

	private void initConnectionPool(int maxSize) throws SQLException {
		if(this.initialSize <1 || this.maxSize<1 || initialSize>maxSize) {
			throw new IllegalArgumentException("illegal parameter in pool sizing");
		}
		else {
			for(int i=0;i<this.initialSize;i++) {
				openPoolConnection();
			}
			
		}
	}

	private synchronized void openPoolConnection() throws SQLException {
		if(currentPoolSize == maxSize) {
			return;
		}
		Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		queue.offer(new PooledConnection(this, conn));
		currentPoolSize++;
	}
	
	public Connection borrowConnection() throws InterruptedException, SQLException {
		if(currentPoolSize < maxSize) {
			openPoolConnection();
		}
		return queue.take();
	}
	
	public void surrendorConnection(Connection con) {
		if(!(con instanceof PooledConnection)) {
			return;
		}
		queue.offer(con);
	}

}
