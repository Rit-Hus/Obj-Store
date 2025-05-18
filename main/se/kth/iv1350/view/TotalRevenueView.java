package main.se.kth.iv1350.view;

import main.se.kth.iv1350.model.RevenueObserver;

/**
 * The TotalRevenueView class implements the RevenueObserver interface and
 * displays the total revenue in the console whenever a new sale is made.
 */
public class TotalRevenueView implements RevenueObserver {
    private double totalRevenue = 0.0;


    /**
     * This method is called whenever a new sale occurs. It updates the total
     * revenue and displays the cumulative revenue in the console.
     *
     * @param saleAmount The amount of the new sale.
     */
    public void onNewSale(double saleAmount) {
        totalRevenue += saleAmount;
        String formatted = String.format("%.2f", totalRevenue).replace('.', ',');
        System.out.println("Total revenue so far: " + formatted + " SEK");
    }
}
