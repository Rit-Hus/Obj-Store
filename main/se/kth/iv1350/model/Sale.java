package main.se.kth.iv1350.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import main.se.kth.iv1350.integration.SaleDTO;


/**
 * The Sale class represents a sale in the inventory system. It contains information
 * about the items purchased, the total amount, and the date of the sale. The class
 * also implements the Observer pattern to notify observers about new sales.
 */
public class Sale {
    private LocalDate saleDate;
    private double totalAmount;
    private double totalVAT;
    private ArrayList<Item> items = new ArrayList<>();

    private DiscountStrategy discountStrategy = new NoDiscountStrategy();
    private final List<RevenueObserver> observers = new ArrayList<>();


    /**
     * Sets the discount strategy to be used for the sale.
     *
     * @param ds The discount strategy to be set.
     */
    public void setDiscountStrategy(DiscountStrategy ds) {
        discountStrategy = ds;
    }


    /**
     * Adds an observer to the list of observers.
     *
     * @param obs The observer to be added.
     */


    public void addObserver(RevenueObserver obs) {
        observers.add(obs);
    }
/**
 * 
     * Removes an observer from the list of observers.
     *
     * @param obs The observer to be removed.
     */

    public void removeObserver(RevenueObserver obs) {
        observers.remove(obs);
    }
/**
     * Notifies all observers about a new sale.
     *
     * @param saleAmount The amount of the new sale.
     */

    private void notifyObservers(double saleAmount) {
        for (RevenueObserver obs : observers) {
            obs.onNewSale(saleAmount);
        }
    }
   /**
     * Constructs a Sale object with the current date.
     */
    public Sale() {
        saleDate = LocalDate.now();
    }

    /**
     * Scans the items and adds them to the sale. If an item is already scanned, it
     * increments the quantity of that item.
     *
     * @param newItems The list of items to be scanned.
     */
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
    /**
     * Returns the total amount of the sale.
     *
     * @return The total amount of the sale.
     */

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

    /**
     * Returns the total VAT of the sale.
     *
     * @return The total VAT of the sale.
     */
    public LocalDate getSaleDate() {
        return saleDate;
    }

}
