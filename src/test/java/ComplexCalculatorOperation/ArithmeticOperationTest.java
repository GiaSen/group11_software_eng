/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author Pietro
 */
public class ArithmeticOperationTest {

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
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of sum method, of class ArithmeticOperation.
     */
    @Test
    public void testSum() {
        System.out.println("sum");
        ArrayDeque<Complex> stack = new ArrayDeque<>();
        ArithmeticOperation instance = new ArithmeticOperation(stack);
        Complex n1 = new Complex(4, 2);
        Complex n2 = new Complex(2, 4);
        stack.push(n1);
        stack.push(n2);

        instance.sum();

        assertEquals(n1.sum(n2), stack.getFirst());
    }

    @Test
    public void testSum2() {
        System.out.println("sum fail");
        ArrayDeque<Complex> stack = new ArrayDeque<>();
        ArithmeticOperation instance = new ArithmeticOperation(stack);
        Complex n1 = new Complex(4, 2);
        stack.push(n1);

        assertThrows(NotEnoughDataException.class, () -> {
            instance.sum();
        });
    }

    @Test
    public void testSub() {
        System.out.println("sub");
        ArrayDeque<Complex> stack = new ArrayDeque<>();
        ArithmeticOperation instance = new ArithmeticOperation(stack);
        Complex n1 = new Complex(4, 2);
        Complex n2 = new Complex(2, 4);
        stack.push(n1);
        stack.push(n2);

        instance.sub();

        assertEquals(n1.sub(n2), stack.getFirst());
    }

    @Test
    public void testProduct() {
        System.out.println("product");
        ArrayDeque<Complex> stack = new ArrayDeque<>();
        ArithmeticOperation instance = new ArithmeticOperation(stack);
        Complex n1 = new Complex(4, 2);
        Complex n2 = new Complex(2, 4);
        stack.push(n1);
        stack.push(n2);

        instance.product();

        assertEquals(n1.product(n2), stack.getFirst());
    }

    @Test
    public void testDivision() {
        System.out.println("division");
        ArrayDeque<Complex> stack = new ArrayDeque<>();
        ArithmeticOperation instance = new ArithmeticOperation(stack);
        Complex n1 = new Complex(4, 2);
        Complex n2 = new Complex(2, 4);
        stack.push(n1);
        stack.push(n2);

        instance.division();

        assertEquals(n1.division(n2), stack.getFirst());
    }

    @Test
    public void testInversion() {
        System.out.println("inversion");
        ArrayDeque<Complex> stack = new ArrayDeque<>();
        ArithmeticOperation instance = new ArithmeticOperation(stack);
        Complex n1 = new Complex(4, 2);
        stack.push(n1);

        instance.inversion();

        assertEquals(n1.negate(), stack.getFirst());
    }

    @Test
    public void testSqrt() {
        System.out.println("sqrt");
        ArrayDeque<Complex> stack = new ArrayDeque<>();
        ArithmeticOperation instance = new ArithmeticOperation(stack);
        Complex n1 = new Complex(4, 2);
        stack.push(n1);

        instance.sqrt();

        assertEquals(n1.sqrt(), stack.getFirst());
    }

}
