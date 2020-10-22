package libraryManagementSystem.controllers;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import libraryManagementSystem.beans.UserType;
import libraryManagementSystem.helpers.UserTypeHelper;
import javafx.scene.control.Hyperlink;

public class LoginPageController {
		
	private int userTypeId;
	
    @FXML
    private ChoiceBox<String> loginDropDown;

    @FXML
    private TextField usernameId;

    @FXML
    private PasswordField passwordId;

    @FXML
    private Button loginButton;

    @FXML
    private Hyperlink newUserLink;

    @FXML
    private Hyperlink forgotPasswordLink;


    @FXML
    void LoginClick(ActionEvent event) {

    }

    @FXML
    void forgotPasswordClick(ActionEvent event) {

    }

    @FXML
    void newUserButtonClick(ActionEvent event) {

    }
    
//    @Override
    public void initialize() {
    	
    	List<UserType> userTypeList = new UserTypeHelper().getUserTypeList();
       	for(UserType userTypeObject : userTypeList) {
       		//loginDropDown.getItems().add(userTypeObject.getUserTypeDescription());
       		loginDropDown.getItems().add(userTypeObject.getUserTypeDescription());
       	}	
    	EventHandler<ActionEvent> eventUserType = new EventHandler<ActionEvent>() {	
			public void handle(ActionEvent event) {
				int index = loginDropDown.getItems().indexOf(loginDropDown.getValue());
				userTypeId = userTypeList.get(index).getUserTypeId();
			}
		};
		loginDropDown.setOnAction(eventUserType);

    	
    }

}
