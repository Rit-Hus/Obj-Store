// src/main/java/main/se/kth/iv1350/integration/ItemNotFoundException.java
package main.se.kth.iv1350.integration;

/**
 * Thrown when the requested item identifier does not exist.
 */
public class ItemNotFoundException extends Exception {
    public ItemNotFoundException(String itemID) {
        super("Item not found: " + itemID);
    }
}
