package ecommerce;

import java.util.ArrayList;

class ShippingService {
    public static void ship(ArrayList<Shippable> items) {
        System.out.println("\n** Shipment notice **");
        double totalWeight = 0;
        for (Shippable item : items) {
            System.out.printf("- %s: %.2fkg\n", item.getName(), item.getWeight());
            totalWeight += item.getWeight();
        }
        System.out.printf("Total package weight: %.2fkg\n\n", totalWeight);
    }
}
