package ComplexCalculatorOperation;

import ComplexCalculator.Complex;
import ComplexCalculatorException.InvalidInputException;
import ComplexCalculatorException.NotEnoughStackElementsException;
import ComplexCalculatorException.VariableException;
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
    public void testOperationInterpreter1() {
        System.out.println("OperationInterpreter1");
        stack.push(c);
        String input = ">a"; // example of a right input insertion
        varOp.operationInterpreter(input);

        assertEquals(c, map.get("a"));
    }

    @Test
    public void testOperationInterpreter2() {
        System.out.println("OperationInterpreter2 bad input");
        String input = "<A"; // example of a bad input insertion (Capital a)
        assertThrows(InvalidInputException.class, () -> varOp.operationInterpreter(input));
    }

    /**
     * Test of fromStackToVar method, of class VariableOperation.
     */
    @Test
    public void testFromStackToVar1() {
        System.out.println("FromStackToVar1");
        stack.push(c);
        varOp.fromStackToVar("a");
        assertEquals(c, map.get("a"));
    }

    @Test
    public void testFromStackToVar2() {
        System.out.println("FromStackToVar2");
        assertThrows(NotEnoughStackElementsException.class, () -> varOp.fromStackToVar("a"));
    }

    @Test
    public void testFromStackToVar3() {
        System.out.println("FromStackToVar3");
        stack.push(c3);
        stack.push(c2);
        varOp.fromStackToVar("a");
        assertEquals(c2, map.get("a"));
    }

    /**
     * Test of fromVarToStack method, of class VariableOperation.
     */
    @Test
    public void testFromVarToStack1() {
        System.out.println("FromVarToStack1");
        map.put("a", c);
        varOp.fromVarToStack("a");
        assertEquals(c, stack.getFirst());
    }

    @Test
    public void testFromVarToStack2() {
        System.out.println("FromVarToStack2 no variable");
        assertThrows(VariableException.class, () -> varOp.fromVarToStack("a"));
    }

    @Test
    public void testFromVarToStack3() {
        System.out.println("FromVarToStack3");
        map.put("a", c3);
        map.put("b", c2);
        varOp.fromVarToStack("b");
        assertEquals(c2, stack.getFirst());
    }

    /**
     * Test of sumVar method, of class VariableOperation.
     */
    @Test
    public void testSumVar1() {
        System.out.println("sumVar1");
        map.put("a", c);
        stack.push(c2);
        Complex sum = c.sum(c2);
        varOp.sumVar("a");
        assertEquals(sum, map.get("a"));
    }

    @Test
    public void testSumVar2() {
        System.out.println("sumVar2 no variable and no stack elements");
        assertThrows(VariableException.class, () -> varOp.sumVar("a"));
    }

    @Test
    public void testSumVar3() {
        System.out.println("sumVar3 no stack elements");
        map.put("a", c);
        assertThrows(NotEnoughStackElementsException.class, () -> varOp.sumVar("a"));
    }

    @Test
    public void testSumVar4() {
        System.out.println("sumVar4 no variable");
        stack.push(c);
        assertThrows(VariableException.class, () -> varOp.sumVar("a"));
    }

    /**
     * Test of subVar method, of class VariableOperation.
     */
    @Test
    public void testSubVar1() {
        System.out.println("subVar1");
        map.put("a", c);
        stack.push(c2);
        Complex sub = c.sub(c2);
        varOp.subVar("a");
        assertEquals(sub, map.get("a"));
    }

    @Test
    public void testSubVar2() {
        System.out.println("subVar2 no variable and no stack elements");
        assertThrows(VariableException.class, () -> varOp.subVar("a"));
    }

    @Test
    public void testSubVar3() {
        System.out.println("subVar3 no stack elements");
        map.put("a", c);
        assertThrows(NotEnoughStackElementsException.class, () -> varOp.subVar("a"));
    }

    @Test
    public void testSubVar4(){
        System.out.println("subVar4 no variable");
        stack.push(c);
        assertThrows(VariableException.class, () -> varOp.subVar("a"));
    }

    /**
     * Test of getMap method, of class VariableOperation.
     */
    @Test
    public void testGetMap() {
        assertNotNull(varOp.getMap());
    }

}
