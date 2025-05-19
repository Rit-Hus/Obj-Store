package test.se.kth.iv1350.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.se.kth.iv1350.model.DiscountStrategy;
import main.se.kth.iv1350.model.NoDiscountStrategy;
import main.se.kth.iv1350.model.BulkDiscountStrategy;


/**
 * This class contains tests for the DiscountStrategy class and its implementations.
 * It verifies the behavior of different discount strategies.
 */
public class DiscountStrategyTest {


    /**
     * Tests the NoDiscountStrategy class to ensure it applies the full price without any discount.
     * It verifies that the applyDiscount method returns the correct total price.
     */
    @Test
    public void noDiscountStrategy_appliesFullPrice() {
        DiscountStrategy strat = new NoDiscountStrategy();
        double price    = 20.0;
        int    quantity = 5;
        double expected = price * quantity;
        assertEquals("NoDiscountStrategy should return price × quantity",
                     expected, strat.applyDiscount(price, quantity), 1e-3);
    }


    /**
     * Tests the BulkDiscountStrategy class to ensure it applies a discount when the quantity exceeds a threshold.
     * It verifies that the applyDiscount method returns the correct total price with the discount applied.
     */
    @Test
    public void bulkDiscountStrategy_belowThreshold_noDiscount() {
        int    threshold = 10;
        double rate      = 0.10;
        DiscountStrategy strat = new BulkDiscountStrategy(threshold, rate);

        double price    = 15.0;
        int    quantity = threshold; 
        double expected = price * quantity;
        assertEquals("BulkDiscountStrategy should not discount at or below threshold",
                     expected, strat.applyDiscount(price, quantity), 1e-3);
    }

    /**
     * Tests the BulkDiscountStrategy class to ensure it applies a discount when the quantity exceeds a threshold.
     * It verifies that the applyDiscount method returns the correct total price with the discount applied.
     */
    @Test
    public void bulkDiscountStrategy_aboveThreshold_appliesDiscount() {
        int    threshold = 10;
        double rate      = 0.10;
        DiscountStrategy strat = new BulkDiscountStrategy(threshold, rate);

        double price    = 10.0;
        int    quantity = 12;  
        double expected = price * quantity * (1.0 - rate);
        assertEquals("BulkDiscountStrategy should discount when quantity exceeds threshold",
                     expected, strat.applyDiscount(price, quantity), 1e-3);
    }
}
