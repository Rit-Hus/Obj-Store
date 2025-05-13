package main.se.kth.iv1350.integration;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds a catalog of ItemDTO templates and serves fresh copies
 * with requested quantities.
 */
public class ExternalInventorySystem {
    private final List<ItemDTO> catalog = new ArrayList<>();

    public ExternalInventorySystem() {
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
     * or returns null if not found.
     */
    public ItemDTO fetchItemDTO(String itemID, int quantity) {
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
        return null;
    }
}
