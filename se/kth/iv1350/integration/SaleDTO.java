package se.kth.iv1350.integration;

import java.time.LocalDate;
import java.util.ArrayList;
import se.kth.iv1350.model.Item;

/**
 * Represents the details of a sale, including VAT, items, total amount, etc.
 */
public class SaleDTO {

    private int VAT;  // Total VAT for the sale
    private ArrayList<Item> items;
    private LocalDate saleDate;
    private int totalAmount;
    private int amountPaid;

    /**
     * Constructor for SaleDTO.
     * 
     * @param VAT The total VAT for the sale.
     * @param items The list of items in the sale.
     * @param saleDate The date of the sale.
     * @param amountPaid The amount paid by the customer.
     * @param totalAmount The total price of the sale.
     */
    public SaleDTO(int VAT, ArrayList<Item> items, LocalDate saleDate, int amountPaid, int totalAmount) {
        this.VAT = VAT;
        this.items = items;
        this.saleDate = saleDate;
        this.amountPaid = amountPaid;
        this.totalAmount = totalAmount;
    }

    public int getVAT() {
        return VAT;  // Return the total VAT for the sale
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public int getAmountPaid() {
        return amountPaid;
    }
}
