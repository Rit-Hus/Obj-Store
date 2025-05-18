package main.se.kth.iv1350.model;

/**
 * The Discount class represents a discount that can be applied to an item or a
 * sale. It contains information about the discount percentage and the reason for
 * the discount.
 */
public class Item {
    private double price;
    private double vat;
    private int quantity;
    private String itemID;
    private String name;
    private String description;


    /**
     * Constructs an Item object with the specified parameters.
     *
     * @param price       The price of the item.
     * @param vat         The VAT of the item.
     * @param quantity    The quantity of the item.
     * @param itemID      The identifier of the item.
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
     * Gets the price of the item.
     *
     * @return The price of the item.
     */
    public double getPrice() {
        return price;
    }

/**
     * Gets the VAT of the item.
     *
     * @return The VAT of the item.
     */

    public double getVat() {
        return vat;
    }



    /**
     * Gets the quantity of the item.
     *
     * @return The quantity of the item.
     */
    public int getQuantity() {
        return quantity;
    }


    /**
     * Gets the identifier of the item.
     *
     * @return The identifier of the item.
     */
    public String getItemID() {
        return itemID;
    }


    /**
     * Gets the name of the item.
     *
     * @return The name of the item.
     */
    public String getName() {
        return name;
    }

 
    /**
     * Gets the description of the item.
     *
     * @return The description of the item.
     */
    public String getDescription() {
        return description;
    }


    /**
     * Sets the quantity of the item.
     *
     * @param quantity The new quantity of the item.
     */
    public void incrementQuantity() {
        this.quantity++;
    }
}