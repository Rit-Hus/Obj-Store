// src/main/java/main/se/kth/iv1350/controller/Controller.java
package main.se.kth.iv1350.controller;

import java.util.ArrayList;
import main.se.kth.iv1350.integration.ExternalInventorySystem;
import main.se.kth.iv1350.integration.InventoryAccessException;
import main.se.kth.iv1350.integration.ItemDTO;
import main.se.kth.iv1350.integration.ItemNotFoundException;
import main.se.kth.iv1350.integration.Printer;
import main.se.kth.iv1350.integration.ReceiptDTO;
import main.se.kth.iv1350.integration.SaleDTO;
import main.se.kth.iv1350.model.Item;
import main.se.kth.iv1350.model.Payment;
import main.se.kth.iv1350.model.Sale;

/**
 * Manages the sale workflow: starting a sale, adding items, and ending the sale.
 */
public class Controller {
    private Sale sale;
    private Printer printer;
    private ExternalInventorySystem inventorySystem;

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
     * Fetches an ItemDTO from integration (or throws),
     * converts it to a model.Item, and scans it into the sale.
     *
     * @param itemID   The identifier of the item.
     * @param quantity The quantity to scan.
     * @return The fetched ItemDTO.
     * @throws InventoryAccessException If inventory is unavailable.
     * @throws ItemNotFoundException    If itemID not found.
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
     * Ends the sale, builds a SaleDTO, computes change,
     * wraps into a Receipt, and prints it.
     */
    public void endSale(double amountPaid) {
        SaleDTO saleDTO = sale.createSaleDTO(amountPaid);
        double change = new Payment().getChange(amountPaid, saleDTO);
        ReceiptDTO receiptDTO = new ReceiptDTO(saleDTO, change);
        printer.print(receiptDTO);
    }
}
