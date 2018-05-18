package application;

import java.io.IOException;
import java.util.Random;

import javafx.collections.FXCollections;
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

public class ModifyProductController {
	@FXML private Button saveButton, cancelButton, deleteButton, addButton, searchButton, cancelSearchPartButton;
	@FXML private TextField idInput, nameInput, inventoryInput, priceInput, maxInput,
	minInput,searchPartInput;
	@FXML private TableView<Part> partsTableView;
	@FXML private TableColumn<Part, Integer> partIDColumn;
	@FXML private TableColumn<Part, String> partNameColumn;
	@FXML private TableColumn<Part, Integer> partInventoryColumn;
	@FXML private TableColumn<Part, Double> partCostColumn;
	
	@FXML private TableView<Part> productPartTableView;
	@FXML private TableColumn<Part, Integer> productPartIDColumn;
	@FXML private TableColumn<Part, String> productPartNameColumn;
	@FXML private TableColumn<Part, Integer> productPartInventoryColumn;
	@FXML private TableColumn<Part, Double> productPartCostColumn;
	
	private ObservableList<Part> partsList = FXCollections.observableArrayList();
	
	private Product previousProduct;
	
	public void saveProduct(ActionEvent event) throws IOException {
		previousProduct.setName(nameInput.getText());
		previousProduct.setPrice(Double.parseDouble(priceInput.getText()));
		previousProduct.setInStock(Integer.parseInt(inventoryInput.getText()));
		previousProduct.setMin(Integer.parseInt(minInput.getText()));
		previousProduct.setMax(Integer.parseInt(maxInput.getText()));
		
		cancelClicked(event);
	}
	
	public void deletePart() {
		Part selectedPart = productPartTableView.getSelectionModel().getSelectedItem();
		previousProduct.removeAssociatedPart(selectedPart);
	}
	public void addPart() {
		Part selectedPart = partsTableView.getSelectionModel().getSelectedItem();
		if(selectedPart != null && previousProduct.lookupAssociatedPart(selectedPart) < 0) {
			previousProduct.addAssociatedPart(selectedPart);
		}
	}
	public void searchPart() {
		String searchString = searchPartInput.getText();
		ObservableList<Part> filteredList = FXCollections.observableArrayList();
		for(int i=0; i<Main.inventory.getAllParts().size(); i++) {
			if(searchString.toLowerCase().equals(Main.inventory.lookupPart(i).getName().toLowerCase())) {
				filteredList.add(Main.inventory.lookupPart(i));
			}
		}
		partsTableView.setItems(filteredList);
		cancelSearchPartButton.setVisible(true);
		cancelSearchPartButton.setDisable(false);
	}
	
	public void cancelPartSearch() {
		searchPartInput.clear();
		cancelSearchPartButton.setDisable(true);
		cancelSearchPartButton.setVisible(false);
		partsTableView.setItems(Main.inventory.getAllParts());
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
		partsTableView.setItems(Main.inventory.getAllParts());
		
		productPartIDColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partID"));
		productPartNameColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
		productPartInventoryColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("inStock"));
		productPartCostColumn.setCellValueFactory(new PropertyValueFactory<Part, Double>("price"));
	}
	public void initData(Product product) {
		previousProduct = product;
		productPartTableView.setItems(product.getParts());
		idInput.setText(Integer.toString(product.getProductID()));
		nameInput.setText(product.getName());
		inventoryInput.setText(Integer.toString(product.getInStock()));
		priceInput.setText(Double.toString(product.getPrice()));
		maxInput.setText(Integer.toString(product.getMax()));
		minInput.setText(Integer.toString(product.getMin()));
	}
}