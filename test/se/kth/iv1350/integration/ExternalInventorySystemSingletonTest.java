package test.se.kth.iv1350.integration;

import static org.junit.Assert.assertSame;

import org.junit.Test;

import main.se.kth.iv1350.integration.ExternalInventorySystem;

/**
 * This class contains tests for the singleton implementation of the ExternalInventorySystem class.
 * It verifies that the getInstance() method always returns the same instance.
 */
public class ExternalInventorySystemSingletonTest {

    /**
     * Tests the singleton implementation of the ExternalInventorySystem class.
     * It verifies that the getInstance() method always returns the same instance.
     */
    @Test
    public void getInstance_returnsSameInstance() {
        ExternalInventorySystem first  = ExternalInventorySystem.getInstance();
        ExternalInventorySystem second = ExternalInventorySystem.getInstance();
        assertSame("ExternalInventorySystem.getInstance() should return the same instance",
                   first, second);
    }
}
