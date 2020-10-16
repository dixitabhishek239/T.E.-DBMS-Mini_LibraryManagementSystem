package libraryManagementSystem.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class EmailScreenController {

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
    private TableColumn<?, ?> emailId;

    @FXML
    private TableColumn<?, ?> issuedDateId;

    @FXML
    private TableColumn<?, ?> returnDateId;

    @FXML
    private TableColumn<?, ?> contactNumberId;

    @FXML
    private TableColumn<?, ?> fineId;

    @FXML
    private Button sendMailButton;

    @FXML
    void BackButtonClick(ActionEvent event) {

    }

    @FXML
    void SendMailButtonClick(ActionEvent event) {

    }

}
