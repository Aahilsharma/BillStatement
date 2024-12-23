package entity;

public class Category {
	private String name;
	private double discount;

	public Category(String name, double discount) {
		this.name = name;
		this.discount = discount;
	}

	public double getDiscount() {
		return discount;
	}
	
	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getName() {
		return name;
	}

}
