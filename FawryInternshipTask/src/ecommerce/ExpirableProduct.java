package ecommerce;

public class ExpirableProduct extends Product {
	 private String expiryDate;

	    public ExpirableProduct(String name, double price, int quantity, String expiryDate) {
	        super(name, price, quantity);
	        this.expiryDate = expiryDate;
	    }

	    public String getExpiryDate() {
	        return expiryDate;
	    }


}
