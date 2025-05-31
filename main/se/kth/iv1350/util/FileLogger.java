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


        /**
     * Logs a message to the revenue log file with a timestamp.
     *
     * @param message The message to be logged.
     */
    public static void log(String message) {
        try (PrintWriter out = new PrintWriter(new FileWriter(REVENUE_LOG_FILE, true))) {
            out.printf("%s: %s%n", LocalDateTime.now(), message);
        } catch (IOException ignored) { }
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
