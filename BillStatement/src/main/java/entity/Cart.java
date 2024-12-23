package entity;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Item> items;
	
	public Cart() {
		this.items = new ArrayList<>();
	}
	
	public void addItem(Item item){
		items.add(item);
	}
	
	public double calculateTotalPrice(){
		return items.stream().mapToDouble(Item::calculatePrice).sum();
	}
	
	public double calculateTotalDiscountPrice() {
		return items.stream().mapToDouble(Item::calculateDiscountPrice).sum();
	}
	
	public List<Item> getItems(){
		return items;
	}
}
