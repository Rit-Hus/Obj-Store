package test.se.kth.iv1350.model;

import main.se.kth.iv1350.integration.ItemDTO;
import main.se.kth.iv1350.integration.SaleDTO;
import main.se.kth.iv1350.model.Payment;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


/**
 * This class contains tests for the Payment class.
 * It verifies the behavior of the getChange method, ensuring it calculates the correct change
 * based on the amount paid and the total amount of the sale.
 */
class PaymentTest {


    /**
     * Tests the getChange method to ensure it returns the correct change when paid over the total amount.
     * It verifies that the change is positive when paid more than the total.
     */
    @Test
    public void changeIsPositiveWhenPaidOverTotal() {

        double vat         = 0.0;
        ArrayList<ItemDTO> items      = new ArrayList<>();
        LocalDate saleDate = LocalDate.now();
        double amountPaid  = 0.0; 
        double totalAmount = 50.0;

        SaleDTO sale = new SaleDTO(vat, items, saleDate, amountPaid, totalAmount);
        Payment payment = new Payment();

   
        double change = payment.getChange(80.0, sale);


        assertEquals(30.0, change, 1e-6, "80 paid on 50 total → 30 change");
    }

    /**
     * Tests the getChange method to ensure it returns zero when the payment is exactly equal to the total amount.
     * It verifies that the change is zero when paid exactly.
     */
    @Test
    public void changeIsZeroWhenExactPayment() {
        SaleDTO sale = new SaleDTO(
            0.0,
            new ArrayList<>(),
            LocalDate.now(),
            0.0,
            75.25
        );
        Payment payment = new Payment();

        double change = payment.getChange(75.25, sale);
        assertEquals(0.0, change, 1e-6, "Exact payment yields zero change");
    }

    /**
     * Tests the getChange method to ensure it returns a negative value when the payment is less than the total amount.
     * It verifies that the change is negative when underpaid.
     */
    @Test
    public void changeIsNegativeWhenUnderpaid() {
        SaleDTO sale = new SaleDTO(
            0.0,
            new ArrayList<>(),
            LocalDate.now(),
            0.0,
            30.0
        );
        Payment payment = new Payment();

        double change = payment.getChange(20.0, sale);
        assertTrue(change < 0, "Underpayment yields negative change");
    }
}
