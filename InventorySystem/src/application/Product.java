package application;

import javafx.collections.ObservableList;

public class Product {
	
	private ObservableList<Part> associatedParts;
	private int productID;
	private String name;
	private double price;
	private int inStock;
	private int min;
	private int max;
	
	public Product(ObservableList<Part> associatedParts, int productID, String name, double price, int inStock, int min, int max) {
		this.associatedParts = associatedParts;
		this.productID = productID;
		this.name = name;
		this.price = price;
		this.inStock = inStock;
		this.min = min;
		this.max = max;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
	public void setInStock(int stock) {
		this.inStock = stock;
	}
	public int getInStock() {
		return this.inStock;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMin() {
		return this.min;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getMax() {
		return this.max;
	}
	public void addAssociatedPart(Part part) {
		this.associatedParts.add(part);
	}
	public boolean removeAssociatedPart(int index) {
		return this.associatedParts.remove(index) != null;
	}
	public void removeAssociatedPart(Part part) {
		this.associatedParts.remove(part);
	}
	public ObservableList<Part> getParts() {
		return this.associatedParts;
	}
	public Part lookupAssociatedPart(int index) {
		return this.associatedParts.get(index);
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getProductID() {
		return this.productID;
	}

}
