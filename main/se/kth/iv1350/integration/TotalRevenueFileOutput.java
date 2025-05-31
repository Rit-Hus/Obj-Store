package main.se.kth.iv1350.integration;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import main.se.kth.iv1350.view.AbstractRevenueObserver;

/**
 * Writes total revenue to a file.
 */
public class TotalRevenueFileOutput extends AbstractRevenueObserver {
    private static final String FILE_NAME = "total-revenue.txt";

    @Override
    protected void doShowTotalIncome() throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, false))) {
            writer.println("Total revenue (file output): " + getTotalIncome() + " SEK");
        }
    }

    @Override
    protected void handleErrors(Exception e) {
        System.err.println(">>> Failed to write revenue to file: " + e.getMessage());
    }
}
