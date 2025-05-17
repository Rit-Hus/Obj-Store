package main.se.kth.iv1350.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;


public class FileLogger {
    private static final String REVENUE_LOG_FILE = "revenue.log";
    private static final String ERROR_LOG_FILE   = "errors.log";


    public static void log(String message) {
        try (PrintWriter out = new PrintWriter(new FileWriter(REVENUE_LOG_FILE, true))) {
            out.printf("%s: %s%n", LocalDateTime.now(), message);
        } catch (IOException ignored) { }
    }


    public static void log(Exception e) {
        try (PrintWriter out = new PrintWriter(new FileWriter(ERROR_LOG_FILE, true))) {
            out.printf("%s: Exception: %s%n", LocalDateTime.now(), e.getMessage());
            e.printStackTrace(out);
        } catch (IOException ignored) { }
    }
}
