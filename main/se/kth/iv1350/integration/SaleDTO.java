package main.se.kth.iv1350.integration;

import java.time.LocalDate;
import java.util.ArrayList;

import main.se.kth.iv1350.model.Item;

public class SaleDTO {
    private double VAT;
    private ArrayList<Item> items;
    private LocalDate saleDate;
    private double totalAmount;
    private double amountPaid;

    public SaleDTO(double VAT, ArrayList<Item> items, LocalDate saleDate, double amountPaid, double totalAmount) {
        this.VAT = VAT;
        this.items = items;
        this.saleDate = saleDate;
        this.amountPaid = amountPaid;
        this.totalAmount = totalAmount;
    }

    public double getVAT() {
        return VAT;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public double getAmountPaid() {
        return amountPaid;
    }
}