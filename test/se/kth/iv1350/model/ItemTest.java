package test.se.kth.iv1350.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import main.se.kth.iv1350.model.Item;

class ItemTest {
    private Item item;

    @BeforeEach
    void setUp() {

        item = new Item(
            29.90,    
            6.0,     
            1,      
            "abc123",
            "BigWheel Oatmeal",
            "500g whole grain oats" 
        );
    }

    @Test
    void incrementQuantityIncreasesCount() {
        assertEquals(1, item.getQuantity());
        item.incrementQuantity();
        assertEquals(2, item.getQuantity(), 
            "incrementQuantity() should add 1 to quantity");
    }

    @Test
    void gettersReturnConstructorValues() {
        assertEquals(29.90, item.getPrice(), 1e-6);
        assertEquals(6.0, item.getVat(), 1e-6);
        assertEquals("abc123", item.getItemID());
        assertEquals("BigWheel Oatmeal", item.getName());
        assertEquals("500g whole grain oats", item.getDescription());
    }
}