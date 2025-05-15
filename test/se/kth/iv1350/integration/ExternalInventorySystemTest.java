package test.se.kth.iv1350.integration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import main.se.kth.iv1350.integration.*;;

class ExternalInventorySystemTest {
    private final ExternalInventorySystem eis = ExternalInventorySystem.getInstance();

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
