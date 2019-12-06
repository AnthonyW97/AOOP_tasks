import java.sql.*;

public class threading_task_2 extends Thread
{
  // Default no of threads to 10
  private static int NUM_OF_THREADS = 10;

  private int m_myId;

  //declare all the variables to be used throughout the program
  private static  int c_nextId = 1;
  private static  Connection s_conn = null;
  private static  boolean   share_connection = false;
  private ResultSet  rs   = null;
  private Statement  stmt = null;
  private static boolean greenLight = false;
  private int count = 0;
  //====================================================================================================//
  
  //constructor
  public threading_task_2()
  {
     super();
     // Assign an Id to the thread
     m_myId = getNextId();
  }

  
  //create a method to get the next thread id by incrementing the thread number variable by 1
  synchronized static int getNextId()
  {
      return c_nextId++;
  }
  
  //create a greenlight method to start all 10 threads at the same time
  static synchronized void setGreenLight() 
  { 
	  greenLight = true; 
  }
  synchronized boolean getGreenLight() 
  { 
	  return greenLight; 
  }
  public static void main (String args [])
  {
    try  
    {  
      /* Load the JDBC driver */
      
      Class.forName("com.mysql.cj.jdbc.Driver");
    
     
      System.out.println("All threads will be sharing the same connection");   
  
      
      //insert the correct information to access the database
      try
    	  {
    		  String filename = "jdbc:mysql://ecommsvr5:3306/";
    		  String databaseTable = "anthonyw_oop";
			                                             
    		  String userName = "anthonyw_aoop";
    		  String password = "1716208";
          
    		  String databaseConn = filename + databaseTable;
          
    		  s_conn = DriverManager.getConnection(databaseConn,userName,password);
    		  
    		  //once the connection has been made, set the status of the share_connection boolean to true
    		  share_connection = true;
    		  
    	  }catch(SQLException x) 
    	  {
    		  
    		  //if the connection cannot be established return an error message to the user
            System.out.println("Exception connecting to database:" + x);
            return;
    	  }
     
      System.out.println("MySQL JDBC Driver Registered!");
   
  
      // Create the threads
      Thread[] threadList = new Thread[NUM_OF_THREADS];

      // spawn threads
      for (int i = 0; i < NUM_OF_THREADS; i++)
      {
          threadList[i] = new threading_task_2();
          threadList[i].start();
      }
    
      // Start everyone at the same time
      setGreenLight();

      // wait for all threads to end
      for (int i = 0; i < NUM_OF_THREADS; i++)
      {
          threadList[i].join();
      }

      if (share_connection)
      {
          s_conn.close();
          s_conn = null;
      }
    }//end try
    catch(Exception e)
    {
       e.printStackTrace();
    }
  
  }//end main  

 
  public void run()
  {
	  try
	  {
		  // check the connection
		  if (share_connection)
		  {
			  stmt = s_conn.createStatement(); // Create a Statement
		  }
      

      //checks the race has started
      while (!getGreenLight())
      {
        yield();
      }
          
      //create the query that will delete a record from the table
      count = stmt.executeUpdate("DELETE FROM myemployeesbook WHERE Name='Phil'");   
      
      //if the count variable is greater than 0, it means the query has been executed
      //and therefore the current thread is the one that executed the task
      if (count>0)
      {
    	  System.out.println("Thread reached the end first " + m_myId);	
      }
     
      rs = stmt.executeQuery ("select * from myemployeesbook");  
              
      // Loop through the results
      while (rs.next())
      {
        System.out.println("Thread " + m_myId + " Name: " + rs.getString(1));
        
        // breaking the other threads as soon as one has reached the 'end' i.e. record deleted successfully
        yield();  // Yield To other threads
      }
          
      // Close all the resources
      rs.close();
      rs = null;      
  
      // Close the statement     
      stmt.close();
      stmt = null;
  
      // Close the local connection
      if ((!share_connection) && (s_conn != null))
      {
    	  s_conn.close();
    	  s_conn = null;
      }
      System.out.println("Thread " + m_myId +  " is finished. ");
   }
   catch (Exception e)
   {
	   System.out.println("Thread " + m_myId + " got Exception: " + e);
	   e.printStackTrace();
      return;
    }
  }

  
}//end class