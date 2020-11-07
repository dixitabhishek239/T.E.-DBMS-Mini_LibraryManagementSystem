package libraryManagementSystem.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import libraryManagementSystem.helpers.BookDetailsHelper;
import libraryManagementSystem.wrapper.BookDetailsWrapper;

public class BookDetailsController {

	private Integer userId;
	private int userTypeId;
	
    @FXML
    private Button backButton;

    @FXML
    private TableView<BookDetailsWrapper> bookDetailsTable;
    
    @FXML
    private TableColumn<BookDetailsWrapper, String> bookNameId;

    @FXML
    private TableColumn<BookDetailsWrapper, String> authorNameId;

    @FXML
    private TableColumn<BookDetailsWrapper, String> departmentId;

    @FXML
    private TableColumn<BookDetailsWrapper, Integer> quantityId;

    @FXML
    private TableColumn<BookDetailsWrapper, Integer> priceId;

    @FXML
    private TableColumn<BookDetailsWrapper, String> commentsId;

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
    
    public void initialize() {
    	
    	ArrayList<BookDetailsWrapper> bookDetailsList = new BookDetailsHelper().getBookDetails();
    	ArrayList<BookDetailsWrapper> bookDetailsWrapperList = new ArrayList<BookDetailsWrapper>();
    	
    	bookNameId.setCellValueFactory(new PropertyValueFactory<BookDetailsWrapper, String>("BookName"));
    	authorNameId.setCellValueFactory(new PropertyValueFactory<BookDetailsWrapper, String>("BookAuthor"));
    	departmentId.setCellValueFactory(new PropertyValueFactory<BookDetailsWrapper, String>("DepartmentDescription"));
    	quantityId.setCellValueFactory(new PropertyValueFactory<BookDetailsWrapper, Integer>("BookQuantity"));
    	priceId.setCellValueFactory(new PropertyValueFactory<BookDetailsWrapper, Integer>("BookPrice"));
    	commentsId.setCellValueFactory(new PropertyValueFactory<BookDetailsWrapper, String>("BookComments"));
    
    	for(BookDetailsWrapper bookDetailsWrapper : bookDetailsList) {
    		
    		bookDetailsWrapperList.add(
    				new BookDetailsWrapper(
    				bookDetailsWrapper.getBookName(),
    				bookDetailsWrapper.getBookAuthor(),
    				bookDetailsWrapper.getDepartmentDescription(),
    				bookDetailsWrapper.getBookQuantity(),
    				bookDetailsWrapper.getBookPrice(),
    				bookDetailsWrapper.getBookComments()));
    		
    	}
    	ObservableList<BookDetailsWrapper> list =FXCollections.observableArrayList(bookDetailsWrapperList);
    	bookDetailsTable.setItems(list);
    	
    }
	public void getFromPreviousScreen(int userId, int userTypeId) {
		this.userId = userId;
    	this.userTypeId = userTypeId;	
	}
}
















