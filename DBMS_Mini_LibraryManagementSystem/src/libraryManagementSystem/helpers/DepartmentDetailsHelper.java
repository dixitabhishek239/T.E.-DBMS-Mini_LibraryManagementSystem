package libraryManagementSystem.helpers;

import java.util.ArrayList;

import libraryManagementSystem.beans.DepartmentDetails;
import libraryManagementSystem.daos.DepartmentDetailsDao;

public class DepartmentDetailsHelper {

	public ArrayList<DepartmentDetails> getDepartmentDetailsList(){
		return new DepartmentDetailsDao().getDepartmentDetailsList();
	}
	
}
