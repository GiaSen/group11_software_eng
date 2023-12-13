package ComplexCalculatorOperation;

import ComplexCalculator.Complex;
import ComplexCalculatorException.*;
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
public class ArithmeticOperationTest {

    ArithmeticOperation instance;
    ArrayDeque<Complex> stack;

    public ArithmeticOperationTest() {
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
        instance = new ArithmeticOperation(stack);
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testOperationInterpreter() {
        System.out.println("opInterpreter");

        Complex n1 = new Complex(4, 2);
        Complex n2 = new Complex(2, 4);

        stack.push(n1);
        stack.push(n2);

        instance.operationInterpreter("+");

        assertEquals(n1.sum(n2), stack.getFirst());
        assertEquals(stack.size(), 1);
    }

    @Test
    public void testOperationInterpreter2() {
        System.out.println("opInterpreter wrong input");

        Complex n1 = new Complex(4, 2);
        Complex n2 = new Complex(2, 4);

        stack.push(n1);
        stack.push(n2);

        assertThrows(InvalidInputException.class, () -> {
            instance.operationInterpreter("sum");
        });
        assertEquals(stack.size(), 2);
    }

    /**
     * Test of sum method, of class ArithmeticOperation.
     */
    @Test
    public void testSum() {
        System.out.println("sum");
        Complex n1 = new Complex(4, 2);
        Complex n2 = new Complex(2, 4);

        stack.push(n1);
        stack.push(n2);

        instance.sum();

        assertEquals(n1.sum(n2), stack.getFirst());
        assertEquals(stack.size(), 1);
    }

    @Test
    public void testSum2() {
        System.out.println("sum fail");
        Complex n1 = new Complex(4, 2);
        stack.push(n1);

        assertThrows(NotEnoughDataException.class, () -> {
            instance.sum();
        });
        assertEquals(stack.size(), 1);
    }

    @Test
    public void testSub() {
        System.out.println("sub");
        Complex n1 = new Complex(4, 2);
        Complex n2 = new Complex(2, 4);
        stack.push(n1);
        stack.push(n2);

        instance.sub();

        assertEquals(n1.sub(n2), stack.getFirst());
        assertEquals(stack.size(), 1);
    }

    @Test
    public void testSub2() {
        System.out.println("sub fail");
        Complex n1 = new Complex(4, 2);
        stack.push(n1);

        assertThrows(NotEnoughDataException.class, () -> {
            instance.sub();
        });
        assertEquals(stack.size(), 1);
    }

    @Test
    public void testProduct() {
        System.out.println("product");
        Complex n1 = new Complex(4, 2);
        Complex n2 = new Complex(2, 4);
        stack.push(n1);
        stack.push(n2);

        instance.product();

        assertEquals(n1.product(n2), stack.getFirst());
        assertEquals(stack.size(), 1);
    }

    @Test
    public void testProduct2() {
        System.out.println("product fail");
        Complex n1 = new Complex(4, 2);
        stack.push(n1);

        assertThrows(NotEnoughDataException.class, () -> {
            instance.product();
        });
        assertEquals(stack.size(), 1);
    }

    @Test
    public void testDivision() {
        System.out.println("division");
        Complex n1 = new Complex(4, 2);
        Complex n2 = new Complex(2, 4);
        stack.push(n1);
        stack.push(n2);

        instance.division();

        assertEquals(n1.division(n2), stack.getFirst());
        assertEquals(stack.size(), 1);
    }

    @Test
    public void testDivision2() {
        System.out.println("division fail");
        Complex n1 = new Complex(4, 2);
        stack.push(n1);

        assertThrows(NotEnoughDataException.class, () -> {
            instance.division();
        });
        assertEquals(stack.size(), 1);
    }

    @Test
    public void testDivision3() {
        System.out.println("division by 0");
        Complex n1 = new Complex(4, 2);
        Complex n2 = new Complex(0, 0);
        stack.push(n1);
        stack.push(n2);

        assertThrows(ZeroDivisionException.class, () -> {
            instance.division();
        });
        assertEquals(stack.size(), 2);
    }

    @Test
    public void testInversion() {
        System.out.println("inversion");
        Complex n1 = new Complex(4, 2);
        stack.push(n1);

        instance.inversion();

        assertEquals(n1.negate(), stack.getFirst());
        assertEquals(stack.size(), 1);
    }

    @Test
    public void testInversion2() {
        System.out.println("inversion fail");

        assertThrows(NotEnoughDataException.class, () -> {
            instance.inversion();
        });
        assertEquals(stack.size(), 0);
    }

    @Test
    public void testSqrt() {
        System.out.println("sqrt");
        Complex n1 = new Complex(4, 2);
        stack.push(n1);

        instance.sqrt();

        assertEquals(n1.sqrt(), stack.getFirst());
        assertEquals(stack.size(), 1);
    }

    @Test
    public void testSqrt2() {
        System.out.println("sqrt fail");

        assertThrows(NotEnoughDataException.class, () -> {
            instance.sqrt();
        });
        assertEquals(stack.size(), 0);
    }

}
