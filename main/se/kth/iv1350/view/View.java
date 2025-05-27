package main.se.kth.iv1350.view;

import main.se.kth.iv1350.controller.Controller;
import main.se.kth.iv1350.integration.ItemDTO;
import main.se.kth.iv1350.integration.Printer;

/**
 * Drives a hardcoded sale scenario: only controller calls.
 */
public class View {
    private Controller controller;
    private Printer printer;

    public View(Controller controller, Printer printer) {
        this.controller = controller;
        this.printer = printer;
    }

    /** Simulate a sale with three controller calls only. */
    public void run() {
        controller.startSale();
        ItemDTO dto = controller.addItemToSale("abc123", 1);
        printItemDetails(dto);
        ItemDTO dto2 = controller.addItemToSale("abc123", 1);
        printItemDetails(dto2);
        ItemDTO dto3 = controller.addItemToSale("def456", 1);
        printItemDetails(dto3);
        controller.endSale(100.00);
    }

    
        private void printItemDetails(ItemDTO item) {
        System.out.println("Item ID: "         + item.getIdentifier());
        System.out.println("Item name: "       + item.getName());
        System.out.println("Item cost: "       + printer.formatPrice(item.getPrice()) + " SEK");
        System.out.println("VAT: "             + item.getVat() + "%");
        System.out.println("Item description: " + item.getDescription());
        System.out.println();
    }
}
