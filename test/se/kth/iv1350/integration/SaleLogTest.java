package test.se.kth.iv1350.integration;

import static org.junit.Assert.*;
import org.junit.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import main.se.kth.iv1350.integration.*;


/**
 * This class contains unit tests for the SaleLog class. It tests the storesInfo
 * method to ensure it correctly adds a SaleDTO object to the log.
 */
public class SaleLogTest {
    @Test
    public void testStoresInfoAddsToLog() {
        
        
        SaleLog log = new SaleLog();
        SaleDTO dto = new SaleDTO(1.79, new ArrayList<>(), 
                                LocalDate.now(), 50.0, 29.90);
        
       
        log.storesInfo(dto);
        
        int newCount = getSaleCount(log);
       
        
        assertEquals("Log count should increase by 1", 1, newCount);
       
    }
    /**
     * This method uses reflection to access the private saleDTOList field in the
     * SaleLog class and returns its size.
     * 
     * @param log The SaleLog instance to inspect.
     * @return The number of SaleDTO objects in the log.
     */
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