package libraryManagementSystem.helpers;

import java.util.ArrayList;

import libraryManagementSystem.daos.IssuedBooksDao;
import libraryManagementSystem.wrapper.IssuedBooksWrapper;

public class IssuedBookHelper {

	public ArrayList<IssuedBooksWrapper> getBookDetails() {
		return new IssuedBooksDao().getBookDetails();
	}

	public ArrayList<IssuedBooksWrapper> getBookDetails(int userType) {
		return new IssuedBooksDao().getBookDetails(userType);
	}
	
}
