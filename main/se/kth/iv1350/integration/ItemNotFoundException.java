package main.se.kth.iv1350.integration;

/**
 * The ItemNotFoundException class is a custom exception that is thrown when an
 * item is not found in the inventory system. It extends the Exception class and
 * provides a constructor that takes the item ID as a parameter.
 */
public class ItemNotFoundException extends Exception {

    /**
     * Constructs a new ItemNotFoundException with the specified item ID.
     *
     * @param itemID The ID of the item that was not found.
     */
    public ItemNotFoundException(String itemID) {
        super(itemID);
    }
}
