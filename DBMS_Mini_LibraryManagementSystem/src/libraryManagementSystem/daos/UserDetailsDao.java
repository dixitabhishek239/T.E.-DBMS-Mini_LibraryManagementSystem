package libraryManagementSystem.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import libraryManagementSystem.beans.TestTable;
import libraryManagementSystem.beans.UserDetails;
import libraryManagementSystem.jdbc.connectivity.ConnectionManager;
import libraryManagementSystem.wrapper.UserDetailsWrapper;

public class UserDetailsDao {

	public UserDetails getPassword(String emailId) { 
		
		UserDetails userData = null;

		try(Connection connection =  DriverManager.getConnection(ConnectionManager.getDbUrl(),ConnectionManager.getUser(),ConnectionManager.getPass())){
			Statement statement = connection.createStatement();
			
			String query = "SELECT USER_ID, USER_TYPE_ID, EMAIL_ID, PASSWORD, CONTACT_NO FROM USER_DETAILS\n" + 
					"WHERE EMAIL_ID = '"+ emailId +"';";
//			System.out.println(query);
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				userData = new UserDetails(rs.getInt("USER_ID"),rs.getInt("USER_TYPE_ID"),rs.getString("EMAIL_ID"),rs.getString("PASSWORD"),rs.getInt("CONTACT_NO"));
			}
						
		} 
		catch (SQLException e) {
			userData = null;
			e.printStackTrace();
		}
		
		return userData;
		
	}

	public UserDetails getPasswordNew(String userName) {
		UserDetails userData = null;

		try(Connection connection =  DriverManager.getConnection(ConnectionManager.getDbUrl(),ConnectionManager.getUser(),ConnectionManager.getPass())){
			Statement statement = connection.createStatement();
			
			String query = "SELECT USER_ID, USER_TYPE_ID, EMAIL_ID, PASSWORD, CONTACT_NO, SECURE_PASSWORD, SALT FROM USER_DETAILS\n" + 
					"WHERE EMAIL_ID = '"+ userName +"';";
//			System.out.println(query);
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				userData = new UserDetails(rs.getInt("USER_ID"),rs.getInt("USER_TYPE_ID"),rs.getString("EMAIL_ID"),rs.getString("PASSWORD"),rs.getInt("CONTACT_NO"),rs.getString("SECURE_PASSWORD"),rs.getString("SALT"));
			}
						
		} 
		catch (SQLException e) {
			userData = null;
			e.printStackTrace();
		}
		
		return userData;

	}
	
	public ArrayList<UserDetailsWrapper> getUserDetails() {
		
		ArrayList<UserDetailsWrapper> userDetailsList = new ArrayList<UserDetailsWrapper>();
		
		try(Connection connection =  DriverManager.getConnection(ConnectionManager.getDbUrl(),ConnectionManager.getUser(),ConnectionManager.getPass())){
			Statement statement = connection.createStatement();
			
			String query = "SELECT \n" + 
					"UD.USER_ID,\n" + 
					"UD.USER_NAME,\n" + 
					"UD.EMAIL_ID,\n" + 
					"DD.DEPARTMENT_DESCRIPTION,\n" + 
					"UD.CONTACT_NO,\n" + 
					"(SELECT COUNT(BOOK_ID) FROM ISSUED_BOOKS\n" + 
					"WHERE USER_ID = UD.USER_ID) AS ISSUED_BOOKS_COUNT,\n" + 
					"UT.USER_TYPE_DESCRIPTION\n" + 
					"FROM USER_DETAILS AS UD\n" + 
					"JOIN DEPARTMENT_DETAILS AS DD\n" + 
					"ON UD.DEPARTMENT_ID = DD.DEPARTMENT_ID\n" + 
					"JOIN USER_TYPE AS UT\n" + 
					"ON UD.USER_TYPE_ID = UT.USER_TYPE_ID;";
//			System.out.println(query);
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				userDetailsList.add(new UserDetailsWrapper(
						rs.getInt("USER_ID"),
						rs.getString("USER_NAME"),
						rs.getString("EMAIL_ID"),
						rs.getString("DEPARTMENT_DESCRIPTION"),
						rs.getInt("CONTACT_NO"),
						rs.getInt("ISSUED_BOOKS_COUNT"),
						rs.getString("USER_TYPE_DESCRIPTION")));
			}
						
		} 
		catch (SQLException e) {
			userDetailsList = null;
			e.printStackTrace();
		}
		
		return userDetailsList;
	}

	public void deleteUser(Integer userId) {
		try(Connection connection =  DriverManager.getConnection(ConnectionManager.getDbUrl(),ConnectionManager.getUser(),ConnectionManager.getPass())){
			Statement statement = connection.createStatement();
			
			String query = "DELETE FROM USER_DETAILS\n" + 
					"WHERE USER_ID = "+ userId +"";
//			System.out.println(query);
			statement.executeUpdate(query);
						
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
public TestTable getDecryptedPassword(String userName) {
	
		TestTable userDetailsList = null;
		
		try(Connection connection =  DriverManager.getConnection(ConnectionManager.getDbUrl(),ConnectionManager.getUser(),ConnectionManager.getPass())){
			Statement statement = connection.createStatement();
			
			String query = "SELECT USERNAME, PASSWORD, SALT FROM TEST_TABLE "
					+ "WHERE USERNAME = '"+ userName +"';\n" + 
					"";
			System.out.println(query);
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				userDetailsList = new TestTable(
						rs.getString("USERNAME"),
						rs.getString("PASSWORD"),
						rs.getString("SALT"));
			}
						
		} 
		catch (SQLException e) {
			userDetailsList = null;
			e.printStackTrace();
		}
		
		return userDetailsList;
	}
	
}
