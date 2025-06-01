package main.se.kth.iv1350.view;

import main.se.kth.iv1350.model.RevenueObserver;

/**
 * Template class for handling total revenue logic.
 */
public abstract class AbstractRevenueObserver implements RevenueObserver {
    private int totalIncome = 0;
    /**
     * Default constructor.
     */
    @Override
    public void onNewSale(double saleAmount) {
        calculateTotalIncome(saleAmount);
        showTotalIncome();
    }

    private void showTotalIncome() {
        try {
            doShowTotalIncome();
        } catch (Exception e) {
            handleErrors(e);
        }
    }

    protected void calculateTotalIncome(double saleAmount) {
        totalIncome += (int) saleAmount;
    }

    protected int getTotalIncome() {
        return totalIncome;
    }

    protected abstract void doShowTotalIncome() throws Exception;

    protected abstract void handleErrors(Exception e);
}
