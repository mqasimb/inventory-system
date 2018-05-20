package application.Model;

public abstract class Part {
	private int partID;
	private String name;
	private double price;
	private int inStock;
	private int min;
	private int max;
	
	public Part(int partID, String name, double price, int inStock, int min, int max) {
		this.partID = partID;
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
	public void setInStock(int inStock) {
		this.inStock = inStock;
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
	public void setPartID(int partID) {
		this.partID = partID;
	}
	public int getPartID() {
		return this.partID;
	}

	@Override
	public String toString() {
		return "Part [partID=" + partID + ", name=" + name + ", price=" + price + ", inStock=" + inStock + ", min="
				+ min + ", max=" + max + ", getName()=" + getName() + ", getPrice()=" + getPrice() + ", getInStock()="
				+ getInStock() + ", getMin()=" + getMin() + ", getMax()=" + getMax() + ", getPartID()=" + getPartID()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
