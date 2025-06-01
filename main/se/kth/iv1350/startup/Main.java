package main.se.kth.iv1350.startup;

import main.se.kth.iv1350.controller.Controller;
import main.se.kth.iv1350.integration.ExternalInventorySystem;
import main.se.kth.iv1350.integration.Printer;
import main.se.kth.iv1350.integration.TotalRevenueFileOutput;
import main.se.kth.iv1350.util.FileLogger;
import main.se.kth.iv1350.view.TotalRevenueView;
import main.se.kth.iv1350.view.View;

/**
 * Main class to start the application.
 */
public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        ExternalInventorySystem inventorySystem = ExternalInventorySystem.getInstance();
        Controller controller = new Controller(printer, inventorySystem);

        TotalRevenueView consoleObserver = new TotalRevenueView();
        TotalRevenueFileOutput fileObserver = new TotalRevenueFileOutput();

        controller.addRevenueObserver(consoleObserver);
        controller.addRevenueObserver(fileObserver);

        // Run the view
        View view = new View(controller, printer);
        view.run();
    }
}
