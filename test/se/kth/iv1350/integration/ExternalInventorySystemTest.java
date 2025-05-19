package test.se.kth.iv1350.integration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import main.se.kth.iv1350.integration.*;;

/**
 * This class contains tests for the ExternalInventorySystem class, specifically focusing on
 * the main functionality of fetching item data.
 */
class ExternalInventorySystemTest {
    private final ExternalInventorySystem eis = ExternalInventorySystem.getInstance();
    /**
     * This test verifies that the fetchItemDTO method returns a non-null ItemDTO object
     * when a known item identifier is provided.
     */
    @Test
    void fetchKnownItemReturnsCorrectDTO() throws Exception{

        ItemDTO dto = eis.fetchItemDTO("abc123", 2);
        assertEquals("abc123", dto.getIdentifier());
        assertEquals("BigWheel Oatmeal", dto.getName());
        assertEquals(2,             dto.getQuantity());
        assertEquals(29.90,         dto.getPrice(), 1e-6);
        assertEquals(6,             dto.getVat());
    }
}
