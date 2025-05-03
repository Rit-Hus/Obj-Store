package se.kth.iv1350.startup;

import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.integration.Printer;
import se.kth.iv1350.view.View;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer(); 
        Controller controller = new Controller(printer);  
        View view = new View(controller); 
        view.run(); 
    }
}
