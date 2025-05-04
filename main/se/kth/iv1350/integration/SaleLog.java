package main.se.kth.iv1350.integration;

import java.util.ArrayList;

/**
 * The SaleLog class is responsible for storing information about sales. It keeps
 * track of all the sales made during the program's execution.
 */
public class SaleLog {

private ArrayList<SaleDTO> saleDTOList = new ArrayList<>();
   

/**
 * Adds a SaleDTO object to the sale log. This method is used to store information
 * about a completed sale.
 *
 * @param saleInfo The SaleDTO object containing information about the sale.
 */
public void storesInfo(SaleDTO saleInfo){

saleDTOList.add(saleInfo);

}



/**
 * Retrieves the list of SaleDTO objects stored in the sale log. This method is used
 * to access the information about all completed sales.
 *
 * @return An ArrayList of SaleDTO objects containing information about all sales.
 */
public SaleLog(){



}

    
}




