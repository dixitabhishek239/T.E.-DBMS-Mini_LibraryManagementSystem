package libraryManagementSystem.helpers;

import java.util.ArrayList;

import libraryManagementSystem.beans.UserType;
import libraryManagementSystem.daos.UserTypeDao;

public class UserTypeHelper {

	public ArrayList<UserType> getUserTypeList(){
		return new UserTypeDao().getUserTypeList();	
	}
	
}
