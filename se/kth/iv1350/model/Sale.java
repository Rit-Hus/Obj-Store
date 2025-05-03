package se.kth.iv1350.model;

import java.time.LocalDate;
import java.util.ArrayList;
public class Sale {

    private LocalDate saleDate;
    private double  totalAmount;
    private int VAT;
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Item> scannedItems = new ArrayList<>();


    public Sale(){
        saleDate = LocalDate.now();
    }


    public void updateTotal(){
        totalAmount = 0;

        for(Item item : items){
            totalAmount += item.getQuantity() * item.getPrice() * item.getVat();
        }
        
        System.out.println("The Total is now:" + totalAmount);
    }


    public void uppdateTotal() {
        totalAmount = 0;
        for (Item item : items) {
            totalAmount += item.getQuantity() * item.getPrice() * item.getVat();
            // VAT = items.getVAT()*items.getItemPrice()*items.getQuantity()
            totalAmount = this.totalAmount;

        }

    }

   public void scanItems(ArrayList<Item> items){
    for(Item item : items){

        if(isScanned(item.getItemID())){
            item.incrementQuantity();
        }
    }

    updateTotal();
    
   }

   public boolean isScanned(String itemID){
    for(Item item : items){
        if(item.getItemID().equals(itemID)){
            return true;
        }
    }
    return false;

   }





}