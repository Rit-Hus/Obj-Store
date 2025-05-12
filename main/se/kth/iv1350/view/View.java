package main.se.kth.iv1350.view;

import main.se.kth.iv1350.controller.Controller;

/**
 * Drives a hardcoded sale scenario: only controller calls.
 */
public class View {
    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    /** Simulate a sale with three controller calls only. */
    public void run() {
        controller.startSale();
        controller.addItemToSale("abc123", 1);
        controller.addItemToSale("abc123", 1);
        controller.addItemToSale("def456", 1);
        controller.endSale(100.00);
    }
}
