package main.se.kth.iv1350.startup;

import main.se.kth.iv1350.controller.Controller;
import main.se.kth.iv1350.integration.ExternalInventorySystem;
import main.se.kth.iv1350.integration.Printer;
import main.se.kth.iv1350.integration.TotalRevenueFileOutput;
import main.se.kth.iv1350.model.RevenueObserver;
import main.se.kth.iv1350.util.FileLogger;
import main.se.kth.iv1350.view.TotalRevenueView;
import main.se.kth.iv1350.view.View;


public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();

        ExternalInventorySystem inventorySystem = ExternalInventorySystem.getInstance();
        Controller controller = new Controller(printer, inventorySystem);

        controller.addRevenueObserver((RevenueObserver) new TotalRevenueView());
        controller.addRevenueObserver(new TotalRevenueFileOutput());



        TotalRevenueView consoleObserver = new TotalRevenueView();
        TotalRevenueFileOutput fileObserver = new TotalRevenueFileOutput();
        FileLogger logger = new FileLogger();

        controller.addRevenueObserver((RevenueObserver) consoleObserver);
        controller.addRevenueObserver(fileObserver);
        controller.addRevenueObserver(logger);




        View view = new View(controller, printer);
        view.run();
    
    
    
    
    
    
    
    
    
    
    
    }
}
