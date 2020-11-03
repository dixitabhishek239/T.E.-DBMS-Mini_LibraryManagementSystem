package libraryManagementSystem.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import libraryManagementSystem.beans.UserDetails;
import libraryManagementSystem.jdbc.connectivity.ConnectionManager;

public class NewUserDao {

	public void create(UserDetails userDetails) {
		try(Connection connection = DriverManager.getConnection(ConnectionManager.getDbUrl(),ConnectionManager.getUser(),ConnectionManager.getPass())){
			Statement statement = connection.createStatement();
			String query = "INSERT INTO USER_DETAILS ("
					+ "USER_NAME,"
					+ "USER_TYPE_ID,"
					+ "EMAIL_ID,"
					+ "PASSWORD)\n" + 
					"VALUES ('"
					+userDetails.getUserName()+"',"
					+userDetails.getUserTypeId()+",'"
					+userDetails.getEmail()+"','"
					+userDetails.getPassword()+"');";
			System.out.println(query);
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
