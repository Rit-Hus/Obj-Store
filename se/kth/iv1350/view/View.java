package se.kth.iv1350.view;

import java.util.Scanner;

public class View {

    public void storeTerminal() {
        Scanner scanner = new Scanner(System.in);
        
        // Store inventory (parallel arrays)
        String[] items = {"Apple", "Banana", "Milk", "Bread"};
        double[] prices = {0.99, 0.59, 2.49, 1.99};
      
        double total = 0.0;
       
        System.out.println("=== Welcome to the Store Terminal ===");
        System.out.println("Available items:");

        for (int i = 0; i < items.length; i++) {
            System.out.printf("%d. %s - $%.2f\n", i + 1, items[i], prices[i]);
        }
        
        while (true) {
            System.out.print("Enter the item number to purchase (or 100 to checkout): ");
            int choice = scanner.nextInt();

            if (choice == 100) {
                break;
            }

            if (choice < 0 || choice > items.length) {
                System.out.println("Invalid item number. Try again.");
            } 
            
            else {
                int index = choice - 1;
                total += prices[index];
                System.out.printf("Added %s. Current total: ", items[index], total);
            }
                
        }

        System.out.printf("Thank you! Your total is: ", total);
    }
}