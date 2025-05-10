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
        
       

        
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
       
        

        Printer printer = new Printer();
        printer.print(receipt);
        

        System.setOut(originalOut);
        String printedOutput = outContent.toString();
        
        

       
        
        String[] expectedPatterns = {
            "BigWheel Oatmeal",
            "2 x 29,90",
            "59,80 SEK",
            "Total:",
            "40,20 SEK",
            "--- End receipt ---"
        };
        
        for (String pattern : expectedPatterns) {
           
            assertTrue("Missing: " + pattern, printedOutput.contains(pattern));
            
        }
        
        
    }
}