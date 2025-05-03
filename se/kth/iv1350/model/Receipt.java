package se.kth.iv1350.model;

import java.time.LocalDate;
import se.kth.iv1350.integration.SaleDTO;


    public class Receipt {

        private int totalVAT;
        private int totalPrice;
        private double totalChange;
        private LocalDate saleDate;
    
        public Receipt(SaleDTO saleDTO, double change) {
            this.saleDate = saleDTO.getSaleDate();
            this.totalPrice = saleDTO.getTotalAmount();
            this.totalVAT = saleDTO.getVAT();  // Correctly fetch VAT from SaleDTO
            this.totalChange = change;  // Set the calculated change
        }
    
        public int getTotalPrice() {
            return totalPrice;
        }
    
        public int getTotalVat() {
            return totalVAT;  // Return total VAT from SaleDTO
        }
    
        public LocalDate getSaleDate() {
            return saleDate;
        }
    
        public double getChange() {
            return totalChange;
        }
    }
    
