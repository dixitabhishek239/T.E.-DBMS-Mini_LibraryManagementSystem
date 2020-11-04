package libraryManagementSystem.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import libraryManagementSystem.beans.BookDetails;
import libraryManagementSystem.jdbc.connectivity.ConnectionManager;
import libraryManagementSystem.wrapper.BookDetailsWrapper;

public class BookDetailsDao {

	public ArrayList<BookDetailsWrapper> getBookDetails() {
		
		ArrayList<BookDetailsWrapper> bookDetailsList = new ArrayList<BookDetailsWrapper>();
		
		try(Connection connection = DriverManager.getConnection(ConnectionManager.getDbUrl(),ConnectionManager.getUser(),ConnectionManager.getPass())){
			Statement statement = connection.createStatement();
			String query = ""
					+ "SELECT \n" + 
					"BD.BOOK_ID, \n" + 
					"BD.BOOK_NAME, \n" + 
					"DD.DEPARTMENT_DESCRIPTION, \n" + 
					"BD.BOOK_AUTHOR, \n" + 
					"BD.BOOK_QUANTITY, \n" + 
					"BD.BOOK_PRICE, \n" + 
					"BD.BOOK_COMMENTS \n" + 
					"FROM BOOK_DETAILS AS BD\n" + 
					"JOIN DEPARTMENT_DETAILS AS DD \n" + 
					"ON BD.DEPARTMENT_ID = DD.DEPARTMENT_ID; \n" + 
					"";
//			System.out.println(query);
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				bookDetailsList.add(
						new BookDetailsWrapper(
								rs.getInt("BOOK_ID"), 
								rs.getString("BOOK_NAME"), 
								rs.getString("DEPARTMENT_DESCRIPTION"), 
								rs.getString("BOOK_AUTHOR"), 
								rs.getInt("BOOK_QUANTITY"), 
								rs.getInt("BOOK_PRICE"), 
								rs.getString("BOOK_COMMENTS")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookDetailsList;
	}
	
	public void create(BookDetails bookDetails) {
		
		try(Connection connection = DriverManager.getConnection(ConnectionManager.getDbUrl(),ConnectionManager.getUser(),ConnectionManager.getPass())){
			Statement statement = connection.createStatement();
			String query = "INSERT INTO BOOK_DETAILS \n" + 
					"( BOOK_NAME, \n" + 
					"  DEPARTMENT_ID,\n" + 
					"  BOOK_AUTHOR,\n" + 
					"  BOOK_QUANTITY,\n" + 
					"  BOOK_PRICE,\n" + 
					"  BOOK_COMMENTS )\n" + 
					"VALUES(\n" + 
					" '"+ bookDetails.getBookName() +"',\n" + 
					" "+ bookDetails.getDepartmentId() +",\n" + 
					" '"+ bookDetails.getBookAuthor() +"',\n" + 
					" "+ bookDetails.getBookQuantity() +",\n" + 
					" "+ bookDetails.getBookPrice() +",\n" + 
					" '"+ bookDetails.getBookComments() +"'\n" + 
					")\n" + 
					"\n" + 
					"\n" + 
					"\n" + 
					"\n" + 
					"\n" + 
					"";
			System.out.println(query);
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
