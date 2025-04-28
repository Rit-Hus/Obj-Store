package Ineregation;

import Model.Recipt;

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

    public Printer(int paidAmount, SlaeDTO saleDTO) {

        Recipt receipt = new Recipt(paidAmount, saleDTO);

        System.out.println("Created the receipt");

        System.out.println("Printer initialized.");

        receipt.printReceipt(receipt);

    }

}
