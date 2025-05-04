package test.se.kth.iv1350.integration;

import static org.junit.Assert.*;
import org.junit.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import main.se.kth.iv1350.integration.*;

public class SaleLogTest {
    @Test
    public void testStoresInfoAddsToLog() {
        System.out.println("\n--- Testing SaleLog storesInfo ---");
        
        SaleLog log = new SaleLog();
        SaleDTO dto = new SaleDTO(1.79, new ArrayList<>(), 
                                LocalDate.now(), 50.0, 29.90);
        
        System.out.println("Initial log count: " + getSaleCount(log));
        System.out.println("Adding sale to log...");
        log.storesInfo(dto);
        
        int newCount = getSaleCount(log);
        System.out.println("New log count: " + newCount);
        
        assertEquals("Log count should increase by 1", 1, newCount);
        System.out.println("--- Test PASSED ---");
    }
    
    private int getSaleCount(SaleLog log) {
        try {
            java.lang.reflect.Field field = SaleLog.class.getDeclaredField("saleDTOList");
            field.setAccessible(true);
            return ((java.util.ArrayList<?>) field.get(log)).size();
        } catch (Exception e) {
            fail("Failed to access sale count: " + e.getMessage());
            return -1;
        }
    }
}