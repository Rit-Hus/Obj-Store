package main.se.kth.iv1350.model;

import java.time.LocalDate;
import java.util.ArrayList;
import main.se.kth.iv1350.integration.SaleDTO;
/**
 * The Sale class represents a sale in the system. It contains information about
 * the sale date, total amount, total VAT, and the items in the sale.
 */
public class Sale {
    private LocalDate saleDate;
    private double totalAmount;
    private double totalVAT;
    private ArrayList<Item> items = new ArrayList<>();

/**
     * Creates a new instance of Sale with the current date.
     */

    public Sale() {
        saleDate = LocalDate.now();
    }

    


    
    /**
     * Scans the items in the sale. If an item has already been scanned, its
     * quantity is incremented.
     *
     * @param newItems The list of items to be scanned.
     */
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


    /**
     * Checks if an item with the specified ID has already been scanned.
     *
     * @param itemID The ID of the item to check.
     * @return True if the item has already been scanned, false otherwise.
     */
    private boolean isScanned(String itemID) {
        for (Item item : items) {
            if (item.getItemID().equals(itemID)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Updates the total amount and total VAT of the sale based on the items in the
     * sale.
     */
    private void updateTotal() {
        totalAmount = 0;
        totalVAT = 0;

        for (Item item : items) {
            double itemTotal = item.getQuantity() * item.getPrice();
            totalAmount += itemTotal;
            totalVAT += itemTotal * (item.getVat() / 100);
        }
    }
/**
     * Creates a SaleDTO object with the current sale information.
     *
     * @param amountPaid The amount paid by the customer.
     * @return A SaleDTO object containing the sale information.
     */
    public SaleDTO createSaleDTO(double amountPaid) {
        return new SaleDTO(totalVAT, items, saleDate, amountPaid, totalAmount);
    }


    /**
     * Returns the total amount of the sale.
     *
     * @return The total amount of the sale.
     */
    public double getTotalAmount() {
        return totalAmount;
    }



    /**
     * Returns the date of the sale.
     *
     * @return The date of the sale.
 */
    public LocalDate getSaleDate() {
        return saleDate;
    }


   
/**
 * Returns the list of items registered in the current sale.
 *
 * @return A list of all items that have been scanned during the sale.
 */

    public ArrayList<Item> getItems() {
        return items;
    }
}