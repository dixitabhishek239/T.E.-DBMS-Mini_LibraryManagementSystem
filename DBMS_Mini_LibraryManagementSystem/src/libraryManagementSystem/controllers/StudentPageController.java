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
    	Parent myNewScene = null;
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxmls/IssuedBooks.fxml"));
			myNewScene = loader.load();
			IssuedBooksController issuedBooksController = loader.getController();
			issuedBooksController.getFromPreviousScreen(userId,userTypeId);
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

    	Parent myNewScene = null;
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxmls/SearchBook.fxml"));
			myNewScene = loader.load();
			SearchBookController searchBookController = loader.getController();
			searchBookController.getFromPreviousScreen(userId,userTypeId);
			Stage stage = (Stage) issuedBook.getScene().getWindow();
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
		    	stage.setTitle("SEARCH BOOK");
		    	stage.show(); 
			} catch (IOException e) {
				e.printStackTrace();
			}

    }
    

    @FXML
    void SubmitButtonClick(ActionEvent event) {
		Parent myNewScene = null;
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxmls/SubmitBooks.fxml"));
			myNewScene = loader.load();
			SubmitPageController submitPageController = loader.getController();
			submitPageController.getFromPreviousScreen(userId,userTypeId);
			Stage stage = (Stage) issuedBook.getScene().getWindow();
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
		    	stage.setTitle("SUBMIT BOOK");
		    	stage.show(); 
			} catch (IOException e) {
				e.printStackTrace();
			}

    }
    
    public void initialize() {
    	
    }

    void getFromLoginPage(int userId, int userTypeId) {
    	
    	this.userId = userId;
    	this.userTypeId = userTypeId;
    	    
    }


}
