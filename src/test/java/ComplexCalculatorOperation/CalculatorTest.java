package ComplexCalculatorOperation;

import ComplexCalculator.Complex;
import ComplexCalculatorException.InvalidInputException;
import java.util.ArrayDeque;
import java.util.HashMap;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author group11
 */
public class CalculatorTest {

    Calculator instance;

    public CalculatorTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        instance = new Calculator();
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of interpreter method, of class Calculator.
     */
    @Test
    public void testInterpreter() {
        System.out.println("interpreter");

        instance.interpreter("3");

        assertEquals(1, instance.getStack().size());
    }

    @Test
    public void testInterpreter2() {
        System.out.println("interpreter wrong input");

        String str = "test"; //example of a bad input insertion

        assertThrows(InvalidInputException.class, () -> instance.interpreter(str));

    }

    /**
     * Test of getStack method, of class Calculator.
     */
    @Test
    public void testGetStack() {
        System.out.println("getStack when empty");
        ArrayDeque<Complex> stack = instance.getStack();

        assertNotNull(stack);
        assertTrue(stack.isEmpty());

    }

    @Test
    public void testGetStack2() {
        System.out.println("getStack when not empty");
        ArrayDeque<Complex> stack = instance.getStack();

        assertNotNull(stack);
        assertTrue(stack.isEmpty());

        Complex n1 = new Complex(1, 4);
        Complex n2 = new Complex(-2, -8.9);
        stack.push(n1);
        stack.push(n2);

        assertFalse(stack.isEmpty());
        assertEquals(2, instance.getStack().size());

    }

    /**
     * Test of getMap method, of class Calculator.
     */
    @Test
    public void testGetMap() {
        System.out.println("getMap when empty");
        HashMap<String, Complex> map = instance.getMap();

        assertNotNull(map);
        assertTrue(map.isEmpty());
    }

    @Test
    public void testGetMap2() {
        System.out.println("getMap when not empty");
        HashMap<String, Complex> map = instance.getMap();

        assertNotNull(map);
        assertTrue(map.isEmpty());

        Complex n1 = new Complex(10, 8);
        Complex n2 = new Complex(-1, 7.2);
        map.put("a", n1);
        map.put("b", n2);

        assertFalse(map.isEmpty());
        assertEquals(2, instance.getMap().size());
    }

    @Test
    public void testStackLimit() {
        Integer i;
        for (i = 0; i < 1000000; i++) { //checks if the stack supports 1_000_000 elements
            instance.interpreter(i.toString() + "+" + i.toString() + "j");
        }
        assertEquals(i, instance.getStack().size());
    }
}
