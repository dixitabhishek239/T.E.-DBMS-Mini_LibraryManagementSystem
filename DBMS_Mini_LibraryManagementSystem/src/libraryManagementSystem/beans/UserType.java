package libraryManagementSystem.beans;

public class UserType {

	int userTypeId;
	String userTypeDescription;
	
	public UserType(int userTypeId, String userTypeDescription) {
		super();
		this.userTypeId = userTypeId;
		this.userTypeDescription = userTypeDescription;
	}
	
	public int getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}
	public String getUserTypeDescription() {
		return userTypeDescription;
	}
	public void setUserTypeDescription(String userTypeDescription) {
		this.userTypeDescription = userTypeDescription;
	}
	
	
	
}
