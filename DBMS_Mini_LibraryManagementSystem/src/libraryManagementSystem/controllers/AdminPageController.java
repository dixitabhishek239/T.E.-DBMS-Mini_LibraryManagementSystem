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
    private Button backButton;

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
			Stage stage = (Stage) addBookButton.getScene().getWindow();
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

    }

    @FXML
    void SendMailButtonClick(ActionEvent event) {

    }

    @FXML
    void TotalBooksButtonClick(ActionEvent event) {

    }

    @FXML
    void backButtonClick(ActionEvent event) {

    }

}
