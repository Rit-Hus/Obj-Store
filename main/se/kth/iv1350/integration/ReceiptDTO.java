package main.se.kth.iv1350.integration;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * DTO for printing a receipt: wraps a SaleDTO plus the computed change.
 */
public class ReceiptDTO {
    private final double totalVAT;
    private final double totalPrice;
    private final double totalChange;
    private final LocalDate saleDate;
    private final ArrayList<ItemDTO> items;
    private final double amountPaid;

/**
 * Creates a new instance of ReceiptDTO.
 *  @param saleDTO the SaleDTO containing the sale information.
 * @param change the amount of change to be returned to the customer.
 * */

    public ReceiptDTO(SaleDTO saleDTO, double change) {
        this.saleDate    = saleDTO.getSaleDate();
        this.totalPrice  = saleDTO.getTotalAmount();
        this.totalVAT    = saleDTO.getVAT();
        this.totalChange = change;
        this.items       = saleDTO.getItems();
        this.amountPaid  = saleDTO.getAmountPaid();
    }

    /**
     * Gets the total price of the sale.
     * @return the total price.
     */ 
    public double            getTotalPrice() { return totalPrice; }
    /**
     * Gets the total VAT of the sale.
     * @return the total VAT.
     */
    public double            getTotalAmount() { return totalPrice; }
    /**
     * Gets the total VAT of the sale.
     * @return the total VAT.
     */ 
    public double            getTotalVat()   { return totalVAT; }
    /**
     * Gets the change to be returned to the customer.
     * @return the change amount.
     */ 
    public double            getChange()     { return totalChange; }
    
    /**
     * Gets the date of the sale.
     * @return the date of the sale.
     */ 
    public LocalDate         getSaleDate()   { return saleDate; }
   
    /**
     * Gets the list of items in the sale.
     * @return the list of items.
     */ 
    public ArrayList<ItemDTO> getItems()     { return items; }
    
    /**
     * Gets the amount paid by the customer.
     * @return the amount paid.
     */ 
    public double            getAmountPaid() { return amountPaid; }
}
