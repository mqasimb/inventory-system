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
	public boolean removeProduct(int index) {
		return Products.remove(index) != null;
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
}
