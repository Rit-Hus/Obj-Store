package test.se.kth.iv1350.controller;

import java.util.ArrayList;

import test.se.kth.iv1350.integration.Printer;
import test.se.kth.iv1350.integration.SaleDTO;
import test.se.kth.iv1350.model.Item;
import test.se.kth.iv1350.model.Payment;
import test.se.kth.iv1350.model.Receipt;
import test.se.kth.iv1350.model.Sale;

public class Controller {
    private Sale sale;
    private Printer printer;

    public Controller(Printer printer) {
        this.printer = printer;
        this.sale = new Sale();
    }

    public void startSale() {
        this.sale = new Sale();
        System.out.println("Sale started at: " + sale.getSaleDate());
    }

    public void scanItems(ArrayList<Item> items) {
        sale.scanItems(items);
    }

    public Receipt endSale(double amountPaid) {
        SaleDTO saleDTO = sale.createSaleDTO(amountPaid);
        Payment payment = new Payment();
        double change = payment.getChange(amountPaid, saleDTO);
        return new Receipt(saleDTO, change);
    }
}