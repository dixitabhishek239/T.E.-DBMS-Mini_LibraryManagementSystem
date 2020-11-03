package libraryManagementSystem.helpers;

import libraryManagementSystem.beans.UserDetails;
import libraryManagementSystem.daos.UserDetailsDao;

public class UserDetailsHelper {

	public UserDetails getPassword(String emailId) {
		return new UserDetailsDao().getPassword(emailId);	
	}
	
}
