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
String  productName;


/**
 * Creates a new {@code SaleDTO}, which represents a completed sale.
 *
 * @param priceTotal The total price of the sale.
 * @param productAmount The number of products sold.
 * @param saleDate The date of the sale (e.g., as an integer timestamp or formatted value).
 * @param productName The name of the sold product.
 * @param pricePerItem The price per single item.
 */


public SaleDTO( double priceTotal, int productAmount,int saleDate, String productName, double pricePerItem){

 this.priceTotal  = priceTotal;
this.productAmount = productAmount;
this.saleDate = saleDate;
this.productName = productName;
this.pricePerItem = pricePerItem;


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
/*A method to update the total price*/
public void updateTotal(double pricePerItem, int vat){
this.priceTotal =  (pricePerItem * productAmount) * (1 + vat / 100.0);


}




}

