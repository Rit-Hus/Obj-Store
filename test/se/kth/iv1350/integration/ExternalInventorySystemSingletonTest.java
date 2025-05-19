package test.se.kth.iv1350.integration;

import static org.junit.Assert.assertSame;

import org.junit.Test;

import main.se.kth.iv1350.integration.ExternalInventorySystem;

public class ExternalInventorySystemSingletonTest {
    /**
     * Verifies that ExternalInventorySystem.getInstance() always returns
     * the same object, confirming the Singleton pattern.
     */
    @Test
    public void getInstance_returnsSameInstance() {
        ExternalInventorySystem first  = ExternalInventorySystem.getInstance();
        ExternalInventorySystem second = ExternalInventorySystem.getInstance();
        assertSame("ExternalInventorySystem.getInstance() should return the same instance",
                   first, second);
    }
}
