package main.se.kth.iv1350.integration;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The ReceiptDTO class represents a Data Transfer Object (DTO) for a receipt in the
 * inventory system. It contains information about the total price, VAT, change,
 * sale date, items purchased, and amount paid.
 */
public class ReceiptDTO {
    private final double totalVAT;
    private final double totalPrice;
    private final double totalChange;
    private final LocalDate saleDate;
    private final ArrayList<ItemDTO> items;
    private final double amountPaid;


    /**
     * Constructs a ReceiptDTO object with the specified parameters.
     *
     * @param saleDTO The SaleDTO object containing sale information.
     * @param change  The change returned to the customer.
     */
    public ReceiptDTO(SaleDTO saleDTO, double change) {
        this.saleDate = saleDTO.getSaleDate();
        this.totalPrice = saleDTO.getTotalAmount();
        this.totalVAT = saleDTO.getVAT();
        this.totalChange = change;
        this.items = saleDTO.getItems();
        this.amountPaid = saleDTO.getAmountPaid();
    }

    /**
     * Gets the total price of the receipt.
     *
     * @return The total price of the receipt.
     */
    public double getTotalPrice() {
        return totalPrice;
    }


    /**
     * Gets the total VAT of the receipt.
     *
     * @return The total VAT of the receipt.
     */
    public double getTotalVat() {
        return totalVAT;
    }


    /**
     * Gets the change returned to the customer.
     *
     * @return The change returned to the customer.
     */
    public double getChange() {
        return totalChange;
    }


    /**
     * Gets the date of the sale.
     *
     * @return The date of the sale.
     */
    public LocalDate getSaleDate() {
        return saleDate;
    }


    /**
     * Gets the list of items purchased in the receipt.
     *
     * @return The list of items purchased in the receipt.
     */
    public ArrayList<ItemDTO> getItems() {
        return items;
    }
/**
     * Gets the amount paid by the customer.
     *
     * @return The amount paid by the customer.
     */
    public double getAmountPaid() {
        return amountPaid;
    }
}
