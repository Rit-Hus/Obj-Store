<<<<<<<< HEAD:S3-FörstaSeminaruim/se/kth/iv1350/integration/ItemDTO.java
package integration;
========
package se.kth.iv1350.codestore.integration;
>>>>>>>> acc30cce604e97b45184ffb58eb6f52d40cb0a6c:S3-FörstaSeminaruim/Main/se.kth.iv1350.codestore.integration/ItemDTO.java


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
