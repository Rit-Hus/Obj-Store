package se.kth.iv1350.controller;

import se.kth.iv1350.integration.ExternalAccountingSystem;
import se.kth.iv1350.integration.ExternalInventorySystem;
import se.kth.iv1350.integration.SaleDTO;
import se.kth.iv1350.integration.SaleLog;
import se.kth.iv1350.model.Sale;

public class Controller {
    
    private ExternalInventorySystem iSystem;
    private ExternalAccountingSystem aSystem;
    private SaleLog saleLog;
    private Sale sale;

  

  //constructer for controller
  public void controller(SaleLog saleLog, ExternalInventorySystem iSystem, ExternalAccountingSystem aSystem){

        this.saleLog = saleLog;
        this.iSystem = iSystem;
        this.aSystem = aSystem;
  }

  public void startSale(){
     //sale = new Sale();
  } 

  
  public SaleDTO scanitem(String itemID,int quantity){
    return null;
  }



  /** let's come back for this later and cahnge the void. date(24-04-2025)
   * 
   */
  public void finishSale(double payment){

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
