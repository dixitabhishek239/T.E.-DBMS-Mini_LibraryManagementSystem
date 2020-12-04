package libraryManagementSystem.helpers;

import libraryManagementSystem.beans.UserDetails;
import libraryManagementSystem.daos.NewUserDao;

public class NewUserHelper {

	public void create(UserDetails userDetails) {
		new NewUserDao().create(userDetails);
	}
	public void createNew(UserDetails userDetailsNew) {
		new NewUserDao().createNew(userDetailsNew);
	}

}
