package libraryManagementSystem.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import libraryManagementSystem.beans.DepartmentDetails;
import libraryManagementSystem.beans.IssuedBooks;
import libraryManagementSystem.helpers.BookDetailsHelper;
import libraryManagementSystem.helpers.DepartmentDetailsHelper;
import libraryManagementSystem.helpers.IssuedBookHelper;
import libraryManagementSystem.wrapper.BookDetailsWrapper;

public class SearchBookController {

	List<BookDetailsWrapper> bookDetailsList = new ArrayList<BookDetailsWrapper>();
	BookDetailsWrapper bookDetailsWrapper = new BookDetailsWrapper();
	
	RadioButton selectedBox;
	
	private Integer userId;
	private int userTypeId;
	private int departmentId;
	private String bookName;
	private String bookAuthor;
	int count = 0;
	
    @FXML
    private Button backButton;

    @FXML
    private ChoiceBox<String> departmentChoiceBox;

    @FXML
    private TextField nameText;

    @FXML
    private TextField authorText;

    @FXML
    private Button searchButton;

    @FXML
    private TableView<BookDetailsWrapper> searchedBookTable;
    
    @FXML
    private TableColumn<BookDetailsWrapper, String> bookNameId;

    @FXML
    private TableColumn<BookDetailsWrapper, String> authorNameId;

    @FXML
    private TableColumn<BookDetailsWrapper, String> departmentCol;

    @FXML
    private TableColumn<BookDetailsWrapper, RadioButton> selectChoiceBoxId;

    @FXML
    private Button issueButton;

