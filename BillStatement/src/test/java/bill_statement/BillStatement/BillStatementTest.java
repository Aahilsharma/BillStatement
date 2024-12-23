package bill_statement.BillStatement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Cart;
import entity.Category;
import entity.Customer;
import entity.Item;

public class BillStatementTest {
	private Category fruits;
	private Category vegetables;
	private Category dairy;
	private Category cheese;

	private Item apple;
	private Item orange;
	private Item potato;
	private Item tomato;
	private Item cowMilk;
	private Item gouda;

	private Cart cart;
	private Customer customer;

	@BeforeEach
	void setup() {
		// Initialize categories
		fruits = new Category("Fruits", 18.0);
		vegetables = new Category("Vegetables", 5.0);
		dairy = new Category("Dairy", 15.0);
		cheese = new Category("Cheese", 20.0);

		// Initialize items
		apple = new Item("Apple", 50.0, 6, fruits); // 6 Kg @ 50/Kg
		orange = new Item("Orange", 80.0, 2, fruits); // 2 Kg @ 80/Kg
		potato = new Item("Potato", 30.0, 14, vegetables); // 14 Kg @ 30/Kg
		tomato = new Item("Tomato", 70.0, 3, vegetables); // 3 Kg @ 70/Kg
		cowMilk = new Item("Cow Milk", 50.0, 8, dairy); // 8 Lt @ 50/Lt
		gouda = new Item("Gouda", 80.0, 2, cheese); // 2 Kg @ 80/Kg

		// Initialize cart and customer
		cart = new Cart();
		customer = new Customer("Anish Kumar");
	}

	@Test
	void testAddItemsToCart() {
		cart.addItem(apple);
		cart.addItem(orange);

		List<Item> items = cart.getItems();

		assertEquals(2, items.size());
		assertTrue(items.contains(apple));
		assertTrue(items.contains(orange));
	}

	@Test
	void testCalculateTotalAmount() {
		cart.addItem(apple);
		cart.addItem(orange);

		double totalAmount = cart.calculateTotalPrice();
		assertEquals(580.0, totalAmount); // (6*50) + (2*80)
	}

	@Test
	void testCalculateTotalSavings() {
		cart.addItem(apple);
		cart.addItem(orange);

		double totalSavings = cart.calculateTotalPrice();
		assertEquals(104.4, totalSavings, 0.01); // 18% on both items
	}

//	    @Test
//	    void testInvoiceGeneration() {
//	        cart.addItem(apple);
//	        cart.addItem(orange);
//	        cart.addItem(potato);
//	        cart.addItem(tomato);
//	        cart.addItem(cowMilk);
//	        cart.addItem(gouda);
//
//	        assertNotNull(BillingServiceImpl.generateInvoice(customer, cart));
//
////	        assertNotNull(invoice);
//	        assertTrue(invoice.contains("Customer: Anish Kumar"));
//	        assertTrue(invoice.contains("Apple"));
//	        assertTrue(invoice.contains("Total Amount"));
//	        assertTrue(invoice.contains("You saved"));
//	    }

	@Test
	void testAutoSetMeasuringUnit() {
		assertEquals("Kg", apple.getMeasuringUnit());
		assertEquals("Kg", potato.getMeasuringUnit());
		assertEquals("Lt", cowMilk.getMeasuringUnit());
		assertEquals("Kg", gouda.getMeasuringUnit());
	}

	@Test
	void testDiscountedPriceCalculation() {
		double discountedPriceApple = apple.calculateDiscountPrice();
		double discountedPriceCowMilk = cowMilk.calculateDiscountPrice();

		assertEquals(246.0, discountedPriceApple, 0.01); // 6*50 - 18%
		assertEquals(340.0, discountedPriceCowMilk, 0.01); // 8*50 - 15%
	}
}
