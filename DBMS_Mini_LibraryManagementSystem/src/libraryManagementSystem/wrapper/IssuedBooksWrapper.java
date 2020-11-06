package libraryManagementSystem.wrapper;

import java.util.Date;

import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;

public class IssuedBooksWrapper {

	int bookId;
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	int issuedId;
	String userName;
	String departmentDescription;
	String bookName;
	String emailId;
	Date issuedDate;
	Date returnDate;
	Integer contactNo;
	boolean emailSent;
	CheckBox emailSentCheckBox;
	Integer fine;
	RadioButton selectedBox;
	
	public IssuedBooksWrapper(int bookId, String userName, String departmentDescription, String bookName, Date issuedDate,
			Date returnDate, int fine) {
		// TODO Auto-generated constructor stub
		this.bookId = bookId;
		this.userName = userName;
		this.departmentDescription = departmentDescription;
		this.bookName = bookName;
		this.issuedDate = issuedDate;
		this.returnDate = returnDate;
		this.fine = fine;
	}
	
	public RadioButton getSelectedBox() {
		return selectedBox;
	}

	public void setSelectedBox(RadioButton selectedBox) {
		this.selectedBox = selectedBox;
	}

	public Integer getFine() {
		return fine;
	}

	public void setFine(Integer fine) {
		this.fine = fine;
	}

	public IssuedBooksWrapper() {
		super();
	}

	public IssuedBooksWrapper(int issuedId, String userName, String departmentDescription, String bookName,
			String emailId, Date issuedDate, Date returnDate, Integer contactNo, boolean emailSent) {
		super();
		this.issuedId = issuedId;
		this.userName = userName;
		this.departmentDescription = departmentDescription;
		this.bookName = bookName;
		this.emailId = emailId;
		this.issuedDate = issuedDate;
		this.returnDate = returnDate;
		this.contactNo = contactNo;
		this.emailSent = emailSent;
	}
	
	public IssuedBooksWrapper(String userName, String departmentDescription, String bookName,
			String emailId, Date issuedDate, Date returnDate, Integer contactNo, CheckBox emailSentCheckBox) {
		super();
		this.userName = userName;
		this.departmentDescription = departmentDescription;
		this.bookName = bookName;
		this.emailId = emailId;
		this.issuedDate = issuedDate;
		this.returnDate = returnDate;
		this.contactNo = contactNo;
		this.emailSentCheckBox = emailSentCheckBox;
	}

	public IssuedBooksWrapper(String userName, String departmentDescription, String bookName, String emailId,
			Date issuedDate, Date returnDate, Integer contactNo) {
		// TODO Auto-generated constructor stub
		this.userName = userName;
		this.departmentDescription = departmentDescription;
		this.bookName = bookName;
		this.emailId = emailId;
		this.issuedDate = issuedDate;
		this.returnDate = returnDate;
		this.contactNo = contactNo;
	
	}

	public IssuedBooksWrapper(String userName, String departmentDescription, String bookName, Date issuedDate, Date returnDate,
			int fine) {
		this.userName = userName;
		this.departmentDescription = departmentDescription;
		this.bookName = bookName;
		this.issuedDate = issuedDate;
		this.returnDate = returnDate;
		this.fine = fine;
	}



	public IssuedBooksWrapper(String userName, String departmentDescription, String bookName, Date issuedDate,
			Date returnDate, CheckBox emailSentCheckBox, Integer fine) {
		this.userName = userName;
		this.departmentDescription = departmentDescription;
		this.bookName = bookName;
		this.issuedDate = issuedDate;
		this.returnDate = returnDate;
		this.emailSentCheckBox = emailSentCheckBox;
		this.fine = fine;
	}

	public IssuedBooksWrapper(String userName, String departmentDescription, String bookName, Date issuedDate,
			Date returnDate, RadioButton selectedBox, Integer fine) {
		this.userName = userName;
		this.departmentDescription = departmentDescription;
		this.bookName = bookName;
		this.issuedDate = issuedDate;
		this.returnDate = returnDate;
		this.selectedBox = selectedBox;
		this.fine = fine;

	}

	

	public CheckBox getEmailSentCheckBox() {
		return emailSentCheckBox;
	}

	public void setEmailSentCheckBox(CheckBox emailSentCheckBox) {
		this.emailSentCheckBox = emailSentCheckBox;
	}

	public int getIssuedId() {
		return issuedId;
	}
	public void setIssuedId(int issuedId) {
		this.issuedId = issuedId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDepartmentDescription() {
		return departmentDescription;
	}
	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
	public Integer getContactNo() {
		return contactNo;
	}
	public void setContactNo(Integer contactNo) {
		this.contactNo = contactNo;
	}
	public boolean isEmailSent() {
		return emailSent;
	}
	public void setEmailSent(boolean emailSent) {
		this.emailSent = emailSent;
	}
	
}
