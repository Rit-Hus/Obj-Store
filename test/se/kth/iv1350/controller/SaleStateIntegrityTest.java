package test.se.kth.iv1350.controller;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import main.se.kth.iv1350.controller.Controller;
import main.se.kth.iv1350.integration.ExternalInventorySystem;
import main.se.kth.iv1350.integration.Printer;
import main.se.kth.iv1350.integration.ReceiptDTO;
import main.se.kth.iv1350.integration.ItemNotFoundException;
import main.se.kth.iv1350.integration.InventoryAccessException;

public class SaleStateIntegrityTest {
    private Controller ctrl;

    @Before
    public void setUp() {
        Printer printer = new Printer();
        ExternalInventorySystem inv = ExternalInventorySystem.getInstance();
        ctrl = new Controller(printer, inv);
        ctrl.startSale();
    }

    @Test
    public void saleState_afterItemNotFoundException_noItemsAdded() throws Exception {
        try {
            ctrl.addItemToSale("noSuchID", 1);
        } catch (ItemNotFoundException e) {
            // after exception, finish sale
            ReceiptDTO dto = ctrl.endSale(0.0);
            assertTrue("No items should be on the sale", dto.getItems().isEmpty());
            assertEquals("Total price should be 0", 0.0, dto.getTotalPrice(), 1e-3);
            return;
        }
        fail("Expected ItemNotFoundException");
    }

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
