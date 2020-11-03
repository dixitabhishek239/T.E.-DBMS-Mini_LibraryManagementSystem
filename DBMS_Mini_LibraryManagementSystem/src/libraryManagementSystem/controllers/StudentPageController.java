package libraryManagementSystem.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import libraryManagementSystem.beans.UserDetails;

public class StudentPageController {

	UserDetails userDetails;
	private int userId;
	private int userTypeId;

    @FXML
    private Button logoutbutton;

    @FXML
    private Button searchBook;

    @FXML
    private Button issuedBook;

    @FXML
    private Button submitButton;

    @FXML
    void IssuedBookClick(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
    	Parent myNewScene;
		try {
			myNewScene = loader.load(getClass().getResource("../fxmls/IssuedBooks.fxml").openStream());
			Stage stage = (Stage) issuedBook.getScene().getWindow();
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("ISSUED BOOKS");
	    	stage.show(); 
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void LogoutButtonClick(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
    	Parent myNewScene;
		try {
			myNewScene = loader.load(getClass().getResource("../fxmls/LoginPage.fxml").openStream());
			Stage stage = (Stage) logoutbutton.getScene().getWindow();
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("LOGIN");
	    	stage.show(); 
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void SearchBookButton(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
    	Parent myNewScene;
		try {
			myNewScene = loader.load(getClass().getResource("../fxmls/SearchBook.fxml").openStream());
			Stage stage = (Stage) searchBook.getScene().getWindow();
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("SEARCH BOOKS");
	    	stage.show(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    

    @FXML
    void SubmitButtonClick(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
    	Parent myNewScene;
		try {
			myNewScene = loader.load(getClass().getResource("../fxmls/SubmitBooks.fxml").openStream());
			Stage stage = (Stage) submitButton.getScene().getWindow();
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("SUBMIT BOOKS");
	    	stage.show(); 
		} catch (IOException e) {
			e.printStackTrace();
		}

    }
    
    public void initialize() {
    	
    	System.out.println("ADMIN CONTROLLER INITIALIZE");
    	System.out.println("USER ID : "+userId);
    	System.out.println("USER TYPE ID : "+userTypeId);
    	
    }

    void getFromLoginPage(int userId, int userTypeId) {
    	
    	this.userId = userId;
    	this.userTypeId = userTypeId;
    	
    	System.out.println("ADMIN CONTROLLER");
    	System.out.println("USER ID : "+userId);
    	System.out.println("USER TYPE ID : "+userTypeId);
    
    }


}
