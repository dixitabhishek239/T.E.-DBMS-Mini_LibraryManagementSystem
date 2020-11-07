package libraryManagementSystem.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdminPageController {

	private int userId;
	private int userTypeId;
	
    @FXML
    private Button logoutbutton;

    @FXML
    private Button addBookButton;

    @FXML
    private Button issuedBookButton;

    @FXML
    private Button sendMailButton;

    @FXML
    private Button totalBooksButton;

    @FXML
    private Button searchBooksButton;

    @FXML
    private Button showUsersButton;
    
    @FXML
    void ShowUsersButtonClick(ActionEvent event) {

    	Parent myNewScene = null;
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxmls/UserDetails.fxml"));
			myNewScene = loader.load();
			UserDetailsController userDetails = loader.getController();
			userDetails.getFromPreviousScreen(userId, userTypeId);
			Stage stage = (Stage) showUsersButton.getScene().getWindow();
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
		    	stage.setTitle("USER DETAILS");
		    	stage.show(); 
			} catch (IOException e) {
				e.printStackTrace();
			}

    	
    }
    
    @FXML
    void AddBookButtonClick(ActionEvent event) {
    	Parent myNewScene = null;
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxmls/AddBooks.fxml"));
			myNewScene = loader.load();
			AddBooksController addBooksController = loader.getController();
			addBooksController.getFromPreviousScreen(userId, userTypeId);
			Stage stage = (Stage) issuedBookButton.getScene().getWindow();
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
		    	stage.setTitle("ADD BOOKS");
		    	stage.show(); 
			} catch (IOException e) {
				e.printStackTrace();
			}

    }

    @FXML
    void IssuedBookButtonClick(ActionEvent event) {
    	Parent myNewScene = null;
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxmls/IssuedBooks.fxml"));
			myNewScene = loader.load();
			IssuedBooksController issuedBooksController = loader.getController();
			issuedBooksController.getFromPreviousScreen(userId,userTypeId);
			Stage stage = (Stage) issuedBookButton.getScene().getWindow();
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
		    	stage.setTitle("ISSUED BOOKS");
		    	stage.show(); 
			} catch (IOException e) {
				e.printStackTrace();
			}
    }

    @FXML
    void SearchBooksButtonClick(ActionEvent event) {
		
    	Parent myNewScene = null;
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxmls/SearchBook.fxml"));
			myNewScene = loader.load();
			SearchBookController searchBookController = loader.getController();
			searchBookController.getFromPreviousScreen(userId,userTypeId);
			Stage stage = (Stage) issuedBookButton.getScene().getWindow();
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
		    	stage.setTitle("SEARCH BOOK");
		    	stage.show(); 
			} catch (IOException e) {
				e.printStackTrace();
			}
    }

    @FXML
    void SendMailButtonClick(ActionEvent event) {
    	Parent myNewScene = null;
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxmls/EmailScreen.fxml"));
			myNewScene = loader.load();
			EmailScreenController emailScreenController = loader.getController();
			emailScreenController.getFromPreviousScreen(userId,userTypeId);
			Stage stage = (Stage) issuedBookButton.getScene().getWindow();
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("EMAIL SCREEN");
	    	stage.show(); 
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void TotalBooksButtonClick(ActionEvent event) {
	 	Parent myNewScene = null;
			try {
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxmls/BookDetails.fxml"));
				myNewScene = loader.load();
				BookDetailsController bookDetailsController = loader.getController();
				bookDetailsController.getFromPreviousScreen(userId,userTypeId);
				Stage stage = (Stage) issuedBookButton.getScene().getWindow();
		    	Scene scene = new Scene(myNewScene);
		    	stage.setScene(scene);
			    	stage.setTitle("BOOK DETAILS");
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
    
    void getFromLoginPage(int userId, int userTypeId) {
    	
    	this.userId = userId;
    	this.userTypeId = userTypeId;
    	    	
    }
    
    public void initialize() {
    	
    }

}
