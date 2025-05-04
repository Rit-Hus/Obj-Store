package main.se.kth.iv1350.integration;

import java.time.LocalDate;
import java.util.ArrayList;
import main.se.kth.iv1350.model.Item;
/**
 * The SaleDTO class is a Data Transfer Object that contains the details of a sale.
 * It includes information about the items sold, the sale date, total amount, VAT,
 * and amount paid.
 */
public class SaleDTO {
    private double VAT;
    private ArrayList<Item> items;
    private LocalDate saleDate;
    private double totalAmount;
    private double amountPaid;

  
   /**
     * Creates a new instance of SaleDTO with the specified parameters.
     *
     * @param VAT        The VAT amount for the sale.
     * @param items      The list of items sold in the sale.
     * @param saleDate   The date of the sale.
     * @param amountPaid The amount paid by the customer.
     * @param totalAmount The total amount for the sale.
     */
    public SaleDTO(double VAT, ArrayList<Item> items, LocalDate saleDate, double amountPaid, double totalAmount) {
        this.VAT = VAT;
        this.items = items;
        this.saleDate = saleDate;
        this.amountPaid = amountPaid;
        this.totalAmount = totalAmount;
    }

    /**
     * Returns the total amount for the sale.
     *
     * @return The total amount for the sale.
     */
    public double getVAT() {
        return VAT;
    }


    /**
     * Returns the list of items sold in the sale.
     *
     * @return The list of items sold in the sale.
     */
    public ArrayList<Item> getItems() {
        return items;
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
     * Returns the total amount for the sale.
     *
     * @return The total amount for the sale.
     */
    public double getTotalAmount() {
        return totalAmount;
    }


    /**
     * Returns the amount paid by the customer.
     *
     * @return The amount paid by the customer.
     */
    public double getAmountPaid() {
        return amountPaid;
    }
}