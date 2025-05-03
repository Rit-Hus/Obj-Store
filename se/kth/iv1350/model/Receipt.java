package se.kth.iv1350.model;

import java.time.LocalDate;
import se.kth.iv1350.integration.SaleDTO;

public class Receipt {
    private int totalVAT;
    private int totalPrice;
    private double totalChange;
    private LocalDate saleDate;
    private int amountPaid;


    public Receipt(SaleDTO saleDTO, Payment payment){
        this.saleDate = saleDTO.getSaleDate();
        this.totalPrice = saleDTO.getTotalPrice();
        this.totalVAT = saleDTO.getTotalVat();
        this.amountPaid = saleDTO.getAmountPaid();
        this.totalChange = payment.getChange(amountPaid, saleDTO);
    }



    public int getTotalPrice(){
        return totalPrice;
    }


    public int getTotalVat(){
        return totalVAT;
    }


    public LocalDate getSaleDate(){
        return saleDate;
    }

    public double getChange(){
        return totalChange;
    }



}
