package test.se.kth.iv1350.view;

import main.se.kth.iv1350.controller.Controller;
import main.se.kth.iv1350.integration.ExternalInventorySystem;
import main.se.kth.iv1350.integration.Printer;
import main.se.kth.iv1350.integration.ItemDTO;
import main.se.kth.iv1350.view.View;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;


public class ViewTest {
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;
    private ByteArrayOutputStream outBuffer;

    private View view;
    private Controller controller;

    @Before
    public void setUp() {
      
        outBuffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outBuffer));

        
        Printer printer = new Printer();
        ExternalInventorySystem invSys = ExternalInventorySystem.getInstance();
        controller = new Controller(printer, invSys);
        view = new View(controller, printer);
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void testPrintItemDetails_showsAllFields() {
    
        ItemDTO dto = new ItemDTO(
                123.45,    
                25,        
                2,         
                "ID-XYZ",  
                "TestItem",
                "A test item" 
        );

  
        view.printItemDetails(dto);
        String output = outBuffer.toString();

        assertTrue("Should print 'Item ID: ID-XYZ'",
                output.contains("Item ID: ID-XYZ"));
        assertTrue("Should print 'Item name: TestItem'",
                output.contains("Item name: TestItem"));
        assertTrue("Should print 'Item cost:'",
                output.contains("Item cost:"));
        assertTrue("Should print 'VAT: 25%'",
                output.contains("VAT: 25%"));
        assertTrue("Should print 'Item description: A test item'",
                output.contains("Item description: A test item"));
    }

    @Test
    public void testRun_showsMenuAndHandlesInvalidID() {

        String userInput = String.join(System.lineSeparator(),
                    "2",
                    "noSuchID"
                ) + System.lineSeparator();
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        view.run();
        String output = outBuffer.toString();


        assertTrue("Should display the discount selection prompt",
                output.contains("Choose discount mode:"));
        assertTrue("Should offer '1) No discount'",
                output.contains("1) No discount"));
        assertTrue("Should offer '2) Bulk discount'",
                output.contains("2) Bulk discount"));

    
        assertTrue("Should print 'Sale started at:'",
                output.contains("Sale started at:"));

        
        assertTrue("Should print 'Sorry, that item ID does not exist.'",
                output.contains("Sorry, that item ID does not exist."));
    }
}
