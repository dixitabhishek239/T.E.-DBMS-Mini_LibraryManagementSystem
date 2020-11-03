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
    	FXMLLoader loader = new FXMLLoader();
    	Parent myNewScene;
		try {
			myNewScene = loader.load(getClass().getResource("../fxmls/AdminPage.fxml").openStream());
			Stage stage = (Stage) backButton.getScene().getWindow();
	    	Scene scene = new Scene(myNewScene);
	    	stage.setScene(scene);
	    	stage.setTitle("ADD BOOKS");
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

}
















