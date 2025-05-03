package se.kth.iv1350.model;


public class Item{

    private double price;
    private int vat;
    private int quantity;
    private int identifier;
    private String name;
    private String description;


    public Item(double price,int vat,int quantity,int identifier, String name, String description){

        this.price = price;
        this.vat = vat;
        this.quantity = quantity;
        this.identifier = identifier;
        this.name = name;
        this.description = description;
    
    
    
    
    }

}