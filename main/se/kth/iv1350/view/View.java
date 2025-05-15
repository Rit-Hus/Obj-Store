package main.se.kth.iv1350.view;

import main.se.kth.iv1350.controller.Controller;
import main.se.kth.iv1350.integration.InventoryAccessException;
import main.se.kth.iv1350.integration.ItemDTO;
import main.se.kth.iv1350.integration.ItemNotFoundException;
import main.se.kth.iv1350.integration.Printer;
import main.se.kth.iv1350.util.FileLogger;

/**
 * Drives a hardcoded sale scenario with exception handling.
 */
public class View {
    private final Controller controller;
    private final Printer printer;

    public View(Controller controller, Printer printer) {
        this.controller = controller;
        this.printer = printer;
    }

    public void run() {
        controller.startSale();

        // 1) First scan: valid item
        try {
            ItemDTO dto1 = controller.addItemToSale("abc123", 1);
            printItemDetails(dto1);
        } catch (ItemNotFoundException e) {
            System.out.println("Sorry, that item ID does not exist.\n");
            // error details go to errors.log
            FileLogger.log(e);
        } catch (InventoryAccessException e) {
            System.out.println("A system error occurred. Please try again later.\n");
            FileLogger.log(e);
        }

        // 2) Second scan: same valid item
        try {
            ItemDTO dto2 = controller.addItemToSale("abc123", 1);
            printItemDetails(dto2);
        } catch (ItemNotFoundException e) {
            System.out.println("Sorry, that item ID does not exist.\n");
            FileLogger.log(e);
        } catch (InventoryAccessException e) {
            System.out.println("A system error occurred. Please try again later.\n");
            FileLogger.log(e);
        }

        // 3) Third scan: different valid item
        try {
            ItemDTO dto3 = controller.addItemToSale("def456", 1);
            printItemDetails(dto3);
        } catch (ItemNotFoundException e) {
            System.out.println("Sorry, that item ID does not exist.\n");
            FileLogger.log(e);
        } catch (InventoryAccessException e) {
            System.out.println("A system error occurred. Please try again later.\n");
            FileLogger.log(e);
        }

        // 4) Fourth scan: non-existent ID → ItemNotFoundException
        try {
            controller.addItemToSale("noSuchID", 1);
        } catch (ItemNotFoundException e) {
            System.out.println("Sorry, that item ID does not exist.\n");
            FileLogger.log(e);
        } catch (InventoryAccessException e) {
            System.out.println("A system error occurred. Please try again later.\n");
            FileLogger.log(e);
        }

        // 5) Fifth scan: simulated DB error → InventoryAccessException
        try {
            controller.addItemToSale("dbError", 1);
        } catch (ItemNotFoundException e) {
            System.out.println("Sorry, that item ID does not exist.\n");
            FileLogger.log(e);
        } catch (InventoryAccessException e) {
            System.out.println("A system error occurred. Please try again later.\n");
            FileLogger.log(e);
        }

        // Finish sale (only the successful scans—two abc123 and one def456—will be on the receipt)
        controller.endSale(100.00);
    }

    public void printItemDetails(ItemDTO item) {
        System.out.println("Item ID: "         + item.getIdentifier());
        System.out.println("Item name: "       + item.getName());
        System.out.println("Item cost: "       + printer.formatPrice(item.getPrice()) + " SEK");
        System.out.println("VAT: "             + item.getVat() + "%");
        System.out.println("Item description: " + item.getDescription());
        System.out.println();
    }
}
