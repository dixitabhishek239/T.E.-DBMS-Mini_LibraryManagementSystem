package libraryManagementSystem.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import libraryManagementSystem.beans.UserType;
import libraryManagementSystem.jdbc.connectivity.ConnectionManager;

public class UserTypeDao{
	
	public ArrayList<UserType> getUserTypeList(){
				
		ArrayList<UserType> userTypeList = new ArrayList<UserType>();
		
		try(Connection connection =  DriverManager.getConnection(ConnectionManager.getDbUrl(),ConnectionManager.getUser(),ConnectionManager.getPass())){
			Statement statement = connection.createStatement();
			
			String query = "SELECT USER_TYPE_ID, USER_TYPE_DESCRIPTION FROM USER_TYPE;";
			
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				userTypeList.add(new UserType(rs.getInt("USER_TYPE_ID"),rs.getString("USER_TYPE_DESCRIPTION")));
			}
			
		} 
		catch (SQLException e) {
			userTypeList = null;
			e.printStackTrace();
		}
		
		return userTypeList;
		
	}

	
}
