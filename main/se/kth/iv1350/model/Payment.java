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
     * Starts the payment process by setting the amount paid by the customer.
     *
     * @param amountPaid The amount paid by the customer.
     */
    public void startPayment(double amountPaid) {
        this.amountPaid = amountPaid;
    }


    /**
     * Calculates the change to be returned to the customer.
     *
     * @param amountPaid The amount paid by the customer.
     * @param saleDTO The SaleDTO object containing the sale information.
     * @return The change to be returned to the customer.
     */
    public double getChange(double amountPaid, SaleDTO saleDTO) {
        return amountPaid - saleDTO.getTotalAmount();
    }
}