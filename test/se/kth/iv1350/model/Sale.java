package test.se.kth.iv1350.model;

import java.time.LocalDate;
import java.util.ArrayList;

import test.se.kth.iv1350.integration.SaleDTO;

public class Sale {
    private LocalDate saleDate;
    private double totalAmount;
    private double totalVAT;
    private ArrayList<Item> items = new ArrayList<>();

    public Sale() {
        saleDate = LocalDate.now();
    }

    public void scanItems(ArrayList<Item> newItems) {
        for (Item item : newItems) {
            if (isScanned(item.getItemID())) {
                item.incrementQuantity();
            } else {
                this.items.add(item);
            }
        }
        updateTotal();
    }

    private boolean isScanned(String itemID) {
        for (Item item : items) {
            if (item.getItemID().equals(itemID)) {
                return true;
            }
        }
        return false;
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

    public double getTotalAmount() {
        return totalAmount;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}