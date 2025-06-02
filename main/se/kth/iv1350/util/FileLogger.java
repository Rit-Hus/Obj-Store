package main.se.kth.iv1350.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;


/**
 * The FileLogger class is responsible for logging messages and exceptions to
 * separate log files. It provides methods to log messages and exceptions with
 * timestamps.
 */
public class FileLogger {
    private static final String REVENUE_LOG_FILE = "revenue.log";
    private static final String ERROR_LOG_FILE   = "errors.log";


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



    /**
     * Logs an exception to the error log file with a timestamp.
     *
     * @param e The exception to be logged.
     */
    public static void log(Exception e) {
        try (PrintWriter out = new PrintWriter(new FileWriter(ERROR_LOG_FILE, true))) {
            out.printf("%s: Exception: %s%n", LocalDateTime.now(), e.getMessage());
            e.printStackTrace(out);
        } catch (IOException ignored) { }
    }
}