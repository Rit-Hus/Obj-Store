package main.se.kth.iv1350.integration;


public class ItemNotFoundException extends Exception {
    public ItemNotFoundException(String itemID) {
        super("Item not found: " + itemID);
    }
}
