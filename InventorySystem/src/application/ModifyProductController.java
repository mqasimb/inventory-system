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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ModifyProductController {
	@FXML private Button saveButton, cancelButton, deleteButton, addButton, searchButton, cancelSearchPartButton;
	@FXML private TextField idInput, nameInput, inventoryInput, priceInput, maxInput,
	minInput,searchPartInput;
	@FXML private Label minimumPartValidationLabel,nameValidationLabel, priceValidationLabel;
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
	
	private Product previousProduct;
	private ObservableList<Part> partsList;
	
	public void saveProduct(ActionEvent event) throws IOException {
		boolean partValidation = true, nameValidation = true, priceValidation = true;
		
		nameValidationLabel.setVisible(false);
		priceValidationLabel.setVisible(false);
		minimumPartValidationLabel.setVisible(false);
		
		if(nameInput.getText()==null || nameInput.getText().trim().isEmpty()== true) {
			nameValidation = false;
			nameValidationLabel.setVisible(true);
		}
		if(priceInput.getText()==null || priceInput.getText().trim().isEmpty()== true) {
			priceValidation = false;
			priceValidationLabel.setVisible(true);
		}
		if(inventoryInput.getText()==null || inventoryInput.getText().trim().isEmpty()== true) {
			inventoryInput.setText("0");
		}
		
		if(partsList.size() < 1) {
			minimumPartValidationLabel.setVisible(true);
			partValidation = false;
		}
		
		if(partValidation && nameValidation && priceValidation) {
			previousProduct.saveList(partsList);
			previousProduct.setName(nameInput.getText());
			previousProduct.setPrice(Double.parseDouble(priceInput.getText()));
			previousProduct.setInStock(Integer.parseInt(inventoryInput.getText()));
			previousProduct.setMin(Integer.parseInt(minInput.getText()));
			previousProduct.setMax(Integer.parseInt(maxInput.getText()));
			
			cancelClicked(event);
		}
	}
	
	public void deletePart() {
		Part selectedPart = productPartTableView.getSelectionModel().getSelectedItem();
		partsList.remove(selectedPart);
	}
	public void addPart() {
		Part selectedPart = partsTableView.getSelectionModel().getSelectedItem();
		if(selectedPart != null && partsList.indexOf(selectedPart) < 0) {
			partsList.add(selectedPart);
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
		Parent mainView = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene mainViewScene = new Scene(mainView);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(mainViewScene);
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
		partsList = product.getPartsCopy();
		productPartTableView.setItems(partsList);
		idInput.setText(Integer.toString(product.getProductID()));
		nameInput.setText(product.getName());
		inventoryInput.setText(Integer.toString(product.getInStock()));
		priceInput.setText(Double.toString(product.getPrice()));
		maxInput.setText(Integer.toString(product.getMax()));
		minInput.setText(Integer.toString(product.getMin()));
	}
}