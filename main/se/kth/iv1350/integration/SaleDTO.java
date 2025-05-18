package main.se.kth.iv1350.integration;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The ReceiptDTO class represents a Data Transfer Object (DTO) for a receipt in the
 * inventory system. It contains information about the total VAT, total price, total
 * change, sale date, items purchased, and amount paid.
 */
public class SaleDTO {
    private final double VAT;
    private final ArrayList<ItemDTO> items;
    private final LocalDate saleDate;
    private final double amountPaid;
    private final double totalAmount;


    /**
     * Constructs a SaleDTO object with the specified parameters.
     *
     * @param VAT         The total VAT of the sale.
     * @param items       The list of items purchased in the sale.
     * @param saleDate    The date of the sale.
     * @param amountPaid  The amount paid by the customer.
     * @param totalAmount The total amount of the sale.
     */
    public SaleDTO(double VAT, ArrayList<ItemDTO> items,
                   LocalDate saleDate, double amountPaid, double totalAmount) {
        this.VAT         = VAT;
        this.items       = items;
        this.saleDate    = saleDate;
        this.amountPaid  = amountPaid;
        this.totalAmount = totalAmount;
    }


    /**
     * Gets the total VAT of the sale.
     *
     * @return The total VAT of the sale.
     */
    public double            getVAT()         { return VAT; }
    
    /**
     * Gets the list of items purchased in the sale.
     *
     * @return The list of items purchased in the sale.
     */

    public ArrayList<ItemDTO> getItems()      { return items; }
   
   
    /**
     * Gets the date of the sale.
     *
     * @return The date of the sale.
     */
   
   
    public LocalDate         getSaleDate()    { return saleDate; }
   
   
   
    /**
     * Gets the amount paid by the customer.
     *
     * @return The amount paid by the customer.
     */
    public double            getAmountPaid()  { return amountPaid; }
   
   
   
   /**
     * Gets the total amount of the sale.
     *
     * @return The total amount of the sale.
     */
    public double            getTotalAmount() { return totalAmount; }
}
