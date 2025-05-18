package main.se.kth.iv1350.integration;

import java.util.ArrayList;


/**
 * The SaleLog class is responsible for storing information about sales. It contains
 * a list of SaleDTO objects, which represent individual sales. The class provides
 * methods to add sale information to the log.
 */
public class SaleLog {

private ArrayList<SaleDTO> saleDTOList = new ArrayList<>();
   

/**
 * Adds sale information to the log.
 *
 * @param saleInfo The SaleDTO object containing sale information to be added.
 */
public void storesInfo(SaleDTO saleInfo){

saleDTOList.add(saleInfo);

}


/**
 * Gets the list of SaleDTO objects representing the sales stored in the log.
 *
 * @return The list of SaleDTO objects.
 */
public SaleLog(){



}

    
}




