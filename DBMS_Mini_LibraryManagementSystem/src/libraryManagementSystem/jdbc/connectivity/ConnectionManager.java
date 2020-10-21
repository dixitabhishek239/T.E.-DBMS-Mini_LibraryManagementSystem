package libraryManagementSystem.jdbc.connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/LIBRARY_MANAGEMENT_SYSTEM";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "abhishek239";
	   
	   public static void main(String[] args) {
	   Connection conn = null;
	   Statement stmt = null;
	   try{
	      //STEP 2: Register JDBC driver
	      //Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);

	      //STEP 4: Execute a query
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();
	      String sql;
	      sql = "SELECT * FROM BOOK_DETAILS;";
	      ResultSet rs = stmt.executeQuery(sql);

	      //STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	         int bookId  = rs.getInt("BOOK_ID");
	         String bookName = rs.getString("BOOK_NAME");
	         int departmentId = rs.getInt("DEPARTMENT_ID");
	         String bookAuthor = rs.getString("BOOK_AUTHOR");
	         int bookQuantity = rs.getInt("BOOK_QUANTITY");
	         int bookPrice = rs.getInt("BOOK_PRICE");
	         String bookComments = rs.getString("BOOK_COMMENTS");

	         //Display values
	         System.out.print("ID: " + bookId);
	         System.out.print("\nBook Name: " + bookName);
	         System.out.print("\nDepartment ID: " + departmentId);
	         System.out.println("\nBook Author: " + bookAuthor);
	         System.out.print("\nBook Quantity: " + bookQuantity);
	         System.out.print("\nBook Price: " + bookPrice);
	         System.out.print("\nBook Comments: " + bookComments);
	         System.out.println("\n\n");

	      }
	      //STEP 6: Clean-up environment
	      rs.close();
	      stmt.close();
	      conn.close();
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
	   }
}
