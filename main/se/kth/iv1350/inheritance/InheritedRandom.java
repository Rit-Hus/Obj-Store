package main.se.kth.iv1350.inheritance;

import java.util.Random;

import main.se.kth.iv1350.inheritancecomposition.ComposedRandom;

/**
 * Adapts java.util.Random using inheritance.
 * Overrides nextInt to always return only even numbers.
 */
public class InheritedRandom extends Random {
    @Override
    public int nextInt(int bound) {
        int result = super.nextInt(bound);
        return result % 2 == 0 ? result : result - 1;
    }
}
