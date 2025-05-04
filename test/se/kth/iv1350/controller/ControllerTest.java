package test.se.kth.iv1350.controller;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import main.se.kth.iv1350.integration.*;
import main.se.kth.iv1350.model.*;
import main.se.kth.iv1350.controller.*;

public class ControllerTest {
    private static final String ITEM_ID = "abc123";
    private static final double PRICE = 29.90;
    private static final double VAT = 6.0;
    
    @Test
    public void testEndSaleReturnsValidReceipt() {
        System.out.println("\n--- Testing Controller endSale ---");
        
        Printer printer = new Printer();
        Controller controller = new Controller(printer);
        controller.startSale();
        
        System.out.println("Creating test items...");
        // Explicitly create ArrayList instead of using List.of()
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(PRICE, VAT, 1, ITEM_ID, "Oatmeal", "500g"));
        
        System.out.println("Scanning items...");
        controller.scanItems(items); // Now matches the exact parameter type
        
        System.out.println("Ending sale with payment 50.0...");
        Receipt receipt = controller.endSale(50.0);
        
        System.out.println("Verifying receipt...");
        assertNotNull("Receipt should not be null", receipt);
        assertEquals("Should have 1 item", 1, receipt.getItems().size());
        assertEquals("Total should match item price", PRICE, receipt.getTotalPrice(), 0.001);
        assertEquals("Change should be correct", 50.0 - PRICE, receipt.getChange(), 0.001);
        
        System.out.println("Receipt contains:");
        System.out.println("- Items: " + receipt.getItems().size());
        System.out.println("- Total: " + receipt.getTotalPrice());
        System.out.println("- Change: " + receipt.getChange());
        System.out.println("--- Test PASSED ---");
    }
}