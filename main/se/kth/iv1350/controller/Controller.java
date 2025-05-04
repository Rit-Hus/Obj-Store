package main.se.kth.iv1350.controller;

import java.util.ArrayList;
import main.se.kth.iv1350.integration.Printer;
import main.se.kth.iv1350.integration.SaleDTO;
import main.se.kth.iv1350.model.Item;
import main.se.kth.iv1350.model.Payment;
import main.se.kth.iv1350.model.Receipt;
import main.se.kth.iv1350.model.Sale;

    

/**
 * The Controller class is responsible for managing the sale process, including
 * starting a new sale, scanning items, and ending the sale. It interacts with
 * the model and the printer to handle the sale and print receipts.
 */
public class Controller {
    private Sale sale;
    private Printer printer;

    /**
     * Creates a new instance of the Controller class.
     *
     * @param printer The printer used for printing receipts.
     */
    public Controller(Printer printer) {
        this.printer = printer;
        this.sale = new Sale();
    }


    /**
     * Starts a new sale by creating a new Sale object and initializing it with the
     * current date and time.
     */
    public void startSale() {
        this.sale = new Sale();
        System.out.println("Sale started at: " + sale.getSaleDate());
    }

    /**
     * Scans the items for the current sale. This method updates the sale with the
     * scanned items.
     *
     * @param items The list of items to be scanned.
     */
    public void scanItems(ArrayList<Item> items) {
        sale.scanItems(items);
    }

    /**
     * Ends the current sale by creating a SaleDTO object and a Payment object. It
     * calculates the change and creates a Receipt object.
     *
     * @param amountPaid The amount paid by the customer.
     * @return A Receipt object containing the details of the sale and change.
     */
    public Receipt endSale(double amountPaid) {
        SaleDTO saleDTO = sale.createSaleDTO(amountPaid);
        Payment payment = new Payment();
        double change = payment.getChange(amountPaid, saleDTO);
        return new Receipt(saleDTO, change);
    }
}