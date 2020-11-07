package libraryManagementSystem.wrapper;

import javafx.scene.control.RadioButton;

public class UserDetailsWrapper {

	Integer userId;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	String userName;
	String emailId;
	String departmentDescription;
	Integer contactNo;
	String userTypeDescription;
	Integer issuedBooks;
	public Integer getIssuedBooks() {
		return issuedBooks;
	}
	public void setIssuedBooks(Integer issuedBooks) {
		this.issuedBooks = issuedBooks;
	}
	RadioButton select;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getDepartmentDescription() {
		return departmentDescription;
	}
	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}
	public Integer getContactNo() {
		return contactNo;
	}
	public void setContactNo(Integer contactNo) {
		this.contactNo = contactNo;
	}
	public String getUserTypeDescription() {
		return userTypeDescription;
	}
	public UserDetailsWrapper(String userName, String emailId, String departmentDescription, Integer contactNo, Integer issuedBooks, 
			String userTypeDescription, RadioButton select) {
		super();
		this.userName = userName;
		this.emailId = emailId;
		this.departmentDescription = departmentDescription;
		this.contactNo = contactNo;
		this.userTypeDescription = userTypeDescription;
		this.issuedBooks = issuedBooks;
		this.select = select;
	}
	public UserDetailsWrapper(Integer userId, String userName, String emailId, String departmentDescription, Integer contactNo, Integer issuedBooks,
			String userTypeDescription) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.emailId = emailId;
		this.departmentDescription = departmentDescription;
		this.contactNo = contactNo;
		this.issuedBooks = issuedBooks;
		this.userTypeDescription = userTypeDescription;

	}
	public UserDetailsWrapper() {
		super();
	}
	public UserDetailsWrapper(String userName, String emailId, String departmentDescription, Integer contactNo,
			String userTypeDescription, RadioButton selectedBox) {
		super();
		this.userName = userName;
		this.emailId = emailId;
		this.departmentDescription = departmentDescription;
		this.contactNo = contactNo;
		this.userTypeDescription = userTypeDescription;
	}
	public void setUserTypeDescription(String userTypeDescription) {
		this.userTypeDescription = userTypeDescription;
	}
	public RadioButton getSelect() {
		return select;
	}
	public void setSelect(RadioButton select) {
		this.select = select;
	}
	
}
