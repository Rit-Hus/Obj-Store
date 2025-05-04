package main.se.kth.iv1350.model;

/**
 * The Item class represents an item in the sale. It contains information about the
 * item's price, VAT, quantity, item ID, name, and description.
 */
public class Item {
    private double price;
    private double vat;
    private int quantity;
    private String itemID;
    private String name;
    private String description;

    /**
     * Creates a new instance of Item with the specified parameters.
     *
     * @param price       The price of the item.
     * @param vat         The VAT of the item.
     * @param quantity    The quantity of the item.
     * @param itemID      The ID of the item.
     * @param name        The name of the item.
     * @param description A description of the item.
     */

    public Item(double price, double vat, int quantity, String itemID, String name, String description) {
        this.price = price;
        this.vat = vat;
        this.quantity = quantity;
        this.itemID = itemID;
        this.name = name;
        this.description = description;
    }


    /**
     * Returns the price of the item.
     *
     * @return The price of the item.
     */
        
    public double getPrice() {
        return price;
    }
/**
     * Returns the VAT of the item.
     *
     * @return The VAT of the item.
     */
    public double getVat() {
        return vat;
    }

    /**
     * Returns the quantity of the item.
     *
     * @return The quantity of the item.
     */
    public int getQuantity() {
        return quantity;
    }
/**
     * Returns the ID of the item.
     *
     * @return The ID of the item.
     */
    public String getItemID() {
        return itemID;
    }


    /**
     * Returns the name of the item.
     *
     * @return The name of the item.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the description of the item.
     *
     * @return The description of the item.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the total price of the item, including VAT.
     *
     * @return The total price of the item, including VAT.
     */
    public void incrementQuantity() {
        this.quantity++;
    }
}