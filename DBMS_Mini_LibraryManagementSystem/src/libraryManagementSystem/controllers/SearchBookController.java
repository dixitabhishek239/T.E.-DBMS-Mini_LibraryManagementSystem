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

    @FXML
    private Button backButton;

    @FXML
    private ChoiceBox<?> departmentChoiceBox;

    @FXML
    private ChoiceBox<?> subjectChoiceBox;

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
    void IssueButtonClick(ActionEvent event) {

    }

    @FXML
    void SearchButtonClick(ActionEvent event) {

    }

}
