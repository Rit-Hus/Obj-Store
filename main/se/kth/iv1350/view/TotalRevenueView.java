// src/main/java/main/se/kth/iv1350/view/TotalRevenueView.java
package main.se.kth.iv1350.view;

import main.se.kth.iv1350.observer.RevenueObserver;

/**
 * View‐layer observer that prints cumulative revenue to the console.
 */
public class TotalRevenueView implements RevenueObserver {
    private double totalRevenue = 0.0;

    public void onNewSale(double saleAmount) {
        totalRevenue += saleAmount;
        String formatted = String.format("%.2f", totalRevenue).replace('.', ',');
        System.out.println("Total revenue so far: " + formatted + " SEK");
    }
}
