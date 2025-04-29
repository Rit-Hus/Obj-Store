<<<<<<<< HEAD:S3-FörstaSeminaruim/se/kth/iv1350/integration/SaleDTO.java
package integration;
========
package se.kth.iv1350.codestore.integration;
>>>>>>>> acc30cce604e97b45184ffb58eb6f52d40cb0a6c:S3-FörstaSeminaruim/Main/se.kth.iv1350.codestore.integration/SaleDTO.java

public class SaleDTO{
    private double priceTotal;
private int productAmount;
private int saleDate;
private double pricePerItem;
String  productName;


public SaleDTO( double priceTotal, int productAmount,int saleDate, String productName, double pricePerItem){

 this.priceTotal  = priceTotal;
this.productAmount = productAmount;
this.saleDate = saleDate;
this.productName = productName;
this.pricePerItem = pricePerItem;


}
/*These are the getters. It creates a well encapsulated code*/

public double getPriceTotal(){

    return priceTotal;
}

public int getProductAmount(){
return productAmount;
}


public double getPricePerItem(){

    return pricePerItem;
}

public int getSaleDate(){

    return saleDate;
}

public String getProductName(){

return productName;



}
/*A method to update the total price*/
public void updateTotal(double pricePerItem, int vat){
this.priceTotal =  (pricePerItem * productAmount) * (1 + vat / 100.0);


}




}

