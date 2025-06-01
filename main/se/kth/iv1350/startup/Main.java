package main.se.kth.iv1350.startup;

import main.se.kth.iv1350.controller.Controller;
import main.se.kth.iv1350.integration.ExternalInventorySystem;
import main.se.kth.iv1350.integration.Printer;
import main.se.kth.iv1350.integration.TotalRevenueFileOutput;
import main.se.kth.iv1350.view.TotalRevenueView;
import main.se.kth.iv1350.view.View;

/**
 * The main class to start the application.
 * It initializes the necessary components and starts the user interface.
 */
public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        ExternalInventorySystem inventorySystem = ExternalInventorySystem.getInstance();
        Controller controller = new Controller(printer, inventorySystem);

        controller.addRevenueObserver(new TotalRevenueView());
        controller.addRevenueObserver(new TotalRevenueFileOutput());

        View view = new View(controller, printer);
        view.run();
    }
}
