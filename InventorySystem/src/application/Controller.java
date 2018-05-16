package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
//import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Controller {
	@FXML private Button searchPartButton, addPartButton, modifyPartButton, deletePartButton,
	searchProductButton, addProductButton, modifyProductButton, deleteProductButton;
	@FXML private TextField searchPartInput, searchProductInput;
	@FXML private TableView<Part> partsTableView;
	@FXML private TableColumn<Part, Integer> partIDColumn;
	@FXML private TableColumn<Part, String> partNameColumn;
	@FXML private TableColumn<Part, Integer> partInventoryColumn;
	@FXML private TableColumn<Part, Double> partCostColumn;
	@FXML private TableView<Product> productsTableView;
	@FXML private TableColumn<Product, Integer> productIDColumn;
	@FXML private TableColumn<Product, String> productNameColumn;
	@FXML private TableColumn<Product, Integer> productInventoryColumn;
	@FXML private TableColumn<Product, Double> productCostColumn;
	
	private Inventory inventory = new Inventory();

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
		Part selectedPart = partsTableView.getSelectionModel().getSelectedItem();
		System.out.println(selectedPart);
		inventory.deletePart(selectedPart);
		
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
	public void initialize() {
		partIDColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partID"));
		partNameColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
		partInventoryColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("inStock"));
		partCostColumn.setCellValueFactory(new PropertyValueFactory<Part, Double>("price"));
//		System.out.println(inventory);
		inventory.addPart(new Outsourced(123, "sample", 10.00, 5, 0, 3, "Empire"));
		partsTableView.setItems(inventory.getAllParts());
	}
}