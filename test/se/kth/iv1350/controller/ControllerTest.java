package test.se.kth.iv1350.controller;

import main.se.kth.iv1350.integration.ExternalInventorySystem;
import main.se.kth.iv1350.controller.Controller;
import main.se.kth.iv1350.integration.ItemDTO;
import main.se.kth.iv1350.integration.ReceiptDTO;
import main.se.kth.iv1350.integration.Printer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 * This class contains tests for the Controller class, specifically focusing on
 * the main functionality of adding items to a sale and ending a sale.
 */
class ControllerTest {
    private Controller ctrl;


    /**
     * Sets up the test environment before each test case.
     * Initializes a Controller instance with a Printer and an ExternalInventorySystem.
     */
    @BeforeEach
    void setUp() {
        ctrl = new Controller(new Printer(), new ExternalInventorySystem());
        ctrl.startSale();
    }

    /**
     * Tests the addItemToSale method when an item with a known ID is added.
     * Verifies that the returned ItemDTO contains the correct identifier, quantity, and price.
     */
    @Test
    void addItemToSaleReturnsCorrectDTO() throws Exception {
        ItemDTO dto = ctrl.addItemToSale("abc123", 3);
        assertEquals("abc123", dto.getIdentifier());
        assertEquals(3,       dto.getQuantity());
        assertEquals(29.90,   dto.getPrice(), 1e-6);
    }
/**
     * Tests the addItemToSale method when an item with an unknown ID is added.
     * Expects an ItemNotFoundException to be thrown.
     */
    @Test
    void endSaleComputesReceiptCorrectly() throws Exception {
        ctrl.addItemToSale("abc123", 2);
        ctrl.addItemToSale("def456", 1); 
        ReceiptDTO receipt = ctrl.endSale(100.0);

        double expectedTotal = 59.80 + 14.90;
        assertEquals(expectedTotal,    receipt.getTotalPrice(), 1e-6);
        assertEquals(expectedTotal*0.06, receipt.getTotalVat(),   1e-6);
        assertEquals(100.0 - expectedTotal, receipt.getChange(), 1e-6);
    }
}
