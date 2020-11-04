package libraryManagementSystem.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SearchBookController {

	private Integer userId;
	private int userTypeId;
	
    @FXML
    private Button backButton;

    @FXML
    private ChoiceBox<?> departmentChoiceBox;

    @FXML
    private TextField nameText;

    @FXML
    private TextField authorText;

    @FXML
    private Button searchButton;

    @FXML
    private TableColumn<?, ?> bookNameId;

    @FXML
    private TableColumn<?, ?> authorNameId;

    @FXML
    private TableColumn<?, ?> subjectId;

    @FXML
    private TableColumn<?, ?> departmentId;

    @FXML
    private TableColumn<?, ?> selectChoiceBoxId;

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
    void IssueButtonClick(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
    	Parent myNewScene;
		try {
			myNewScene = loader.load(getClass().getResource("../fxmls/IssuedBooks.fxml").openStream());
			Stage stage = (Stage) issueButton.getScene().getWindow();
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("ISSUED BOOKS");
	    	stage.show(); 
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void SearchButtonClick(ActionEvent event) {

    }
    
    public void initialize() {}

	public void getFromPreviousScreen(int userId, int userTypeId) {
	
		this.userId = userId;
    	this.userTypeId = userTypeId;
    	
    	System.out.println("ISSUED BOOKS METHOD");
    	System.out.println("USER ID : "+userId);
    	System.out.println("USER TYPE ID : "+userTypeId);	
		
	}
    
}
