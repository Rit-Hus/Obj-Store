package main.se.kth.iv1350.integration;

import main.se.kth.iv1350.model.RevenueObserver;
import main.se.kth.iv1350.util.FileLogger;


public class TotalRevenueFileOutput implements RevenueObserver {
    private double totalRevenue = 0.0;

    public void onNewSale(double saleAmount) {
        totalRevenue += saleAmount;
        String formatted = String.format("%.2f", totalRevenue).replace('.', ',');
        FileLogger.log("Cumulative revenue: " + formatted + " SEK");
    }
}
