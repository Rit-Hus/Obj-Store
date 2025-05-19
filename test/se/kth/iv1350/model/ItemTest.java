package test.se.kth.iv1350.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import main.se.kth.iv1350.model.Item;


/**
 * This class contains tests for the Item class.
 * It verifies the behavior of the Item class, including quantity incrementing and getter methods.
 */
class ItemTest {
    private Item item;

    /**
     * This method is called before each test case to set up the initial state of the item.
     * It creates a new Item object with predefined values.
     */
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

    /**
     * Test to verify that the initial quantity of the item is set to 1.
     */
    @Test
    void incrementQuantityIncreasesCount() {
        assertEquals(1, item.getQuantity());
        item.incrementQuantity();
        assertEquals(2, item.getQuantity(), 
            "incrementQuantity() should add 1 to quantity");
    }
/**
     * Test to verify that the quantity can be incremented multiple times.
     */
    @Test
    void gettersReturnConstructorValues() {
        assertEquals(29.90, item.getPrice(), 1e-6);
        assertEquals(6.0, item.getVat(), 1e-6);
        assertEquals("abc123", item.getItemID());
        assertEquals("BigWheel Oatmeal", item.getName());
        assertEquals("500g whole grain oats", item.getDescription());
    }
}