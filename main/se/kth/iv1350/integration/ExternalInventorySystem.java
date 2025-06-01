package main.se.kth.iv1350.integration;

import java.util.ArrayList;
import java.util.List;


public class ExternalInventorySystem {
    private static final ExternalInventorySystem INSTANCE = new ExternalInventorySystem();

    public static ExternalInventorySystem getInstance() {
        return INSTANCE;
    }

    private final List<ItemDTO> catalog = new ArrayList<>();

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
 * Fetches an ItemDTO from the inventory system based on the item ID and quantity.
 *
 * @param itemID The unique identifier for the item.
 * @param quantity The quantity of the item to fetch.
 * @return An ItemDTO containing the item's details.
 * @throws ItemNotFoundException If the item with the specified ID does not exist.
 * @throws InventoryAccessException If there is an error accessing the inventory system.
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
