// src/main/java/main/se/kth/iv1350/observer/RevenueObserver.java
package main.se.kth.iv1350.observer;

/**
 * Observer interface for tracking total revenue.
 */
public interface RevenueObserver {
    /**
     * Called after each completed sale with that sale’s total amount.
     * @param saleAmount the total of the sale just completed
     */
    void onNewSale(double saleAmount);
}
