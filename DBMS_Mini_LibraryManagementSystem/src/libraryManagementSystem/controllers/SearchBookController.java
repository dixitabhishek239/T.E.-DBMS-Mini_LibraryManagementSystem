package libraryManagementSystem.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

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

    }

    @FXML
    void IssueButtonClick(ActionEvent event) {

    }

    @FXML
    void SearchButtonClick(ActionEvent event) {

    }

}
