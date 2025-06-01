package main.se.kth.iv1350.integration;

public class ItemDTO {
    /**
     * The ItemDTO class represents an item with its details such as price, VAT,
     * quantity, identifier, name, and description.
     * It provides methods to access these details.
     */
private double price;
private int VAT;
private int quantity;
private String itemID;
private String name;
private String description;




/**
 * Creates a new {@code ItemDTO}, which represents an item with its details.
 *
 * @param price       The price of the item.
 * @param vat         The VAT (Value Added Tax) of the item.
 * @param quantity    The quantity of the item.
 * @param identifier  The unique identifier of the item.
 * @param name        The name of the item.
 * @param description A description of the item.
 */
public ItemDTO( double price,int vat,int quantity,String itemID, String name, String description){

this.price = price;
this.VAT = vat;
this.quantity = quantity;
this.itemID = itemID;
this.name = name;
this.description = description;



}








/* These are getters which helps to keep ItemDTO well encapsulated */

/**
 * Gets the price of the item.
 *
 * @return The price of the item.
 */
public double getPrice(){

    return price;
}



/**
 * Gets the VAT (Value Added Tax) of the item.
 *
 * @return The VAT of the item.
 */
public int getVat (){

    return VAT;
    
}

/**
 * Gets the quantity of the item.
 *
 * @return The quantity of the item.
 */
public int getQuantity (){

    return quantity;
    
}

/**
 * Gets the unique identifier of the item.
 *
 * @return The unique identifier of the item.
 */
public String getIdentifier (){

    return itemID; 
    
}


/**
 * Gets the name of the item.
 *
 * @return The name of the item.
 */
public String getName(){

    return name;
    
}


/**
 * Gets the description of the item.
 *
 * @return The description of the item.
 */
public String getDescription(){

    return  description;
    
}
}