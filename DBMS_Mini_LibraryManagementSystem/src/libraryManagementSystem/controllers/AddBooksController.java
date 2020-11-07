package libraryManagementSystem.controllers;

import java.io.IOException;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import libraryManagementSystem.beans.BookDetails;
import libraryManagementSystem.beans.DepartmentDetails;
import libraryManagementSystem.helpers.BookDetailsHelper;
import libraryManagementSystem.helpers.DepartmentDetailsHelper;

public class AddBooksController {

	private Integer userId;
	private int userTypeId;
	
	private String bookName;
	private Integer booksQuantity;
	private String bookAuthor;
	private Integer departmentId;
	private Integer bookPrice;
	private String comments;
	
    @FXML
    private Button backButton;

    @FXML
    private TextField bookNameText;

    @FXML
    private Spinner<Integer> quantitySpinner;

    @FXML
    private Label author;

    @FXML
    private TextField authorText;

    @FXML
    private Label department;

    @FXML
    private ChoiceBox<String> departmentChoiceBox;

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
    	    	
    	if(
    			 bookNameText.getText().trim().isEmpty() ||
    			 authorText.getText().trim().isEmpty() ||
    			 priceText.getText().trim().isEmpty() ||
    			 commentText.getText().trim().isEmpty() ||
    			 departmentId == null
    	) {
    		Alert a1 = new Alert(AlertType.NONE,  
                    "Please Fill the Book Details",ButtonType.OK); 

		      // show the dialog 
		      a1.show();

    	}
    	else {
    	    	
    		bookName = bookNameText.getText().toUpperCase();
        	booksQuantity = quantitySpinner.getValue();
        	bookAuthor = authorText.getText().toUpperCase();
        	bookPrice = Integer.parseInt(priceText.getText().toString());
        	comments = commentText.getText().toUpperCase();

        	BookDetails bookDetails = new BookDetails(bookName,departmentId,bookAuthor,booksQuantity,bookPrice,comments);
        	new BookDetailsHelper().create(bookDetails);
        	
        	
	    	FXMLLoader loader = new FXMLLoader();
	    	Parent myNewScene;
			try {
				myNewScene = loader.load(getClass().getResource("../fxmls/AdminPage.fxml").openStream());
				Stage stage = (Stage) backButton.getScene().getWindow();
		    	Scene scene = new Scene(myNewScene);
		    	stage.setScene(scene);
		    	stage.setTitle("ADMIN PAGE");
		    	stage.show(); 
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}
    }

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
    void ResetButtonClick(ActionEvent event) {

    	bookNameText.clear();
    	authorText.clear();
    	priceText.clear();
    	commentText.clear();    	
    	
    	addButton.setDisable(true);
    	
    }
    
    public void initialize() {
    	
    	priceText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                	priceText.setText(oldValue);
                }
            }
        });
    	
    	List<DepartmentDetails> departmentDetailsList = new DepartmentDetailsHelper().getDepartmentDetailsList();
       	for(DepartmentDetails departmentDetails : departmentDetailsList) {
       		departmentChoiceBox.getItems().add(departmentDetails.getDepartmentDescription());
       	}	
    	EventHandler<ActionEvent> eventDepartmentDetails = new EventHandler<ActionEvent>() {	
			public void handle(ActionEvent event) {
				int index = departmentChoiceBox.getItems().indexOf(departmentChoiceBox.getValue());
				departmentId = departmentDetailsList.get(index).getDepartmentId();
			}
		};
		departmentChoiceBox.setOnAction(eventDepartmentDetails);
    	
		ObservableList<Integer> quantityList = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10);
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<Integer>(quantityList);
		quantitySpinner.setValueFactory(valueFactory);
    }

	public void getFromPreviousScreen(int userId, int userTypeId) {
		this.userId = userId;
    	this.userTypeId = userTypeId;		
	}
    
}
