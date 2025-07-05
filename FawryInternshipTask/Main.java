package ecommerce;

public class Main {
	public static void main(String[] args) {
        Product tv = new ShippableProduct("TV", 1500, 2, 10.0);
        Product scratchCard = new Product("Scratch Card", 50, 10) {};
        Customer customer = new Customer("Mohie", 3000);
        Cart cart = new Cart();
        cart.addProduct(tv, 1);
        cart.addProduct(scratchCard, 1);
        Receipt.checkout(customer, cart); 
}
	}
