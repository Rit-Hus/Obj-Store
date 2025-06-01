package main.se.kth.iv1350.integration;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * DTO capturing a completed sale:
 * total VAT, line-items as ItemDTOs, date, paid and total amounts.
 */
public class SaleDTO {
    private final double VAT;
    private final ArrayList<ItemDTO> items;
    private final LocalDate saleDate;
    private final double amountPaid;
    private final double totalAmount;

    /**
     * Creates a SaleDTO with the specified parameters.
     *
     * @param VAT         The total VAT for the sale.
     * @param items       The list of items sold, represented as ItemDTOs.
     * @param saleDate    The date when the sale was made.
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
     * Gets the total VAT for the sale.
     *
     * @return The total VAT.
     */
    public double            getVAT()         { return VAT; }
    
    /**
     * Gets the list of items sold in the sale.
     *
     * @return The list of ItemDTOs representing the items sold.
     */
    public ArrayList<ItemDTO> getItems()      { return items; }
    
    /**
     * Gets the date when the sale was made.
     *
     * @return The date of the sale.
     */ 
    public LocalDate         getSaleDate()    { return saleDate; }
    

    /**
     * Gets the amount paid by the customer.
     *
     * @return The amount paid.
     */

    public double            getAmountPaid()  { return amountPaid; }
    
    /**
     * Gets the total amount of the sale.
     *
     * @return The total amount.
     */
    public double            getTotalAmount() { return totalAmount; }
}
