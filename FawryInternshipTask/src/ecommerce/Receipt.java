package ecommerce;

import java.util.ArrayList;

public class Receipt {
	public static void checkout(Customer customer, Cart cart) {
  
        double subtotal = 0;
        double shippingFee = 0;
        ArrayList<Shippable> shippableItems = new ArrayList<>();
        

        for (CartItem item : cart.getItems()) {
            Product p = item.getProduct();

            if (p.isExpired()) {
                throw new IllegalArgumentException("Product " + p.getName() + " is expired");
            }

            if (item.getQuantity() > p.getQuantity()) {
                throw new IllegalArgumentException("Product " + p.getName() + " is out of stock");
            }

            subtotal += item.getTotalPrice();

            if (p instanceof Shippable) {
                shippableItems.add((Shippable) p);
            }
        }

        if (!shippableItems.isEmpty()) {
            shippingFee = 30; // Flat shipping fee
        }

        double total = subtotal + shippingFee;

        if (customer.getBalance() < total) {
            throw new IllegalArgumentException("Customer's balance is insufficient");
        }

        for (CartItem item : cart.getItems()) {
            item.getProduct().updateQuantity(item.getQuantity());
        }
        customer.updateBalance(total);

        System.out.println("** Checkout receipt **");
        for (CartItem item : cart.getItems()) {
            System.out.printf("%dx %s\t%.2f\n", item.getQuantity(), item.getProduct().getName(), item.getTotalPrice());
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal:\t%.2f\n", subtotal);
        System.out.printf("Shipping:\t%.2f\n", shippingFee);
        System.out.printf("Amount Paid:\t%.2f\n", total);
        System.out.printf("Remaining Balance:\t%.2f\n", customer.getBalance());
    }
}
