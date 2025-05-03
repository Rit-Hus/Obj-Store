package se.kth.iv1350.model;

import java.time.LocalDate;
import java.util.ArrayList;
import se.kth.iv1350.integration.SaleDTO;

public class Sale {

    private LocalDate saleDate;
    private double totalAmount;
    private int VAT;  // Assuming VAT is set somewhere
    private ArrayList<Item> items = new ArrayList<>();

    public Sale(){
        saleDate = LocalDate.now();
    }

    // Updates the totalAmount based on the scanned items
    public void updateTotal(){
        totalAmount = 0; // Reset totalAmount
        for(Item item : items){
            totalAmount += item.getQuantity() * item.getPrice() * item.getVat();  // Calculate total including VAT
        }
        System.out.println("The Total is now: " + totalAmount);  // For debugging purposes
    }

    // Scan the items and add them to the sale
    public void scanItems(ArrayList<Item> items){
        for(Item item : items){
            if(isScanned(item.getItemID())){
                item.incrementQuantity();  // If item exists, increment its quantity
            } else {
                this.items.add(item);  // Otherwise, add the new item
            }
        }
        updateTotal();  // Update the total amount after scanning
    }

    // Check if the item is already in the sale
    public boolean isScanned(String itemID){
        for(Item item : items){
            if(item.getItemID().equals(itemID)){
                return true;
            }
        }
        return false;
    }

    // Create a SaleDTO with the current sale data
    public SaleDTO createSaleDTO(int amountPaid){
        return new SaleDTO(VAT, items, saleDate, amountPaid,(int) totalAmount);  // Pass totalAmount to SaleDTO
    }

    // Getter for totalAmount (in case you need it elsewhere)
    public double getTotalAmount() {
        return totalAmount;
    }

    // Getter for saleDate (in case you need it elsewhere)
    public LocalDate getSaleDate() {
        return saleDate;
    }

    // Getter for items
    public ArrayList<Item> getItems() {
        return items;
    }
}
