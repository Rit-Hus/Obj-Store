package se.kth.iv1350.model;

import java.time.LocalDate;
import java.util.ArrayList;

import se.kth.iv1350.integration.ExternalInventorySystem;
import se.kth.iv1350.integration.ItemDTO;
import se.kth.iv1350.integration.SaleDTO;

public class Sale {
    private final  java.time.LocalDate saleDate;
    private se.kth.iv1350.integration.ItemDTO ItemDTO;
    private ItemDTO[] scannedcart;
    private double  totalAmount;
    /**
    private double  VAT;
    // private ExternalInventorySystem EI; bra att ha
   // private ArrayList<Item> items = new ArrayList<>(); behövs inte i våran sitation
    
     * Constructor for creating a new Sale object
     */
    public Sale() {
        this.saleDate = LocalDate.now();

    }

    /**
     * Returns the total amount for the sale
     * @return the total amount for the sale
     */


    public double getToTalAmount() {
        return this.totalAmount;
    }


    /**
     * Adds an item to the itemDTO
     * @param ItemDTO the ID of the item to add
     */
    public void addItems(ItemDTO cart){
      int counter =0;
     while (!.next ==null) { 
           counter++;
     }
     
     ItemDTO[] scanneditems= new ItemDTO[counter];
     counter=0;
     for(ItemDTO item: scanneditems ){
      scanneditems[counter++]=.next;
      .next.next;

     }

     this.scannedcart=scanneditems;
      //add the list where the saleDTO is created
      //SaleDTO.updateDTOlist(scanneditems);

    }
    /**
     * Checks if an item has been scanned
     * @param ItemDTO the ID of the item to check
     * @return true if the item has been scanned, otherwise false
     */

    public boolean isScanned(ItemDTO item) {
       int counter = 0;
       for(ItemDTO scan:this.scannedcart){
         if(item ==this.scannedcart[counter++]){
            return true;
         }
       }
       return false;
        
    }
    /**
     * Ends the sale and generates a Receipt object
     * @param saleDTO the SaleDTO object containing information about the sale
     * @param payment the Payment object containing information about the payment
     * @return a Receipt object containing information about the sale and payment
     */

    public Receipt endsSale(SaleDTO saleDTO, Payment payment) {
        return new Receipt(saleDTO, payment);
    }
 
     /**
     * Returns a SaleDTO object with information about the sale
     * @return a SaleDTO object with information about the sale
     */
    public SaleDTO getSaleDTO() {
        SaleDTO currentSale = new SaleDTO(this.VAT, this.items, this.saleDate, this.totalAmount);
        return currentSale;
    }
   


}
