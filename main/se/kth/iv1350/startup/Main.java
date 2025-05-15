package main.se.kth.iv1350.startup;

import main.se.kth.iv1350.controller.Controller;
import main.se.kth.iv1350.integration.ExternalInventorySystem;
import main.se.kth.iv1350.integration.Printer;
import main.se.kth.iv1350.integration.TotalRevenueFileOutput;
import main.se.kth.iv1350.view.TotalRevenueView;
import main.se.kth.iv1350.view.View;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        ExternalInventorySystem inventorySystem = new ExternalInventorySystem();
        Controller controller = new Controller(printer, inventorySystem);

        // Register observers before any sales occur
        controller.addObserver(new TotalRevenueView());
        controller.addObserver(new TotalRevenueFileOutput());

        View view = new View(controller,printer);
        view.run();
    }
}
