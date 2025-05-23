package se.kth.iv1350.model;

import java.time.LocalDate;
import se.kth.iv1350.integration.ItemDTO;
import se.kth.iv1350.integration.SaleDTO;

public class Sale {
    private final  java.time.LocalDate saleDate;
    private se.kth.iv1350.integration.ItemDTO ItemDTO;
    private ItemDTO[] scannedcart;
    private double  totalAmount;
    private ItemDTO.Node first;
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
     
    
    public void scanitems(ItemDTO item){

    ItemDTO.add(item);


    }

    /**
     * Adds an items to the itemDTO list
     * @param ItemDTO the ID of the item to add
     */
     // Head of the linked list
     
    public void addItemsTolist() {
        int count = 0;
        ItemDTO.Node current = first;
        ItemDTO.Node next = ItemDTO.getNext();
        // Count nodes
        while (current != null) {
            count++;
            current = current.next;
        }

        // Populate array
        ItemDTO[] items = new ItemDTO[count];
        current = first;
        int i = 0;

        while (current != null) {
            items[i++] = current.item;
            current = current.next;
        }

        this.scannedcart =items;
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

    public SaleDTO endsSale() {
    return new SaleDTO(saleDate,scannedcart);
    }
 
  
   
 //skapa item class

}
