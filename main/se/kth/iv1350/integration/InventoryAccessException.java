package main.se.kth.iv1350.integration;

/**
 * Thrown when the inventory system experiences a simulated database failure.
 */
public class InventoryAccessException extends Exception {

    /**
     * Creates a new instance of <code>InventoryAccessException</code> without detail
     * message.
     */
    public InventoryAccessException(String message) {
        super(message);
    }


    /**
     * Constructs an instance of <code>InventoryAccessException</code> with the
     * specified detail message and cause.
     *
     * @param message The detail message.
     * @param cause   The cause of the exception.
     */
    public InventoryAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
