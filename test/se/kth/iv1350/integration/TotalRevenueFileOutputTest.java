package test.se.kth.iv1350.integration;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import main.se.kth.iv1350.integration.TotalRevenueFileOutput;

/**
 * This class contains tests for the TotalRevenueFileOutput class, specifically focusing on
 * the functionality of writing cumulative revenue to a log file.
 */
public class TotalRevenueFileOutputTest {
    private static final String LOG_FILE = "revenue.log";

    /**
     * Sets up the test environment before each test case.
     * It ensures that the log file is deleted before running the tests.
     */
    @Before
    public void clearLog() throws Exception {
        Files.deleteIfExists(Paths.get(LOG_FILE));
    }

    /**
     * Tests the onNewSale method to ensure it writes the correct cumulative revenue to the log file.
     * It verifies that the log file contains the expected lines after multiple sales.
     */
    @Test
    public void onNewSale_writesCumulativeLines() throws Exception {
        TotalRevenueFileOutput out = new TotalRevenueFileOutput();
        out.onNewSale(20.0);
        out.onNewSale(5.5);

        List<String> lines = Files.readAllLines(Paths.get(LOG_FILE));
        assertTrue(lines.get(0).contains("Cumulative revenue: 20,00 SEK"));
        assertTrue(lines.get(1).contains("Cumulative revenue: 25,50 SEK"));
    }
}
