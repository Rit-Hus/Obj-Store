package main.se.kth.iv1350.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import main.se.kth.iv1350.integration.SaleDTO;

public class Sale {
    private LocalDate saleDate;
    private double totalAmount;
    private double totalVAT;
    private ArrayList<Item> items = new ArrayList<>();

    private DiscountStrategy discountStrategy = new NoDiscountStrategy();
    private final List<RevenueObserver> observers = new ArrayList<>();

    public void setDiscountStrategy(DiscountStrategy ds) {
        discountStrategy = ds;
    }

    public void addObserver(RevenueObserver obs) {
        observers.add(obs);
    }

    public void removeObserver(RevenueObserver obs) {
        observers.remove(obs);
    }

    private void notifyObservers(double saleAmount) {
        for (RevenueObserver obs : observers) {
            obs.onNewSale(saleAmount);
        }
    }

    public Sale() {
        saleDate = LocalDate.now();
    }

    public void scanItems(ArrayList<Item> newItems) {
        for (Item item : newItems) {
            if (isScanned(item.getItemID())) {
                for (Item stored : items) {
                    if (stored.getItemID().equals(item.getItemID())) {
                        stored.incrementQuantity();
                        break;
                    }
                }
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

/**
 * Recalculates totalAmount and totalVAT across all scanned items,
 * applying the active DiscountStrategy to each line.
 */
private void updateTotal() {
    totalAmount = 0;
    totalVAT    = 0;

    for (Item item : items) {

        double lineTotal = discountStrategy.applyDiscount(
            item.getPrice(),
            item.getQuantity()
        );
        totalAmount += lineTotal;
        totalVAT    += lineTotal * (item.getVat() / 100);
    }
}


    public SaleDTO createSaleDTO(double amountPaid) {

        ArrayList<main.se.kth.iv1350.integration.ItemDTO> dtoItems = new ArrayList<>();
        for (Item item : items) {
            dtoItems.add(new main.se.kth.iv1350.integration.ItemDTO(
                    item.getPrice(),
                    (int) item.getVat(),
                    item.getQuantity(),
                    item.getItemID(),
                    item.getName(),
                    item.getDescription()));
        }

        SaleDTO dto = new SaleDTO(
                totalVAT,
                dtoItems,
                saleDate,
                amountPaid,
                totalAmount);

        notifyObservers(totalAmount);

        return dto;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

}
