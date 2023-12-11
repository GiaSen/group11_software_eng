/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ComplexCalculator;

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
public class ComplexTest {
    
    public ComplexTest() {
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
     * Test of getReal method, of class Complex.
     */
    @Test
    public void testGetReal() {
        System.out.println("getReal");
        Complex instance = null;
        double expResult = 0.0;
        double result = instance.getReal();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImaginary method, of class Complex.
     */
    @Test
    public void testGetImaginary() {
        System.out.println("getImaginary");
        Complex instance = null;
        double expResult = 0.0;
        double result = instance.getImaginary();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of negate method, of class Complex.
     */
    @Test
    public void testNegate() {
        System.out.println("negate");
        Complex instance = null;
        Complex expResult = null;
        Complex result = instance.negate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sum method, of class Complex.
     */
    @Test
    public void testSum() {
        System.out.println("sum");
        Complex n = null;
        Complex instance = null;
        Complex expResult = null;
        Complex result = instance.sum(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sub method, of class Complex.
     */
    @Test
    public void testSub() {
        System.out.println("sub");
        Complex n = null;
        Complex instance = null;
        Complex expResult = null;
        Complex result = instance.sub(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of product method, of class Complex.
     */
    @Test
    public void testProduct() {
        System.out.println("product");
        Complex n = null;
        Complex instance = null;
        Complex expResult = null;
        Complex result = instance.product(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of division method, of class Complex.
     */
    @Test
    public void testDivision() {
        System.out.println("division");
        Complex n = null;
        Complex instance = null;
        Complex expResult = null;
        Complex result = instance.division(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sqrt method, of class Complex.
     */
    @Test
    public void testSqrt() {
        System.out.println("sqrt");
        Complex instance = null;
        Complex expResult = null;
        Complex result = instance.sqrt();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isComplex method, of class Complex.
     */
    @Test
    public void testIsComplex() {
        System.out.println("isComplex");
        String s = "";
        boolean expResult = false;
        boolean result = Complex.isComplex(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Complex.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Complex instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
