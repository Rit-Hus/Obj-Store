package test.se.kth.iv1350.model;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.time.LocalDate;
import main.se.kth.iv1350.integration.SaleDTO;
import main.se.kth.iv1350.model.Payment;


/**
 * This class contains unit tests for the Payment class. It tests the getChange
 * method to ensure it calculates the correct change based on the amount paid and
 * the sale total.
 */
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
    /**
     * Tests the getChange method of the Payment class when the payment is exact.
     * It verifies that the change is 0.0 when the amount paid equals the sale total.
     */
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

    /**
     * Tests the getChange method of the Payment class when the payment is less than
     * the sale total. It verifies that the change is negative, indicating an amount
     * due.
     */
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