package test.se.kth.iv1350.controller;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import main.se.kth.iv1350.integration.*;
import main.se.kth.iv1350.model.*;
import main.se.kth.iv1350.controller.*;


/**
 * This class contains unit tests for the Controller class. It tests the endSale
 * method to ensure it returns a valid receipt with the correct total price and
 * change.
 */
public class ControllerTest {
    private static final String ITEM_ID = "abc123";
    private static final double PRICE = 29.90;
    private static final double VAT = 6.0;
    
    @Test
    /**
     * Tests the endSale method of the Controller class. It verifies that the
     * returned receipt contains the correct total price and change.
     */
    public void testEndSaleReturnsValidReceipt() {
        
        
        Printer printer = new Printer();
        Controller controller = new Controller(printer);
        controller.startSale();
        
        
        
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(PRICE, VAT, 1, ITEM_ID, "Oatmeal", "500g"));
        
        
        controller.scanItems(items); 
        
       
        ReceiptDTO receipt = controller.endSale(50.0);
        
        
        assertNotNull("Receipt should not be null", receipt);
        assertEquals("Should have 1 item", 1, receipt.getItems().size());
        assertEquals("Total should match item price", PRICE, receipt.getTotalPrice(), 0.001);
        assertEquals("Change should be correct", 50.0 - PRICE, receipt.getChange(), 0.001);
        
        
    }
}