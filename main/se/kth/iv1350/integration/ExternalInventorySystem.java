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
     * Fetches an item template with the specified quantity.
     *
     * @param itemID The identifier of the item to fetch.
     * @param quantity The quantity of the item to include in the returned template.
     * @return A new ItemDTO object with the specified quantity, or null if the item is not found.
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
