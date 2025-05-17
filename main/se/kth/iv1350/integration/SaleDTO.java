package main.se.kth.iv1350.integration;

import java.time.LocalDate;
import java.util.ArrayList;


public class SaleDTO {
    private final double VAT;
    private final ArrayList<ItemDTO> items;
    private final LocalDate saleDate;
    private final double amountPaid;
    private final double totalAmount;

    public SaleDTO(double VAT, ArrayList<ItemDTO> items,
                   LocalDate saleDate, double amountPaid, double totalAmount) {
        this.VAT         = VAT;
        this.items       = items;
        this.saleDate    = saleDate;
        this.amountPaid  = amountPaid;
        this.totalAmount = totalAmount;
    }

    public double            getVAT()         { return VAT; }
    public ArrayList<ItemDTO> getItems()      { return items; }
    public LocalDate         getSaleDate()    { return saleDate; }
    public double            getAmountPaid()  { return amountPaid; }
    public double            getTotalAmount() { return totalAmount; }
}
