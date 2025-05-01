package se.kth.iv1350.integration;

/**
 * The SaleDTO class represents a completed sale with details such as the total price,
 * product amount, sale date, product name, and price per item.
 * It provides methods to access these details and update the total price.
 */
public class SaleDTO{
    private double priceTotal;
private int productAmount;
private int saleDate;
private double pricePerItem;
private String  productName;
private ItemDTO itemDTOList[];

/**
 * Creates a new {@code SaleDTO}, which represents a completed sale.
 *
 * @param priceTotal The total price of the sale.
 * @param productAmount The number of products sold.
 * @param saleDate The date of the sale (e.g., as an integer timestamp or formatted value).
 * @param productName The name of the sold product.
 * @param pricePerItem The price per single item.
 */


/**
 * Constructor for the SaleDTO class. Initializes the sale details.
 *
 * @param priceTotal   The total price of the sale.
 * @param productAmount The number of products sold.
 * @param saleDate     The date of the sale.
 * @param productName  The name of the product sold.
 * @param pricePerItem The price per item sold.
 * @param itemDTOs     An array of ItemDTO objects representing the items sold in the sale.
 * @param vat         The VAT (Value Added Tax) percentage to be applied.
 */
public SaleDTO( double priceTotal, int productAmount,int saleDate, String productName, double pricePerItem, ItemDTO[] itemDTOs, int vat){

 this.priceTotal  = priceTotal;
this.productAmount = productAmount;
this.saleDate = saleDate;
this.productName = productName;
this.pricePerItem = pricePerItem;
this.itemDTOList = new ItemDTO[productAmount];

}

/* These are getters which helps to keep SaleDTO well encapsulated */


/**        
 * Gets the total price of the sale.
 *
 * @return The total price of the sale.
 */ 
public double getPriceTotal(){

    return priceTotal;
}

/**
 * Gets the amount of products sold.
 *
 * @return The number of products sold.
 */
public int getProductAmount(){

    return productAmount;}




/**
 * Gets the price per item sold.
 *
 * @return The price per item sold.
 */
public double getPricePerItem(){

    return pricePerItem;
}


/**
 * Gets the date of the sale.
 *
 * @return The date of the sale.
 */
public int getSaleDate(){

    return saleDate;
}


/**
 * Gets the name of the product sold.
 *
 * @return The name of the product sold.
 */
public String getProductName(){

return productName;



}

/**
 * Gets the list of ItemDTO objects representing the items sold in the sale.
 *
 * @return An array of ItemDTO objects.
 */
public ItemDTO[] getItemDTOList(){

    return itemDTOList;
}

/**
 * Updates the total price of the sale based on the price per item and VAT.
 *
 * @param pricePerItem The price per item sold.
 * @param vat The VAT (Value Added Tax) percentage to be applied.
 */
public void updateTotal(double pricePerItem, int vat){
this.priceTotal =  (pricePerItem * productAmount) * (1 + vat / 100.0);


}




}

