// File: src/test/java/test/se/kth/iv1350/integration/PrinterReceiptTest.java
package test.se.kth.iv1350.integration;

import main.se.kth.iv1350.integration.Printer;
import main.se.kth.iv1350.integration.ReceiptDTO;
import main.se.kth.iv1350.integration.ItemDTO;
import main.se.kth.iv1350.integration.SaleDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;


/**
 * This class tests the functionality of the Printer class, specifically
 * the print method which generates a receipt based on a SaleDTO object.
 */

public class PrinterReceiptTest {
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outBuffer;
    private Printer printer;

    /**
     * Sets up the test environment by redirecting System.out to a ByteArrayOutputStream
     * to capture printed output, and initializes the Printer instance.
     */
    @Before
    public void setUp() {
        outBuffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outBuffer));
        printer = new Printer();
    }

    /**
     * Restores the original System.out after each test to avoid interference
     * with other tests or the application.
     */
    @After
    public void tearDown() {
        System.setOut(originalOut);
    }
/**
 * Tests the print method of the Printer class to ensure that it correctly
 * */
    @Test
    public void testPrint_receiptIncludesItemsAndTotals() {

        ArrayList<ItemDTO> items = new ArrayList<>();
        items.add(new ItemDTO(
            50.00,  
            12,     
            1,      
            "A1",   
            "Apple",
            "Fresh apple"
        ));
        items.add(new ItemDTO(
            30.00,
            12,    
            2,       
            "B2",     
            "Banana",
            "Yellow banana"
        ));


        double totalAmount = (50.00 * 1) + (30.00 * 2);
        double totalVAT    = (50.00 * 0.12) + (30.00 * 2 * 0.12);
        double amountPaid  = 120.00;
        double change      = amountPaid - (totalAmount + totalVAT);



        LocalDate today = LocalDate.now();
        SaleDTO saleDTO = new SaleDTO(totalVAT, items, today, amountPaid, totalAmount);

        ReceiptDTO receipt = new ReceiptDTO(saleDTO, change);  

  
        printer.print(receipt);

        String output = outBuffer.toString();


        assertTrue("Receipt should mention 'Apple'", output.contains("Apple"));
        assertTrue("Receipt should mention 'Banana'", output.contains("Banana"));

      
        String formattedTotal = String.format("%.2f", totalAmount).replace('.', ',');
        assertTrue("Receipt should show total amount", output.contains(formattedTotal));

      
        String formattedVAT = String.format("%.2f", totalVAT).replace('.', ',');
        assertTrue("Receipt should show total VAT", output.contains(formattedVAT));

       
        String formattedPaid   = String.format("%.2f", amountPaid).replace('.', ',');
        String formattedChange = String.format("%.2f", change).replace('.', ',');
        assertTrue("Receipt should show paid amount", output.contains(formattedPaid));
        assertTrue("Receipt should show change amount", output.contains(formattedChange));
    }
}
