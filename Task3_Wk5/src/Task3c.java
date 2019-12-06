/* *************************
 * Author: 1716208         /*
 * Task: 3				   /*
 * Description: edit SQL   /*
 * tables using JDBC       /*
 * Date: 08/11/2019        /* 
 * ************************/


//import all the relevant libraries to establish a jdbc connection
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Task3c {
	
	//create variable to hold the connection details (filename, database, username, password)
	private static String filename;
	private static String database;
	private static String username;
	private static String password;
	
	//create a string to concatenate 2 variables at once as the connection method only accepts 3 parameters
	private static String db;
	
	//create the main method to perform the database connection 
	public static void main(String arg[]) {
		
		//create a connection variable 
		Connection aConnection;
		
		//use try/catch to establish a connection to a driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch(ClassNotFoundException x) {
			
			//return an error message to the user if a connection to the driver cannot be established
			System.out.println("Cannot find driver class. Check CLASSPATH");
			return;
		}
		
		//once a connection to the driver has been established 
		//a connection to the database can be created
		
		//use try/catch to connect to the database
		try {
			
			//give values to the variables declared above
			filename = "jdbc:mysql://ecommsvr5:3306/";
			database = "anthonyw_oop";
			username = "anthonyw_aoop";
			password = "1716208";
			
			db = filename + database;
			
			//establish a connection with the given information
			aConnection = DriverManager.getConnection(db, username, password);
		} catch(SQLException x) {
			
			//return an error message if the database cannot be connected to
			System.out.println("Exception connecting to database");
			return;
		}
		
		//once connection to driver and database has been established
		//attempt to edit table using jdbc
		
		//use try/catch to attempt to manipulate the table
		try {
			Statement aStmt = aConnection.createStatement();
			
			//enter the SQL code to run and manipulate the table
			String records = ("UPDATE myemployeesbook SET Salary = 2000 WHERE Salary = 1000"
					);
			aStmt.executeUpdate(records);
					
		} catch(SQLException x) {
			//if there is an error, print a message to the screen alerting user
			System.out.println("Exception while executing query:" + x);
		}
		
	}

}
