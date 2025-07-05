package ecommerce;

public class Product {
    protected String name;
    protected double price;
    protected int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        if (price < 0) {
            System.out.print("ERROR");
        }
        this.price = price;
    }
    

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
    	 if (this.quantity > quantity) {
             System.out.print("NOT ENOUGH QUANTITY IN STOCK");
    	 }
        this.quantity = quantity;
    }
    
    public void updateQuantity(int amount) {
        if (amount > quantity) {
            throw new IllegalArgumentException("Not enough quantity in stock for product: " + name);
        }
        this.quantity -= amount;
    }

	public boolean isExpired() {
		return false;
	}

	
}
