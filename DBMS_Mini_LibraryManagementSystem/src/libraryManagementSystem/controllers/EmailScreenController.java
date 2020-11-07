package libraryManagementSystem.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Pair;
import libraryManagementSystem.helpers.IssuedBookHelper;
import libraryManagementSystem.wrapper.IssuedBooksWrapper;

public class EmailScreenController {

	IssuedBooksWrapper issuedBooksWrapperObject = new IssuedBooksWrapper();
	private RadioButton selectedBox;
	
	private int bookId;
	private int userId;
	private int userTypeId;
	
	String subject;
	String body;
    @FXML
    private Button backButton;

    @FXML
    private TableView<IssuedBooksWrapper> emailTableId;

    @FXML
    private TableColumn<IssuedBooksWrapper, RadioButton> selectId;

    @FXML
    private TableColumn<IssuedBooksWrapper, String> studentNameId;

    @FXML
    private TableColumn<IssuedBooksWrapper, String> departmentId;

    @FXML
    private TableColumn<IssuedBooksWrapper, String> bookNameId;

    @FXML
    private TableColumn<IssuedBooksWrapper, String> emailId;

    @FXML
    private TableColumn<IssuedBooksWrapper, Date> issuedDateId;

    @FXML
    private TableColumn<IssuedBooksWrapper, Date> returnDateId;

    @FXML
    private TableColumn<IssuedBooksWrapper, Integer> contactNumberId;

    @FXML
    private TableColumn<IssuedBooksWrapper, Integer> fineId;

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
    void SendMailButtonClick(ActionEvent event) throws AddressException {

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

    	subject = "Reminder to return the book";
    	body = "Do return the book "+ issuedBooksWrapperObject.getBookName() +" before "+ issuedBooksWrapperObject.getReturnDate() +"";
    	
    	TextField emailSubject = new TextField();
    	emailSubject.setPromptText("Subject");
    	emailSubject.setText(subject);
    	TextArea emailBody = new TextArea();
    	emailBody.setPromptText("Body");
    	emailBody.setText(body);

    	grid.add(new Label("Subject:"), 0, 0);
    	grid.add(emailSubject, 1, 0);
    	grid.add(new Label("Body:"), 0, 1);
    	grid.add(emailBody, 1, 1);

    	dialog.getDialogPane().setContent(grid);
    	// Request focus on the username field by default.
    	Platform.runLater(() -> emailSubject.requestFocus());
    	// Convert the result to a username-password-pair when the login button is clicked.
    	dialog.setResultConverter(dialogButton -> {
    	    if (dialogButton == sendButtonType) {
    	    	try {
					sendMail();
					new IssuedBookHelper().updateEmailSent(issuedBooksWrapperObject.getUserId(), issuedBooksWrapperObject.getBookId());
					displayTable();
				} catch (AddressException e) {
					e.printStackTrace();
				}
    	        return new Pair<>(emailSubject.getText(), emailBody.getText());
    	    }
    	    return null;
    	});

    	Optional<Pair<String, String>> result = dialog.showAndWait();

    	result.ifPresent(usernamePassword -> {
//    	    System.out.println("Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());
    	});

    }
    
    public void initialize() {
    	
    	displayTable();    	
    	
    }

	public void getFromPreviousScreen(int userId, int userTypeId) {
		this.userId = userId;
    	this.userTypeId = userTypeId;
	}
	
	public void sendMail() throws AddressException {
		
				String host = "smtp.gmail.com";
				String user="miniprojectlibrarysystem@gmail.com";  //Your E-mail-Id
				String pass="bapsbaps"; //your e-mail account password

				String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
				String to = issuedBooksWrapperObject.getEmailId().toString().toLowerCase(); //recipient E-mail-Id
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
					
//						System.out.println("A");
						msg.setFrom(new InternetAddress(from));
//						System.out.println("B");
						InternetAddress[] address = {new InternetAddress(to)};
//						System.out.println("C");
						msg.setRecipients(Message.RecipientType.TO, address);
//						System.out.println("D");
						msg.setSubject(subject);
//						System.out.println("E");
						msg.setContent(body, "text/html");
//						System.out.println("F");
						transport = mailSession.getTransport("smtp");
//						System.out.println("4");
						transport.connect(host, user, pass);
//						System.out.println("3");
						
				      transport.sendMessage(msg, msg.getAllRecipients());
//				      System.out.println("Send Success");
				      boolean WasEmailSent = true; // assume it was sent
				      transport.close();

				 }
				 catch (Exception err) {
//					 System.out.println("1");
					 boolean WasEmailSent = false; 
			     }

	}
	public void displayTable() {
		ArrayList<IssuedBooksWrapper> getEmailTableList = new IssuedBookHelper().getEmailTableData();
    	ArrayList<IssuedBooksWrapper> getEmailTableWrapperList = new ArrayList<IssuedBooksWrapper>();
    	
    	selectId.setCellValueFactory(new PropertyValueFactory<IssuedBooksWrapper, RadioButton>("SelectedBox"));
    	studentNameId.setCellValueFactory(new PropertyValueFactory<IssuedBooksWrapper, String>("UserName"));
    	departmentId.setCellValueFactory(new PropertyValueFactory<IssuedBooksWrapper, String>("DepartmentDescription"));
    	bookNameId.setCellValueFactory(new PropertyValueFactory<IssuedBooksWrapper, String>("BookName"));
    	emailId.setCellValueFactory(new PropertyValueFactory<IssuedBooksWrapper, String>("EmailId"));
    	issuedDateId.setCellValueFactory(new PropertyValueFactory<IssuedBooksWrapper, Date>("IssuedDate"));
    	returnDateId.setCellValueFactory(new PropertyValueFactory<IssuedBooksWrapper, Date>("ReturnDate"));
    	contactNumberId.setCellValueFactory(new PropertyValueFactory<IssuedBooksWrapper, Integer>("ContactNo"));
    	fineId.setCellValueFactory(new PropertyValueFactory<IssuedBooksWrapper, Integer>("Fine"));
    	
    	ToggleGroup radioGroup = new ToggleGroup();    	
    	
    	for(IssuedBooksWrapper issuedBooksWrapper : getEmailTableList) {
    		
    		selectedBox = new RadioButton();
    		selectedBox.setToggleGroup(radioGroup);
    		  	
    		EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					bookId = issuedBooksWrapper.getBookId();
					issuedBooksWrapperObject = issuedBooksWrapper;
				} 
    		};

    		
    		getEmailTableWrapperList.add(
    				new IssuedBooksWrapper(
    				selectedBox,
    				issuedBooksWrapper.getUserName(),
    				issuedBooksWrapper.getDepartmentDescription(),
    				issuedBooksWrapper.getBookName(),
    				issuedBooksWrapper.getEmailId(),
    				issuedBooksWrapper.getIssuedDate(),
    				issuedBooksWrapper.getReturnDate(),
    				issuedBooksWrapper.getContactNo(),
    				issuedBooksWrapper.getFine()));
    		
        	selectedBox.setOnAction(event1);
    		
    	}
    	ObservableList<IssuedBooksWrapper> list =FXCollections.observableArrayList(getEmailTableWrapperList);
    	emailTableId.setItems(list);

	}

}
