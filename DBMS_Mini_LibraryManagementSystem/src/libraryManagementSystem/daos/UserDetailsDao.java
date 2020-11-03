package libraryManagementSystem.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import libraryManagementSystem.beans.UserDetails;
import libraryManagementSystem.jdbc.connectivity.ConnectionManager;

public class UserDetailsDao {

	public UserDetails getPassword(String emailId) { 
		
		UserDetails userData = null;

		try(Connection connection =  DriverManager.getConnection(ConnectionManager.getDbUrl(),ConnectionManager.getUser(),ConnectionManager.getPass())){
			Statement statement = connection.createStatement();
			
			String query = "SELECT USER_ID, USER_TYPE_ID, EMAIL_ID, PASSWORD FROM USER_DETAILS\n" + 
					"WHERE EMAIL_ID = '"+ emailId +"';";
			
			ResultSet rs = statement.executeQuery(query);

			while(rs.next()) {
				userData = new UserDetails(rs.getInt("USER_ID"),rs.getInt("USER_TYPE_ID"),rs.getString("EMAIL_ID"),rs.getString("PASSWORD"));
			}
						
		} 
		catch (SQLException e) {
			userData = null;
			e.printStackTrace();
		}
		
		return userData;
		
	}
	
}
