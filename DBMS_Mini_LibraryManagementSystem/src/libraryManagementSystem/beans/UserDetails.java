package libraryManagementSystem.beans;

public class UserDetails {

	int userId;
	String userName;
	int userTypeId;
	String email;
	String password;
	int departmentId;
	Integer contactNo;
	
	
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public Integer getContactNo() {
		return contactNo;
	}
	public void setContactNo(Integer contactNo) {
		this.contactNo = contactNo;
	}
	public UserDetails(int userId, String userName, int userTypeId, String email, String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userTypeId = userTypeId;
		this.email = email;
		this.password = password;
	}
	public UserDetails(int userId, int userTypeId, String email, String password, int contactNo) {
		// TODO Auto-generated constructor stub
		super();
		this.userId = userId;
		this.userTypeId = userTypeId;
		this.email = email;
		this.password = password;
		this.contactNo = contactNo;
	}
	public UserDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public UserDetails(String userName, Integer userTypeId, String email, String password, int departmentId, int contactNo) {
		// TODO Auto-generated constructor stub
		super();
		this.userName = userName;
		this.userTypeId = userTypeId;
		this.email = email;
		this.password = password;
		this.departmentId = departmentId;
		this.contactNo = contactNo;
		
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
