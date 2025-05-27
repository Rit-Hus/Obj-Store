package main.se.kth.iv1350.view;

import main.se.kth.iv1350.controller.Controller;
import main.se.kth.iv1350.integration.InventoryAccessException;
import main.se.kth.iv1350.integration.ItemDTO;
import main.se.kth.iv1350.integration.ItemNotFoundException;
import main.se.kth.iv1350.integration.Printer;
import main.se.kth.iv1350.util.FileLogger;

/**
 * The View class represents the user interface of the application. It interacts
 * with the controller to perform operations and displays the results to the user.
 */
public class View {
    private final Controller controller;
    private final Printer printer;

    public View(Controller controller, Printer printer) {
        this.controller = controller;
        this.printer = printer;
    }
/**
     * Starts the application and simulates a sale by adding items to the sale and
     * printing their details.
     */
    public void run() {


        System.out.println("Choose discount mode:");
        System.out.println("  1) No discount");
        System.out.println("  2) Bulk discount");



        controller.startSale();


        try {
            ItemDTO dto1 = controller.addItemToSale("abc123", 1);
            printItemDetails(dto1);
        } catch (ItemNotFoundException e) {
            System.out.println("Sorry, that item ID does not exist.\n");
            FileLogger.log(e);
        } catch (InventoryAccessException e) {
            System.out.println("A system error occurred. Please try again later.\n");
            FileLogger.log(e);
        }

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

        try {
            controller.addItemToSale("noSuchID", 1);
        } catch (ItemNotFoundException e) {
            System.out.println("Sorry, that item ID does not exist.\n");
            FileLogger.log(e);
        } catch (InventoryAccessException e) {
            System.out.println("A system error occurred. Please try again later.\n");
            FileLogger.log(e);
        }

        try {
            controller.addItemToSale("dbError", 1);
        } catch (ItemNotFoundException e) {
            System.out.println("Sorry, that item ID does not exist.\n");
            FileLogger.log(e);
        } catch (InventoryAccessException e) {
            System.out.println("A system error occurred. Please try again later.\n");
            FileLogger.log(e);
        }

        controller.endSale(100.00);
    }
/**
     * Prints the details of an item to the console.
     *
     * @param item The item to print.
     */
    public void printItemDetails(ItemDTO item) {
        System.out.println("Item ID: "         + item.getIdentifier());
        System.out.println("Item name: "       + item.getName());
        System.out.println("Item cost: "       + printer.formatPrice(item.getPrice()) + " SEK");
        System.out.println("VAT: "             + item.getVat() + "%");
        System.out.println("Item description: " + item.getDescription());
        System.out.println();
    }
}
