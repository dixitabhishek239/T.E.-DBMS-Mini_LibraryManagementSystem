package libraryManagementSystem.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
			System.out.println(query);
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
	
}
