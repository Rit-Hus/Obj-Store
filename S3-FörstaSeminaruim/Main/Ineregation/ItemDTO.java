package Ineregation;


public class ItemDTO {
    /*These are the attributes of ItemDTO */
private double price;
private int vat;
private int quantity;
private int identifier;
private String name;
private String description;

public ItemDTO( double price,int vat,int quantity,int identifier, String name, String description){

this.price = price;
this.vat = vat;
this.quantity = quantity;
this.identifier = identifier;
this.name = name;
this.description = description;



}
/* These are getters which helps to keep ItemDTO well encapsulated */
public double getPrice(){

    return price;
}




public int getVat (){

    return vat;
    
}

public int getQuantity (){

    return quantity;
    
}


public int getIdentifier (){

    return identifier; 
    
}



public String getName(){

    return name;
    
}



public String getDescription(){

    return  description;
    
}


}
