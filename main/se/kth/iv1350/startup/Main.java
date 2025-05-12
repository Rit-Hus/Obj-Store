package main.se.kth.iv1350.startup;

import main.se.kth.iv1350.controller.Controller;
import main.se.kth.iv1350.integration.ExternalInventorySystem;
import main.se.kth.iv1350.integration.Printer;
import main.se.kth.iv1350.view.View;

/**
 * Entry point: wires everything together.
 */
public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        ExternalInventorySystem inventorySystem = new ExternalInventorySystem();
        Controller controller = new Controller(printer, inventorySystem);
        View view = new View(controller);
        view.run();
    }
}
