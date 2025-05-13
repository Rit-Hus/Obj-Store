// src/main/java/main/se/kth/iv1350/integration/InventoryAccessException.java
package main.se.kth.iv1350.integration;

/**
 * Thrown when the inventory system cannot be accessed
 * (simulated database failure).
 */
public class InventoryAccessException extends Exception {
    public InventoryAccessException(String itemID, Throwable cause) {
        super("Inventory access failure for item: " + itemID, cause);
    }
}
