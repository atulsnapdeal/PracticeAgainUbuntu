package connectionpool;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Logger;

public class ConnectionFactory {
	
	
	private static final Logger logger  = Logger.getLogger(ConnectionFactory.class.getCanonicalName().toString());
	int availableConnection, initialConnection,maxSize;
	Connection connection;
	BlockingQueue<Connection> queue; 
	
	public ConnectionFactory(int availableConnection, int initialConnection, int maxSize,Connection connection) {
		
		if(initialConnection <1 || availableConnection<1 ||  initialConnection >maxSize) {
			throw new IllegalArgumentException("Some problem with inital arguments of the connection factory");
		}
		this.connection = connection;
		this.maxSize = maxSize;
		this.initialConnection = initialConnection;
		this.availableConnection = availableConnection;
		queue = new LinkedBlockingQueue<Connection>(maxSize);
		initConnection();
	}
	
	private void initConnection() {
		
		while(queue.size() < maxSize){
			queue.offer(connection);
		}

	}
	
	public synchronized Connection getConnection() {
		Connection newConnection = null;
		Iterator queueIterator = queue.iterator();
		while(queueIterator.hasNext())
			newConnection = (Connection)queueIterator.next();
		    if(newConnection.connectionAvailable) {
		    	newConnection.connectionAvailable = false;
		    	return newConnection;
		    	
		    	
		    }
		    else
		    	return null;
		}

}
