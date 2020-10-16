package libraryManagementSystem.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class BookDetailsController {

    @FXML
    private Button backButton;

    @FXML
    private TableColumn<?, ?> bookNameId;

    @FXML
    private TableColumn<?, ?> authorNameId;

    @FXML
    private TableColumn<?, ?> departmentId;

    @FXML
    private TableColumn<?, ?> subjectId;

    @FXML
    private TableColumn<?, ?> quantityId;

    @FXML
    private TableColumn<?, ?> priceId;

    @FXML
    private TableColumn<?, ?> commentsId;

    @FXML
    void BackButtonClick(ActionEvent event) {

    }

}
