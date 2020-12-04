package libraryManagementSystem.helpers;

import java.util.ArrayList;

import libraryManagementSystem.beans.TestTable;
import libraryManagementSystem.beans.UserDetails;
import libraryManagementSystem.daos.UserDetailsDao;
import libraryManagementSystem.wrapper.UserDetailsWrapper;

public class UserDetailsHelper {

	public UserDetails getPassword(String emailId) {
		return new UserDetailsDao().getPassword(emailId);	
	}

	public ArrayList<UserDetailsWrapper> getUserDetails() {
		return new UserDetailsDao().getUserDetails();
	}

	public void deleteUser(Integer userId) {
		new UserDetailsDao().deleteUser(userId);
	}
	
	public TestTable getDecryptedPassword(String userName) {
		return new UserDetailsDao().getDecryptedPassword(userName);
	}

	public UserDetails getPasswordNew(String userName) {
		// TODO Auto-generated method stub
		return new UserDetailsDao().getPasswordNew(userName);
	}
}
