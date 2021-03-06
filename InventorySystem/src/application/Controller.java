package application;

import java.io.IOException;

import application.Model.Part;
import application.Model.Product;
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

public class Controller {
	@FXML private Button searchPartButton, addPartButton, modifyPartButton, deletePartButton,
	searchProductButton, addProductButton, modifyProductButton, deleteProductButton, cancelSearchPartButton, cancelSearchProductButton;
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

	public void addPart(ActionEvent event) throws IOException {
		Parent addPart = FXMLLoader.load(getClass().getResource("addPart.fxml"));
		Scene addPartScene = new Scene(addPart);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(addPartScene);
		window.show();
	}
	
	public void modifyPart(ActionEvent event) throws IOException {
		if(partsTableView.getSelectionModel().getSelectedItem() != null) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("modifyPart.fxml"));
			Parent modifyPart = loader.load();
			Scene modifyPartScene = new Scene(modifyPart);
			
			ModifyPartController controller  = loader.getController();
			controller.initData(partsTableView.getSelectionModel().getSelectedItem());
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(modifyPartScene);
			window.show();
		}
	}

	public void deletePart() {
		Part selectedPart = partsTableView.getSelectionModel().getSelectedItem();
		Main.inventory.deletePart(selectedPart);
		
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
	
	public void addProduct(ActionEvent event) throws IOException {
		Parent addProduct = FXMLLoader.load(getClass().getResource("addProduct.fxml"));
		Scene addProductScene = new Scene(addProduct);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(addProductScene);
		window.show();
	}
	
	public void modifyProduct(ActionEvent event) throws IOException {
		if(productsTableView.getSelectionModel().getSelectedItem() != null) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("modifyProduct.fxml"));
			Parent modifyProduct = loader.load();
			Scene modifyProductScene = new Scene(modifyProduct);
			
			ModifyProductController controller  = loader.getController();
			controller.initData(productsTableView.getSelectionModel().getSelectedItem());
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setScene(modifyProductScene);
			window.show();
		}
	}

	public void deleteProduct() {
		Product selectedProduct = productsTableView.getSelectionModel().getSelectedItem();
		Main.inventory.removeProduct(selectedProduct);
	}
	public void searchProduct() {
		String searchString = searchProductInput.getText();
		ObservableList<Product> filteredList = FXCollections.observableArrayList();
		for(int i=0; i<Main.inventory.getAllProducts().size(); i++) {
			if(searchString.toLowerCase().equals(Main.inventory.lookupProduct(i).getName().toLowerCase())) {
				filteredList.add(Main.inventory.lookupProduct(i));
			}
		}
		productsTableView.setItems(filteredList);
		cancelSearchProductButton.setVisible(true);
		cancelSearchProductButton.setDisable(false);
	}
	public void cancelProductSearch() {
		searchProductInput.clear();
		cancelSearchProductButton.setDisable(true);
		cancelSearchProductButton.setVisible(false);
		productsTableView.setItems(Main.inventory.getAllProducts());
	}
	public void exitApplication(ActionEvent event) {
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.close();
	}
	public void initialize() {
		partIDColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partID"));
		partNameColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
		partInventoryColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("inStock"));
		partCostColumn.setCellValueFactory(new PropertyValueFactory<Part, Double>("price"));
		partsTableView.setItems(Main.inventory.getAllParts());
		
		productIDColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("productID"));
		productNameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
		productInventoryColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("inStock"));
		productCostColumn.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
		productsTableView.setItems(Main.inventory.getAllProducts());
	}
}