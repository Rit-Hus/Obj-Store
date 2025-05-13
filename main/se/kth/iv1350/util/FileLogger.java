// src/main/java/main/se/kth/iv1350/util/FileLogger.java
package main.se.kth.iv1350.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Simple file logger for exception stack traces.
 */
public class FileLogger {
    private PrintWriter logStream;

    public FileLogger() {
        try {
            logStream = new PrintWriter(new FileWriter("log.txt"), true);
        } catch (IOException ioe) {
            System.out.println("CAN NOT LOG.");
            ioe.printStackTrace();
        }
    }

    public void log(String msg, Exception e) {
        if (logStream != null) {
            logStream.println(msg);
            e.printStackTrace(logStream);
        }
    }
}
