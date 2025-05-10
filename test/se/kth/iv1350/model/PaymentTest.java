package test.se.kth.iv1350.model;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.time.LocalDate;
import main.se.kth.iv1350.model.*;
import main.se.kth.iv1350.integration.*;

public class PaymentTest {
    @Test
    public void testGetChangeWithOverpayment() {
       
        
        // Setup
        Payment payment = new Payment();
        double amountPaid = 100.0;
        double saleTotal = 29.90;
        SaleDTO dto = createTestDTO(amountPaid, saleTotal);
        
       
        
        // Execution
        double change = payment.getChange(amountPaid, dto);
       
        
        // Verification
        double expectedChange = 70.10;
        
        assertEquals("Change calculation incorrect", 
                    expectedChange, change, 0.001);  // Increased delta for floating-point
        
       
    }

    @Test
    public void testGetChangeWithExactPayment() {
        
        
        // Setup
        Payment payment = new Payment();
        double amountPaid = 29.90;
        SaleDTO dto = createTestDTO(amountPaid, amountPaid);
        
       
        
        // Execution
        double change = payment.getChange(amountPaid, dto);
       
        
        // Verification
        double expectedChange = 0.0;
        assertEquals("Exact payment should yield zero change", 
                    expectedChange, change, 0.0);
        
        
    }

    @Test
    public void testGetChangeWithUnderpayment() {
       
        
        // Setup
        Payment payment = new Payment();
        double amountPaid = 20.0;
        double saleTotal = 29.90;
        SaleDTO dto = createTestDTO(amountPaid, saleTotal);
        
       
        
        // Execution
        double change = payment.getChange(amountPaid, dto);
       
        
        // Verification
        double expectedChange = -9.90;
        assertEquals("Underpayment should show negative change", 
                    expectedChange, change, 0.001);  // Adjusted delta for floating-point
        
       
    }

    private SaleDTO createTestDTO(double amountPaid, double totalAmount) {
        return new SaleDTO(
            1.79,  // VAT (6% of 29.90)
            new ArrayList<>(),
            LocalDate.now(),
            amountPaid,
            totalAmount
        );
    }
}