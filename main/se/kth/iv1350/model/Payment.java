package main.se.kth.iv1350.model;

import main.se.kth.iv1350.integration.SaleDTO;

/**
 * The Payment class handles the
  payment process in the system. It contains methods to start a payment and
 * calculate the change to be returned to the customer.
 */
public class Payment {
    private double amountPaid;


    /**
     * Creates a new instance of Payment.
     */
    public void startPayment(double amountPaid) {
        this.amountPaid = amountPaid;
    }


    /**
     * Returns the amount paid by the customer.
     *
     * @return The amount paid by the customer.
     */
    public double getChange(double amountPaid, SaleDTO saleDTO) {
        return amountPaid - saleDTO.getTotalAmount();
    }
}