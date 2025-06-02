package main.se.kth.iv1350.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import main.se.kth.iv1350.view.AbstractRevenueObserver;
import java.time.LocalDateTime;


/**
 * Logs revenue and errors to a file.
 */
public class FileLogger extends AbstractRevenueObserver {
    private static final String REVENUE_LOG_FILE = "revenue-log.log";

    private static final String ERROR_LOG_FILE   = "errors.log";



    // Use this for logging revenue
    @Override
    protected void doShowTotalIncome() throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(REVENUE_LOG_FILE, true))) {
            writer.println("Revenue update - Total income: " + getTotalIncome() + " SEK");
        }
    }

    @Override
    protected void handleErrors(Exception e) {
        System.err.println(">>> Failed to log revenue: " + e.getMessage());
    }


    /**
     * Logs an error message to the error log file.
     * @param e The exception to log.
     * @throws IOException If an I/O error occurs while writing to the log file.
     */

        // Use this for logging exceptions
    public static void log(Exception e) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ERROR_LOG_FILE, true))) {
            writer.println("ERROR: " + e.toString());
        } catch (IOException ioEx) {
            System.err.println(">>> Could not log error: " + ioEx.getMessage());
        }
    }
}
