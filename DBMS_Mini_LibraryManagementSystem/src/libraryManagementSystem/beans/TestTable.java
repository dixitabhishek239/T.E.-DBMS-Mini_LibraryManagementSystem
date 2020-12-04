package libraryManagementSystem.beans;

public class TestTable {

	String userName;
	String password;
	String salt;
	
	
	
	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getSalt() {
		return salt;
	}



	public void setSalt(String salt) {
		this.salt = salt;
	}



	public TestTable(String userName, String password, String salt) {
		super();
		this.userName = userName;
		this.password = password;
		this.salt = salt;
	}
	
	
	
}
