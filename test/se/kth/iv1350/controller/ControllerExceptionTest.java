package test.se.kth.iv1350.controller;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import main.se.kth.iv1350.controller.Controller;
import main.se.kth.iv1350.integration.ExternalInventorySystem;
import main.se.kth.iv1350.integration.Printer;
import main.se.kth.iv1350.integration.ItemNotFoundException;
import main.se.kth.iv1350.integration.InventoryAccessException;

/**
 * This class contains tests for the Controller class, specifically focusing on
 * exception handling.
 */
public class ControllerExceptionTest {
    private Controller ctrl;

    /**
     * Sets up the test environment before each test case.
     * Initializes a Controller instance with a Printer and an
     * ExternalInventorySystem.
     */
    @Before
    public void setUp() {
        Printer printer = new Printer();
        ExternalInventorySystem inv = ExternalInventorySystem.getInstance();
        ctrl = new Controller(printer, inv);
        ctrl.startSale();
    }

    /**
     * Tests the addItemToSale method when an item with an unknown ID is added.
     * Expects an ItemNotFoundException to be thrown.
     * 
     * @throws ItemNotFoundException when the inventory system cannot find the item
     * @throws Exception             if an unexpected error occurs during the test
     */
    @Test
    public void addItemToSale_unknownId_throwsItemNotFoundException() throws Exception {
        try {
            ctrl.addItemToSale("noSuchID", 1);
        } catch (ItemNotFoundException e) {
            assertEquals("Item not found: noSuchID", e.getMessage());
            return;
        }
        fail("Expected ItemNotFoundException");
    }

    /**
     * Tests the addItemToSale method when a database error occurs.
     * Expects an InventoryAccessException to be thrown.
     * 
     * @throws InventoryAccessException when the inventory system signals a DB
     *                                  failure
     * @throws Exception                if an unexpected error occurs during the
     *                                  test
     */
    @Test
    public void addItemToSale_dbError_throwsInventoryAccessException() throws Exception {
        try {
            ctrl.addItemToSale("dbError", 1);
        } catch (InventoryAccessException e) {
            assertTrue(e.getMessage().startsWith("Simulated database failure for:"));
            return;
        }
        fail("Expected InventoryAccessException");
    }
}
