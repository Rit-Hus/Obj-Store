package se.kth.iv1350.integration;

import se.kth.iv1350.integration.ItemDTO.Node;
import se.kth.iv1350.model.Item;
public class ItemDTO {
    /**
     * The ItemDTO class represents an item with its details such as price, VAT,
     * quantity, identifier, name, and description.
     * It provides methods to access these details.
     */
private double price;
private int vat;
private int quantity;
private int identifier;
private String name;
private String description;
private ItemDTO next;



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
public ItemDTO( double price,int vat,int quantity,int identifier, String name, String description){

this.price = price;
this.vat = vat;
this.quantity = quantity;
this.identifier = identifier;
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


public ItemDTO createItemDTO(Item item){
    price = item.getPrice();
    description = item.getDescription();
    vat = item.getVat();
    name = item.getName();
    quantity = item.getQuantity();
    identifier = item.getIdentifier();
    
    ItemDTO itemdto = new ItemDTO(price,vat,quantity,identifier,name,description);
    return itemdto;


}


    public class Node {
       public ItemDTO item;
       public  Node next;

        Node(ItemDTO item) {
            this.item = item;
            this.next = null;
        }

        
   

    }

   
    private Node first;

   
    public void add(ItemDTO item) {
        Node newNode = new Node(item);

        if (first == null) {
            first = newNode;
        } else {
            Node current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    
     public Node getfirst() {
        return first;
    }

    public Node getNext() {
        return first.next;
    }

}
