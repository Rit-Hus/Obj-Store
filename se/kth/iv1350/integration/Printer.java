package se.kth.iv1350.integration;

import se.kth.iv1350.model.Receipt;


public class Printer {

    /**
     * Constructor for the Printer class. Initializes the printer, creates a receipt
     * from the given sale information,
     * and prints the receipt to the console.
     * 
     * @param paidAmount The amount paid by the customer for the sale.
     * @param saleDTO    The SaleDTO object containing the sale details such as
     *                   product name, quantity, price, and total price.
     */

    public Printer(int paidAmount, SaleDTO saleDTO) {

        Receipt receipt = new Receipt(paidAmount, saleDTO);

        System.out.println("Created the receipt");

        System.out.println("Printer initialized.");

        receipt.printReceipt(receipt);

    }

}
