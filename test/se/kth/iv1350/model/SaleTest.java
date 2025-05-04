package test.se.kth.iv1350.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import main.se.kth.iv1350.model.*;
import main.se.kth.iv1350.integration.*;

public class SaleTest {
    private Sale sale;
    private static final String ITEM_ID = "abc123";
    private static final double PRICE = 29.90;
    private static final double VAT = 6.0;
    private static final String NAME = "BigWheel Oatmeal";
    private static final String DESC = "500g, whole grain oats";

    @Before
    public void setUp() {
        sale = new Sale();
    }

    @Test
    public void testScanNewItem() {
        System.out.println("--- Testing scanNewItem ---");
        
        // 1. Create test item
        Item testItem = new Item(PRICE, VAT, 1, ITEM_ID, NAME, DESC);
        
        // 2. Scan the item
        sale.scanItems(new ArrayList<>(List.of(testItem)));
        
        // 3. Verify results
        System.out.println("Verifying item was added...");
        assertEquals("Should have exactly 1 item", 1, sale.getItems().size());
        
        Item scannedItem = sale.getItems().get(0);
        System.out.println("Scanned item: " + scannedItem.getName());
        
        assertEquals("Item ID should match", ITEM_ID, scannedItem.getItemID());
        assertEquals("Price should match", PRICE, scannedItem.getPrice(), 0.001);
        assertEquals("Quantity should be 1", 1, scannedItem.getQuantity());
        
        System.out.println("Verifying total amount...");
        assertEquals("Total should equal item price", PRICE, sale.getTotalAmount(), 0.001);
        
        System.out.println("--- testScanNewItem PASSED ---\n");
    }

    @Test
    public void testScanExistingItem() {
        System.out.println("--- Testing scanExistingItem ---");
        
        Item testItem = new Item(PRICE, VAT, 1, ITEM_ID, NAME, DESC);
        
        // First scan
        sale.scanItems(new ArrayList<>(List.of(testItem)));
        System.out.println("First scan complete");
        
        // Second scan
        sale.scanItems(new ArrayList<>(List.of(testItem)));
        System.out.println("Second scan complete");
        
        // Verify
        assertEquals("Should still have 1 item", 1, sale.getItems().size());
        assertEquals("Quantity should be 2", 2, sale.getItems().get(0).getQuantity());
        assertEquals("Total should be doubled", PRICE*2, sale.getTotalAmount(), 0.001);
        
        System.out.println("--- testScanExistingItem PASSED ---\n");
    }

    @Test
    public void testCreateSaleDTO() {
        System.out.println("--- Testing createSaleDTO ---");
        
        Item testItem = new Item(PRICE, VAT, 1, ITEM_ID, NAME, DESC);
        sale.scanItems(new ArrayList<>(List.of(testItem)));
        
        double amountPaid = 100.0;
        SaleDTO dto = sale.createSaleDTO(amountPaid);
        
        System.out.println("Verifying DTO contents...");
        assertNotNull("DTO should not be null", dto);
        assertEquals("Total amount should match", PRICE, dto.getTotalAmount(), 0.001);
        assertEquals("Amount paid should match", amountPaid, dto.getAmountPaid(), 0.001);
        assertEquals("Should have 1 item", 1, dto.getItems().size());
        
        System.out.println("--- testCreateSaleDTO PASSED ---\n");
    }
}