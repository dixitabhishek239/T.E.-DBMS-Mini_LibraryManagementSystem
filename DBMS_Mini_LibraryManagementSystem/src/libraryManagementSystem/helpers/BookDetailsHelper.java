package libraryManagementSystem.helpers;

import java.util.ArrayList;

import libraryManagementSystem.daos.BookDetailsDao;
import libraryManagementSystem.wrapper.BookDetailsWrapper;

public class BookDetailsHelper {

	public ArrayList<BookDetailsWrapper> getBookDetails() {
		return new BookDetailsDao().getBookDetails();
	}
	
}
