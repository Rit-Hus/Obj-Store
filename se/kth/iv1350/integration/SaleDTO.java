package se.kth.iv1350.integration;

import java.time.LocalDate;
import java.util.ArrayList;
import se.kth.iv1350.model.Item;

/**
 * The SaleDTO class represents a completed sale with details such as the total price,
 * product amount, sale date, product name, and price per item.
 * It provides methods to access these details and update the total price.
 */
public class SaleDTO{
        private int totalPrice;
        private ArrayList<Item> items = new ArrayList<>();
        private int totalVAT;
        private java.time.LocalDate saleDate;
        private int amountPaid;

        
/**
     * Constructor for the SaleDTO. Creates a new instance of SaleDTO.
     *
     * @param totalVAT the total VAT of the sale
     * @param items the list of items sold
     * @param saleDate the date of the sale
     * @param amountPaid the amount paid by the customer
     */


        public SaleDTO(int totalVAT, ArrayList<Item> items, LocalDate saleDate, int amountPaid){
            this.items = items;
            this.totalVAT = totalVAT;
            this.saleDate = saleDate;
            this.amountPaid = amountPaid;
        }


        public ArrayList<Item> getItems(){
            return items;
        }

        public LocalDate getSaleDate(){
            return saleDate;
        }

        public int getTotalVat(){
            return totalVAT;
        }

        public int getTotalPrice(){
            return totalPrice;
        }

        public int getAmountPaid(){
            return amountPaid;
        }



}