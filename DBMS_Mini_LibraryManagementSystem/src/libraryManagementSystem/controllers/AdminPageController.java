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
    void AddBookButtonClick(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
    	Parent myNewScene;
		try {
			myNewScene = loader.load(getClass().getResource("../fxmls/AddBooks.fxml").openStream());
			Stage stage = (Stage) addBookButton.getScene().getWindow();
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
    	FXMLLoader loader = new FXMLLoader();
    	Parent myNewScene;
		try {
			myNewScene = loader.load(getClass().getResource("../fxmls/IssuedBooks.fxml").openStream());
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
    	FXMLLoader loader = new FXMLLoader();
    	Parent myNewScene;
		try {
			myNewScene = loader.load(getClass().getResource("../fxmls/SearchBook.fxml").openStream());
			Stage stage = (Stage) searchBooksButton.getScene().getWindow();
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("SEARCH BOOKS");
	    	stage.show(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void SendMailButtonClick(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
    	Parent myNewScene;
		try {
			myNewScene = loader.load(getClass().getResource("../fxmls/EmailScreen.fxml").openStream());
			Stage stage = (Stage) sendMailButton.getScene().getWindow();
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("EMAIL");
	    	stage.show(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void TotalBooksButtonClick(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
    	Parent myNewScene;
		try {
			myNewScene = loader.load(getClass().getResource("../fxmls/BookDetails.fxml").openStream());
			Stage stage = (Stage) totalBooksButton.getScene().getWindow();
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

}
