package main.se.kth.iv1350.controller;

import java.util.ArrayList;
import java.util.List;
import main.se.kth.iv1350.integration.ExternalInventorySystem;
import main.se.kth.iv1350.integration.InventoryAccessException;
import main.se.kth.iv1350.integration.ItemDTO;
import main.se.kth.iv1350.integration.ItemNotFoundException;
import main.se.kth.iv1350.integration.Printer;
import main.se.kth.iv1350.integration.ReceiptDTO;
import main.se.kth.iv1350.integration.SaleDTO;
import main.se.kth.iv1350.model.Item;
import main.se.kth.iv1350.model.Payment;
import main.se.kth.iv1350.model.RevenueObserver;
import main.se.kth.iv1350.model.Sale;

/**
 * Manages the sale workflow: starting a sale, fetching and scanning items,
 * ending the sale, and notifying registered RevenueObservers after each completed sale.
 */
public class Controller {
    private Sale sale;
    private final Printer printer;
    private final ExternalInventorySystem inventorySystem;
    private final List<RevenueObserver> observers = new ArrayList<>();

    /**
     * Registers a RevenueObserver to be notified after each sale.
     */
    public void addObserver(RevenueObserver observer) {
        observers.add(observer);
    }

    /**
     * Unregisters a previously registered RevenueObserver.
     */
    public void removeObserver(RevenueObserver observer) {
        observers.remove(observer);
    }

    public Controller(Printer printer, ExternalInventorySystem inventorySystem) {
        this.printer = printer;
        this.inventorySystem = inventorySystem;
        this.sale = new Sale();
    }

    /** Starts a new sale. */
    public void startSale() {
        this.sale = new Sale();
    }

    /**
     * Fetches an ItemDTO from integration, converts it to a model.Item, scans it,
     * and returns the DTO.
     */
    public ItemDTO addItemToSale(String itemID, int quantity)
            throws InventoryAccessException, ItemNotFoundException {
        ItemDTO dto = inventorySystem.fetchItemDTO(itemID, quantity);
        Item item = new Item(
            dto.getPrice(),
            dto.getVat(),
            dto.getQuantity(),
            dto.getIdentifier(),
            dto.getName(),
            dto.getDescription()
        );
        ArrayList<Item> batch = new ArrayList<>();
        batch.add(item);
        sale.scanItems(batch);
        return dto;
    }

    /**
     * Ends the sale: builds a SaleDTO, computes change, wraps into ReceiptDTO, prints it,
     * and then notifies all registered observers.
     */
    public ReceiptDTO endSale(double amountPaid) {
        SaleDTO saleDTO = sale.createSaleDTO(amountPaid);
        double change = new Payment().getChange(amountPaid, saleDTO);
        ReceiptDTO receiptDTO = new ReceiptDTO(saleDTO, change);
        printer.print(receiptDTO);

        notifyObservers(saleDTO.getTotalAmount());

        return receiptDTO;
    }

    /**
     * Notifies each registered RevenueObserver of the given sale total.
     */
    private void notifyObservers(double saleTotal) {
        for (RevenueObserver obs : observers) {
            obs.onNewSale(saleTotal);
        }
    }
}
