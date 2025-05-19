
package test.se.kth.iv1350.model;   

import main.se.kth.iv1350.integration.SaleDTO;
import main.se.kth.iv1350.model.Item;
import main.se.kth.iv1350.model.Sale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 * This class contains tests for the Sale class.
 * It verifies the behavior of the scanItems method and the createSaleDTO method.
 */
class SaleTest {
    private Sale sale;

    /**
     * Sets up the test environment before each test case.
     * Initializes a Sale instance.
     */
    @BeforeEach
    void setUp() {
        sale = new Sale();
    }


    /**
     * Tests the scanItems method to ensure it correctly accumulates items.
     * It verifies that the total amount and VAT are calculated correctly.
     */
    @Test
    void scanItemsAccumulatesTotalsCorrectly() {

        Item item = new Item(15.0, 10.0, 1, "A1", "Gadget", "Test gadget");
        ArrayList<Item> firstScan  = new ArrayList<>(List.of(item));
        ArrayList<Item> secondScan = new ArrayList<>(List.of(item));

        sale.scanItems(firstScan);
        sale.scanItems(secondScan);

        SaleDTO summary = sale.createSaleDTO(0.0);
        assertEquals(1, summary.getItems().size());
        assertEquals(2, summary.getItems().get(0).getQuantity());

        assertEquals(30.0, summary.getTotalAmount(), 1e-6);

        assertEquals(3.0, summary.getVAT(), 1e-6);
    }

    /**
     * Tests the scanItems method to ensure it correctly accumulates items with different IDs.
     * It verifies that the total amount and VAT are calculated correctly.
     */
    @Test
    void mixedScansAccumulateSeparateLines() {
        ArrayList<Item> scanX = new ArrayList<>(List.of(
            new Item(10.0, 5.0, 1, "X", "One", "Desc")
        ));
        ArrayList<Item> scanY = new ArrayList<>(List.of(
            new Item(20.0, 5.0, 1, "Y", "Two", "Desc")
        ));

        sale.scanItems(scanX);
        sale.scanItems(scanY);

        SaleDTO summary = sale.createSaleDTO(0.0);
        assertEquals(2, summary.getItems().size(),
                     "Different item IDs should result in two separate line-items");
    }
}
