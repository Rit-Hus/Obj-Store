package se.kth.iv1350.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Sale {

    private LocalDate saleDate;
    private double  totalAmount;
    private int VAT;
    private ArrayList<Item> items = new ArrayList<>();


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




}