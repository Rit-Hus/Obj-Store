// src/main/java/main/se/kth/iv1350/integration/ExternalInventorySystem.java
package main.se.kth.iv1350.integration;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds a catalog of ItemDTO templates and serves fresh copies
 * with requested quantities—or throws exceptions on errors.
 */
public class ExternalInventorySystem {
    private final List<ItemDTO> items = new ArrayList<>();

    public ExternalInventorySystem() {
        items.add(new ItemDTO(
            29.90, 6, 0,
            "abc123", "BigWheel Oatmeal",
            "BigWheel Oatmeal 500g, whole grain oats, high fiber, gluten free"
        ));
        items.add(new ItemDTO(
            14.90, 6, 0,
            "def456", "YouGoGo Blueberry",
            "YouGoGo Blueberry 240g, low sugar yoghurt, blueberry flavour"
        ));
    }

    /**
     * @param itemID   The identifier to look up.
     * @param quantity The requested quantity.
     * @return A fresh ItemDTO copy.
     * @throws InventoryAccessException If itemID equals "dbError".
     * @throws ItemNotFoundException    If no matching ID is found.
     */
    public ItemDTO fetchItemDTO(String itemID, int quantity)
            throws InventoryAccessException, ItemNotFoundException {

        // Simulate a database failure for this special ID
        if ("dbError".equals(itemID)) {
            throw new InventoryAccessException(itemID,
                new RuntimeException("Simulated connection failure"));
        }

        // Normal lookup
        for (ItemDTO template : items) {
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

        // Not found → exception
        throw new ItemNotFoundException(itemID);
    }
}
