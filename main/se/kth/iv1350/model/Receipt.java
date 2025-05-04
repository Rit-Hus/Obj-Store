package main.se.kth.iv1350.model;

import java.time.LocalDate;
import java.util.ArrayList;
import main.se.kth.iv1350.integration.SaleDTO;


/**
 * The Receipt class represents a receipt for a sale. It contains information about
 * the total price, total VAT, change, sale date, items in the sale, and amount
 * paid by the customer.
 */
public class Receipt {
    private double totalVAT;
    private double totalPrice;
    private double totalChange;
    private LocalDate saleDate;
    private ArrayList<Item> items;
    private double amountPaid;

/**
     * Creates a new instance of Receipt with the specified parameters.
     *
     * @param saleDTO The SaleDTO object containing information about the sale.
     * @param change  The change to be returned to the customer.
     */

    public Receipt(SaleDTO saleDTO, double change) {
        this.saleDate = saleDTO.getSaleDate();
        this.totalPrice = saleDTO.getTotalAmount();
        this.totalVAT = saleDTO.getVAT();
        this.totalChange = change;
        this.items = saleDTO.getItems();
        this.amountPaid = saleDTO.getAmountPaid();
    }

/**
     * Returns the total price of the sale.
     *
     * @return The total price of the sale.
     */

    public double getTotalPrice() {
        return totalPrice;
    }


    /**
     * Returns the total VAT of the sale.
     *
     * @return The total VAT of the sale.
     */
    public double getTotalVat() {
        return totalVAT;
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
     * Returns the change to be returned to the customer.
     *
     * @return The change to be returned to the customer.
     */
    public double getChange() {
        return totalChange;
    }


    /**
     * Returns the items in the sale.
     *
     * @return The items in the sale.
     */
    public ArrayList<Item> getItems() {
        return items;
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