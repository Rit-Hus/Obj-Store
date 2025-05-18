package main.se.kth.iv1350.integration;
/**
 * The ItemDTO class represents a Data Transfer Object (DTO) for an item in the
 * inventory system. It contains information about the item's price, VAT, quantity,
 * identifier, name, and description.
 */
public class ItemDTO {

private double price;
private int VAT;
private int quantity;
private String itemID;
private String name;
private String description;




/**
 * Constructs an ItemDTO object with the specified parameters.
 *
 * @param price       The price of the item.
 * @param vat         The VAT of the item.
 * @param quantity    The quantity of the item.
 * @param itemID      The identifier of the item.
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




/**
 * Gets the price of the item.
 *
 * @return The price of the item.
 */

public double getPrice(){

    return price;
}


/**
 * Gets the VAT of the item.
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
 * Gets the identifier of the item.
 *
 * @return The identifier of the item.
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