package main.se.kth.iv1350.inheritance;



import main.se.kth.iv1350.inheritance.InheritedRandom;
import main.se.kth.iv1350.inheritance.ComposedRandom;

/**
 * 
 * Demonstrates the difference between inheritance and composition adaptation.
 */
public class RandomTestMain {
    public static void main(String[] args) {
        InheritedRandom inherited = new InheritedRandom();
        ComposedRandom composed = new ComposedRandom();

        System.out.println("Using inherited Random:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Inherited nextEvenInt: " + inherited.nextInt(100));
        }

        System.out.println("\nUsing composed Random:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Composed nextEvenInt: " + composed.nextEvenInt(100));
        }
    }
}
