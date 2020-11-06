package libraryManagementSystem.beans;

public class BookDetails {

	 int bookId;
     String bookName;
     int departmentId;
     String bookAuthor;
     int bookQuantity;
     int bookPrice;
     String bookComments;
     
	public BookDetails(int bookId, String bookName, int departmentId, String bookAuthor, int bookQuantity,
			int bookPrice, String bookComments) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.departmentId = departmentId;
		this.bookAuthor = bookAuthor;
		this.bookQuantity = bookQuantity;
		this.bookPrice = bookPrice;
		this.bookComments = bookComments;
	}

	public BookDetails(String bookName, int departmentId, String bookAuthor, int bookQuantity,
			int bookPrice, String bookComments) {
		super();
		this.bookName = bookName;
		this.departmentId = departmentId;
		this.bookAuthor = bookAuthor;
		this.bookQuantity = bookQuantity;
		this.bookPrice = bookPrice;
		this.bookComments = bookComments;
	}

	
	public BookDetails(int departmentId, String bookName, String bookAuthor) {
		super();
		this.bookName = bookName;
		this.departmentId = departmentId;
		this.bookAuthor = bookAuthor;
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
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
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
