package libraryManagementSystem.helpers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import libraryManagementSystem.beans.IssuedBooks;
import libraryManagementSystem.daos.IssuedBooksDao;
import libraryManagementSystem.wrapper.IssuedBooksWrapper;

public class IssuedBookHelper {

	public ArrayList<IssuedBooksWrapper> getBookDetails() {
		return new IssuedBooksDao().getBookDetails();
	}

	public ArrayList<IssuedBooksWrapper> getBookDetails(int userType) {
		return new IssuedBooksDao().getBookDetails(userType);
	}
	public void issuedBookTransaction(int bookId, int userId, Date issuedDate, Date returnDate) throws SQLException {
		new IssuedBooksDao().issuedBookTransaction(bookId, userId, issuedDate, returnDate);	
	}
	public ArrayList<IssuedBooksWrapper> getSubmitDetailsData(int userId){
		return new IssuedBooksDao().getSubmitDetailsData(userId);
	}
	public void submitbook(IssuedBooks issuedBooks) throws SQLException  {
		new IssuedBooksDao().submitbook(issuedBooks);
	}

	public ArrayList<IssuedBooks> getIssuedBookIdsList(Integer userId) {
		return new IssuedBooksDao().getIssuedBookIdsList(userId);
	}

	public int getBookIssuedCount(Integer userId) {
		return new IssuedBooksDao().getBookIssuedCount(userId);
	}
}
