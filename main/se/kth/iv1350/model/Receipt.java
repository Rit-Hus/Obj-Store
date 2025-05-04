package main.se.kth.iv1350.model;

import java.time.LocalDate;
import java.util.ArrayList;

import main.se.kth.iv1350.integration.SaleDTO;

public class Receipt {
    private double totalVAT;
    private double totalPrice;
    private double totalChange;
    private LocalDate saleDate;
    private ArrayList<Item> items;
    private double amountPaid;

    public Receipt(SaleDTO saleDTO, double change) {
        this.saleDate = saleDTO.getSaleDate();
        this.totalPrice = saleDTO.getTotalAmount();
        this.totalVAT = saleDTO.getVAT();
        this.totalChange = change;
        this.items = saleDTO.getItems();
        this.amountPaid = saleDTO.getAmountPaid();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getTotalVat() {
        return totalVAT;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public double getChange() {
        return totalChange;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public double getAmountPaid() {
        return amountPaid;
    }
}