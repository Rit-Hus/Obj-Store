package test.se.kth.iv1350.view;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import main.se.kth.iv1350.view.TotalRevenueView;

public class TotalRevenueViewTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private PrintStream originalOut;
    private TotalRevenueView view;

    @Before
    public void setUp() {
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        view = new TotalRevenueView();
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void onNewSale_firstSale_printsCorrectLine() {
        view.onNewSale(10.0);
        assertEquals("Total revenue so far: 10,00 SEK", outContent.toString().trim());
    }

    @Test
    public void onNewSale_multipleSales_printsUpdatedLines() {
        view.onNewSale(10.0);
        view.onNewSale(5.5);
        String[] lines = outContent.toString().split("\\r?\\n");
        assertEquals("Total revenue so far: 10,00 SEK", lines[0].trim());
        assertEquals("Total revenue so far: 15,50 SEK", lines[1].trim());
    }
}
