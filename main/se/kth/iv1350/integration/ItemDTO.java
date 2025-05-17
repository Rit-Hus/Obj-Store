package main.se.kth.iv1350.integration;

public class ItemDTO {

private double price;
private int VAT;
private int quantity;
private String itemID;
private String name;
private String description;






public ItemDTO( double price,int vat,int quantity,String itemID, String name, String description){

this.price = price;
this.VAT = vat;
this.quantity = quantity;
this.itemID = itemID;
this.name = name;
this.description = description;



}






public double getPrice(){

    return price;
}



public int getVat (){

    return VAT;
    
}


public int getQuantity (){

    return quantity;
    
}


public String getIdentifier (){

    return itemID; 
    
}



public String getName(){

    return name;
    
}



public String getDescription(){

    return  description;
    
}
}