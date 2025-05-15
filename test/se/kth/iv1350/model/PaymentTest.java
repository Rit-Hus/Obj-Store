package test.se.kth.iv1350.model;   // mirror the production package

import main.se.kth.iv1350.integration.ItemDTO;
import main.se.kth.iv1350.integration.SaleDTO;
import main.se.kth.iv1350.model.Payment;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {
    @Test
    void changeIsPositiveWhenPaidOverTotal() {
        // Arrange: build a SaleDTO whose totalAmount is 50.0
        double vat         = 0.0;
        ArrayList<ItemDTO> items      = new ArrayList<>();
        LocalDate saleDate = LocalDate.now();
        double amountPaid  = 0.0;   // payment.amountPaid in the DTO isn’t used by getChange
        double totalAmount = 50.0;

        SaleDTO sale = new SaleDTO(vat, items, saleDate, amountPaid, totalAmount);
        Payment payment = new Payment();

        // Act
        double change = payment.getChange(80.0, sale);

        // Assert
        assertEquals(30.0, change, 1e-6, "80 paid on 50 total → 30 change");
    }

    @Test
    void changeIsZeroWhenExactPayment() {
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

    @Test
    void changeIsNegativeWhenUnderpaid() {
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
