package libraryManagementSystem.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import libraryManagementSystem.beans.IssuedBooks;
import libraryManagementSystem.helpers.IssuedBookHelper;
import libraryManagementSystem.wrapper.IssuedBooksWrapper;

public class SubmitPageController {

	private Integer userId;
	private int userTypeId;
	RadioButton selectedBox;
	IssuedBooksWrapper issuedBooksWrapperObject = new IssuedBooksWrapper();
    @FXML
    private Button backButton;
    
    @FXML
    private TableView<IssuedBooksWrapper> submitTable;

    @FXML
    private TableColumn<IssuedBooksWrapper, String> studentNameId;

    @FXML
    private TableColumn<IssuedBooksWrapper, String> departmentId;

    @FXML
    private TableColumn<IssuedBooksWrapper, String> bookNameId;

    @FXML
    private TableColumn<IssuedBooksWrapper, Date> issuedDateId;

    @FXML
    private TableColumn<IssuedBooksWrapper, Date> returnDateId;

    @FXML
    private TableColumn<IssuedBooksWrapper, CheckBox> chooseId;

    @FXML
    private TableColumn<IssuedBooksWrapper, Integer> fineAmountId;

    @FXML
    private Button submitButton;

    @FXML
    void BackButtonClick(ActionEvent event) {
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

    @FXML
    void SubmitButtonClick(ActionEvent event) throws SQLException {

    	IssuedBooks issuedBooks = new IssuedBooks( issuedBooksWrapperObject.getBookId(), userId);
    	new IssuedBookHelper().submitbook(issuedBooks);
 
    	getFromPreviousScreen(userId,userTypeId);
    	
    }
    
    public void initialize() {
    	


    	
    }

	public void getFromPreviousScreen(int userId, int userTypeId) {
		this.userId = userId;
    	this.userTypeId = userTypeId;
    	
    	System.out.println("ISSUED BOOKS METHOD");
    	System.out.println("USER ID : "+userId);
    	System.out.println("USER TYPE ID : "+userTypeId);	
    	
    	ArrayList<IssuedBooksWrapper> submitDetailsList = new IssuedBookHelper().getSubmitDetailsData(userId);
    	ArrayList<IssuedBooksWrapper> submitDetailsWrapperList = new ArrayList<IssuedBooksWrapper>();

    	studentNameId.setCellValueFactory(new PropertyValueFactory<IssuedBooksWrapper, String>("UserName"));
    	departmentId.setCellValueFactory(new PropertyValueFactory<IssuedBooksWrapper, String>("DepartmentDescription"));
    	bookNameId.setCellValueFactory(new PropertyValueFactory<IssuedBooksWrapper, String>("BookName"));
    	issuedDateId.setCellValueFactory(new PropertyValueFactory<IssuedBooksWrapper, Date>("IssuedDate"));
    	returnDateId.setCellValueFactory(new PropertyValueFactory<IssuedBooksWrapper, Date>("ReturnDate"));
    	chooseId.setCellValueFactory(new PropertyValueFactory<IssuedBooksWrapper, CheckBox>("SelectedBox"));
    	fineAmountId.setCellValueFactory(new PropertyValueFactory<IssuedBooksWrapper, Integer>("Fine"));    	
    	
    	ToggleGroup radioGroup = new ToggleGroup();    	
    	
		for(IssuedBooksWrapper issuedBooksWrapper : submitDetailsList) {
    		
			selectedBox = new RadioButton();
    		selectedBox.setToggleGroup(radioGroup);
    		
    		EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					System.out.println("NAME : "+issuedBooksWrapper.getBookName());
					issuedBooksWrapperObject = issuedBooksWrapper;
				} 
    		};

    		
    		submitDetailsWrapperList.add(
    				new IssuedBooksWrapper(
    				issuedBooksWrapper.getUserName(),
    				issuedBooksWrapper.getDepartmentDescription(),
    				issuedBooksWrapper.getBookName(),
    				issuedBooksWrapper.getIssuedDate(),
    				issuedBooksWrapper.getReturnDate(),
    				selectedBox,
    				issuedBooksWrapper.getFine()));
    		selectedBox.setOnAction(event1);

		}
		
		ObservableList<IssuedBooksWrapper> list =FXCollections.observableArrayList(submitDetailsWrapperList);
		submitTable.setItems(list);
		
	}
}
