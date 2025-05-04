package main.se.kth.iv1350.view;

import java.util.ArrayList;
import main.se.kth.iv1350.controller.Controller;
import main.se.kth.iv1350.integration.Printer;
import main.se.kth.iv1350.model.Item;
import main.se.kth.iv1350.model.Receipt;

/**
 * The View class is responsible for displaying information to the user and
 * interacting with the Controller. It handles user input and output, including
 * printing receipts.
 */
public class View {
    private Controller controller;
    private Printer printer;

    public View(Controller controller) {
        this.controller = controller;
        this.printer = new Printer();
    }
/**
     * Starts the sale process by calling the appropriate methods in the Controller
     * class. It simulates a sale by adding items, calculating totals, and printing
     * the receipt.
     */
    public void run() {
        controller.startSale();
        System.out.println("Add 1 item with item id abc123:");

        ArrayList<Item> items = new ArrayList<>();
        Item oatmeal = new Item(29.90, 6.0, 1, "abc123", "BigWheel Oatmeal", 
                              "BigWheel Oatmeal 500g, whole grain oats, high fiber, gluten free");
        items.add(oatmeal);
        
        printItemDetails(oatmeal);
        System.out.println("\nTotal cost (incl VAT): " + formatPrice(oatmeal.getPrice()) + " SEK");
        System.out.println("Total VAT: " + formatPrice(oatmeal.getPrice() * oatmeal.getVat()/100) + " SEK\n");
        
        controller.scanItems(items);

        // Add same item again
        System.out.println("Add 1 item with item id abc123:");
        items.clear();
        items.add(oatmeal);
        printItemDetails(oatmeal);
        System.out.println("\nTotal cost (incl VAT): " + formatPrice(2*oatmeal.getPrice()) + " SEK");
        System.out.println("Total VAT: " + formatPrice(2*(oatmeal.getPrice() * oatmeal.getVat()/100)) + " SEK\n");
        
        controller.scanItems(items);

        // Add different item
        System.out.println("Add 1 item with item id def456:");
        Item yogurt = new Item(14.90, 6.0, 1, "def456", "YouGoGo Blueberry", 
                             "YouGoGo Blueberry 240g, low sugar yoghurt, blueberry flavour");
        items.clear();
        items.add(yogurt);
        
        printItemDetails(yogurt);
        double runningTotal = 2*oatmeal.getPrice() + yogurt.getPrice();
        double runningVAT = 2*(oatmeal.getPrice() * oatmeal.getVat()/100) + (yogurt.getPrice() * yogurt.getVat()/100);
        System.out.println("\nTotal cost (incl VAT): " + formatPrice(runningTotal) + " SEK");
        System.out.println("Total VAT: " + formatPrice(runningVAT) + " SEK\n");
        
        controller.scanItems(items);

        // End sale
        System.out.println("End sale:");
        Receipt receipt = controller.endSale(100);
        System.out.println("Total cost (incl VAT): " + formatPrice(receipt.getTotalPrice()) + " SEK\n");

        // Print receipt
        printer.print(receipt);
        
        // Final change message
        System.out.println("Change to give the customer: " + formatPrice(receipt.getChange()) + " SEK");
    }


    /**
     * Prints the details of an item, including its ID, name, cost, VAT, and
     * description.
     *
     * @param item The item to be printed.
     */
    private void printItemDetails(Item item) {
        System.out.println("Item ID: " + item.getItemID());
        System.out.println("Item name: " + item.getName());
        System.out.println("Item cost: " + formatPrice(item.getPrice()) + " SEK");
        System.out.println("VAT: " + item.getVat() + "%");
        System.out.println("Item description: " + item.getDescription());
    }

    private String formatPrice(double price) {
        return String.format("%.2f", price).replace('.', ',');
    }
}