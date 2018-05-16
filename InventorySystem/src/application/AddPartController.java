package application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddPartController {
	public Button saveButton, cancelButton;
	public TextField idInput, nameInput, inventoryInput, priceInput, maxInput,
	minInput, machineIDInput;
	public Label machineIDLabel;
	
	public void savePart() {
		
	}
	
	public void outsourceClicked() {
		machineIDLabel.setText("Company Name");
		
	}

	public void inhouseClicked() {
		machineIDLabel.setText("Machine ID");
	}
}