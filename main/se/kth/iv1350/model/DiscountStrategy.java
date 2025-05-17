package main.se.kth.iv1350.model;

/**
 * Strategy interface for computing item discounts.
 */
public interface DiscountStrategy {
    /**
     * Compute the discounted total price for a given base price and quantity.
     *
     * @param basePrice The unit price before discount.
     * @param quantity  The number of units.
     * @return The line‐item total after discount (pre‐VAT).
     */
    double applyDiscount(double basePrice, int quantity);
}
