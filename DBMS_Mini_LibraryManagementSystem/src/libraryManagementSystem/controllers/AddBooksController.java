package libraryManagementSystem.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddBooksController {

    @FXML
    private Button backButton;

    @FXML
    private TextField bookNameText;

    @FXML
    private Spinner<?> quantitySpinner;

    @FXML
    private Label author;

    @FXML
    private TextField authorText;

    @FXML
    private Label department;

    @FXML
    private ChoiceBox<?> departmentChoiceBox;

    @FXML
    private ChoiceBox<?> subjectChoiceBox;

    @FXML
    private TextField priceText;

    @FXML
    private TextArea commentText;

    @FXML
    private Button addButton;

    @FXML
    private Button resetButton;

    @FXML
    void AddButtonClick(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
    	Parent myNewScene;
		try {
			myNewScene = loader.load(getClass().getResource("../fxmls/AdminPage.fxml").openStream());
			Stage stage = (Stage) backButton.getScene().getWindow();
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("ADD BOOKS");
	    	stage.show(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void BackButtonClick(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
    	Parent myNewScene;
		try {
			myNewScene = loader.load(getClass().getResource("../fxmls/AdminPage.fxml").openStream());
			Stage stage = (Stage) backButton.getScene().getWindow();
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("ADD BOOKS");
	    	stage.show(); 
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void ResetButtonClick(ActionEvent event) {

    }

}
