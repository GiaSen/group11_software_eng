package ComplexCalculatorOperation;

import ComplexCalculator.Complex;
import ComplexCalculatorException.InvalidInputException;
import ComplexCalculatorException.NotEnoughStackElementsException;
import java.util.ArrayDeque;
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
public class StackOperationTest {

    StackOperation instance;
    ArrayDeque<Complex> stack;

    public StackOperationTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        stack = new ArrayDeque<>();
        instance = new StackOperation(stack);
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of operationInterpreter method, of class StackOperation.
     */
    @Test
    public void testOperationInterpreter() {
        System.out.println("OperationInterpreter");

        Complex n1 = new Complex(10, -8.1);
        Complex n2 = new Complex(-9, 1.2);
        stack.push(n1);
        stack.push(n2);

        instance.operationInterpreter("clear");

        assertEquals(0, stack.size());

    }

    @Test
    public void testOperationInterpreter2() {
        System.out.println("OperationInterpreter wrong input");

        Complex n1 = new Complex(10, -8.1);
        Complex n2 = new Complex(-9, 1.2);
        stack.push(n1);
        stack.push(n2);

        String input = "test";  //example of a bad input that throws exception
        assertThrows(InvalidInputException.class, () -> instance.operationInterpreter(input));

    }

    /**
     * Test of clear method, of class StackOperation.
     */
    @Test
    public void testClear1() {
        System.out.println("Clear1");

        stack.clear();

        assertEquals(0, stack.size());
    }

    @Test
    public void testClear2() {
        System.out.println("Clear2");

        Complex n = new Complex(1, 2);
        stack.push(n);

        instance.clear();

        assertEquals(0, stack.size());
    }

    @Test
    public void testClear3() {
        System.out.println("Clear3");

        Complex n1 = new Complex(1, 2);
        Complex n2 = new Complex(-10, 2.5);
        Complex n3 = new Complex(23, -18);
        stack.push(n1);
        stack.push(n2);
        stack.push(n3);

        instance.clear();

        assertEquals(0, stack.size());
    }

    /**
     * Test of drop method, of class StackOperation.
     */
    @Test
    public void testDrop1() {
        System.out.println("Drop1");

        int size = stack.size();

        assertThrows(NotEnoughStackElementsException.class, () -> instance.drop());
        assertEquals(size, stack.size());
    }

    @Test
    public void testDrop2() {
        System.out.println("Drop2");

        Complex n1 = new Complex(10, 5);
        stack.push(n1);

        instance.drop();

        assertEquals(0, stack.size());
    }

    @Test
    public void testDrop3() {
        System.out.println("Drop3");

        Complex n1 = new Complex(10, 5);
        Complex n2 = new Complex(-5, -3.2);
        stack.push(n1);
        stack.push(n2);

        instance.drop();

        assertEquals(1, stack.size());
    }

    /**
     * Test of dup method, of class StackOperation.
     */
    @Test
    public void testDup1() {
        System.out.println("Dup1");

        int size = stack.size();

        assertThrows(NotEnoughStackElementsException.class, () -> instance.dup());
        assertEquals(size, stack.size());
    }

    @Test
    public void testDup2() {
        System.out.println("Dup2");

        Complex n1 = new Complex(10, 3);
        stack.push(n1);

        int size = stack.size();

        instance.dup();

        assertEquals(size + 1, stack.size());
        assertEquals(n1, stack.getFirst());
    }

    @Test
    public void testDup3() {
        System.out.println("Dup3");

        Complex n1 = new Complex(10, 3);
        Complex n2 = new Complex(-2, 8.7);
        stack.push(n1);
        stack.push(n2);

        int size = stack.size();

        instance.dup();

        assertEquals(size + 1, stack.size());
        assertEquals(n2, stack.getFirst());
    }

    /**
     * Test of swap method, of class StackOperation.
     */
    @Test
    public void testSwap1() {
        System.out.println("Swap1");

        int size = stack.size();

        assertThrows(NotEnoughStackElementsException.class, () -> instance.swap());
        assertEquals(size, stack.size());
    }

    @Test
    public void testSwap2() {
        System.out.println("Swap2");

        int size = stack.size();

        Complex n1 = new Complex(10, 3);
        stack.push(n1);

        assertThrows(NotEnoughStackElementsException.class, () -> instance.swap());

    }

    @Test
    public void testSwap3() {
        System.out.println("Swap3");

        Complex n1 = new Complex(10, 3);
        Complex n2 = new Complex(1, -3);
        stack.push(n1);
        stack.push(n2);

        int size = stack.size();

        instance.swap();

        assertEquals(n2, stack.getLast());
        assertEquals(n1, stack.getFirst());
        assertEquals(size, stack.size());
    }

    @Test
    public void testSwap4() {
        System.out.println("Swap4");

        Complex n1 = new Complex(10, 3);
        Complex n2 = new Complex(1, -3);
        Complex n3 = new Complex(-2, -10.3);
        stack.push(n1);
        stack.push(n2);
        stack.push(n3);

        int size = stack.size();

        instance.swap();

        assertEquals(size, stack.size());
        assertEquals(n2, stack.remove());
        assertEquals(n3, stack.remove());

    }

    /**
     * Test of over method, of class StackOperation.
     */
    @Test
    public void testOver1() {
        System.out.println("Over1");

        int size = stack.size();

        assertThrows(NotEnoughStackElementsException.class, () -> instance.over());
        assertEquals(size, stack.size());

    }

    @Test
    public void testOver2() {
        System.out.println("Over2");

        Complex n = new Complex(1, 2);
        stack.push(n);

        int size = stack.size();

        assertThrows(NotEnoughStackElementsException.class, () -> instance.over());
        assertEquals(size, stack.size());
    }

    @Test
    public void testOver3() {
        System.out.println("Over2");

        Complex n1 = new Complex(10, 3);
        Complex n2 = new Complex(1, -3);
        stack.push(n1);
        stack.push(n2);

        int size = stack.size();

        instance.over();

        assertEquals(size + 1, stack.size());

        Complex r1 = stack.pop();
        Complex r2 = stack.pop();
        Complex r3 = stack.pop();

        assertEquals(n1, r1);
        assertEquals(n2, r2);
        assertEquals(n1, r3);

    }

    @Test
    public void testOver4() {
        System.out.println("Over3");

        Complex n1 = new Complex(10, 3);
        Complex n2 = new Complex(1, -3);
        Complex n3 = new Complex(-1, 3.7);
        stack.push(n1);
        stack.push(n2);
        stack.push(n3);

        int size = stack.size();

        instance.over();

        assertEquals(size + 1, stack.size());

        Complex r1 = stack.pop();
        Complex r2 = stack.pop();
        Complex r3 = stack.pop();
        Complex r4 = stack.pop();

        assertEquals(n2, r1);
        assertEquals(n3, r2);
        assertEquals(n2, r3);
        assertEquals(n1, r4);
    }

}
