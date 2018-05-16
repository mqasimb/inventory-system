package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddPartController {
	public Button saveButton, cancelButton;
	public TextField idInput, nameInput, inventoryInput, priceInput, maxInput,
	minInput, machineIDInput;
	public Label machineIDLabel;
	
	public void savePart() {
		if(machineIDLabel.getText() == "Company Name") {
			new Outsourced(0, null, 0, 0, 0, 0, null);
		}
		new Inhouse(10, nameInput.getText(), 0, 0, 0, 0, 0);
	}
	
	public void outsourceClicked() {
		machineIDLabel.setText("Company Name");
		
	}

	public void inhouseClicked() {
		machineIDLabel.setText("Machine ID");
	}
	public void cancelClicked(ActionEvent event) throws IOException {
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
	}
}