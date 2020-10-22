package libraryManagementSystem.beans;

import java.util.Date;

public class IssuedBooks {
	
	int issuedId;
	int bookId;
	int userId;
	Date issuedDate;
	Date returnDate;
	int fine;
	
	
	public IssuedBooks(int issuedId, int bookId, int userId, Date issuedDate, Date returnDate, int fine) {
		super();
		this.issuedId = issuedId;
		this.bookId = bookId;
		this.userId = userId;
		this.issuedDate = issuedDate;
		this.returnDate = returnDate;
		this.fine = fine;
	}
	public int getIssuedId() {
		return issuedId;
	}
	public void setIssuedId(int issuedId) {
		this.issuedId = issuedId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public int getFine() {
		return fine;
	}
	public void setFine(int fine) {
		this.fine = fine;
	}
	
	
	
}
