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

    public ReceiptDTO(SaleDTO saleDTO, double change) {
        this.saleDate    = saleDTO.getSaleDate();
        this.totalPrice  = saleDTO.getTotalAmount();
        this.totalVAT    = saleDTO.getVAT();
        this.totalChange = change;
        this.items       = saleDTO.getItems();
        this.amountPaid  = saleDTO.getAmountPaid();
    }

    public double            getTotalPrice() { return totalPrice; }
    public double            getTotalVat()   { return totalVAT; }
    public double            getChange()     { return totalChange; }
    public LocalDate         getSaleDate()   { return saleDate; }
    public ArrayList<ItemDTO> getItems()     { return items; }
    public double            getAmountPaid() { return amountPaid; }
}
