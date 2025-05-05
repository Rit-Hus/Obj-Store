package test.se.kth.iv1350.integration;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import main.se.kth.iv1350.model.*;
import main.se.kth.iv1350.integration.*;

/**
 * This class contains unit tests for the Printer class. It tests the print method
 * to ensure it generates the correct output for a given receipt.
 */
public class PrinterTest {
    @Test

    /**
     * Tests the print method of the Printer class. It verifies that the printed
     * output contains the expected information about the items, total price, and
     * change.
     */
    public void testPrintOutputContainsCorrectInformation() {
        System.out.println("\n=== STARTING PRINTER TEST ===");
        System.out.println("[SETUP] Creating test data...");
        
   
        Item testItem = new Item(29.90, 6.0, 2, "abc123", "BigWheel Oatmeal", "500g");
        ArrayList<Item> items = new ArrayList<>();
        items.add(testItem);
        
      
        SaleDTO dto = new SaleDTO(
            3.58,
            items,
            LocalDate.now(),
            100.0, 
            59.80  
        );
        

        Receipt receipt = new Receipt(dto, 40.20);
        
        System.out.println("[TEST] Created receipt with:");
        System.out.println("  - 2 items of BigWheel Oatmeal");
        System.out.println("  - Total: 59.80 SEK");
        System.out.println("  - Change: 40.20 SEK");

        System.out.println("[ACTION] Capturing printer output...");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        

        Printer printer = new Printer();
        printer.print(receipt);
        

        System.setOut(originalOut);
        String printedOutput = outContent.toString();
        
        System.out.println("[OUTPUT] Printer generated:");
        System.out.println("----------------------------------------");
        System.out.print(printedOutput);
        System.out.println("----------------------------------------");
        

        System.out.println("[VERIFICATION] Checking output contains:");
        
        String[] expectedPatterns = {
            "BigWheel Oatmeal",
            "2 x 29,90",
            "59,80 SEK",
            "Total:",
            "40,20 SEK",
            "--- End receipt ---"
        };
        
        for (String pattern : expectedPatterns) {
            System.out.print("  Looking for '" + pattern + "'... ");
            assertTrue("Missing: " + pattern, printedOutput.contains(pattern));
            System.out.println("FOUND");
        }
        
        System.out.println("=== PRINTER TEST PASSED ===\n");
    }
}