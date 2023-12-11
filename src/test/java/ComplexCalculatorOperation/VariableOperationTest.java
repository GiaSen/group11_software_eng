/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
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
 * @author giasen
 */
public class VariableOperationTest {

    HashMap<String, Complex> map;
    ArrayDeque<Complex> stack;
    VariableOperation varOp;
    Complex c, c2, c3;

    public VariableOperationTest() {
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
        varOp = new VariableOperation(stack);
        map = varOp.getMap();
        c = new Complex(1, 2);
        c2 = new Complex(10, 20);
        c3 = new Complex(4, 5);
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of operationInterpreter method, of class VariableOperation.
     */
    @Test
    public void testOperationInterpreter() {
        String input = "Hi";
        assertThrows(InvalidInputException.class, () -> varOp.operationInterpreter(input));
    }

    /**
     * Test of fromStackToVar method, of class VariableOperation.
     */
    @Test
    public void testFromStackToVar1() {
        stack.push(c);
        varOp.fromStackToVar("a");
        assertEquals(c, map.get("a"));
    }

    @Test
    public void testFromStackToVar2() {
        stack.push(c2);
        varOp.fromStackToVar("a");
        assertEquals(c2, map.get("a"));
    }

    @Test
    public void testFromStackToVar3() {
        stack.push(c3);
        varOp.fromStackToVar("a");
        assertEquals(c3, map.get("a"));
    }

    /**
     * Test of fromVarToStack method, of class VariableOperation.
     */
    @Test
    public void testFromVarToStack1() {
        map.put("a", c);
        varOp.fromVarToStack("a");
        assertEquals(c, stack.getFirst());
    }

    @Test
    public void testFromVarToStack2() {
        map.put("a", c2);
        varOp.fromVarToStack("a");
        assertEquals(c2, stack.getFirst());
    }

    @Test
    public void testFromVarToStack3() {
        map.put("a", c3);
        varOp.fromVarToStack("a");
        assertEquals(c3, stack.getFirst());
    }

    /**
     * Test of sumVar method, of class VariableOperation.
     */
    @Test
    public void testSumVar1() {
        map.put("a", c);
        stack.push(c2);
        Complex sum = c.sum(c2);
        varOp.sumVar("a");
        assertEquals(sum, map.get("a"));
    }

    @Test
    public void testSumVar2() {
        map.put("a", c);
        stack.push(c3);
        Complex sum = c.sum(c3);
        varOp.sumVar("a");
        assertEquals(sum, map.get("a"));
    }

    /**
     * Test of subVar method, of class VariableOperation.
     */
    @Test
    public void testSubVar1() {
        map.put("a", c);
        stack.push(c2);
        Complex sub = c.sub(c2);
        varOp.subVar("a");
        assertEquals(sub, map.get("a"));
    }

    @Test
    public void testSubVar2() {
        map.put("a", c);
        stack.push(c2);
        Complex sub = c.sub(c2);
        varOp.subVar("a");
        assertEquals(sub, map.get("a"));
    }

    /**
     * Test of getMap method, of class VariableOperation.
     */
    @Test
    public void testGetMap() {
        assertNotNull(varOp.getMap());
    }

}
