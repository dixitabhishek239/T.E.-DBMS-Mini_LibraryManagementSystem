package libraryManagementSystem.controllers;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import libraryManagementSystem.beans.DepartmentDetails;
import libraryManagementSystem.beans.UserDetails;
import libraryManagementSystem.beans.UserType;
import libraryManagementSystem.helpers.DepartmentDetailsHelper;
import libraryManagementSystem.helpers.NewUserHelper;
import libraryManagementSystem.helpers.UserDetailsHelper;
import libraryManagementSystem.helpers.UserTypeHelper;

public class NewUserController {

	private Integer userTypeId;
	private String userName;
	private String userEmail;
	private String userPassword;
	private Integer departmentId;
	private Integer contactNo;
	
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
    private ChoiceBox<String> departmentChoiceBox;
    
    @FXML
    private TextField contechNoId;
    
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

    		if( 
    				newNameId.getText().isEmpty() ||
    				newEmailId.getText().isEmpty() ||
    				newPasswordId.getText().isEmpty() ||
    				contechNoId.getText().toString().isEmpty() ||
    				departmentId == null ||
    				userTypeId == null
    				) {
    			ButtonType ok = new ButtonType("ok", ButtonBar.ButtonData.OK_DONE);
        		Alert alert = new Alert(AlertType.WARNING,
        		        "Please fill the fields",
        		        ok);

        		alert.setTitle("Date format warning");
        		Optional<ButtonType> result = alert.showAndWait();

        		if (result.get() == ok) {
        		}
    		}
    		else {
    		userName = newNameId.getText().toUpperCase();
        	userEmail = newEmailId.getText().toUpperCase();
        	userPassword = newPasswordId.getText().toUpperCase();
        	contactNo = Integer.parseInt(contechNoId.getText().toString().toUpperCase());
   		
	    	if(userTypeId==1) {
	    		ButtonType ok = new ButtonType("ok", ButtonBar.ButtonData.OK_DONE);
        		Alert alert = new Alert(AlertType.WARNING,
        		        "ADMIN can't be added to the System.",
        		        ok);

        		alert.setTitle("Date format warning");
        		Optional<ButtonType> result = alert.showAndWait();

        		if (result.get() == ok) {
        		}
	    	}
	    	else {
	    	
	    		UserDetails getUserData = new UserDetailsHelper().getPassword(userEmail);
	    		if(getUserData != null) {
	    			System.out.println("User Exists");
		    		ButtonType ok = new ButtonType("ok", ButtonBar.ButtonData.OK_DONE);
	        		Alert alert = new Alert(AlertType.WARNING,
	        		        "User Exists",
	        		        ok);

	        		alert.setTitle("Date format warning");
	        		Optional<ButtonType> result = alert.showAndWait();

	        		if (result.get() == ok) {
	        		}

	    		}
	    		else {
	    			
	    			UserDetails userDetails = new UserDetails(userName,userTypeId,userEmail,userPassword,departmentId,contactNo);
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
    		}
    	
    }
    
   public void initialize() {
	   
	   contechNoId.textProperty().addListener(new ChangeListener<String>() {
           @Override
           public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
               if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
            	   contechNoId.setText(oldValue);
               }
           }
       });

	   
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

}
