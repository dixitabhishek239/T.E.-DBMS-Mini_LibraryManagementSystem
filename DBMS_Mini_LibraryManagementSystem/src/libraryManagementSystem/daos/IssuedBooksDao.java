package libraryManagementSystem.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import libraryManagementSystem.beans.IssuedBooks;
import libraryManagementSystem.jdbc.connectivity.ConnectionManager;
import libraryManagementSystem.wrapper.IssuedBooksWrapper;

public class IssuedBooksDao {


	public ArrayList<IssuedBooksWrapper> getBookDetails() {
		
		ArrayList<IssuedBooksWrapper> issuedBooksList = new ArrayList<IssuedBooksWrapper>();
		
		try(Connection connection = DriverManager.getConnection(ConnectionManager.getDbUrl(),ConnectionManager.getUser(),ConnectionManager.getPass())){
			Statement statement = connection.createStatement();
			String query = "SELECT ISSUED_ID, \n" + 
					"UD.USER_NAME, \n" + 
					"DD.DEPARTMENT_DESCRIPTION,\n" + 
					"BD.BOOK_NAME, \n" + 
					"UD.EMAIL_ID, \n" + 
					"IB.ISSUED_DATE, \n" + 
					"IB.RETURN_DATE, \n" + 
					"UD.CONTACT_NO, \n" + 
					"IB.EMAIL_SENT\n" + 
					"FROM ISSUED_BOOKS AS IB\n" + 
					"JOIN BOOK_DETAILS AS BD\n" + 
					"ON IB.BOOK_ID = BD.BOOK_ID\n" + 
					"JOIN DEPARTMENT_DETAILS AS DD\n" + 
					"ON BD.DEPARTMENT_ID = DD.DEPARTMENT_ID\n" + 
					"JOIN USER_DETAILS AS UD\n" + 
					"ON IB.USER_ID = UD.USER_ID\n" + 
					"\n" + 
					"\n" + 
					"\n" + 
					"";
			//System.out.println(query);
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				issuedBooksList.add(
						new IssuedBooksWrapper(
								rs.getInt("ISSUED_ID"), 
								rs.getString("USER_NAME"), 
								rs.getString("DEPARTMENT_DESCRIPTION"), 
								rs.getString("BOOK_NAME"), 
								rs.getString("EMAIL_ID"), 
								rs.getDate("ISSUED_DATE"), 
								rs.getDate("RETURN_DATE"),
								rs.getInt("CONTACT_NO"),
								rs.getBoolean("EMAIL_SENT")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return issuedBooksList;
	}

	public ArrayList<IssuedBooksWrapper> getBookDetails(int userId) {
		
		
		ArrayList<IssuedBooksWrapper> issuedBooksList = new ArrayList<IssuedBooksWrapper>();
		
		try(Connection connection = DriverManager.getConnection(ConnectionManager.getDbUrl(),ConnectionManager.getUser(),ConnectionManager.getPass())){
			Statement statement = connection.createStatement();
			String query = "SELECT ISSUED_ID, \n" + 
					"UD.USER_NAME, \n" + 
					"DD.DEPARTMENT_DESCRIPTION,\n" + 
					"BD.BOOK_NAME, \n" + 
					"UD.EMAIL_ID, \n" + 
					"IB.ISSUED_DATE, \n" + 
					"IB.RETURN_DATE, \n" + 
					"UD.CONTACT_NO, \n" + 
					"IB.EMAIL_SENT\n" + 
					"FROM ISSUED_BOOKS AS IB\n" + 
					"JOIN BOOK_DETAILS AS BD\n" + 
					"ON IB.BOOK_ID = BD.BOOK_ID\n" + 
					"JOIN DEPARTMENT_DETAILS AS DD\n" + 
					"ON BD.DEPARTMENT_ID = DD.DEPARTMENT_ID\n" + 
					"JOIN USER_DETAILS AS UD\n" + 
					"ON IB.USER_ID = UD.USER_ID\n" + 
					"WHERE IB.USER_ID = "+userId+"";
			//System.out.println(query);
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				issuedBooksList.add(
						new IssuedBooksWrapper(
								rs.getInt("ISSUED_ID"), 
								rs.getString("USER_NAME"), 
								rs.getString("DEPARTMENT_DESCRIPTION"), 
								rs.getString("BOOK_NAME"), 
								rs.getString("EMAIL_ID"), 
								rs.getDate("ISSUED_DATE"), 
								rs.getDate("RETURN_DATE"),
								rs.getInt("CONTACT_NO"),
								rs.getBoolean("EMAIL_SENT")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return issuedBooksList;
		
	}
	
	public void issuedBookTransaction(int bookId, int userId, Date issuedDate, Date returnDate) throws SQLException {
		
		java.sql.Date convertedIssuedDate = new java.sql.Date(issuedDate.getTime());
		java.sql.Date convertedReturnDate = new java.sql.Date(returnDate.getTime());		
		
		    PreparedStatement insertIssueBook = null;
		    PreparedStatement updateBookDetails = null;
		    
		    String insertIssueBookQuery =
		    		"INSERT INTO ISSUED_BOOKS \n" + 
		    		"( \n" + 
		    		"	BOOK_ID,\n" + 
		    		"    USER_ID,\n" + 
		    		"    ISSUED_DATE,\n" + 
		    		"    RETURN_DATE\n" + 
		    		")\n" + 
		    		"VALUES\n" + 
		    		"(\n" + 
		    		"	"+ bookId +",\n" + 
		    		"    "+ userId +",\n" + 
		    		"    '"+ convertedIssuedDate +"',\n" + 
		    		"    '"+ convertedReturnDate +"'\n" + 
		    		");";

		    String updateBookDetailsQuery =
		    		"UPDATE BOOK_DETAILS \n" + 
		    		"SET BOOK_QUANTITY = BOOK_QUANTITY - 1\n" + 
		    		"WHERE BOOK_ID = "+ bookId +"";
		    
		    Connection connection = DriverManager.getConnection(ConnectionManager.getDbUrl(),ConnectionManager.getUser(),ConnectionManager.getPass());
		    try {
		        connection.setAutoCommit(false);
		        insertIssueBook = connection.prepareStatement(insertIssueBookQuery);
		        updateBookDetails = connection.prepareStatement(updateBookDetailsQuery);
		        
		        	System.out.println(insertIssueBookQuery);
		            insertIssueBook.executeUpdate();
		            System.out.println(updateBookDetailsQuery);
		            updateBookDetails.executeUpdate();

		            connection.commit();
		            
		    } catch (SQLException e ) {
		        //JDBCTutorialUtilities.printSQLException(e);
		        if (connection != null) {
		            try {
		                System.err.print("Transaction is being rolled back");
		                connection.rollback();
		            } catch(SQLException excep) {
		                //JDBCTutorialUtilities.printSQLException(excep);
		            }
		        }
		    } finally {
		        if (insertIssueBook != null) {
		            insertIssueBook.close();
		        }
		        if (updateBookDetails != null) {
		            updateBookDetails.close();
		        }
		        connection.setAutoCommit(true);
		    }
		
	}
	
	public ArrayList<IssuedBooksWrapper> getSubmitDetailsData(int userId){
		
		ArrayList<IssuedBooksWrapper> submitDetailList = new ArrayList<IssuedBooksWrapper>();
		
		try(Connection connection = DriverManager.getConnection(ConnectionManager.getDbUrl(),ConnectionManager.getUser(),ConnectionManager.getPass())){
			Statement statement = connection.createStatement();
			String query = "SELECT \n" + 
					"IB.BOOK_ID,\n" +
					"UD.USER_NAME,\n" + 
					"DD.DEPARTMENT_DESCRIPTION,\n" + 
					"BD.BOOK_NAME,\n" + 
					"IB.ISSUED_DATE,\n" + 
					"IB.RETURN_DATE,\n" + 
					"IB.FINE\n" + 
					"FROM ISSUED_BOOKS AS IB\n" + 
					"JOIN USER_DETAILS AS UD\n" + 
					"ON IB.USER_ID = UD.USER_ID\n" + 
					"JOIN BOOK_DETAILS AS BD\n" + 
					"ON IB.BOOK_ID = BD.BOOK_ID \n" + 
					"JOIN DEPARTMENT_DETAILS AS DD\n" + 
					"ON BD.DEPARTMENT_ID = DD.DEPARTMENT_ID\n" + 
					"WHERE IB.USER_ID = "+ userId +"\n" + 
					"";
			
//			System.out.println(query);
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				submitDetailList.add(
						new IssuedBooksWrapper(
								rs.getInt("BOOK_ID"),
								rs.getString("USER_NAME"), 
								rs.getString("DEPARTMENT_DESCRIPTION"), 
								rs.getString("BOOK_NAME"), 
								rs.getDate("ISSUED_DATE"), 
								rs.getDate("RETURN_DATE"), 
								rs.getInt("FINE")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return submitDetailList;		
	}
	
	public void submitbook(IssuedBooks issuedBooks) throws SQLException {
		
		    PreparedStatement deleteIssuedBook = null;
		    PreparedStatement updateBookDetails = null;
		    
		    String deleteIssueBookQuery =
		    		"DELETE FROM ISSUED_BOOKS\n" + 
		    		"WHERE USER_ID = "+ issuedBooks.getUserId() +" AND BOOK_ID = "+ issuedBooks.getBookId() +"";

		    String updateBookDetailsQuery =
		    		"UPDATE BOOK_DETAILS \n" + 
		    		"SET BOOK_QUANTITY = BOOK_QUANTITY + 1\n" + 
		    		"WHERE BOOK_ID = "+ issuedBooks.getBookId() +";";
		    
		    Connection connection = DriverManager.getConnection(ConnectionManager.getDbUrl(),ConnectionManager.getUser(),ConnectionManager.getPass());
		    try {
		        connection.setAutoCommit(false);
		        deleteIssuedBook = connection.prepareStatement(deleteIssueBookQuery);
		        updateBookDetails = connection.prepareStatement(updateBookDetailsQuery);
		        
		        	System.out.println(deleteIssueBookQuery);
		            deleteIssuedBook.executeUpdate();
		            System.out.println(updateBookDetailsQuery);
		            updateBookDetails.executeUpdate();

		            connection.commit();
		            
		    } catch (SQLException e ) {
		        //JDBCTutorialUtilities.printSQLException(e);
		        if (connection != null) {
		            try {
		                System.err.print("Transaction is being rolled back");
		                connection.rollback();
		            } catch(SQLException excep) {
		                //JDBCTutorialUtilities.printSQLException(excep);
		            }
		        }
		    } finally {
		        if (deleteIssuedBook != null) {
		            deleteIssuedBook.close();
		        }
		        if (updateBookDetails != null) {
		            updateBookDetails.close();
		        }
		        connection.setAutoCommit(true);
		    }
		
	}

	public ArrayList<IssuedBooks> getIssuedBookIdsList(Integer userId) {
    	ArrayList<IssuedBooks> issuedBookIdsList = new ArrayList<IssuedBooks>();
    	try(Connection connection = DriverManager.getConnection(ConnectionManager.getDbUrl(),ConnectionManager.getUser(),ConnectionManager.getPass())){
			Statement statement = connection.createStatement();
			String query = "SELECT BOOK_ID FROM ISSUED_BOOKS WHERE USER_ID = "+ userId +"";
			//System.out.println(query);
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				issuedBookIdsList.add(
						new IssuedBooks(rs.getInt("BOOK_ID")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return issuedBookIdsList;
	}

	public int getBookIssuedCount(Integer userId) {
		int bookIssuedCount = 0;
    	try(Connection connection = DriverManager.getConnection(ConnectionManager.getDbUrl(),ConnectionManager.getUser(),ConnectionManager.getPass())){
			Statement statement = connection.createStatement();
			String query = "SELECT COUNT(BOOK_ID) FROM ISSUED_BOOKS\n" + 
					"WHERE USER_ID = "+ userId +";";
			//System.out.println(query);
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				bookIssuedCount = rs.getInt("COUNT(BOOK_ID)");
			}
			System.out.println("COUNT : "+bookIssuedCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookIssuedCount;
	}

	public ArrayList<IssuedBooksWrapper> getEmailTableData(){
		
		ArrayList<IssuedBooksWrapper> getEmailTableList = new ArrayList<IssuedBooksWrapper>();
		
		try(Connection connection = DriverManager.getConnection(ConnectionManager.getDbUrl(),ConnectionManager.getUser(),ConnectionManager.getPass())){
			Statement statement = connection.createStatement();
			String query = "SELECT\n" + 
					"IB.BOOK_ID,\n" + 
					"UD.USER_ID,\n" + 
					"UD.USER_NAME,\n" + 
					"DD.DEPARTMENT_DESCRIPTION,\n" + 
					"BD.BOOK_NAME,\n" + 
					"UD.EMAIL_ID,\n" + 
					"IB.ISSUED_DATE,\n" + 
					"IB.RETURN_DATE,\n" + 
					"UD.CONTACT_NO,\n" + 
					"IB.FINE\n" + 
					"FROM ISSUED_BOOKS AS IB\n" + 
					"JOIN BOOK_DETAILS AS BD\n" + 
					"ON IB.BOOK_ID = BD.BOOK_ID\n" + 
					"JOIN DEPARTMENT_DETAILS AS DD\n" + 
					"ON BD.DEPARTMENT_ID = DD.DEPARTMENT_ID\n" + 
					"JOIN USER_DETAILS AS UD\n" + 
					"ON IB.USER_ID = UD.USER_ID";
			//System.out.println(query);
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				getEmailTableList.add(
						new IssuedBooksWrapper(
								rs.getInt("BOOK_ID"),
								rs.getInt("USER_ID"),
								rs.getString("USER_NAME"), 
								rs.getString("DEPARTMENT_DESCRIPTION"), 
								rs.getString("BOOK_NAME"), 
								rs.getString("EMAIL_ID"), 
								rs.getDate("ISSUED_DATE"), 
								rs.getDate("RETURN_DATE"), 
								rs.getInt("CONTACT_NO"),
								rs.getInt("FINE")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return getEmailTableList;
		
	}

	public void updateEmailSent(int userId, int bookId) {
		try(Connection connection = DriverManager.getConnection(ConnectionManager.getDbUrl(),ConnectionManager.getUser(),ConnectionManager.getPass())){
			Statement statement = connection.createStatement();
			String query = "UPDATE ISSUED_BOOKS \n" + 
					"SET EMAIL_SENT = 1\n" + 
					"WHERE USER_ID = "+ userId +" AND BOOK_ID = "+ bookId +"";
//			System.out.println(query);
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
