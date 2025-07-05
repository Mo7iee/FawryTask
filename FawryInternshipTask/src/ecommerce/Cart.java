package ecommerce;

import java.util.ArrayList;

public class Cart {
    private ArrayList<CartItem> items = new ArrayList<>();

    public void addProduct(Product product,int quantity) {
        if (quantity>product.getQuantity()) {
            System.out.println("Cannot add more than available quantity for product: " + product.getName());
        }
        items.add(new CartItem(product, quantity));
    }

    public ArrayList<CartItem> getItems() {
        return items;
    }
} 

