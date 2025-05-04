package test.se.kth.iv1350.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import main.se.kth.iv1350.model.*;
import main.se.kth.iv1350.integration.*;

/**
 * This class contains unit tests for the Sale class. It tests the scanItems and
 * createSaleDTO methods to ensure they work correctly with both new and existing
 * items.
 */
public class SaleTest {
    private Sale sale;
    private static final String ITEM_ID = "abc123";
    private static final double PRICE = 29.90;
    private static final double VAT = 6.0;
    private static final String NAME = "BigWheel Oatmeal";
    private static final String DESC = "500g, whole grain oats";

    @Before
    /**
     * Sets up the test environment by creating a new Sale instance before each test.
     */
    public void setUp() {
        sale = new Sale();
        System.out.println("New Sale instance created for test");
    }

    @Test
    /**
     * Tests the scanItems method of the Sale class. It verifies that a new item is
     * added correctly and that the total amount is updated accordingly.
     */
    public void testScanNewItem() {
        System.out.println("\n=== TEST 1: Scanning New Item ===");
        
        // 1. Create test item
        Item testItem = new Item(PRICE, VAT, 1, ITEM_ID, NAME, DESC);
        System.out.println("[SETUP] Created test item: " + NAME);
        
        // 2. Scan the item
        sale.scanItems(new ArrayList<>(List.of(testItem)));
        System.out.println("[ACTION] Item scanned successfully");
        
        // 3. Verify results
        System.out.println("[VERIFICATION] Checking results...");
        assertEquals("Should have exactly 1 item", 1, sale.getItems().size());
        
        Item scannedItem = sale.getItems().get(0);
        System.out.println("  Item details:");
        System.out.println("  - Name: " + scannedItem.getName());
        System.out.println("  - ID: " + scannedItem.getItemID());
        System.out.println("  - Price: " + scannedItem.getPrice());
        System.out.println("  - VAT: " + scannedItem.getVat() + "%");
        System.out.println("  - Quantity: " + scannedItem.getQuantity());
        
        assertEquals("Item ID should match", ITEM_ID, scannedItem.getItemID());
        assertEquals("Price should match", PRICE, scannedItem.getPrice(), 0.001);
        assertEquals("Quantity should be 1", 1, scannedItem.getQuantity());
        
        System.out.println("  Total verification:");
        System.out.println("  - Expected: " + PRICE);
        System.out.println("  - Actual: " + sale.getTotalAmount());
        assertEquals("Total should equal item price", PRICE, sale.getTotalAmount(), 0.001);
        
        System.out.println("=== TEST 1 PASSED ===\n");
    }

    @Test
    /**
     * Tests the scanItems method of the Sale class when scanning an existing item.
     * It verifies that the quantity is updated and the total amount is recalculated
     * correctly.
     */
    public void testScanExistingItem() {
        System.out.println("\n=== TEST 2: Scanning Existing Item ===");
        
        Item testItem = new Item(PRICE, VAT, 1, ITEM_ID, NAME, DESC);
        System.out.println("[SETUP] Created test item: " + NAME);
        
        // First scan
        sale.scanItems(new ArrayList<>(List.of(testItem)));
        System.out.println("[ACTION 1] First scan complete");
        System.out.println("  Current quantity: 1");
        System.out.println("  Current total: " + sale.getTotalAmount());
        
        // Second scan
        sale.scanItems(new ArrayList<>(List.of(testItem)));
        System.out.println("[ACTION 2] Second scan complete");
        
        // Verification
        System.out.println("[VERIFICATION] Checking results...");
        assertEquals("Should still have 1 item", 1, sale.getItems().size());
        
        Item scannedItem = sale.getItems().get(0);
        System.out.println("  Updated details:");
        System.out.println("  - Quantity: " + scannedItem.getQuantity());
        System.out.println("  - Total: " + sale.getTotalAmount());
        
        assertEquals("Quantity should be 2", 2, scannedItem.getQuantity());
        assertEquals("Total should be doubled", PRICE*2, sale.getTotalAmount(), 0.001);
        
        System.out.println("=== TEST 2 PASSED ===\n");
    }

    @Test
    /**
     * Tests the createSaleDTO method of the Sale class. It verifies that the
     * generated SaleDTO object contains the correct information about the sale,
     * including total amount, amount paid, and items.
     */
    public void testCreateSaleDTO() {
        System.out.println("\n=== TEST 3: Creating Sale DTO ===");
        
        Item testItem = new Item(PRICE, VAT, 1, ITEM_ID, NAME, DESC);
        sale.scanItems(new ArrayList<>(List.of(testItem)));
        System.out.println("[SETUP] Scanned item: " + NAME);
        
        double amountPaid = 100.0;
        System.out.println("[ACTION] Creating DTO with payment: " + amountPaid);
        SaleDTO dto = sale.createSaleDTO(amountPaid);
        
        System.out.println("[VERIFICATION] DTO contents:");
        System.out.println("  - Total amount: " + dto.getTotalAmount());
        System.out.println("  - Amount paid: " + dto.getAmountPaid());
        System.out.println("  - VAT: " + dto.getVAT());
        System.out.println("  - Items count: " + dto.getItems().size());
        
        if (!dto.getItems().isEmpty()) {
            Item firstItem = dto.getItems().get(0);
            System.out.println("  First item details:");
            System.out.println("    - Name: " + firstItem.getName());
            System.out.println("    - Price: " + firstItem.getPrice());
            System.out.println("    - Quantity: " + firstItem.getQuantity());
        }
        
        assertNotNull("DTO should not be null", dto);
        assertEquals("Total amount should match", PRICE, dto.getTotalAmount(), 0.001);
        assertEquals("Amount paid should match", amountPaid, dto.getAmountPaid(), 0.001);
        assertEquals("Should have 1 item", 1, dto.getItems().size());
        
        System.out.println("=== TEST 3 PASSED ===\n");
    }
}