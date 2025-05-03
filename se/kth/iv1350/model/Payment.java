package se.kth.iv1350.model;

import se.kth.iv1350.integration.SaleDTO;

public class Payment {
    private double amountPaid;

    public void startPayment(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public double getChange(double amountPaid, SaleDTO saleDTO) {
        return amountPaid - saleDTO.getTotalAmount();
    }
}