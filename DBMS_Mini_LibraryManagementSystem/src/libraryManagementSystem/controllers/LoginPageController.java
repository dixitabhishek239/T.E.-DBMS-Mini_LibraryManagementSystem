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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import libraryManagementSystem.beans.UserDetails;
import libraryManagementSystem.beans.UserType;
import libraryManagementSystem.helpers.UserDetailsHelper;
import libraryManagementSystem.helpers.UserTypeHelper;
import javafx.scene.control.Hyperlink;

public class LoginPageController {
		
	private Integer userTypeId;
	private String userName;
	private String userPassword;
	private Integer userId;
	
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
    	
    	userName = usernameId.getText();
    	userPassword = passwordId.getText();
    	    		
    	if(userName.equals("") || userPassword.equals("")) {
    		System.out.println("Please enter the REQUIRED FEILDS");
   		}
    	else {
    		
    		UserDetails userDetails = new UserDetailsHelper().getPassword(userName);
    	    userId = userDetails.getUserId();
    		
    	    System.out.println("USER ID : "+userId);
        	System.out.println("USER TYPE ID : "+userTypeId);
    	    
    		if(userDetails==null) {
    			System.out.println("User DOESN'T EXIST.");
    		}
    		else {
    			if(userDetails.getPassword().equals(userPassword)) {
	        		if(userTypeId==userDetails.getUserTypeId() && userTypeId==1) {
	        			
	        	    	Parent myNewScene = null;
	        			try {
	        				//user_type_Id
	        				//User_Id
	        				FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxmls/AdminPage.fxml"));
	    	    			myNewScene = loader.load();
	    	    			AdminPageController adminPageController = loader.getController();
	    	    			adminPageController.getFromLoginPage(userId,userTypeId);
	    	    			Stage stage = (Stage) loginButton.getScene().getWindow();
	    	    	    	Scene scene = new Scene(myNewScene);
	    	    	    	stage.setScene(scene);
	    	   		    	stage.setTitle("ADMIN PAGE");
	    	   		    	stage.show(); 
	    	   			} catch (IOException e) {
	    	   				e.printStackTrace();
	        			}
	   	    		}
	   	    		else if((userTypeId==userDetails.getUserTypeId() && (userTypeId==2 || userTypeId==3))){
	   	    			FXMLLoader loader = new FXMLLoader();
	   	    	    	Parent myNewScene;
    	    			try {
	    	    			myNewScene = loader.load(getClass().getResource("../fxmls/StudentPage.fxml").openStream());
	    	    			StudentPageController studentPageController = loader.getController();
	    	    			studentPageController.getFromLoginPage(userId,userTypeId);
	    	    			Stage stage = (Stage) loginButton.getScene().getWindow();
	    	    	    	Scene scene = new Scene(myNewScene);
	    	    	    	stage.setScene(scene);
	    	   		    	stage.setTitle("STUDENT PAGE");
	    	   		    	stage.show(); 
	    	   			} catch (IOException e) {
	    	   				e.printStackTrace();
	        			}
	   	    		}
	   	    		else {
	   	    			System.out.println("Incorrect USER TYPE");
	   	    		}
    	    		
	        	}
	    	   	else {
	    	  		System.out.println("Incorrect Password");
	    	   	}
    		}
    	}	
    }

    @FXML
    void forgotPasswordLinkClick(ActionEvent event) {

    }

    @FXML
    void newUserLinkClick(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
	    	Parent myNewScene;
		try {
			myNewScene = loader.load(getClass().getResource("../fxmls/NewUser.fxml").openStream());
			Stage stage = (Stage) newUserLink.getScene().getWindow();
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
		    	stage.setTitle("NEW USER PAGE");
		    	stage.show(); 
			} catch (IOException e) {
				e.printStackTrace();
		}

    }
    
//  @Override
    public void initialize() {
    	
    	List<UserType> userTypeList = new UserTypeHelper().getUserTypeList();
       	for(UserType userTypeObject : userTypeList) {
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