    @FXML
    void BackButtonClick(ActionEvent event) {
    	if(userTypeId==1) {
    		Parent myNewScene = null;
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxmls/AdminPage.fxml"));
    			myNewScene = loader.load();
    			AdminPageController adminPageController = loader.getController();
    			adminPageController.getFromLoginPage(userId,userTypeId);
    			Stage stage = (Stage) backButton.getScene().getWindow();
    	    	Scene scene = new Scene(myNewScene);
    	    	stage.setScene(scene);
   		    	stage.setTitle("ADMIN PAGE");
   		    	stage.show(); 
   			} catch (IOException e) {
   				e.printStackTrace();
			}
    	}
    	else {
    		FXMLLoader loader = new FXMLLoader();
   	    	Parent myNewScene;
			try {
    			myNewScene = loader.load(getClass().getResource("../fxmls/StudentPage.fxml").openStream());
    			StudentPageController studentPageController = loader.getController();
    			studentPageController.getFromLoginPage(userId,userTypeId);

    			Stage stage = (Stage) backButton.getScene().getWindow();
    	    	Scene scene = new Scene(myNewScene);
    	    	stage.setScene(scene);
   		    	stage.setTitle("STUDENT PAGE");
   		    	stage.show(); 
   			} catch (IOException e) {
   				e.printStackTrace();
			}    	
    	}
    }

    @FXML
    void IssueButtonClick(ActionEvent event) throws SQLException, ParseException {    	    	    	
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	Calendar cal = Calendar.getInstance();
    	String issuedDateString = sdf.format(cal.getTime());
    	System.out.println("Current Date: "+sdf.format(cal.getTime()));
    	cal.add(Calendar.DAY_OF_MONTH, 14);  
    	String returnDateString = sdf.format(cal.getTime());
    	System.out.println("Date after Addition: "+returnDateString);
    	
    	Date issuedDate = new SimpleDateFormat("dd/MM/yyyy").parse(issuedDateString);
    	Date returnDate = new SimpleDateFormat("dd/MM/yyyy").parse(returnDateString);
    	
    	ArrayList<IssuedBooks> issuedBookIdsList = new IssuedBookHelper().getIssuedBookIdsList(userId);
    	ArrayList<Integer> issuedBookIds = new ArrayList<Integer>();
    	for(IssuedBooks issuedBooks : issuedBookIdsList) {
    		issuedBookIds.add(issuedBooks.getBookId());
    	}
    	    	
    	int bookIssuedCount = new IssuedBookHelper().getBookIssuedCount(userId);
    	if(bookIssuedCount>=2) {
    		ButtonType ok = new ButtonType("ok", ButtonBar.ButtonData.OK_DONE);
    		Alert alert = new Alert(AlertType.INFORMATION,
    		        "You can't issue more than two books.",
    		        ok);

    		alert.setTitle("Oop!!!");
    		Optional<ButtonType> result = alert.showAndWait();

    	}
    	else {
	    	if(issuedBookIds.contains(bookDetailsWrapper.getBookId())) {
	    		ButtonType ok = new ButtonType("ok", ButtonBar.ButtonData.OK_DONE);
	    		Alert alert = new Alert(AlertType.INFORMATION,
	    		        "You can't issue same book twice.",
	    		        ok);
	
	    		alert.setTitle("Oop!!!");
	    		Optional<ButtonType> result = alert.showAndWait();
	
	    	}
	    	else {
		       	if(bookDetailsWrapper.getBookQuantity()==0) {
		    		ButtonType ok = new ButtonType("ok", ButtonBar.ButtonData.OK_DONE);
		    		Alert alert = new Alert(AlertType.INFORMATION,
		    		        "Out of Stock",
		    		        ok);
		
		    		alert.setTitle("Oop!!!");
		    		Optional<ButtonType> result = alert.showAndWait();
		    	}
		    	else {
		    	
		    	new IssuedBookHelper().issuedBookTransaction(bookDetailsWrapper.getBookId(), userId, issuedDate, returnDate);
		    	 
		    	Parent myNewScene = null;
				try {
					
					FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxmls/IssuedBooks.fxml"));
					myNewScene = loader.load();
					IssuedBooksController issuedBooksController = loader.getController();
					issuedBooksController.getFromPreviousScreen(userId,userTypeId);
					Stage stage = (Stage) issueButton.getScene().getWindow();
			    	Scene scene = new Scene(myNewScene);
			    	stage.setScene(scene);
				    	stage.setTitle("ISSUED BOOKS");
				    	stage.show(); 
					} catch (IOException e) {
						e.printStackTrace();
					}
		    	}
	    	}
    	}
    }

    @FXML
    void SearchButtonClick(ActionEvent event) {

    	bookName = nameText.getText().toUpperCase();
    	bookAuthor = authorText.getText().toUpperCase();
    	
    	BookDetailsWrapper bookDetails = new BookDetailsWrapper(departmentId, bookName, bookAuthor);
    	new BookDetailsHelper().searchBooks(bookDetails);
    	
    	bookDetailsList = new BookDetailsHelper().searchBooks(bookDetails);
    	ArrayList<BookDetailsWrapper> bookDetailsWrapperList = new ArrayList<BookDetailsWrapper>();
    	
    	bookNameId.setCellValueFactory(new PropertyValueFactory<BookDetailsWrapper, String>("BookName"));
    	authorNameId.setCellValueFactory(new PropertyValueFactory<BookDetailsWrapper, String>("BookAuthor"));
    	departmentCol.setCellValueFactory(new PropertyValueFactory<BookDetailsWrapper, String>("DepartmentDescription"));
    	selectChoiceBoxId.setCellValueFactory(new PropertyValueFactory<BookDetailsWrapper, RadioButton>("SelectedBox"));
    	    
    	
    	ToggleGroup radioGroup = new ToggleGroup();    	
    	
    	for(BookDetailsWrapper book : bookDetailsList) {
    		
    		selectedBox = new RadioButton();
    		selectedBox.setToggleGroup(radioGroup);
    		  	
    		EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					bookDetailsWrapper = book;
				} 
    		};
    		
    		bookDetailsWrapperList.add(
    				new BookDetailsWrapper(
    						book.getBookName(),
    						book.getBookAuthor(),
    						book.getDepartmentDescription(),
    						selectedBox));
    		selectedBox.setOnAction(event1);
    		    		
    	}
    	
    	ObservableList<BookDetailsWrapper> list = FXCollections.observableArrayList(bookDetailsWrapperList);
    	searchedBookTable.setItems(list);
    	
    }
    
    public void initialize() {
    	
    	List<DepartmentDetails> departmentDetailsList = new DepartmentDetailsHelper().getDepartmentDetailsList();
       	for(DepartmentDetails departmentDetails : departmentDetailsList) {
       		departmentChoiceBox.getItems().add(departmentDetails.getDepartmentDescription());
       	}	
    	EventHandler<ActionEvent> eventDepartmentDetails = new EventHandler<ActionEvent>() {	
			public void handle(ActionEvent event) {
				int index = departmentChoiceBox.getItems().indexOf(departmentChoiceBox.getValue());
				departmentId = departmentDetailsList.get(index).getDepartmentId();
			}
		};
		departmentChoiceBox.setOnAction(eventDepartmentDetails);
    	
    }

	public void getFromPreviousScreen(int userId, int userTypeId) {
		this.userId = userId;
    	this.userTypeId = userTypeId;
    	if(userTypeId==1) {
			issueButton.setDisable(true);
		}
	}
    
}
