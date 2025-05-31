package main.se.kth.iv1350.view;

/**
 * Displays total revenue to the console.
 */
public class TotalRevenueView extends AbstractRevenueObserver {

    @Override
    protected void doShowTotalIncome() {
        System.out.println(">>> Total revenue so far: " + getTotalIncome() + " SEK");
    }

    @Override
    protected void handleErrors(Exception e) {
        System.err.println(">>> Could not display total revenue: " + e.getMessage());
    }
}
