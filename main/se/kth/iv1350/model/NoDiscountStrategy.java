package main.se.kth.iv1350.model;

/**
 * No discount: simply multiplies price × quantity.
 */
public class NoDiscountStrategy implements DiscountStrategy {

    public double applyDiscount(double basePrice, int quantity) {
        return basePrice * quantity;
    }
}
