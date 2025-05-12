package main.se.kth.iv1350.integration;

import java.time.format.DateTimeFormatter;
import main.se.kth.iv1350.model.Item;
import main.se.kth.iv1350.model.Receipt;

/**
 * Responsible for all console output:
 * - Printing item details
 * - Printing the final receipt
 */
public class Printer {
    public Printer() { }

    /**
     * Prints the details of a single item.
     */
    public void printItemDetails(Item item) {
        System.out.println("Item ID: " + item.getItemID());
        System.out.println("Item name: " + item.getName());
        System.out.println("Item cost: " + formatPrice(item.getPrice()) + " SEK");
        System.out.println("VAT: " + item.getVat() + "%");
        System.out.println("Item description: " + item.getDescription());
        System.out.println();
    }

    /**
     * Prints a formatted receipt.
     */
    public void print(Receipt receipt) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- Begin receipt ---\n");
        sb.append("Time of Sale: ")
          .append(receipt.getSaleDate())
          .append(" ")
          .append(java.time.LocalTime.now()
            .format(DateTimeFormatter.ofPattern("HH:mm")))
          .append("\n\n");

        for (Item item : receipt.getItems()) {
            double total = item.getQuantity() * item.getPrice();
            sb.append(String.format(
              "%-20s %d x %s\t%s SEK\n",
              item.getName(),
              item.getQuantity(),
              formatPrice(item.getPrice()),
              formatPrice(total)
            ));
        }

        sb.append("\n")
          .append(String.format("Total:\t\t%s SEK\n", formatPrice(receipt.getTotalPrice())))
          .append(String.format("VAT: %s\n", formatPrice(receipt.getTotalVat())))
          .append("\n")
          .append(String.format("Cash:\t\t%s SEK\n", formatPrice(receipt.getAmountPaid())))
          .append(String.format("Change:\t\t%s SEK\n", formatPrice(receipt.getChange())))
          .append("--- End receipt ---\n");

        System.out.println(sb.toString());
    }

    private String formatPrice(double price) {
        return String.format("%.2f", price).replace('.', ',');
    }
}
