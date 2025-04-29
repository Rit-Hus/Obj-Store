<<<<<<<< HEAD:S3-FörstaSeminaruim/se/kth/iv1350/integration/Printer.java
package integration;

import model.Receipt;
========
package se.kth.iv1350.codestore.integration;

import se.kt.iv1350.codestore.model.Receipt;
>>>>>>>> acc30cce604e97b45184ffb58eb6f52d40cb0a6c:S3-FörstaSeminaruim/Main/se.kth.iv1350.codestore.integration/Printer.java

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
