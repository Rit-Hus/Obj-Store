package main.se.kth.iv1350.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * Simple file logger for developer‐level error logging.
 * Now splits revenue vs. error logs into separate files.
 */
public class FileLogger {
    // Where revenue‐related observer messages go
    private static final String REVENUE_LOG_FILE = "revenue.log";
    // Where exception stacks from the View go
    private static final String ERROR_LOG_FILE   = "errors.log";

    /**
     * Append a revenue message to revenue.log.
     */
    public static void log(String message) {
        try (PrintWriter out = new PrintWriter(new FileWriter(REVENUE_LOG_FILE, true))) {
            out.printf("%s: %s%n", LocalDateTime.now(), message);
        } catch (IOException ignored) { }
    }

    /**
     * Append an exception’s stack trace to errors.log.
     */
    public static void log(Exception e) {
        try (PrintWriter out = new PrintWriter(new FileWriter(ERROR_LOG_FILE, true))) {
            out.printf("%s: Exception: %s%n", LocalDateTime.now(), e.getMessage());
            e.printStackTrace(out);
        } catch (IOException ignored) { }
    }
}
