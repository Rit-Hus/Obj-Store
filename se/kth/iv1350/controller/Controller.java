package se.kth.iv1350.controller;

import java.util.ArrayList;
import se.kth.iv1350.integration.Printer;
import se.kth.iv1350.integration.SaleDTO;
import se.kth.iv1350.model.Item;
import se.kth.iv1350.model.Payment;
import se.kth.iv1350.model.Receipt;
import se.kth.iv1350.model.Sale;

public class Controller {

    private Sale sale;
    private Printer printer;

    public Controller(Printer printer) {
        this.sale = new Sale();
        this.printer = printer;
    }

    public void startSale() {
        sale = new Sale();  // Start a new sale
        System.out.println("Sale started at: " + sale.getSaleDate());
    }

    public void scanItems(ArrayList<Item> items) {
        sale.scanItems(items);  // Call the Sale class method to scan items and update the total
    }

    public SaleDTO createSaleDTO(int amountPaid) {
        return sale.createSaleDTO(amountPaid); 
    }

    public Receipt endSale(int amountPaid) {
        SaleDTO saleDTO = createSaleDTO(amountPaid);
        Payment payment = new Payment();
        payment.startPayment(amountPaid);  
        return new Receipt(saleDTO, payment);  
    }
}
