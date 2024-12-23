package service;

import entity.Cart;
import entity.Customer;

public class BillingServiceImpl{
	public static void generateInvoice(Customer customer, Cart cart) {
		System.out.println("Customer: " + customer.getName());
		System.out.println("Item\tQty\tUnit\tAmount");
		cart.getItems().forEach(item -> {
			System.out.printf("%s\t%.2f\t%s\t%.2f\n", item.getName(), item.getQuantity(), item.getMeasuringUnit(),
					item.calculateDiscountPrice());
		});

		double totalAmount = cart.calculateTotalDiscountPrice();
		double savings = cart.calculateTotalPrice() - totalAmount;
		System.out.printf("Total Amount\t%.2f Rs\n", totalAmount);
		System.out.printf("You saved\t%.2f Rs\n", savings);
	}
}
