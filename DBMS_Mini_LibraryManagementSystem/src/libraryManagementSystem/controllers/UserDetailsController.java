package libraryManagementSystem.controllers;

import java.io.IOException;
import java.util.ArrayList;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import libraryManagementSystem.helpers.UserDetailsHelper;
import libraryManagementSystem.wrapper.UserDetailsWrapper;

public class UserDetailsController {

	UserDetailsWrapper userDetailsWrapperObject = new UserDetailsWrapper();
	
	private Integer userId;
	private int userTypeId;

	RadioButton selectedBox;
	
    @FXML
    private Button backButton;

    @FXML
    private TableView<UserDetailsWrapper> userTable;

    @FXML
    private TableColumn<UserDetailsWrapper, String> userNameCol;

    @FXML
    private TableColumn<UserDetailsWrapper, String> emailIdCol;

    @FXML
    private TableColumn<UserDetailsWrapper, String> departmentCol;

    @FXML
    private TableColumn<UserDetailsWrapper, Integer> contactNoCol;

    @FXML
    private TableColumn<UserDetailsWrapper, String> userTypeCol;
    
    @FXML
    private TableColumn<UserDetailsWrapper, Integer> booksIssued;

    @FXML
    private TableColumn<UserDetailsWrapper, RadioButton> selectCol;

    @FXML
    private Button deleteUserButton;

    @FXML
    void BackButtonClick(ActionEvent event) {
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

    @FXML
    void DeleteUserButtonClick(ActionEvent event) {

    	if(userDetailsWrapperObject.getUserId()==1) {
    		ButtonType ok = new ButtonType("ok", ButtonBar.ButtonData.OK_DONE);
    		Alert alert = new Alert(AlertType.WARNING,
    		        "You can't remove the Admin",
    		        ok);

    		alert.setTitle("Date format warning");
    		Optional<ButtonType> result = alert.showAndWait();

    	}else {
    		if(userDetailsWrapperObject.getIssuedBooks()==0) {
    			new UserDetailsHelper().deleteUser(userDetailsWrapperObject.getUserId());
        		displayData();
    		}
    		else {
    			ButtonType ok = new ButtonType("ok", ButtonBar.ButtonData.OK_DONE);
        		Alert alert = new Alert(AlertType.WARNING,
        		        "Before removing him/her, make sure he/she has submitted all the books.",
        		        ok);

        		alert.setTitle("Date format warning");
        		Optional<ButtonType> result = alert.showAndWait();
    		}
    		
    	}
    }
    
    
    public void initialize() {
    	
    	displayData();
    	
    }
    
    public void getFromPreviousScreen(int userId, int userTypeId) {
		this.userId = userId;
    	this.userTypeId = userTypeId;
    	
   	}

    public void displayData() {
    	
    	ArrayList<UserDetailsWrapper> getUserDetailsList = new UserDetailsHelper().getUserDetails();
    	ArrayList<UserDetailsWrapper> getUserDetailsWrappersList = new ArrayList<UserDetailsWrapper>();
    	
    	userNameCol.setCellValueFactory(new PropertyValueFactory<UserDetailsWrapper, String>("UserName"));
    	emailIdCol.setCellValueFactory(new PropertyValueFactory<UserDetailsWrapper, String>("EmailId"));
    	departmentCol.setCellValueFactory(new PropertyValueFactory<UserDetailsWrapper, String>("DepartmentDescription"));
    	contactNoCol.setCellValueFactory(new PropertyValueFactory<UserDetailsWrapper, Integer>("ContactNo"));
    	userTypeCol.setCellValueFactory(new PropertyValueFactory<UserDetailsWrapper, String>("UserTypeDescription"));
    	booksIssued.setCellValueFactory(new PropertyValueFactory<UserDetailsWrapper, Integer>("IssuedBooks"));
    	selectCol.setCellValueFactory(new PropertyValueFactory<UserDetailsWrapper, RadioButton>("Select"));
    	    	
    	ToggleGroup radioGroup = new ToggleGroup();    	
    	
    	for(UserDetailsWrapper userDetailsWrapper : getUserDetailsList) {
    		
    		selectedBox = new RadioButton();
    		selectedBox.setToggleGroup(radioGroup);
    		  	
    		EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					userDetailsWrapperObject = userDetailsWrapper;
				} 
    		};

    		
    		getUserDetailsWrappersList.add(
    				new UserDetailsWrapper(
    				userDetailsWrapper.getUserName(),
    				userDetailsWrapper.getEmailId(),
    				userDetailsWrapper.getDepartmentDescription(),
    				userDetailsWrapper.getContactNo(),
    				userDetailsWrapper.getIssuedBooks(),
    				userDetailsWrapper.getUserTypeDescription(),
    				selectedBox));
    		
        	selectedBox.setOnAction(event1);
    		
    	}
    	ObservableList<UserDetailsWrapper> list =FXCollections.observableArrayList(getUserDetailsWrappersList);
    	userTable.setItems(list);
    	
    }

}
