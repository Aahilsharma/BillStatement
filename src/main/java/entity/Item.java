package entity;

import Constant.Constants;

public class Item {
	private String name;
	private double pricePerUnit;
	private double quantity;
	private String measuringUnit;
	private Category category;

	public Item(String name, double pricePerUnit, double quantity, Category category) {
		this.name = name;
		this.pricePerUnit = pricePerUnit;
		this.quantity = quantity;
		this.category = category;
		this.measuringUnit = inferMeasuringUnit(category.getName()); // Auto-assign unit
	}
	
    private String inferMeasuringUnit(String categoryName) {
        switch (categoryName.toLowerCase()) {
            case "fruits":
            case "vegetables":
            case "cheese":
                return Constants.UNIT_KG; // Weight-based categories
            case "dairy":
                return Constants.UNIT_LT; // Volume-based category
            default:
                return "Units"; // Default fallback for non-standard categories
        }
    }

	public double calculatePrice() {
		return pricePerUnit * quantity;
	}

	public double calculateDiscountPrice() {
		return calculatePrice() * (1 - category.getDiscount() / 100);
	}

	public String getName() {
		return name;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getMeasuringUnit() {
		return measuringUnit;
	}

	public void setMeasuringUnit(String measuringUnit) {
		this.measuringUnit = measuringUnit;
	}

	public Category getCategory() {
		return category;
	}
}
