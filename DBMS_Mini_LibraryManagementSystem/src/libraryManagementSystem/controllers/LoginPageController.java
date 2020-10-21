package libraryManagementSystem.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Hyperlink;

public class LoginPageController {

    @FXML
    private ChoiceBox<?> loginDropDown;

    @FXML
    private TextField usernameId;

    @FXML
    private PasswordField passwordId;

    @FXML
    private Button loginButton;

    @FXML
    private Hyperlink newUserLink;

    @FXML
    private Hyperlink forgotPasswordLink;


    @FXML
    void LoginClick(ActionEvent event) {

    }

    @FXML
    void forgotPasswordClick(ActionEvent event) {

    }

    @FXML
    void newUserButtonClick(ActionEvent event) {

    }

}
