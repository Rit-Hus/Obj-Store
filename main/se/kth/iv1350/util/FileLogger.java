package main.se.kth.iv1350.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import main.se.kth.iv1350.view.AbstractRevenueObserver;

/**
 * Logs revenue and errors to a file.
 */
public class FileLogger extends AbstractRevenueObserver {
    private static final String LOG_FILE = "revenue-log.txt";

    @Override
    protected void doShowTotalIncome() throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            writer.println("Revenue update - Total income: " + getTotalIncome() + " SEK");
        }
    }

    @Override
    protected void handleErrors(Exception e) {
        System.err.println(">>> Failed to log revenue: " + e.getMessage());
    }

    // Add this for logging exceptions
    public static void log(Exception e) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            writer.println("ERROR: " + e.toString());
        } catch (IOException ioEx) {
            System.err.println(">>> Could not log error: " + ioEx.getMessage());
        }
    }
}
