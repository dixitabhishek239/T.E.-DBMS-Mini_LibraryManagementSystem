package libraryManagementSystem.controllers;
import java.io.IOException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import libraryManagementSystem.beans.UserDetails;
import libraryManagementSystem.beans.UserType;
import libraryManagementSystem.helpers.NewUserHelper;
import libraryManagementSystem.helpers.UserTypeHelper;

public class NewUserController {

	private Integer userTypeId;
	private String userName;
	private String userEmail;
	private String userPassword;
	
    @FXML
    private Button backButton;

    @FXML
    private ChoiceBox<String> userTypeChoiceBox;

    @FXML
    private TextField newNameId;

    @FXML
    private TextField newEmailId;

    @FXML
    private TextField newPasswordId;

    @FXML
    private Button signUpButton;

    @FXML
    void BackButtonClick(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
    	Parent myNewScene;
		try {
			myNewScene = loader.load(getClass().getResource("../fxmls/LoginPage.fxml").openStream());
			Stage stage = (Stage) backButton.getScene().getWindow();
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("Login");
	    	stage.show(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void SignUpButtonClick(ActionEvent event) {

    	userName = newNameId.getText();
    	userEmail = newEmailId.getText();
    	userPassword = newPasswordId.getText();
    	
    	if(userTypeId==1) {
    		System.out.println("ADMIN can't be added to the System.");
    	}
    	else {
    		
	    	UserDetails userDetails = new UserDetails(userName,userTypeId,userEmail,userPassword);
	    	new NewUserHelper().create(userDetails);
	    	
	    	FXMLLoader loader = new FXMLLoader();
	    	Parent myNewScene;
			try {
				myNewScene = loader.load(getClass().getResource("../fxmls/LoginPage.fxml").openStream());
				Stage stage = (Stage) backButton.getScene().getWindow();
		    	Scene scene = new Scene(myNewScene);
		    	stage.setScene(scene);
		    	stage.setTitle("Login");
		    	stage.show(); 
			} catch (IOException e) {
				e.printStackTrace();
			}

    	}
    	  	
    }
    
   public void initialize() {
	   
	   List<UserType> userTypeList = new UserTypeHelper().getUserTypeList();
      	for(UserType userTypeObject : userTypeList) {
      		userTypeChoiceBox.getItems().add(userTypeObject.getUserTypeDescription());
      	}	
      	EventHandler<ActionEvent> eventUserType = new EventHandler<ActionEvent>() {	
			public void handle(ActionEvent event) {
				int index = userTypeChoiceBox.getItems().indexOf(userTypeChoiceBox.getValue());
				userTypeId = userTypeList.get(index).getUserTypeId();
			}
		};
		userTypeChoiceBox.setOnAction(eventUserType);

	   
   }

}
