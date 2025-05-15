package main.se.kth.iv1350.integration;

/**
 * Thrown when the inventory system experiences a simulated database failure.
 */
public class InventoryAccessException extends Exception {
    /** Single‐arg constructor so you can throw by message only */
    public InventoryAccessException(String message) {
        super(message);
    }

    /** Two‐arg constructor if you want to wrap a cause later */
    public InventoryAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
