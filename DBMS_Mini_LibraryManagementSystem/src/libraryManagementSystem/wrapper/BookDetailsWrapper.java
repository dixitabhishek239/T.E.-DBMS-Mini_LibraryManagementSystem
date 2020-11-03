package libraryManagementSystem.wrapper;

public class BookDetailsWrapper {

	 int bookId;
     String bookName;
     String departmentDescription;
     String bookAuthor;
     int bookQuantity;
     int bookPrice;
     String bookComments;
     
	public BookDetailsWrapper(int bookId, String bookName, String departmentDescription, String bookAuthor,
			int bookQuantity, int bookPrice, String bookComments) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.departmentDescription = departmentDescription;
		this.bookAuthor = bookAuthor;
		this.bookQuantity = bookQuantity;
		this.bookPrice = bookPrice;
		this.bookComments = bookComments;
	}
	
	public BookDetailsWrapper(String bookName, String bookAuthor, String departmentDescription, int bookQuantity,
			int bookPrice, String bookComments) {
		// TODO Auto-generated constructor stub
		super();
		this.bookName = bookName;
		this.departmentDescription = departmentDescription;
		this.bookAuthor = bookAuthor;
		this.bookQuantity = bookQuantity;
		this.bookPrice = bookPrice;
		this.bookComments = bookComments;
	}

	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getDepartmentDescription() {
		return departmentDescription;
	}
	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public int getBookQuantity() {
		return bookQuantity;
	}
	public void setBookQuantity(int bookQuantity) {
		this.bookQuantity = bookQuantity;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookComments() {
		return bookComments;
	}
	public void setBookComments(String bookComments) {
		this.bookComments = bookComments;
	}

	
}
