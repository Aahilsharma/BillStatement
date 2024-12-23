package bill_statement.BillStatement;

import Constant.Constants;
import entity.Cart;
import entity.Category;
import entity.Customer;
import entity.Item;
import service.BillingService;
import service.BillingServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 // Initialize categories with dynamic discounts
        Category fruits = new Category("Fruits", 18.0);
        Category vegetables = new Category("Vegetables", 5.0);
        Category dairy = new Category("Dairy", 15.0);
        Category cheese = new Category("Cheese", 20.0);

        // Dynamically set item prices and quantities
        Item apple = new Item("Apple", 50.0, 6, fruits);
        Item orange = new Item("Orange", 80.0, 2, fruits);
        Item potato = new Item("Potato", 30.0, 14, vegetables);
        Item tomato = new Item("Tomato", 70.0, 3, vegetables);
        Item cowMilk = new Item("Cow Milk", 50.0, 8, dairy);
        Item gouda = new Item("Gouda", 80.0, 2, cheese);

        // Create cart and add items
        Cart cart = new Cart();
        cart.addItem(apple);
        cart.addItem(orange);
        cart.addItem(potato);
        cart.addItem(tomato);
        cart.addItem(cowMilk);
        cart.addItem(gouda);

        // Print invoice
        Customer customer = new Customer("Anish Kumar");
        BillingServiceImpl.generateInvoice(customer, cart);

        // Dynamically change discounts or prices if needed
        fruits.setDiscount(20.0); // Update discount
        apple.setPricePerUnit(55.0); // Update price

        System.out.println("\n--- Updated Invoice After Changes ---");
        BillingServiceImpl.generateInvoice(customer, cart);
    }
}
