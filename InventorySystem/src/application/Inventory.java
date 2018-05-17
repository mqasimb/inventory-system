package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventory {
	
	private ObservableList<Product> Products;
	private ObservableList<Part> allParts;
	
	public Inventory() {
		this.Products = FXCollections.observableArrayList();
		this.allParts = FXCollections.observableArrayList();
	}
	
	public void addProduct(Product product) {
		this.Products.add(product);
	}
	public boolean removeProduct(int index) {
		return Products.remove(index) != null;
	}
	public boolean removeProduct(Product product) {
		return Products.remove(product);
	}
	public Product lookupProduct(int index) {
		return Products.get(index);
	}
	public void updateProduct(int index, Product product) {
		Products.set(index, product);
	}
	public void addPart(Part part) {
		this.allParts.add(part);
	}
	public boolean deletePart(Part part) {
		return allParts.remove(part);
	}
	public Part lookupPart(int index) {
		return allParts.get(index);
	}
	public void updatePart(int index, Part part) {
		allParts.set(index, part);
	}
	public ObservableList<Part> getAllParts() {
		return this.allParts;
	}
	public ObservableList<Product> getAllProducts() {
		return this.Products;
	}
}
