package se.kth.iv1350.view;

import java.util.ArrayList;
import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.model.Item;
import se.kth.iv1350.model.Payment;
import se.kth.iv1350.model.Receipt;

public class View {
    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void run() {
        controller.startSale();  // Start a new sale

        // Create and scan some sample items
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(25, 2, 1, "1", "banana", "A banana"));
        items.add(new Item(35, 2, 1, "2", "apple", "An apple"));

        controller.scanItems(items);  // Scan the items via the controller

        Payment payment = new Payment();
        payment.startPayment(100);  // Simulate customer paying 100

        Receipt receipt = controller.endSale(100);  // End the sale and get the receipt

        // Print the receipt with the correct total price
        System.out.println("Receipt generated:");
        System.out.println("Total Price: " + receipt.getTotalPrice());  // Should show correct total now
        System.out.println("VAT: " + receipt.getTotalVat());
        System.out.println("Total Change: " + receipt.getChange());
        System.out.println("Sale Date: " + receipt.getSaleDate());
    }
}
