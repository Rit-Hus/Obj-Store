package se.kth.iv1350.model;

import se.kth.iv1350.integration.SaleDTO;

public class Payment {
    private String paymentMethod;
    private double amountPaid;
    private double amountChange;

    /**
     * Performs the payment operation with the specified amount.
     *
     * @param amount The amount to be paid.
     */

    public void payment(double amount){
    }

    /**
     * Initializes the payment and calculates the amount of change.
     *
     * @param amountPaid The amount paid by the customer.
     */

    public void startPayment(double amountPaid){
     
    }


    //add the comments later


    public void cancelPayment(){
    }

     public double getAmountPaid() {
        return this.amountPaid;
    
     }


     public String getPaymentMethod() {
        return paymentMethod; //let's add if cash was used as a payment method the program will need to round that number but iif card was used that the total won't change
    }
     

    public double getChange(int totalPaid, SaleDTO saleDTO) {
        amountChange = saleDTO.getTotalPrice() - totalPaid;
        return amountChange;
    }



}
