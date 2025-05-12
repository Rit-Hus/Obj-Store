package main.se.kth.iv1350.model;

import java.time.LocalDate;
import java.util.ArrayList;
import main.se.kth.iv1350.integration.SaleDTO;

/**
 * Represents a sale: date, total, VAT, and list of items.
 */
public class Sale {
    private LocalDate saleDate;
    private double totalAmount;
    private double totalVAT;
    private ArrayList<Item> items = new ArrayList<>();

    public Sale() {
        saleDate = LocalDate.now();
    }

    /**
     * Scans new items: increments quantity on existing ones,
     * or adds new items, then updates totals.
     */
    public void scanItems(ArrayList<Item> newItems) {
        for (Item scanned : newItems) {
            boolean found = false;
            for (Item existing : items) {
                if (existing.getItemID().equals(scanned.getItemID())) {
                    existing.incrementQuantity();
                    found = true;
                    break;
                }
            }
            if (!found) {
                items.add(scanned);
            }
        }
        updateTotal();
    }

    private void updateTotal() {
        totalAmount = 0;
        totalVAT = 0;
        for (Item item : items) {
            double itemTotal = item.getQuantity() * item.getPrice();
            totalAmount += itemTotal;
            totalVAT += itemTotal * (item.getVat() / 100);
        }
    }

    public SaleDTO createSaleDTO(double amountPaid) {
        return new SaleDTO(totalVAT, items, saleDate, amountPaid, totalAmount);
    }
}
