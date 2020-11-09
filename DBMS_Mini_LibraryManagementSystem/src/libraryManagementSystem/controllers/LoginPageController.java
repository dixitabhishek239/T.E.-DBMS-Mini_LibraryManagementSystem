package libraryManagementSystem.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;
import libraryManagementSystem.beans.UserDetails;
import libraryManagementSystem.beans.UserType;
import libraryManagementSystem.helpers.IssuedBookHelper;
import libraryManagementSystem.helpers.UserDetailsHelper;
import libraryManagementSystem.helpers.UserTypeHelper;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;

public class LoginPageController {
		
	UserDetails userDetails;
	
	private Integer userTypeId;
	private String userName;
	private String userPassword;
	private Integer userId;
	
    @FXML
    private ChoiceBox<String> loginDropDown;

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
    	
    	userName = usernameId.getText().toUpperCase();
    	userPassword = passwordId.getText().toUpperCase();
    	    		
    	if(userName.equals("") || userPassword.equals("")) {
    		
    		ButtonType ok = new ButtonType("ok", ButtonBar.ButtonData.OK_DONE);
    		Alert alert = new Alert(AlertType.WARNING,
    		        "Please enter the REQUIRED FEILDS",
    		        ok);

    		alert.setTitle("Date format warning");
    		Optional<ButtonType> result = alert.showAndWait();

    		if (result.get() == ok) {
    		    usernameId.clear();
    		    passwordId.clear();
    		}
    		
    		
   		}
    	else {
    		
    		UserDetails userDetails = new UserDetailsHelper().getPassword(userName);
    	    
    		if(userDetails==null) {
    			//System.out.println("User DOESN'T EXIST.");
    			
        		ButtonType ok = new ButtonType("ok", ButtonBar.ButtonData.OK_DONE);
        		Alert alert = new Alert(AlertType.WARNING,
        		        "User DOESN'T EXIST.",
        		        ok);

        		alert.setTitle("Date format warning");
        		Optional<ButtonType> result = alert.showAndWait();

        		if (result.get() == ok) {
        		    usernameId.clear();
        		    passwordId.clear();
        		}

    			
    		}
    		else {
    			
        	    userId = userDetails.getUserId();

       			if(userDetails.getPassword().equals(userPassword)) {
	        		if(userTypeId==userDetails.getUserTypeId() && userTypeId==1) {
	        			
	        	    	Parent myNewScene = null;
	        			try {
	        				FXMLLoader loader = new FXMLLoader(getClass().getResource("../fxmls/AdminPage.fxml"));
	    	    			myNewScene = loader.load();
	    	    			AdminPageController adminPageController = loader.getController();
	    	    			adminPageController.getFromLoginPage(userId,userTypeId);
	    	    			Stage stage = (Stage) loginButton.getScene().getWindow();
	    	    	    	Scene scene = new Scene(myNewScene);
	    	    	    	stage.setScene(scene);
	    	   		    	stage.setTitle("ADMIN PAGE");
	    	   		    	stage.show(); 
	    	   			} catch (IOException e) {
	    	   				e.printStackTrace();
	        			}
	   	    		}
	   	    		else if((userTypeId==userDetails.getUserTypeId() && (userTypeId==2 || userTypeId==3))){
	   	    			FXMLLoader loader = new FXMLLoader();
	   	    	    	Parent myNewScene;
    	    			try {
	    	    			myNewScene = loader.load(getClass().getResource("../fxmls/StudentPage.fxml").openStream());
	    	    			StudentPageController studentPageController = loader.getController();
	    	    			studentPageController.getFromLoginPage(userId,userTypeId);
	    	    			Stage stage = (Stage) loginButton.getScene().getWindow();
	    	    	    	Scene scene = new Scene(myNewScene);
	    	    	    	stage.setScene(scene);
	    	   		    	stage.setTitle("STUDENT PAGE");
	    	   		    	stage.show(); 
	    	   			} catch (IOException e) {
	    	   				e.printStackTrace();
	        			}
	   	    		}
	   	    		else {
	   	    			
	   	        		ButtonType ok = new ButtonType("ok", ButtonBar.ButtonData.OK_DONE);
	   	        		Alert alert = new Alert(AlertType.WARNING,
	   	        		        "Incorrect USER TYPE",
	   	        		        ok);

	   	        		alert.setTitle("Date format warning");
	   	        		Optional<ButtonType> result = alert.showAndWait();

	   	        		if (result.get() == ok) {
	   	        		    usernameId.clear();
	   	        		    passwordId.clear();
	   	        		}
	   	    		}
    	    		
	        	}
	    	   	else {	    	   		
   	        		ButtonType ok = new ButtonType("ok", ButtonBar.ButtonData.OK_DONE);
   	        		Alert alert = new Alert(AlertType.WARNING,
   	        		        "Incorrect Password",
   	        		        ok);

   	        		alert.setTitle("Date format warning");
   	        		Optional<ButtonType> result = alert.showAndWait();

   	        		if (result.get() == ok) {
   	        		    usernameId.clear();
   	        		    passwordId.clear();
   	        		}
	    	   	}
    		}
    	}	
    }

    @FXML
    void forgotPasswordLinkClick(ActionEvent event) throws AddressException {
    	
    	// Create the custom dialog.
    	Dialog<String> dialog = new Dialog<>();
    	dialog.setTitle("Forgot Password");
    	dialog.setHeaderText("Confirm the details dear.");

    	// Set the button types.
    	ButtonType sendButtonType = new ButtonType("Send mail", ButtonData.OK_DONE);
    	dialog.getDialogPane().getButtonTypes().addAll(sendButtonType, ButtonType.CANCEL);
    	
    	// Create the username and password labels and fields.
    	GridPane grid = new GridPane();
    	grid.setHgap(10);
    	grid.setVgap(10);
    	grid.setPadding(new Insets(20, 150, 10, 10));

    	TextField emailId = new TextField();
    	emailId.setPromptText("Email:");
    	
    	grid.add(new Label("Email:"), 0, 0);
    	grid.add(emailId, 1, 0);

    	dialog.getDialogPane().setContent(grid);
    	// Request focus on the username field by default.
    	Platform.runLater(() -> emailId.requestFocus());
    	// Convert the result to a username-password-pair when the login button is clicked.
    	dialog.setResultConverter(dialogButton -> {
    	    if (dialogButton == sendButtonType) {
    	    	try {
    	    		String confirmEmailId = emailId.getText().toString().toUpperCase();
    	        	userDetails = new UserDetailsHelper().getPassword(confirmEmailId);
    	        	
    	        	if(emailId.getText().toString().equals("")) {
    	        		ButtonType ok = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
    	        		Alert alert = new Alert(AlertType.WARNING,
    	        		        "Please enter the Details dear.",
    	        		        ok);

    	        		alert.setTitle("Date format warning");
    	        		Optional<ButtonType> result = alert.showAndWait();

    	        	}
    	        	else {
	    	        	if(userDetails==null) {
	    	        		ButtonType ok = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
	    	        		Alert alert = new Alert(AlertType.WARNING,
	    	        		        "User DOESN'T EXIST.",
	    	        		        ok);
	
	    	        		alert.setTitle("Date format warning");
	    	        		Optional<ButtonType> result = alert.showAndWait();
	
	    	        	}
	    	        	else {
	    	        		sendMail(confirmEmailId);
	    	        	}
    	    		}
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	    }
    	    return null;
    	});

    	Optional<String> result = dialog.showAndWait();

    	result.ifPresent(usernamePassword -> {
//    	    System.out.println("Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());
    	});


    }

    @FXML
    void newUserLinkClick(ActionEvent event) {
    	FXMLLoader loader = new FXMLLoader();
	    	Parent myNewScene;
		try {
			myNewScene = loader.load(getClass().getResource("../fxmls/NewUser.fxml").openStream());
			Stage stage = (Stage) newUserLink.getScene().getWindow();
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
		    	stage.setTitle("NEW USER PAGE");
		    	stage.show(); 
			} catch (IOException e) {
				e.printStackTrace();
		}

    }
    
//  @Override
    public void initialize() {
    	
    	List<UserType> userTypeList = new UserTypeHelper().getUserTypeList();
       	for(UserType userTypeObject : userTypeList) {
       		loginDropDown.getItems().add(userTypeObject.getUserTypeDescription());
       	}	
    	EventHandler<ActionEvent> eventUserType = new EventHandler<ActionEvent>() {	
			public void handle(ActionEvent event) {
				int index = loginDropDown.getItems().indexOf(loginDropDown.getValue());
				userTypeId = userTypeList.get(index).getUserTypeId();
			}
		};
		loginDropDown.setOnAction(eventUserType);
		
    }

	public void sendMail(String confirmEmailId) throws AddressException {
		
		String host = "smtp.gmail.com";
		String user="miniprojectlibrarysystem@gmail.com";  //Your E-mail-Id
		String pass="bapsbaps"; //your e-mail account password

		String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		String to = userDetails.getEmail().toString().toLowerCase(); //recipient E-mail-Id
		String from = "miniprojectlibrarysystem@gmail.com"; // Your E-mail Id
						
		boolean sessionDebug = true;
	
	
		Properties props = System.getProperties();
		props.put("mail.host", host);
		props.put("mail.transport.protocol.", "smtp");
		props.put("mail.smtp.auth", "true");
		//props.put("mail.smtp.", "true");
		props.put("mail.smtp.port", "465");//port number 465 for Secure (SSL) and we can also use port no 587 for Secure (TLS)
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
	
	
		Session mailSession = Session.getDefaultInstance(props, null);
		mailSession.setDebug(sessionDebug);
	
		Transport transport = null;
		Message msg = new MimeMessage(mailSession);
		try {
			
//				System.out.println("A");
				msg.setFrom(new InternetAddress(from));
//				System.out.println("B");
				InternetAddress[] address = {new InternetAddress(to)};
//				System.out.println("C");
				msg.setRecipients(Message.RecipientType.TO, address);
//				System.out.println("D");
				msg.setSubject("This your password dear");
//				System.out.println("E");
				msg.setContent("Your password is "+ userDetails.getPassword() +" dear", "text/html");
//				System.out.println("F");
				transport = mailSession.getTransport("smtp");
//				System.out.println("4");
				transport.connect(host, user, pass);
//				System.out.println("3");
				
		      transport.sendMessage(msg, msg.getAllRecipients());
//		      System.out.println("Send Success");
		      boolean WasEmailSent = true; // assume it was sent
		      transport.close();

		 }
		 catch (Exception err) {
//			 System.out.println("1");
			 boolean WasEmailSent = false; 
		 }
	}
    
}
