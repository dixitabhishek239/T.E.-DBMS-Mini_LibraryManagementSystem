package libraryManagementSystem.controllers;

import java.io.IOException;
import java.util.Optional;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;

public class EmailScreenController {

	private int userId;
	private int userTypeId;
	
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
    	Parent myNewScene = null;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxmls/AdminPage.fxml"));
			myNewScene = loader.load();
			AdminPageController adminPageController = loader.getController();
			adminPageController.getFromLoginPage(userId,userTypeId);
			Stage stage = (Stage) backButton.getScene().getWindow();
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
		    	stage.setTitle("ADMIN PAGE");
		    	stage.show(); 
			} catch (IOException e) {
				e.printStackTrace();
		}    
	}

    @FXML
    void SendMailButtonClick(ActionEvent event) {

    	// Create the custom dialog.
    	Dialog<Pair<String, String>> dialog = new Dialog<>();
    	dialog.setTitle("Send Mail");
    	dialog.setHeaderText("Please confirm the Email text dear");

    	// Set the icon (must be included in the project).
    	//dialog.setGraphic(new ImageView(this.getClass().getResource("login.png").toString()));

    	// Set the button types.
    	ButtonType sendButtonType = new ButtonType("Send", ButtonData.OK_DONE);
    	dialog.getDialogPane().getButtonTypes().addAll(sendButtonType, ButtonType.CANCEL);

    	// Create the username and password labels and fields.
    	GridPane grid = new GridPane();
    	grid.setHgap(10);
    	grid.setVgap(10);
    	grid.setPadding(new Insets(20, 150, 10, 10));

    	TextField emailSubject = new TextField();
    	emailSubject.setPromptText("Subject");
    	TextArea emailBody = new TextArea();
    	emailBody.setPromptText("Body");

    	grid.add(new Label("Subject:"), 0, 0);
    	grid.add(emailSubject, 1, 0);
    	grid.add(new Label("Body:"), 0, 1);
    	grid.add(emailBody, 1, 1);

    	// Enable/Disable login button depending on whether a username was entered.
    	Node sendButton = dialog.getDialogPane().lookupButton(sendButtonType);
    	sendButton.setDisable(true);

    	// Do some validation (using the Java 8 lambda syntax).
    	emailSubject.textProperty().addListener((observable, oldValue, newValue) -> {
    		sendButton.setDisable(newValue.trim().isEmpty());
    	});

    	dialog.getDialogPane().setContent(grid);

    	// Request focus on the username field by default.
    	Platform.runLater(() -> emailSubject.requestFocus());

    	// Convert the result to a username-password-pair when the login button is clicked.
    	dialog.setResultConverter(dialogButton -> {
    	    if (dialogButton == sendButtonType) {
    	        return new Pair<>(emailSubject.getText(), emailBody.getText());
    	    }
    	    return null;
    	});

    	Optional<Pair<String, String>> result = dialog.showAndWait();

    	result.ifPresent(usernamePassword -> {
    	    System.out.println("Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());
    	});

    	

    	
    	
    }
    
    public void initialize() {
    	
    }

	public void getFromPreviousScreen(int userId, int userTypeId) {
		this.userId = userId;
    	this.userTypeId = userTypeId;
    	
    	System.out.println("ADMIN CONTROLLER");
    	System.out.println("USER ID : "+userId);
    	System.out.println("USER TYPE ID : "+userTypeId);
		
	}

}
