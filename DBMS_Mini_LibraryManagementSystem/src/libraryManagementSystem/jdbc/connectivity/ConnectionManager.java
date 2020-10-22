package libraryManagementSystem.jdbc.connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   
	   //ABHISHEK
	   static final String DB_URL = "jdbc:mysql://localhost/LIBRARY_MANAGEMENT_SYSTEM";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "abhishek239";
	   
	   //BHADRA
//	   static final String DB_URL = "jdbc:mysql://localhost/LIBRARY_MANAGEMENT_SYSTEM";
//	   //  Database credentials
//	   static final String USER = "root";
//	   static final String PASS = "abhishek239";
	   
	   //PRATIK
//	   static final String DB_URL = "jdbc:mysql://localhost/LIBRARY_MANAGEMENT_SYSTEM";
//	   //  Database credentials
//	   static final String USER = "root";
//	   static final String PASS = "abhishek239";
	   
	   //SOHAM
//	   static final String DB_URL = "jdbc:mysql://localhost/LIBRARY_MANAGEMENT_SYSTEM";
//	   //  Database credentials
//	   static final String USER = "root";
//	   static final String PASS = "abhishek239";
	   
	   
	   public static Connection getConnection() {

			   Connection conn = null;
			   Statement stmt = null;
			   try{
			      //STEP 2: Register JDBC driver
			      //Class.forName("com.mysql.jdbc.Driver");
		
			      //STEP 3: Open a connection
			      System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		
			   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            stmt.close();
			      }catch(SQLException se2){
			      }// nothing we can do
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }//end try
			   System.out.println("END OF ERA!");
	   
	   return conn;
	   }

		public static String getJdbcDriver() {
			return JDBC_DRIVER;
		}
	
		public static String getDbUrl() {
			return DB_URL;
		}
	
		public static String getUser() {
			return USER;
		}
	
		public static String getPass() {
			return PASS;
		}
	   
}
