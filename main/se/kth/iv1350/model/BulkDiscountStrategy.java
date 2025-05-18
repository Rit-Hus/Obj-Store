package main.se.kth.iv1350.model;

/**
 * Bulk discount: if you buy more than a threshold, you get a percentage off the entire line.
 */
public class BulkDiscountStrategy implements DiscountStrategy {
    private final int threshold;
    private final double discountRate;

    /**
     * @param threshold    Minimum quantity to qualify.
     * @param discountRate Fractional discount (e.g. 0.05 for 5% off).
     */
    public BulkDiscountStrategy(int threshold, double discountRate) {
        this.threshold    = threshold;
        this.discountRate = discountRate;
    }


    /**
     * Applies the bulk discount to the total price based on the quantity purchased.
     *
     * @param basePrice The base price of the item.
     * @param quantity  The quantity of items purchased.
     * @return The total price after applying the discount, if applicable.
     */
    public double applyDiscount(double basePrice, int quantity) {
        double total = basePrice * quantity;
        if (quantity > threshold) {
            total *= (1 - discountRate);
        }
        return total;
    }
}
