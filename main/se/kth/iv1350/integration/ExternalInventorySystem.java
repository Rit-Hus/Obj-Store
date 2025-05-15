// src/main/java/main/se/kth/iv1350/integration/ExternalInventorySystem.java
package main.se.kth.iv1350.integration;

import java.util.ArrayList;
import java.util.List;


/**
 * Singleton ExternalInventorySystem: holds a catalog of ItemDTO templates
 * and serves fresh copies with requested quantities.
 */
public class ExternalInventorySystem {
    // Eager‐initialized singleton instance
    private static final ExternalInventorySystem INSTANCE = new ExternalInventorySystem();

    /** Use getInstance() to obtain the sole ExternalInventorySystem. */
    public static ExternalInventorySystem getInstance() {
        return INSTANCE;
    }

    private final List<ItemDTO> catalog = new ArrayList<>();

    // Private constructor prevents any other instantiation
    private ExternalInventorySystem() {
        catalog.add(new ItemDTO(
            29.90, 6, 0,
            "abc123", "BigWheel Oatmeal",
            "BigWheel Oatmeal 500g, whole grain oats, high fiber, gluten free"
        ));
        catalog.add(new ItemDTO(
            14.90, 6, 0,
            "def456", "YouGoGo Blueberry",
            "YouGoGo Blueberry 240g, low sugar yoghurt, blueberry flavour"
        ));
    }

    /**
     * Fetches a new ItemDTO for the given ID and quantity,
     * or throws if not found or on simulated database failure.
     */
    public ItemDTO fetchItemDTO(String itemID, int quantity)
            throws ItemNotFoundException, InventoryAccessException {
        if ("dbError".equals(itemID)) {
            throw new InventoryAccessException("Simulated database failure for: " + itemID);
        }

        for (ItemDTO template : catalog) {
            if (template.getIdentifier().equals(itemID)) {
                return new ItemDTO(
                    template.getPrice(),
                    template.getVat(),
                    quantity,
                    template.getIdentifier(),
                    template.getName(),
                    template.getDescription()
                );
            }
        }
        throw new ItemNotFoundException("Item not found: " + itemID);
    }
}
