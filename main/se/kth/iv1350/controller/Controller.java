package main.se.kth.iv1350.controller;

import java.util.ArrayList;
import main.se.kth.iv1350.integration.ExternalInventorySystem;
import main.se.kth.iv1350.integration.Printer;
import main.se.kth.iv1350.integration.SaleDTO;
import main.se.kth.iv1350.model.Item;
import main.se.kth.iv1350.model.Payment;
import main.se.kth.iv1350.model.Receipt;
import main.se.kth.iv1350.model.Sale;

/**
 * Manages the sale workflow: starting a sale, adding items, and ending the sale.
 */
public class Controller {
    private Sale currentSale;
    private Printer printer;
    private ExternalInventorySystem inventorySystem;

    public Controller(Printer printer, ExternalInventorySystem inventorySystem) {
        this.printer = printer;
        this.inventorySystem = inventorySystem;
        this.currentSale = new Sale();
    }


    public void startSale() {
        this.currentSale = new Sale();
    }

    /**
     * Fetches an item by ID and quantity and prints its details.
     *
     * @param itemID   The item identifier.
     * @param quantity The quantity to add.
     */
    public void addItemToSale(String itemID, int quantity) {
        Item item = inventorySystem.fetchItem(itemID, quantity);
        printer.printItemDetails(item);
        ArrayList<Item> bundle = new ArrayList<>();
        bundle.add(item);
        currentSale.scanItems(bundle);
    }

    /**
     * Ends the sale, calculates change, and prints the receipt.
     *
     * @param amountPaid The amount the customer pays.
     */
    public void endSale(double amountPaid) {
        SaleDTO saleData = currentSale.createSaleDTO(amountPaid);
        Payment payment = new Payment();
        double change = payment.getChange(amountPaid, saleData);
        Receipt receipt = new Receipt(saleData, change);
        printer.print(receipt);
    }
}
