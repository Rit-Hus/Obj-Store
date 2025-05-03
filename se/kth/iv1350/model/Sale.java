package se.kth.iv1350.model;

import java.time.LocalDate;
import java.util.ArrayList;
import se.kth.iv1350.integration.SaleDTO;

public class Sale {

    private LocalDate saleDate;
    private double totalAmount;
    private int totalVAT;  // Correctly track the VAT
    private ArrayList<Item> items = new ArrayList<>();

    public Sale(){
        saleDate = LocalDate.now();
    }

    /**
     * Update the total amount of the sale and calculate the VAT for all items.
     */
    public void updateTotal(){
        totalAmount = 0;
        totalVAT = 0;

        // Calculate total price and VAT
        for(Item item : items){
            double itemTotal = item.getQuantity() * item.getPrice();  // Price * Quantity for the item
            totalAmount += itemTotal;  // Add to the total amount

            // Calculate VAT for this item and accumulate it
            totalVAT += (int) (itemTotal * (item.getVat() / 100));  // VAT as a percentage
        }

        System.out.println("The Total is now: " + totalAmount);
        System.out.println("Total VAT: " + totalVAT);  // Debugging VAT for checking
    }

    public void scanItems(ArrayList<Item> items){
        for(Item item : items){
            if(isScanned(item.getItemID())){
                item.incrementQuantity();
            } else {
                this.items.add(item);
            }
        }
        updateTotal();  // Update total amount and VAT after scanning
    }

    public boolean isScanned(String itemID){
        for(Item item : items){
            if(item.getItemID().equals(itemID)){
                return true;
            }
        }
        return false;
    }

    public SaleDTO createSaleDTO(int amountPaid){
        return new SaleDTO(totalVAT, items, saleDate, amountPaid, (int) totalAmount);
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
