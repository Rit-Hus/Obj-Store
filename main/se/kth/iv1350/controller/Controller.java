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
import main.se.kth.iv1350.model.DiscountStrategy;
import main.se.kth.iv1350.model.Item;
import main.se.kth.iv1350.model.Payment;
import main.se.kth.iv1350.model.RevenueObserver;
import main.se.kth.iv1350.model.Sale;


/**
 * The Controller class is responsible for managing the flow of the application. It
 * interacts with the model and the view to handle user input and update the display.
 * The class provides methods to start a sale, add items to the sale, and end the sale.
 */
public class Controller {
    private  Sale currentSale;
    private final Printer printer;
    private final ExternalInventorySystem invSys;
    private DiscountStrategy discountStrategy;

    public Controller(Printer printer, ExternalInventorySystem invSys) {
        this.printer = printer;
        this.invSys  = invSys;
        this.currentSale    = new Sale();
    }

    /**
     * Starts a new sale by initializing the sale object and setting the date.
     */
    public void startSale() {
        Sale sale = new Sale();
        System.out.println("Sale started at: " + sale.getSaleDate());
    }

    /**
     * Sets the discount strategy for the current sale.
     *
     * @param ds The discount strategy to be set.
     */
    public void addRevenueObserver(RevenueObserver obs) {
        currentSale.addObserver(obs);
    }


    public void setDiscountStrategy(DiscountStrategy strategy) {
    currentSale.setDiscountStrategy(strategy);
    }


    /**
     * Adds an item to the current sale. The item is fetched from the inventory system
     * using its ID and quantity.
     *
     * @param itemID The ID of the item to be added.
     * @param qty    The quantity of the item to be added.
     * @return The ItemDTO object containing information about the added item.
     * @throws ItemNotFoundException If the item with the specified ID is not found.
     * @throws InventoryAccessException If there is an error accessing the inventory system.
     */
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
    
    currentSale.scanItems(new ArrayList<>(List.of(item)));
    return dto;
}


    /**
     * Ends the current sale and generates a receipt. The receipt is printed using the
     * printer object.
     *
     * @param amountPaid The amount paid by the customer.
     * @return The ReceiptDTO object containing information about the sale and change.
     */

    public ReceiptDTO endSale(double amountPaid) {
    SaleDTO saleDTO = currentSale.createSaleDTO(amountPaid);
    Payment payment = new Payment();
    double change = payment.getChange(amountPaid, saleDTO);
    ReceiptDTO receiptDTO = new ReceiptDTO(saleDTO, change);
    printer.print(receiptDTO);

  

    return receiptDTO;
}

}
