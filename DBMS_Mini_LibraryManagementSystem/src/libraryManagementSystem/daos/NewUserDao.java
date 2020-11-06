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
			String query = "INSERT INTO USER_DETAILS \n" + 
					"( \n" + 
					"	USER_NAME,\n" + 
					"    USER_TYPE_ID,\n" + 
					"    EMAIL_ID,\n" + 
					"    PASSWORD,\n" + 
					"    CONTACT_NO,\n" + 
					"    DEPARTMENT_ID\n" + 
					")\n" + 
					"VALUES\n" + 
					"(\n" + 
					"	'"+ userDetails.getUserName() +"',\n" + 
					"    "+ userDetails.getUserTypeId() +",\n" + 
					"    '"+ userDetails.getEmail() +"',\n" + 
					"    '"+ userDetails.getPassword() +"',\n" + 
					"    "+ userDetails.getContactNo() +",\n" + 
					"    "+ userDetails.getDepartmentId() +"\n" + 
					")";
			System.out.println(query);
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
