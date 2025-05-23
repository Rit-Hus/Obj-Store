package se.kth.iv1350.model;

import se.kth.iv1350.integration.SaleDTO;

public class Receipt {

    
    private String itemName;
    private int itemQuantity;
    private int itemPrice;
    private int vatForSale;
    private int dateAndTimeOfSale;

    private int totalPrice;
    private int amountPaid;
    private int totalChange;

    /**
     * Constructor that initializes the Recipt object with the provided paid amount
     * and sale information.
     * 
     * @param paidAmount The amount paid by the customer for the sale.
     * @param saleDTO    The SaleDTO object containing the sale details such as
     *                   product name, quantity, price, and total price.
     */

    public Receipt(SaleDTO saleDTO) {
       // this.amountPaid = paidAmount;

        this.itemName = saleDTO.getProductName();
        this.itemQuantity = saleDTO.getProductAmount();
        this.itemPrice = (int) saleDTO.getPricePerItem();
        this.vatForSale = 0;
        this.totalPrice = (int) saleDTO.getPriceTotal();
        this.totalChange = amountPaid - totalPrice;
        this.dateAndTimeOfSale = saleDTO.getSaleDate();

    }

    /**
     * Prints the details of the receipt to the console.
     * 
     * @param receipt The receipt object containing all the necessary sale details
     *                to be printed.
     */

    public void printReceipt(Receipt receipt) {

        System.out.println("Printing receipt...");
        System.out.println("Item Name: " + receipt.itemName);
        System.out.println("Product Amount: " + receipt.itemQuantity);
        System.out.println("Total Price: " + receipt.totalPrice);
        System.out.println("Total Paid: " + receipt.amountPaid);
        System.out.println("Change: " + receipt.totalChange);
        System.out.println("Date: " + receipt.dateAndTimeOfSale);

    }

}
