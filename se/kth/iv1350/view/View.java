package se.kth.iv1350.view;

import java.util.Scanner;
import se.kth.iv1350.model.Item;

public class View {

    public void storeTerminal() {
        Scanner scanner = new Scanner(System.in);

        // Get the list of items
        Item[] list = Item.getItem();

        System.out.println("=== Welcome to the Store Terminal ===");
        System.out.println("Available items:");

        for (int i = 0; i < list.length; i++) {
            System.out.printf("%d. %s%n", i + 1, list[i]);
        }

        while (true) {
            System.out.print("Enter the item number to purchase (or 100 to checkout): ");
            int choice = scanner.nextInt();

            if (choice == 100) {
                break;
            }

            if (choice < 1 || choice > list.length) {
                System.out.println("Invalid item number. Try again.");
            } else {
                int index = choice - 1;
                System.out.printf("Added %s.%n", list[index]);
            
            }
        }

        System.out.println("Thank you! Your total is: 10");
    }
}
