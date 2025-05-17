package test.se.kth.iv1350.controller;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import main.se.kth.iv1350.controller.Controller;
import main.se.kth.iv1350.integration.ExternalInventorySystem;
import main.se.kth.iv1350.integration.Printer;
import main.se.kth.iv1350.integration.ItemNotFoundException;
import main.se.kth.iv1350.integration.InventoryAccessException;

public class ControllerExceptionTest {
    private Controller ctrl;

    @Before
    public void setUp() {
        Printer printer = new Printer();
        ExternalInventorySystem inv = ExternalInventorySystem.getInstance();
        ctrl = new Controller(printer, inv);
        ctrl.startSale();
    }

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
