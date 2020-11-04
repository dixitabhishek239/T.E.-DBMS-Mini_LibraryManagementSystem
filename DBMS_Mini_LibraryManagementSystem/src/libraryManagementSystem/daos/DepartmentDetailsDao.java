package libraryManagementSystem.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import libraryManagementSystem.beans.DepartmentDetails;
import libraryManagementSystem.jdbc.connectivity.ConnectionManager;

public class DepartmentDetailsDao {

	public ArrayList<DepartmentDetails> getDepartmentDetailsList(){
		
		ArrayList<DepartmentDetails> departmentDetailsList = new ArrayList<DepartmentDetails>();
		
		try(Connection connection =  DriverManager.getConnection(ConnectionManager.getDbUrl(),ConnectionManager.getUser(),ConnectionManager.getPass())){
			Statement statement = connection.createStatement();
			
			String query = "\n" + 
					"SELECT DEPARTMENT_ID, DEPARTMENT_DESCRIPTION FROM DEPARTMENT_DETAILS";
			
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				departmentDetailsList.add(new DepartmentDetails(rs.getInt("DEPARTMENT_ID"),rs.getString("DEPARTMENT_DESCRIPTION")));
			}
			
		} 
		catch (SQLException e) {
			departmentDetailsList = null;
			e.printStackTrace();
		}
		
		return departmentDetailsList;
		
	}

	
}
