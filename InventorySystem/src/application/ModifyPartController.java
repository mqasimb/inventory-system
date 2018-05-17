package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ModifyPartController {
	@FXML private Button saveButton, cancelButton;
	@FXML private TextField idInput, nameInput, inventoryInput, priceInput, maxInput,
	minInput, machineIDInput;
	@FXML private Label machineIDLabel;
	@FXML private RadioButton outsourcedRadioButton, inhouseRadioButton;
	
	private Part previousPart;
	
	public void savePart(ActionEvent event) throws IOException {
		int index = Main.inventory.getAllParts().indexOf(previousPart);
		if(index >= -1) {
			if(machineIDLabel.getText() == "Company Name") {
				Main.inventory.updatePart(index,
				new Outsourced(previousPart.getPartID(), 
						nameInput.getText(), 
						Double.parseDouble(priceInput.getText()),
						Integer.parseInt(inventoryInput.getText()), 
						Integer.parseInt(minInput.getText()),
						Integer.parseInt(maxInput.getText()),
						machineIDInput.getText()));
			} else {
				Main.inventory.updatePart(index,
				new Inhouse(previousPart.getPartID(), 
						nameInput.getText(), 
						Double.parseDouble(priceInput.getText()),
						Integer.parseInt(inventoryInput.getText()), 
						Integer.parseInt(minInput.getText()),
						Integer.parseInt(maxInput.getText()),
						Integer.parseInt(machineIDInput.getText())));
			}
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
		Parent tableViewParent = FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene tableViewScene = new Scene(tableViewParent);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
	}
	public void initData(Part part) {
		previousPart = part;
		idInput.setText(Integer.toString(part.getPartID()));
		nameInput.setText(part.getName());
		inventoryInput.setText(Integer.toString(part.getInStock()));
		priceInput.setText(Double.toString(part.getPrice()));
		maxInput.setText(Integer.toString(part.getMax()));
		minInput.setText(Integer.toString(part.getMin()));
		if(part instanceof Inhouse) {
			inhouseRadioButton.setSelected(true);
			machineIDLabel.setText("Machine ID");
			machineIDInput.setText(Integer.toString(((Inhouse) part).getMachineID()));
		}
		if(part instanceof Outsourced){
			outsourcedRadioButton.setSelected(true);
			machineIDLabel.setText("Company Name");
			machineIDInput.setText(((Outsourced) part).getCompanyName());
		}
	}
}