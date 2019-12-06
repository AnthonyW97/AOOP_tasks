//this class will be used to create 10 threads.
//all of which will attempt to delete a record from mySQL
//while sharing a connection.
//once the record has been deleted by the thread, then the program will terminate


//import the relevant libraries for connecting to mySQL, and multithreading
import java.sql.*;

public class threading_task extends Thread {
	
	//create 'setGreenLight' method to ensure all threads start simultaneously
	private static boolean greenLight = false;
	
	//create a variable to define if the record is deleted
	//	static boolean is_deleted = false;
	
	
	//declare variables to hold jdbc information
	private static String filename = "jdbc:mysql://ecommsvr5:3306/";  
	private static String database = "anthonyw_oop";
	private static String username = "anthonyw_aoop";
	private static String password = "1716208";
	//create a string to concatenate 2 variables at once as the connection method only accepts 3 parameters
	private static String db = filename + database;
	
	//there will be 10 threads sharing the connection
	private static int num_threads = 10;
	
	//create a variable to hold the thread ID
	
	
	//create a variable to begin the generating of IDs;
	private static int next_ID = 1;
	private static int my_threadID = 0;
	
	//create a variable to hold the connection status
	static Connection conn = null;
	
	//create a variable to hold the share connection status]
	private static boolean share_conn = false;
	
	//create a method to increment the id to be called later
	synchronized static int get_next_id() {
		//increase the id by one with each increment
		return next_ID++;
	}
	
	//create the main to begin jdbc and establish a connection
	public static void main(String args[]) {
		
		//load the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException x) {
			//return an error message to the user if a connection to the driver cannot be established
			System.out.println("Cannot find driver class. Check CLASSPATH");
			return;
		}
		
						
		//establish a shared connection between them
		try {
				conn = DriverManager.getConnection(db, username, password);
				share_conn = true;
			} catch(SQLException x) 
        	{
                System.out.println("Exception connecting to database:" + x);
                return;
        	}
        System.out.println("MySQL JDBC Driver Registered!");
  
        System.out.println(share_conn);

	
		System.out.println("All threads will be sharing the same connection");
		
		
		//create the threads
		Thread[] threadList = new Thread[num_threads];
		 
		//generate the threads
		for(int i = 0; i < num_threads; i++) 
		{
			threadList[i] = new Thread();
			 threadList[i].start();			
		}
		
		//start each thread at the same time
		setGreenLight();
		
		
		//wait for all threads to end
		for (int i = 0; i < num_threads; i++) 
		{
			 try {
				threadList[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		System.out.println(share_conn);
		if(share_conn)
		{
			
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = null;
		}
	}
	
	
	public threading_task() 
	{
		super();
		//assign an id to the thread
		my_threadID = get_next_id();
	}
	
	
	
	
	////////BUGGGGGGGGGG/////////////////////////////////
	
	public void run() 
	{
		System.out.println(share_conn);
		
		ResultSet rs = null;
		Statement stmt = null;
		
		//begin connection to database
		System.out.println(share_conn);
		if (share_conn)
			try {
				stmt = conn.createStatement();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} // Create a Statement
				 
		
		
		try {
			
			while (!getGreenLight()) 
			{
				yield();
			}
			
			rs = stmt.executeQuery("DELETE FROM myemployeesbook WHERE Name = Tony ");
			
			greenLight = false;
					
			yield();
			
			
			//close resrources
			rs.close();
			rs = null;
			
			//close statement
			stmt.close();
			stmt = null;
			
			
			//close connection
			if((!share_conn) && (conn != null)){
				conn.close();
				conn = null;
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public static synchronized void setGreenLight()
	{ 
		greenLight = true; 
	}
	
	public synchronized boolean getGreenLight()
	{ 
		return greenLight; 
	}
	
	
	

}
