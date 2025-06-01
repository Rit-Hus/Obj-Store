package test.se.kth.iv1350.integration;

import main.se.kth.iv1350.integration.Printer;
import main.se.kth.iv1350.integration.ItemDTO;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * This class tests the Printer class, specifically the printItemDetails method.
 * It verifies that the method prints all expected lines to the console.
 */
public class PrinterPrintItemTest {
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outBuffer;
    private Printer printer;
/**
 * Sets up the test environment by redirecting System.out to a ByteArrayOutputStream.
 */
    @Before
    public void setUp() {
        outBuffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outBuffer));
        printer = new Printer();
    }

/**
 * Restores the original System.out after each test.
 */
    @After
    public void tearDown() {
        System.setOut(originalOut);
    }

/**
 * Tests the printItemDetails method of the Printer class.
 
 * @throws Exception if any unexpected error occurs during the test.
 */
    @Test
    public void testPrintItemDetails_printsAllLines() {
        ItemDTO dto = new ItemDTO(
                50.0,   
                12,     
                1,     
                "X1",  
                "Apple",
                "Fresh apple" 
        );

        printer.printItemDetails(dto);
        String output = outBuffer.toString();

        assertTrue("Should print 'Item ID: X1'",
                output.contains("Item ID: X1"));
        assertTrue("Should print 'Item name: Apple'",
                output.contains("Item name: Apple"));

        assertTrue("Should print 'Item cost: 50,00 SEK'",
                output.contains("Item cost: 50,00 SEK"));
        assertTrue("Should print 'VAT: 12%'",
                output.contains("VAT: 12%"));
        assertTrue("Should print 'Item description: Fresh apple'",
                output.contains("Item description: Fresh apple"));
    }
}
