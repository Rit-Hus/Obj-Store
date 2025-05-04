package main.se.kth.iv1350.startup;

import main.se.kth.iv1350.controller.Controller;
import main.se.kth.iv1350.integration.Printer;
import main.se.kth.iv1350.view.View;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Controller controller = new Controller(printer);
        View view = new View(controller);
        view.run();
    }
}