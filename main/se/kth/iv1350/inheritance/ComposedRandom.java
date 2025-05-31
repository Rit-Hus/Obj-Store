package main.se.kth.iv1350.inheritance;

import java.util.Random;
import main.se.kth.iv1350.inheritancecomposition.InheritedRandom;


/**
 * Adapts java.util.Random using composition.
 * Delegates functionality and wraps logic.
 */
public class ComposedRandom {
    private final Random random;

    public ComposedRandom() {
        this.random = new Random();
    }

    /**
     * Returns only even numbers between 0 and bound.
     */
    public int nextEvenInt(int bound) {
        int result = random.nextInt(bound);
        return result % 2 == 0 ? result : result - 1;
    }
}
