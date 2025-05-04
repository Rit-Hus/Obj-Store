package main.se.kth.iv1350.startup;

import main.se.kth.iv1350.controller.Controller;
import main.se.kth.iv1350.integration.Printer;
import main.se.kth.iv1350.view.View;

/**
 * The Main class is the entry point of the program. It initializes the necessary
 * components and starts the application.
 */
public class Main {

    /**
     * The main method is the entry point of the program. It initializes the
     * Controller, Printer, and View classes and starts the application.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Printer printer = new Printer();
        Controller controller = new Controller(printer);
        View view = new View(controller);
        view.run();
    }
}