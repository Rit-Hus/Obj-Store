package test.se.kth.iv1350.model;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.time.LocalDate;
import main.se.kth.iv1350.integration.SaleDTO;
import main.se.kth.iv1350.model.Payment;

public class PaymentTest {
    
    @Test
    public void testGetChangeWithOverpayment() {
        System.out.println("\n--- Testing getChange with overpayment ---");
        
        // Setup
        Payment payment = new Payment();
        double amountPaid = 100.0;
        double saleTotal = 29.90;
        SaleDTO dto = new SaleDTO(1.79, new ArrayList<>(), 
                                 LocalDate.now(), amountPaid, saleTotal);
        
        System.out.println("Amount paid: " + amountPaid);
        System.out.println("Sale total: " + saleTotal);
        
        // Execution
        double change = payment.getChange(amountPaid, dto);
        System.out.println("Calculated change: " + change);
        
        // Verification
        double expectedChange = 70.10;
        System.out.println("Expected change: " + expectedChange);
        assertEquals("Change should be 70.10", expectedChange, change, 0.001);
        
        System.out.println("--- Test PASSED ---");
    }

    @Test
    public void testGetChangeWithExactPayment() {
        System.out.println("\n--- Testing getChange with exact payment ---");
        
        // Setup
        Payment payment = new Payment();
        double amountPaid = 29.90;
        SaleDTO dto = new SaleDTO(1.79, new ArrayList<>(), 
                                 LocalDate.now(), amountPaid, amountPaid);
        
        System.out.println("Amount paid: " + amountPaid);
        System.out.println("Sale total: " + amountPaid);
        
        // Execution
        double change = payment.getChange(amountPaid, dto);
        System.out.println("Calculated change: " + change);
        
        // Verification
        double expectedChange = 0.0;
        System.out.println("Expected change: " + expectedChange);
        assertEquals("Change should be 0.0", expectedChange, change, 0.001);
        
        System.out.println("--- Test PASSED ---");
    }

    @Test
    public void testGetChangeWithUnderpayment() {
        System.out.println("\n--- Testing getChange with underpayment ---");
        
        // Setup
        Payment payment = new Payment();
        double amountPaid = 20.0;
        double saleTotal = 29.90;
        SaleDTO dto = new SaleDTO(1.79, new ArrayList<>(), 
                                 LocalDate.now(), amountPaid, saleTotal);
        
        System.out.println("Amount paid: " + amountPaid);
        System.out.println("Sale total: " + saleTotal);
        
        // Execution
        double change = payment.getChange(amountPaid, dto);
        System.out.println("Calculated change: " + change);
        
        // Verification
        double expectedChange = -9.90; // Negative indicates amount due
        System.out.println("Expected change: " + expectedChange);
        assertEquals("Change should be -9.90", expectedChange, change, 0.001);
        
        System.out.println("--- Test PASSED ---");
    }
}