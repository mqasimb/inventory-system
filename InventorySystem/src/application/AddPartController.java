package application;

import java.io.IOException;
import java.util.Random;

import application.Model.Inhouse;
import application.Model.Outsourced;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddPartController {
	@FXML private Button saveButton, cancelButton;
	@FXML private TextField idInput, nameInput, inventoryInput, priceInput, maxInput,
	minInput, machineIDInput;
	@FXML private Label machineIDLabel;
	
	public void savePart(ActionEvent event) throws IOException {
		if(machineIDLabel.getText() == "Company Name") {
			Random rand = new Random();
			int id = rand.nextInt(50);
			Main.inventory.addPart(new Outsourced(id, 
					nameInput.getText(), 
					Double.parseDouble(priceInput.getText()),
					Integer.parseInt(inventoryInput.getText()), 
					Integer.parseInt(minInput.getText()),
					Integer.parseInt(maxInput.getText()),
					machineIDInput.getText()));
		} else {
			Random rand = new Random();
			int id = rand.nextInt(50);
			Main.inventory.addPart(new Inhouse(id, 
					nameInput.getText(), 
					Double.parseDouble(priceInput.getText()),
					Integer.parseInt(inventoryInput.getText()), 
					Integer.parseInt(minInput.getText()),
					Integer.parseInt(maxInput.getText()),
					Integer.parseInt(machineIDInput.getText())));
		}
		cancelClicked(event);
	}
	
	public void outsourceClicked() {
		machineIDLabel.setText("Company Name");
	}

	public void inhouseClicked() {
		machineIDLabel.setText("Machine ID");
	}
	public void cancelClicked(ActionEvent event) throws IOException {
		Parent mainView = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene mainViewScene = new Scene(mainView);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(mainViewScene);
		window.show();
	}
}