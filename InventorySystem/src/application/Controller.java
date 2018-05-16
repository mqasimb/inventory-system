package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
	public Button searchPartButton, addPartButton, modifyPartButton, deletePartButton,
	searchProductButton, addProductButton, modifyProductButton, deleteProductButton;
	public TextField searchPartInput, searchProductInput;
	
	public void addPart(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("addPart.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
	}
	
	public void modifyPart() {
		
	}

	public void deletePart() {

	}
	public void searchPart() {

	}
	
	public void addProduct() {
		
	}
	
	public void modifyProduct() {

		
	}

	public void deleteProduct() {

	}
	public void searchProduct() {

	}
}