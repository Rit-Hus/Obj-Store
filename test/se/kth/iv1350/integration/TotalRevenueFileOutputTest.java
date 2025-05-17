package test.se.kth.iv1350.integration;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import main.se.kth.iv1350.integration.TotalRevenueFileOutput;

public class TotalRevenueFileOutputTest {
    private static final String LOG_FILE = "revenue.log";

    @Before
    public void clearLog() throws Exception {
        Files.deleteIfExists(Paths.get(LOG_FILE));
    }

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
