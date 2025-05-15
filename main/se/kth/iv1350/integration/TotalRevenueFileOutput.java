package main.se.kth.iv1350.integration;

import main.se.kth.iv1350.observer.RevenueObserver;
import main.se.kth.iv1350.util.FileLogger;

/**
 * Integration‐layer observer that logs cumulative revenue to a file.
 */
public class TotalRevenueFileOutput implements RevenueObserver {
    private double totalRevenue = 0.0;

    public void onNewSale(double saleAmount) {
        totalRevenue += saleAmount;
        String formatted = String.format("%.2f", totalRevenue).replace('.', ',');
        // Log the revenue message (goes to revenue.log)
        FileLogger.log("Cumulative revenue: " + formatted + " SEK");
    }
}
