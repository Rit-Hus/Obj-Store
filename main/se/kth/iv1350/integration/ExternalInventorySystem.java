package main.se.kth.iv1350.integration;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds a catalog of ItemDTO templates and serves fresh copies
 * with requested quantities.
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
     * Fetches a new ItemDTO for the given ID and quantity,
     * or returns null if not found.
     */
    public ItemDTO fetchItemDTO(String itemID, int quantity) {
        for (ItemDTO itemDTO : items) {
            if (itemDTO.getIdentifier().equals(itemID)) {
                return new ItemDTO(
                    itemDTO.getPrice(),
                    itemDTO.getVat(),
                    quantity,
                    itemDTO.getIdentifier(),
                    itemDTO.getName(),
                    itemDTO.getDescription()
                );
            }
        }
        return null;
    }
}
