package se.kth.iv1350.controller;

import se.kth.iv1350.integration.ExternalAccountingSystem;
import se.kth.iv1350.integration.ExternalInventorySystem;
import se.kth.iv1350.integration.ItemDTO;
import se.kth.iv1350.integration.SaleDTO;
import se.kth.iv1350.integration.SaleLog;
import se.kth.iv1350.model.Item;
import se.kth.iv1350.model.Receipt;
import se.kth.iv1350.model.Sale;

public class Controller {
    
    private ExternalInventorySystem iSystem;
    private ExternalAccountingSystem aSystem;
    private SaleLog saleLog;
    private Sale sale;
    private Receipt receipt;
    private ItemDTO cart;
    private Item item;
  

  //constructer for controller
  public void controller(SaleLog saleLog, ExternalInventorySystem iSystem, ExternalAccountingSystem aSystem){

        this.saleLog = saleLog;
        this.iSystem = iSystem;
        this.aSystem = aSystem;
  }

  public void startSale(){
     this.sale = new Sale();
     this.item.initializeItems();
  } 

  //
  public void scanitem(ItemDTO cart){
      sale.scanitems(cart);
  }
 
  public void endScanItem(ItemDTO cart){
    sale.addItemsTolist();
}

  /** let's come back for this later and cahnge the void. date(24-04-2025)
   * create SaleDTO when done 
   */
  public void finishSale(){
     SaleDTO saledto = sale.endsSale();
     Receipt receipt = new Receipt(saledto); //vi återkommer
  }


  public void entersIdentification(int soicalNumber){

  }

  public void entersAmount(){

  }

  public void startPayment(){

  }

  public void idNewPrice(int soicalNumber){

  }


  //SaleDTO????

}
