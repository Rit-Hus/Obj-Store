package main.se.kth.iv1350.integration;

import java.time.format.DateTimeFormatter;

import main.se.kth.iv1350.model.Item;
import main.se.kth.iv1350.model.Receipt;

public class Printer {
    public Printer() {
    }

    public void print(Receipt receipt) {
        StringBuilder receiptBuilder = new StringBuilder();
        
        // Header
        receiptBuilder.append("\n--- Begin receipt ---\n");
        receiptBuilder.append("Time of Sale: ").append(receipt.getSaleDate())
                     .append(" ").append(java.time.LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")))
                     .append("\n\n");
        
        // Items
        for (Item item : receipt.getItems()) {
            String itemName = item.getName();
            int quantity = item.getQuantity();
            double price = item.getPrice();
            double total = quantity * price;
            
            receiptBuilder.append(String.format("%-20s %d x %s\t%s SEK\n", 
                itemName, quantity, formatPrice(price), formatPrice(total)));
        }
        
        // Footer
        receiptBuilder.append("\n");
        receiptBuilder.append(String.format("Total:\t\t%s SEK\n", formatPrice(receipt.getTotalPrice())));
        receiptBuilder.append(String.format("VAT: %s\n", formatPrice(receipt.getTotalVat())));
        receiptBuilder.append("\n");
        receiptBuilder.append(String.format("Cash:\t\t%s SEK\n", formatPrice(receipt.getAmountPaid())));
        receiptBuilder.append(String.format("Change:\t\t%s SEK\n", formatPrice(receipt.getChange())));
        receiptBuilder.append("--- End receipt ---\n");
        
        System.out.println(receiptBuilder.toString());
    }

    private String formatPrice(double price) {
        return String.format("%.2f", price).replace('.', ',');
    }
}