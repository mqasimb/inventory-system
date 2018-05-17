package application;

import java.io.IOException;
import java.util.Random;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AddProductController {
	@FXML private Button saveButton, cancelButton, deleteButton, addButton, searchButton;
	@FXML private TextField idInput, nameInput, inventoryInput, priceInput, maxInput,
	minInput;
	@FXML private TableView<Part> partsTableView;
	@FXML private TableColumn<Part, Integer> partIDColumn;
	@FXML private TableColumn<Part, String> partNameColumn;
	@FXML private TableColumn<Part, Integer> partInventoryColumn;
	@FXML private TableColumn<Part, Double> partCostColumn;
	
	@FXML private TableView<Part> partsSearchTableView;
	@FXML private TableColumn<Part, Integer> partSearchIDColumn;
	@FXML private TableColumn<Part, String> partSearchNameColumn;
	@FXML private TableColumn<Part, Integer> partSearchInventoryColumn;
	@FXML private TableColumn<Part, Double> partSearchCostColumn;
	
	private ObservableList<Part> partsList;
	
	public void saveProduct(ActionEvent event) throws IOException {
		Random rand = new Random();
		int id = rand.nextInt(50);
		
		Main.inventory.addProduct(new Product(partsList,
				id,
				nameInput.getText(),
				Double.parseDouble(priceInput.getText()),
				Integer.parseInt(inventoryInput.getText()),
				Integer.parseInt(minInput.getText()),
				Integer.parseInt(maxInput.getText())));
		
		cancelClicked(event);
	}
	
	public void deleteProduct() {
		
	}
	public void addProduct() {
		
	}
	public void searchProduct() {
		
	}
	
	public void cancelClicked(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
	}
	public void initialize() {
		partIDColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partID"));
		partNameColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
		partInventoryColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("inStock"));
		partCostColumn.setCellValueFactory(new PropertyValueFactory<Part, Double>("price"));
		partsTableView.setItems(partsList);
		
		partSearchIDColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partID"));
		partSearchNameColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
		partSearchInventoryColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("inStock"));
		partSearchCostColumn.setCellValueFactory(new PropertyValueFactory<Part, Double>("price"));
	}
}