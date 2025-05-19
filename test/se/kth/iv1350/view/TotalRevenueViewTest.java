package test.se.kth.iv1350.view;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import main.se.kth.iv1350.view.TotalRevenueView;

/**
 * This class contains tests for the TotalRevenueView class, specifically focusing on
 * the functionality of displaying cumulative revenue.
 */
public class TotalRevenueViewTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream originalOut;
    private TotalRevenueView view;


    /**
     * Sets up the test environment before each test case.
     * Redirects System.out to capture output for testing.
     */
    @Before
    public void setUp() {
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        view = new TotalRevenueView();
    }

    /**
     * Cleans up the test environment after each test case.
     * Restores System.out to its original state.
     */
    @After
    public void tearDown() {
        System.setOut(originalOut);
    }


    /**
     * Tests the onNewSale method to ensure it prints the correct cumulative revenue.
     * It verifies that the output matches the expected format.
     */
    @Test
    public void onNewSale_firstSale_printsCorrectLine() {
        view.onNewSale(10.0);
        assertEquals("Total revenue so far: 10,00 SEK", outContent.toString().trim());
    }

    /**
     * Tests the onNewSale method to ensure it prints the correct cumulative revenue
     * after multiple sales. It verifies that the output matches the expected format.
     */
    @Test
    public void onNewSale_multipleSales_printsUpdatedLines() {
        view.onNewSale(10.0);
        view.onNewSale(5.5);
        String[] lines = outContent.toString().split("\\r?\\n");
        assertEquals("Total revenue so far: 10,00 SEK", lines[0].trim());
        assertEquals("Total revenue so far: 15,50 SEK", lines[1].trim());
    }
}
