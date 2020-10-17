package libraryManagementSystem.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

public class SubmitPageController {

    @FXML
    private Button backButton;

    @FXML
    private TableColumn<?, ?> studentNameId;

    @FXML
    private TableColumn<?, ?> departmentId;

    @FXML
    private TableColumn<?, ?> yearId;

    @FXML
    private TableColumn<?, ?> bookNameId;

    @FXML
    private TableColumn<?, ?> issuedDateId;

    @FXML
    private TableColumn<?, ?> returnDateId;

    @FXML
    private TableColumn<?, ?> chooseId;

    @FXML
    private TableColumn<?, ?> fineAmountId;

    @FXML
    private Button submitButton;

    @FXML
    void BackButtonClick(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
    	Parent myNewScene;
		try {
			myNewScene = loader.load(getClass().getResource("../fxmls/StudentPage.fxml").openStream());
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
    void SubmitButtonClick(ActionEvent event) {

    }

}
