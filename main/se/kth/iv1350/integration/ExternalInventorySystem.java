package main.se.kth.iv1350.integration;

import java.util.ArrayList;
import java.util.List;
import main.se.kth.iv1350.model.Item;

/**
 * Provides item data. Holds a list of available items and returns
 * fresh copies with requested quantities.
 */
public class ExternalInventorySystem {
    private List<Item> items = new ArrayList<>();

    public ExternalInventorySystem() {
        items.add(new Item(
            29.90, 6.0, 0,
            "abc123", "BigWheel Oatmeal",
            "BigWheel Oatmeal 500g, whole grain oats, high fiber, gluten free"
        ));
        items.add(new Item(
            14.90, 6.0, 0,
            "def456", "YouGoGo Blueberry",
            "YouGoGo Blueberry 240g, low sugar yoghurt, blueberry flavour"
        ));
    }

    /**
     * Returns a fresh Item copy with the requested quantity.
     * Returns null if no matching ID is found.
     */
    public Item fetchItem(String itemID, int quantity) {
        for (Item template : items) {
            if (template.getItemID().equals(itemID)) {
                return new Item(
                    template.getPrice(),
                    template.getVat(),
                    quantity,
                    template.getItemID(),
                    template.getName(),
                    template.getDescription()
                );
            }
        }
        return null;
    }
}
