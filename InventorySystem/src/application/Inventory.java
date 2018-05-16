package application;

import java.util.ArrayList;

public class Inventory {
	
	private ArrayList<Product> Products;
	private ArrayList<Part> allParts;
	
	public Inventory() {
		this.Products = new ArrayList<Product>();
		this.allParts = new ArrayList<Part>();
	}
	
	
	public void addProduct(Product product) {
		this.Products.add(product);
	}
	public boolean removeProduct(int remove) {
		return true;
	}
	public Product lookupProduct(int productID) {
		return new Product(productID, null, productID, productID, productID, productID);
	}
	public void updateProduct(int productID, Product product) {
		
	}
	public void addPart(Part part) {
		this.allParts.add(part);
	}
	public boolean deletePart(Part part) {
		return true;
	}
	public Part lookupPart(int partID) {
		
		return new Inhouse(partID, null, partID, partID, partID, partID, partID);
	}
	public void updatePart(int partID, Part part) {
		
	}
}
