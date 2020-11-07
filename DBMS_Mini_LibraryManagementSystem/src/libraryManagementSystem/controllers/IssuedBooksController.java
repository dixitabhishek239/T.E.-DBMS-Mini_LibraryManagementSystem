package libraryManagementSystem.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import libraryManagementSystem.helpers.IssuedBookHelper;
import libraryManagementSystem.wrapper.IssuedBooksWrapper;

public class IssuedBooksController {
	
	ArrayList<IssuedBooksWrapper> issuedBooksList = new IssuedBookHelper().getBookDetails();
	ArrayList<IssuedBooksWrapper> issuedBooksWrapperList = new ArrayList<IssuedBooksWrapper>();

	private Integer userId;
	private int userTypeId;
	
    @FXML
    private Button backButton;

    @FXML
    private TableView<IssuedBooksWrapper> issuedBookTable;
    
    @FXML
    private TableColumn<IssuedBooksWrapper, String> studentNameId;

    @FXML
    private TableColumn<IssuedBooksWrapper, String> departmentId;

    @FXML
    private TableColumn<IssuedBooksWrapper, String> bookNameId;

    @FXML
    private TableColumn<IssuedBooksWrapper, String> emailId;

    @FXML
    private TableColumn<IssuedBooksWrapper, Date> issuedDateId;

    @FXML
    private TableColumn<IssuedBooksWrapper, Date> returnDateId;

    @FXML
    private TableColumn<IssuedBooksWrapper, Integer> contactNoId;

    @FXML
    private TableColumn<IssuedBooksWrapper, String> emailSentId;
    
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
    
    public void initialize() {
        	    	

	
    }

	public void getFromPreviousScreen(int userId, int userTypeId) {
		
		this.userId = userId;
    	this.userTypeId = userTypeId;
    	
    	if(userTypeId==1) {
        	emailSentId.setVisible(true);
        	issuedBooksList = new IssuedBookHelper().getBookDetails();
        	issuedBooksWrapperList = new ArrayList<IssuedBooksWrapper>();

        	studentNameId.setCellValueFactory(new PropertyValueFactory<IssuedBooksWrapper, String>("UserName"));
        	departmentId.setCellValueFactory(new PropertyValueFactory<IssuedBooksWrapper, String>("DepartmentDescription"));
        	bookNameId.setCellValueFactory(new PropertyValueFactory<IssuedBooksWrapper, String>("BookName"));
        	emailId.setCellValueFactory(new PropertyValueFactory<IssuedBooksWrapper, String>("EmailId"));
        	issuedDateId.setCellValueFactory(new PropertyValueFactory<IssuedBooksWrapper, Date>("IssuedDate"));
        	returnDateId.setCellValueFactory(new PropertyValueFactory<IssuedBooksWrapper, Date>("ReturnDate"));
        	contactNoId.setCellValueFactory(new PropertyValueFactory<IssuedBooksWrapper, Integer>("ContactNo"));
        	emailSentId.setCellValueFactory(new PropertyValueFactory<IssuedBooksWrapper, String>("EmailSentString"));
        	
    		for(IssuedBooksWrapper issuedBooksWrapper : issuedBooksList) {
        		
        		String emailSent = "No";
        		if(issuedBooksWrapper.isEmailSent()) {
            		emailSent = "Yes";
            	}
        		
        		issuedBooksWrapperList.add(
        				new IssuedBooksWrapper(
        				issuedBooksWrapper.getUserName(),
        				issuedBooksWrapper.getDepartmentDescription(),
        				issuedBooksWrapper.getBookName(),
        				issuedBooksWrapper.getEmailId(),
        				issuedBooksWrapper.getIssuedDate(),
        				issuedBooksWrapper.getReturnDate(),
        				issuedBooksWrapper.getContactNo(),
        				emailSent));
    		}
    		
    		ObservableList<IssuedBooksWrapper> list =FXCollections.observableArrayList(issuedBooksWrapperList);
        	issuedBookTable.setItems(list);

    	}
    	else{
    		issuedBooksList = new IssuedBookHelper().getBookDetails(userId);
        	issuedBooksWrapperList = new ArrayList<IssuedBooksWrapper>();

        	studentNameId.setCellValueFactory(new PropertyValueFactory<IssuedBooksWrapper, String>("UserName"));
        	departmentId.setCellValueFactory(new PropertyValueFactory<IssuedBooksWrapper, String>("DepartmentDescription"));
        	bookNameId.setCellValueFactory(new PropertyValueFactory<IssuedBooksWrapper, String>("BookName"));
        	emailId.setCellValueFactory(new PropertyValueFactory<IssuedBooksWrapper, String>("EmailId"));
        	issuedDateId.setCellValueFactory(new PropertyValueFactory<IssuedBooksWrapper, Date>("IssuedDate"));
        	returnDateId.setCellValueFactory(new PropertyValueFactory<IssuedBooksWrapper, Date>("ReturnDate"));
        	contactNoId.setCellValueFactory(new PropertyValueFactory<IssuedBooksWrapper, Integer>("ContactNo"));
        	emailSentId.setCellValueFactory(new PropertyValueFactory<IssuedBooksWrapper, String>("EmailSentString"));
        	
        	emailSentId.setVisible(false);
        	  	
    		for(IssuedBooksWrapper issuedBooksWrapper : issuedBooksList) {
        		
        		String emailSent = "No";
        		if(issuedBooksWrapper.isEmailSent()) {
            		emailSent = "Yes";
            	}

        		issuedBooksWrapperList.add(
        				new IssuedBooksWrapper(
        				issuedBooksWrapper.getUserName(),
        				issuedBooksWrapper.getDepartmentDescription(),
        				issuedBooksWrapper.getBookName(),
        				issuedBooksWrapper.getEmailId(),
        				issuedBooksWrapper.getIssuedDate(),
        				issuedBooksWrapper.getReturnDate(),
        				issuedBooksWrapper.getContactNo(),
        				emailSent));
    		}
    		
    		ObservableList<IssuedBooksWrapper> list =FXCollections.observableArrayList(issuedBooksWrapperList);
        	issuedBookTable.setItems(list);

    	}
    
	}
	
}











