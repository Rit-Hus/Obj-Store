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
        System.out.println("\n=== TEST 1: Change Calculation (Overpayment) ===");
        
        // Setup
        Payment payment = new Payment();
        double amountPaid = 100.0;
        double saleTotal = 29.90;
        SaleDTO dto = createTestDTO(amountPaid, saleTotal);
        
        System.out.println("[Input] Amount paid: " + amountPaid);
        System.out.println("[Input] Sale total: " + saleTotal);
        
        // Execution
        double change = payment.getChange(amountPaid, dto);
        System.out.println("[Output] Calculated change: " + change);
        
        // Verification
        double expectedChange = 70.10;
        System.out.println("[Expected] Change: " + expectedChange);
        assertEquals("Change calculation incorrect", 
                    expectedChange, change, 0.001);  // Increased delta for floating-point
        
        System.out.println("=== TEST 1 PASSED ===\n");
    }

    @Test
    public void testGetChangeWithExactPayment() {
        System.out.println("\n=== TEST 2: Change Calculation (Exact Payment) ===");
        
        // Setup
        Payment payment = new Payment();
        double amountPaid = 29.90;
        SaleDTO dto = createTestDTO(amountPaid, amountPaid);
        
        System.out.println("[Input] Amount paid: " + amountPaid);
        System.out.println("[Input] Sale total: " + amountPaid);
        
        // Execution
        double change = payment.getChange(amountPaid, dto);
        System.out.println("[Output] Calculated change: " + change);
        
        // Verification
        double expectedChange = 0.0;
        assertEquals("Exact payment should yield zero change", 
                    expectedChange, change, 0.0);
        
        System.out.println("=== TEST 2 PASSED ===\n");
    }

    @Test
    public void testGetChangeWithUnderpayment() {
        System.out.println("\n=== TEST 3: Change Calculation (Underpayment) ===");
        
        // Setup
        Payment payment = new Payment();
        double amountPaid = 20.0;
        double saleTotal = 29.90;
        SaleDTO dto = createTestDTO(amountPaid, saleTotal);
        
        System.out.println("[Input] Amount paid: " + amountPaid);
        System.out.println("[Input] Sale total: " + saleTotal);
        
        // Execution
        double change = payment.getChange(amountPaid, dto);
        System.out.println("[Output] Calculated change: " + change);
        
        // Verification
        double expectedChange = -9.90;
        assertEquals("Underpayment should show negative change", 
                    expectedChange, change, 0.001);  // Adjusted delta for floating-point
        
        System.out.println("=== TEST 3 PASSED ===\n");
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