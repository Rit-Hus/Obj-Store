package test.se.kth.iv1350.integration;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import main.se.kth.iv1350.model.*;
import main.se.kth.iv1350.integration.*;

public class PrinterTest {
    @Test
    public void testPrintOutputContainsCorrectInformation() {
        System.out.println("\n=== STARTING PRINTER TEST ===");
        System.out.println("[SETUP] Creating test data...");
        
        // 1. Create test items
        Item testItem = new Item(29.90, 6.0, 2, "abc123", "BigWheel Oatmeal", "500g");
        ArrayList<Item> items = new ArrayList<>();
        items.add(testItem);
        
        // 2. Create test sale DTO
        SaleDTO dto = new SaleDTO(
            3.58, // VAT
            items,
            LocalDate.now(),
            100.0, // Amount paid
            59.80  // Total (2 x 29.90)
        );
        
        // 3. Create test receipt
        Receipt receipt = new Receipt(dto, 40.20); // Change (100 - 59.80)
        
        System.out.println("[TEST] Created receipt with:");
        System.out.println("  - 2 items of BigWheel Oatmeal");
        System.out.println("  - Total: 59.80 SEK");
        System.out.println("  - Change: 40.20 SEK");
        
        // 4. Capture output
        System.out.println("[ACTION] Capturing printer output...");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        
        // 5. Execute print
        Printer printer = new Printer();
        printer.print(receipt);
        
        // 6. Restore System.out
        System.setOut(originalOut);
        String printedOutput = outContent.toString();
        
        System.out.println("[OUTPUT] Printer generated:");
        System.out.println("----------------------------------------");
        System.out.print(printedOutput);
        System.out.println("----------------------------------------");
        
        // 7. Verify output
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