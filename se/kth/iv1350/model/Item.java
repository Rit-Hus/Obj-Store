package se.kth.iv1350.model;


public class Item{

    private double price;
    private int vat;
    private int quantity;
    private int identifier;
    private String name;
    private String description;
    private Item[] items;

    public Item(double price,int vat,int quantity,int identifier, String name, String description){

        this.price = price;
        this.vat = vat;
        this.quantity = quantity;
        this.identifier = identifier;
        this.name = name;
        this.description = description;
    
    }



/*
 * These are dummy items
 */


 public void initializeItems() {
    Item banana = new Item(25, 2, 1, 1, "banana", "This is a banana in our store");
    Item apple = new Item(35, 2, 1, 2, "apple", "This is a apple in our store");
    Item pear = new Item(40, 2, 1, 3, "pear", "This is a pear in our store");
    Item orange = new Item(20, 2, 1, 4, "orange", "This is a orange in our store");

    // Store items in an array
    Item[]items = { banana, apple, pear, orange };
    this.items = items;
    
}

public static Item[] getItem(){
return items;
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

    return vat;
    
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
public int getIdentifier (){

    return identifier; 
    
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