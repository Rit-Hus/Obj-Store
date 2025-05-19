package test.se.kth.iv1350.integration;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import main.se.kth.iv1350.integration.ExternalInventorySystem;
import main.se.kth.iv1350.integration.ItemNotFoundException;
import main.se.kth.iv1350.integration.InventoryAccessException;


/**
 * This class contains tests for the ExternalInventorySystem class, specifically focusing on
 * exception handling.
 */
public class ExternalInventorySystemExceptionTest {
    private ExternalInventorySystem invSys;


    /**
     * Sets up the test environment before each test case.
     * Initializes an ExternalInventorySystem instance.
     */
    @Before
    public void setUp() {
        invSys = ExternalInventorySystem.getInstance();
    }

    /**
     * Tests the fetchItemDTO method when an item with an unknown ID is requested.
     * Expects an ItemNotFoundException to be thrown.
     */
    @Test
    public void fetchItemDTO_unknownId_throwsItemNotFoundException() throws Exception {
        try {
            invSys.fetchItemDTO("noSuchID", 1);
        } catch (ItemNotFoundException e) {
            assertEquals("Item not found: noSuchID", e.getMessage());
            return;
        }
        fail("Expected ItemNotFoundException");
    }

    /**
     * Tests the fetchItemDTO method when a database error occurs.
     * Expects an InventoryAccessException to be thrown.
     */
    @Test
    public void fetchItemDTO_dbError_throwsInventoryAccessException() throws Exception {
        try {
            invSys.fetchItemDTO("dbError", 1);
        } catch (InventoryAccessException e) {
            assertTrue(e.getMessage().startsWith("Simulated database failure for: dbError"));
            return;
        }
        fail("Expected InventoryAccessException");
    }
}
