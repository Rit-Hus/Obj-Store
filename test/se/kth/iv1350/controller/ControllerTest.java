// src/test/java/main/se/kth/iv1350/controller/ControllerTest.java
package test.se.kth.iv1350.controller;

import main.se.kth.iv1350.integration.ExternalInventorySystem;
import main.se.kth.iv1350.controller.Controller;
import main.se.kth.iv1350.integration.ItemDTO;
import main.se.kth.iv1350.integration.ReceiptDTO;
import main.se.kth.iv1350.integration.Printer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    private Controller ctrl;

    @BeforeEach
    void setUp() {
        ctrl = new Controller(new Printer(), ExternalInventorySystem.getInstance());
        ctrl.startSale();
    }

    @Test
    void addItemToSaleReturnsCorrectDTO() throws Exception {
        ItemDTO dto = ctrl.addItemToSale("abc123", 3);
        assertEquals("abc123", dto.getIdentifier());
        assertEquals(3,       dto.getQuantity());
        assertEquals(29.90,   dto.getPrice(), 1e-6);
    }

    @Test
    void endSaleComputesReceiptCorrectly() throws Exception {
        ctrl.addItemToSale("abc123", 2); // 2×29.90 = 59.80
        ctrl.addItemToSale("def456", 1); // 1×14.90 = 14.90
        ReceiptDTO receipt = ctrl.endSale(100.0);

        double expectedTotal = 59.80 + 14.90;
        assertEquals(expectedTotal,    receipt.getTotalPrice(), 1e-6);
        assertEquals(expectedTotal*0.06, receipt.getTotalVat(),   1e-6);
        assertEquals(100.0 - expectedTotal, receipt.getChange(), 1e-6);
    }
}
