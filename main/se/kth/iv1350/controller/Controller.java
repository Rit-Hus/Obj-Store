package main.se.kth.iv1350.controller;

import java.util.ArrayList;
import java.util.List;

import main.se.kth.iv1350.integration.Printer;
import main.se.kth.iv1350.integration.ReceiptDTO;
import main.se.kth.iv1350.integration.SaleDTO;
import main.se.kth.iv1350.integration.ExternalInventorySystem;
import main.se.kth.iv1350.integration.ItemDTO;
import main.se.kth.iv1350.integration.ItemNotFoundException;
import main.se.kth.iv1350.integration.InventoryAccessException;
import main.se.kth.iv1350.model.Sale;
import main.se.kth.iv1350.model.Item;
import main.se.kth.iv1350.model.Payment;
import main.se.kth.iv1350.model.RevenueObserver;

public class Controller {
    private final Sale sale;
    private final Printer printer;
    private final ExternalInventorySystem invSys;

    public Controller(Printer printer, ExternalInventorySystem invSys) {
        this.printer = printer;
        this.invSys  = invSys;
        this.sale    = new Sale();
    }

    public void startSale() {
        sale.scanItems(new ArrayList<>());
        System.out.println("Sale started at: " + sale.getSaleDate());
    }

    public void addRevenueObserver(RevenueObserver obs) {
        sale.addObserver(obs);
    }

    public ItemDTO addItemToSale(String itemID, int qty)
           throws ItemNotFoundException, InventoryAccessException {
        ItemDTO dto = invSys.fetchItemDTO(itemID, qty);
        Item item = new Item(
            dto.getPrice(),
            dto.getVat(),
            dto.getQuantity(),
            dto.getIdentifier(),
            dto.getName(),
            dto.getDescription()
        );
        sale.scanItems(new ArrayList<>(List.of(item)));
        return dto;
    }

    public ReceiptDTO endSale(double amountPaid) {
        SaleDTO saleDTO = sale.createSaleDTO(amountPaid);
        Payment payment = new Payment();
        double change = payment.getChange(amountPaid, saleDTO);
        ReceiptDTO receiptDTO = new ReceiptDTO(saleDTO, change);
        printer.print(receiptDTO);
        return receiptDTO;
    }
}
