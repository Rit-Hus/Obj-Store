package test.se.kth.iv1350.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import main.se.kth.iv1350.controller.Controller;
import main.se.kth.iv1350.integration.ExternalInventorySystem;
import main.se.kth.iv1350.integration.Printer;
import main.se.kth.iv1350.integration.ReceiptDTO;
import main.se.kth.iv1350.integration.ItemNotFoundException;
import main.se.kth.iv1350.integration.InventoryAccessException;

/**
 * This class contains tests for the Controller class, specifically focusing on
 * the integrity of the sale state after exceptions are thrown.
 */
public class SaleStateIntegrityTest {
    private Controller ctrl;


    /**
     * Sets up the test environment before each test case.
     * Initializes a Controller instance with a Printer and an ExternalInventorySystem.
     */
    @Before
    public void setUp() {
        Printer printer = new Printer();
        ExternalInventorySystem inv = ExternalInventorySystem.getInstance();
        ctrl = new Controller(printer, inv);
        ctrl.startSale();
    }


    /**
     * Tests the sale state after an ItemNotFoundException is thrown.
     * Verifies that no items are added to the sale and the total price is 0.
     */
    @Test
    public void saleState_afterItemNotFoundException_noItemsAdded() throws Exception {
        try {
            ctrl.addItemToSale("noSuchID", 1);
        } catch (ItemNotFoundException e) {

            ReceiptDTO dto = ctrl.endSale(0.0);
            assertTrue("No items should be on the sale", dto.getItems().isEmpty());
            assertEquals("Total price should be 0", 0.0, dto.getTotalPrice(), 1e-3);
            return;
        }
        fail("Expected ItemNotFoundException");
    }
/**
     * Tests the sale state after an InventoryAccessException is thrown.
     * Verifies that no items are added to the sale and the total price is 0.
     */
    @Test
    public void saleState_afterDbErrorException_noItemsAdded() throws Exception {
        try {
            ctrl.addItemToSale("dbError", 1);
        } catch (InventoryAccessException e) {
            ReceiptDTO dto = ctrl.endSale(0.0);
            assertTrue("No items should be on the sale", dto.getItems().isEmpty());
            assertEquals("Total price should be 0", 0.0, dto.getTotalPrice(), 1e-3);
            return;
        }
        fail("Expected InventoryAccessException");
    }
}
