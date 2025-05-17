package main.se.kth.iv1350.integration;

/**
 * Thrown when the inventory system experiences a simulated database failure.
 */
public class InventoryAccessException extends Exception {

    public InventoryAccessException(String message) {
        super(message);
    }

    public InventoryAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
