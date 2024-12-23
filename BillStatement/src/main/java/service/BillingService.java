package service;

import entity.Cart;
import entity.Customer;

public interface BillingService {
	public void generateInvoice(Customer customer, Cart cart);
}
