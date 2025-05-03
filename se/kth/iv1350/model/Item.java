package se.kth.iv1350.model;


public class Item {

    private double price;
    private double vat;  // VAT as a percentage (e.g., 20 for 20% VAT)
    private int quantity;
    private String itemID;
    private String name;
    private String description;

    public Item(double price, double vat, int quantity, String itemID, String name, String description) {
        this.price = price;
        this.vat = vat;  // Ensure VAT is passed as a decimal (e.g., 0.2 for 20%)
        this.quantity = quantity;
        this.itemID = itemID;
        this.name = name;
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public double getVat() {
        return vat;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getItemID() {
        return itemID;
    }

    public void incrementQuantity() {
        this.quantity++;
    }
}
