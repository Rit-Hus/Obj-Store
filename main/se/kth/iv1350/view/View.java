package main.se.kth.iv1350.view;

import main.se.kth.iv1350.controller.Controller;
import main.se.kth.iv1350.integration.InventoryAccessException;
import main.se.kth.iv1350.integration.ItemDTO;
import main.se.kth.iv1350.integration.ItemNotFoundException;
import main.se.kth.iv1350.integration.Printer;
import main.se.kth.iv1350.util.FileLogger;
import main.se.kth.iv1350.model.NoDiscountStrategy;
import main.se.kth.iv1350.model.BulkDiscountStrategy;
import java.util.Scanner;

/**
 * The View class represents the user interface of the application. It interacts
 * with the controller to perform operations and displays the results to the
 * user.
 */
public class View {
    private final Controller controller;
    private final Printer printer;

    public View(Controller controller, Printer printer) {
        this.controller = controller;
        this.printer = printer;
    }

    /**
     * Starts the application and simulates multiple sales by adding items to each sale,
     * prompting for a discount strategy before each, and printing their details.
     */
    public void run() {
        Scanner sc = new Scanner(System.in);

        // ------ Sale #1 ------
        System.out.println("Choose discount mode for Sale #1:");
        System.out.println("  1) No discount");
        System.out.println("  2) Bulk discount");
        System.out.print("> ");
        int choice1 = sc.nextInt();
        sc.nextLine();
        if (choice1 == 1) {
            controller.setDiscountStrategy(new NoDiscountStrategy());
        } else {
            controller.setDiscountStrategy(new BulkDiscountStrategy(1, 0.5));
        }

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

        controller.endSale(100.00);

        // ------ Sale #2 ------
        System.out.println("\nChoose discount mode for Sale #2:");
        System.out.println("  1) No discount");
        System.out.println("  2) Bulk discount");
        System.out.print("> ");
        int choice2 = sc.nextInt();
        sc.nextLine();
        if (choice2 == 1) {
            controller.setDiscountStrategy(new NoDiscountStrategy());
        } else {
            controller.setDiscountStrategy(new BulkDiscountStrategy(1, 0.5));
        }

        controller.startSale();
        try {
            controller.addItemToSale("noSuchID", 1);
        } catch (ItemNotFoundException e) {
            System.out.println("Sorry, that item ID does not exist.\n");
            FileLogger.log(e);
        } catch (InventoryAccessException e) {
            System.out.println("A system error occurred. Please try again later.\n");
            FileLogger.log(e);
        }

        controller.endSale(1000);

        // ------ Sale #3 ------
        System.out.println("\nChoose discount mode for Sale #3:");
        System.out.println("  1) No discount");
        System.out.println("  2) Bulk discount");
        System.out.print("> ");
        int choice3 = sc.nextInt();
        sc.nextLine();
        if (choice3 == 1) {
            controller.setDiscountStrategy(new NoDiscountStrategy());
        } else {
            controller.setDiscountStrategy(new BulkDiscountStrategy(1, 0.5));
        }

        controller.startSale();
        try {
            controller.addItemToSale("dbError", 1);
        } catch (ItemNotFoundException e) {
            System.out.println("Sorry, that item ID does not exist.\n");
            FileLogger.log(e);
        } catch (InventoryAccessException e) {
            System.out.println("A system error occurred. Please try again later.\n");
            FileLogger.log(e);
        }
        controller.endSale(1000);

        // ------ Sale #4 ------
        System.out.println("\nChoose discount mode for Sale #4:");
        System.out.println("  1) No discount");
        System.out.println("  2) Bulk discount");
        System.out.print("> ");
        int choice4 = sc.nextInt();
        sc.nextLine();
        if (choice4 == 1) {
            controller.setDiscountStrategy(new NoDiscountStrategy());
        } else {
            controller.setDiscountStrategy(new BulkDiscountStrategy(1, 0.5));
        }

        controller.startSale();
        try {
            ItemDTO dto4 = controller.addItemToSale("abc123", 1);
            printItemDetails(dto4);
        } catch (ItemNotFoundException e) {
            System.out.println("Sorry, that item ID does not exist.\n");
            FileLogger.log(e);
        } catch (InventoryAccessException e) {
            System.out.println("A system error occurred. Please try again later.\n");
            FileLogger.log(e);
        }

        try {
            ItemDTO dto5 = controller.addItemToSale("def456", 3);
            printItemDetails(dto5);
        } catch (ItemNotFoundException e) {
            System.out.println("Sorry, that item ID does not exist.\n");
            FileLogger.log(e);
        } catch (InventoryAccessException e) {
            System.out.println("A system error occurred. Please try again later.\n");
            FileLogger.log(e);
        }

        try {
            ItemDTO dto6 = controller.addItemToSale("def456", 1);
            printItemDetails(dto6);
        } catch (ItemNotFoundException e) {
            System.out.println("Sorry, that item ID does not exist.\n");
            FileLogger.log(e);
        } catch (InventoryAccessException e) {
            System.out.println("A system error occurred. Please try again later.\n");
            FileLogger.log(e);
        }

        controller.endSale(500.00);
    }

    /**
     * Prints the details of an item to the console.
     *
     * @param item The item to print.
     */
    public void printItemDetails(ItemDTO item) {
        System.out.println("Item ID: " + item.getIdentifier());
        System.out.println("Item name: " + item.getName());
        System.out.println("Item cost: " + printer.formatPrice(item.getPrice()) + " SEK");
        System.out.println("VAT: " + item.getVat() + "%");
        System.out.println("Item description: " + item.getDescription());
        System.out.println();
    }
}
