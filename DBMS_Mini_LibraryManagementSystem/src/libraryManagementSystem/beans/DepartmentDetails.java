package libraryManagementSystem.beans;

public class DepartmentDetails {
	
	int departmentId ;
	String departmentDescription;
	
	
	public DepartmentDetails(int departmentId, String departmentDescription) {
		super();
		this.departmentId = departmentId;
		this.departmentDescription = departmentDescription;
	}
	
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentDescription() {
		return departmentDescription;
	}
	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}
	
	

	
}
