package main.se.kth.iv1350.model;

/**
 * No discount: simply multiplies price × quantity.
 */
public class NoDiscountStrategy implements DiscountStrategy {
    /**
     * Applies no discount to the base price.
     *
     * @param basePrice The base price of the item.
     * @param quantity  The quantity of the item.
     * @return The total price without any discount applied.
     */
    public double applyDiscount(double basePrice, int quantity) {
        return basePrice * quantity;
    }
}
