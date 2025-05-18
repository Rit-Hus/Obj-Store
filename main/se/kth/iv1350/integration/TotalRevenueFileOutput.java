package main.se.kth.iv1350.integration;

import main.se.kth.iv1350.model.RevenueObserver;
import main.se.kth.iv1350.util.FileLogger;


/**
 * The TotalRevenueFileOutput class implements the RevenueObserver interface and
 * is responsible for logging the cumulative revenue to a file. It updates the
 * total revenue whenever a new sale occurs and formats the output to two decimal
 * places, replacing the decimal point with a comma.
 */
public class TotalRevenueFileOutput implements RevenueObserver {
    private double totalRevenue = 0.0;


    /**
     * This method is called whenever a new sale occurs. It updates the total
     * revenue and logs the cumulative revenue to a file.
     *
     * @param saleAmount The amount of the new sale.
     */
    public void onNewSale(double saleAmount) {
        totalRevenue += saleAmount;
        String formatted = String.format("%.2f", totalRevenue).replace('.', ',');
        FileLogger.log("Cumulative revenue: " + formatted + " SEK");
    }
}
