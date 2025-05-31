package test.se.kth.iv1350.startup;

import main.se.kth.iv1350.startup.Main;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;


public class MainTest {
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outBuffer;

    @Before
    public void setUp() {
 
        outBuffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outBuffer));


        String fakeInput = "1\nnoSuchID\n";
        System.setIn(new ByteArrayInputStream(fakeInput.getBytes()));
    }

    @After
    public void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    public void testMain_printsDiscountMenu() {
        Main.main(new String[0]);
        String output = outBuffer.toString();

        assertTrue("Should show the discount prompt",
                output.contains("Choose discount mode:"));
        assertTrue("Should offer “No discount” option",
                output.contains("1) No discount"));
        assertTrue("Should offer “Bulk discount” option",
                output.contains("2) Bulk discount"));
    }
}
