package main.se.kth.iv1350.integration;

import java.time.format.DateTimeFormatter;

/**
 * Prints ItemDTO details and ReceiptDTO to System.out.
 */
public class Printer {

    /**
     * Default constructor for Printer.
     */
    public Printer() { }
    
    /**
     * Prints the details of an ItemDTO to System.out.
     *
     * @param item The ItemDTO to print.
     */

    public void printItemDetails(ItemDTO item) {
        System.out.println("Item ID: "         + item.getIdentifier());
        System.out.println("Item name: "       + item.getName());
        System.out.println("Item cost: "       + formatPrice(item.getPrice()) + " SEK");
        System.out.println("VAT: "             + item.getVat() + "%");
        System.out.println("Item description: " + item.getDescription());
        System.out.println();
    }
/**
     * Prints the receipt to System.out.
     *
     * @param receipt The receipt to print.
     */
    public void print(ReceiptDTO receipt) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n--- Begin receipt ---\n")
          .append("Time of Sale: ").append(receipt.getSaleDate())
          .append(" ").append(java.time.LocalTime.now()
            .format(DateTimeFormatter.ofPattern("HH:mm")))
          .append("\n\n");
        for (ItemDTO item : receipt.getItems()) {
            double lineTotal = item.getQuantity() * item.getPrice();
            sb.append(String.format(
              "%-20s %d x %s\t%s SEK\n",
              item.getName(),
              item.getQuantity(),
              formatPrice(item.getPrice()),
              formatPrice(lineTotal)
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

    /**
     * Formats a price to two decimal places and replaces the decimal point with a
     * comma.
     *
     * @param price The price to format.
     * @return The formatted price as a string.
     */
    public String formatPrice(double price) {
        return String.format("%.2f", price).replace('.', ',');
    }
}
