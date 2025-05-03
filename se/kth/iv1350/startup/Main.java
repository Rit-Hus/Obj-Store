package se.kth.iv1350.startup;

import se.kth.iv1350.model.Item;
import se.kth.iv1350.view.View;

public class Main {
    public static void main(String[] args) {
        // Initialize items statically
        Item.initializeItems();

        View view = new View();
        view.storeTerminal(); // Start the store terminal
    }
}

