package ComplexCalculator;

import ComplexCalculatorException.ZeroDivisionException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
    public void testGetReal1() {
        System.out.println("getReal");
        Complex instance = new Complex("5.002+41j");
        double expResult = 5.002;
        double result = instance.getReal();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetReal2() {
        System.out.println("getReal");
        Complex instance = new Complex("17j");
        double expResult = 0.0;
        double result = instance.getReal();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetReal3() {
        System.out.println("getReal");
        Complex instance = new Complex("-1.324+41j");
        double expResult = -1.324;
        double result = instance.getReal();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetReal4() {
        System.out.println("getReal");
        Complex instance = new Complex("-3.54j");
        double expResult = 0.0;
        double result = instance.getReal();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getImaginary method, of class Complex.
     */
    @Test
    public void testGetImaginary1() {
        System.out.println("getImaginary");
        Complex instance = new Complex("5.002+41j");
        double expResult = 41;
        double result = instance.getImaginary();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetImaginary2() {
        System.out.println("getImaginary");
        Complex instance = new Complex("17j");
        double expResult = 17;
        double result = instance.getImaginary();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetImaginary3() {
        System.out.println("getImaginary");
        Complex instance = new Complex("-2");
        double expResult = 0.0;
        double result = instance.getImaginary();
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testGetImaginary4() {
        System.out.println("getImaginary");
        Complex instance = new Complex("-8.45j");
        double expResult = -8.45;
        double result = instance.getImaginary();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of negate method, of class Complex.
     */
    @Test
    public void testNegate1() {
        System.out.println("negate");
        Complex instance = new Complex("2.551-43j");
        Complex expResult = new Complex("-2.551+43j");
        Complex result = instance.negate();
        assertEquals(expResult, result);

    }

    @Test
    public void testNegate2() {
        System.out.println("negate");
        Complex instance = new Complex("-1.52-2.3j");
        Complex expResult = new Complex("1.52+2.3j");
        Complex result = instance.negate();
        assertEquals(expResult, result);
    }

    @Test
    public void testNegate3() {
        System.out.println("negate");
        Complex instance = new Complex("9.75");
        Complex expResult = new Complex("-9.75");
        Complex result = instance.negate();
        assertEquals(expResult, result);
    }

    @Test
    public void testNegate4() {
        System.out.println("negate");
        Complex instance = new Complex("-8.53j");
        Complex expResult = new Complex("8.53j");
        Complex result = instance.negate();
        assertEquals(expResult, result);
    }

    /**
     * Test of sum method, of class Complex.
     */
    @Test
    public void testSum1() {
        System.out.println("sum");
        Complex n = new Complex("-5.2+2.65j");
        Complex instance = new Complex("1+3j");
        Complex expResult = new Complex("-4.2+5.65j");
        Complex result = instance.sum(n);
        assertEquals(expResult, result);
    }

    @Test
    public void testSum2() {
        System.out.println("sum");
        Complex n = new Complex("0.21+3.005j");
        Complex instance = new Complex("-2.8+4.74j");
        Complex expResult = new Complex("-2.59+7.745j");
        Complex result = instance.sum(n);
        assertEquals(expResult, result);
    }

    @Test
    public void testSum3() {
        System.out.println("sum");
        Complex n = new Complex("1");
        Complex instance = new Complex("j");
        Complex expResult = new Complex("1+j");
        Complex result = instance.sum(n);
        assertEquals(expResult, result);
    }

    @Test
    public void testSum4() {
        System.out.println("sum");
        Complex n = new Complex("2.5478");
        Complex instance = new Complex("0.0002-4.84j");
        Complex expResult = new Complex("2.548-4.84j");
        Complex result = instance.sum(n);
        assertEquals(expResult, result);
    }

    /**
     * Test of sub method, of class Complex.
     */
    @Test
    public void testSub1() {
        System.out.println("sub");
        Complex n = new Complex("4.005+2.74j");
        Complex instance = new Complex("4.005+2.74j");
        Complex expResult = new Complex("0");
        Complex result = instance.sub(n);
        assertEquals(expResult, result);
    }

    @Test
    public void testSub2() {
        System.out.println("sub");
        Complex n = new Complex("1.25-2j");
        Complex instance = new Complex("5.42j");
        Complex expResult = new Complex("-1.25+7.42j");
        Complex result = instance.sub(n);
        assertEquals(expResult, result);
    }

    @Test
    public void testSub3() {
        System.out.println("sub");
        Complex n = new Complex("68-77.15j");
        Complex instance = new Complex("5.12+6.35j");
        Complex expResult = new Complex("-62.88+83.5j");
        Complex result = instance.sub(n);
        assertEquals(expResult, result);
    }

    @Test
    public void testSub4() {
        System.out.println("sub");
        Complex n = new Complex("4+12.5j");
        Complex instance = new Complex("25j");
        Complex expResult = new Complex("-4+12.5j");
        Complex result = instance.sub(n);
        assertEquals(expResult, result);
    }

    /**
     * Test of product method, of class Complex.
     */
    @Test
    public void testProduct1() {
        System.out.println("product");
        Complex n = new Complex("0");
        Complex instance = new Complex("24.4+3.66j");
        Complex expResult = new Complex("0");
        Complex result = instance.product(n);
        assertEquals(expResult.getReal(), result.getReal(), 0.00001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.00001);
    }

    @Test
    public void testProduct2() {
        System.out.println("product");
        Complex n = new Complex("j");
        Complex instance = new Complex("j");
        Complex expResult = new Complex("-1");
        Complex result = instance.product(n);
        assertEquals(expResult.getReal(), result.getReal(), 0.00001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.00001);
    }

    @Test
    public void testProduct3() {
        System.out.println("product");
        Complex n = new Complex("7.21+6j");
        Complex instance = new Complex("3");
        Complex expResult = new Complex("21.63+18j");
        Complex result = instance.product(n);
        assertEquals(expResult.getReal(), result.getReal(), 0.00001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.00001);
    }

    @Test
    public void testProduct4() {
        System.out.println("product");
        Complex n = new Complex("1+3.7j");
        Complex instance = new Complex("7.16+2.51j");
        Complex expResult = new Complex("-2.127+29.002j");
        Complex result = instance.product(n);
        assertEquals(expResult.getReal(), result.getReal(), 0.00001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.00001);
    }

    /**
     * Test of division method, of class Complex.
     */
    @Test
    public void testDivision1() {
        System.out.println("division");
        Complex n = new Complex("j");
        Complex instance = new Complex("1");
        Complex expResult = new Complex("-1j");
        Complex result = instance.division(n);
        assertEquals(expResult.getReal(), result.getReal(), 0.00001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.00001);
    }

    @Test
    public void testDivision2() {
        System.out.println("division");
        Complex n = new Complex("5+4j");
        Complex instance = new Complex("2.3j");
        Complex expResult = new Complex("0.22439+0.28049j");
        Complex result = instance.division(n);
        assertEquals(expResult.getReal(), result.getReal(), 0.00001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.00001);
    }

    @Test
    public void testDivision3() {
        System.out.println("division");
        Complex n = new Complex("10-42j");
        Complex instance = new Complex("-42.4+j");
        Complex expResult = new Complex("-0.25-0.95j");
        Complex result = instance.division(n);
        assertEquals(expResult.getReal(), result.getReal(), 0.00001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.00001);
    }

    @Test
    public void testDivision4() {
        System.out.println("division");
        Complex n = new Complex("0");
        Complex instance = new Complex("3.98+0.5j");
        assertThrows(ZeroDivisionException.class, () -> {
            instance.division(n);
        });
    }

    /**
     * Test of sqrt method, of class Complex.
     */
    @Test
    public void testSqrt1() {
        System.out.println("sqrt");
        Complex instance = new Complex("-1");
        Complex expResult = new Complex("j");
        Complex result = instance.sqrt();
        assertEquals(expResult.getReal(), result.getReal(), 0.00001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.00001);
    }

    @Test
    public void testSqrt2() {
        System.out.println("sqrt");
        Complex instance = new Complex("4+3j");
        Complex expResult = new Complex("2.12132+0.70711j");
        Complex result = instance.sqrt();
        assertEquals(expResult.getReal(), result.getReal(), 0.00001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.00001);
    }

    @Test
    public void testSqrt3() {
        System.out.println("sqrt");
        Complex instance = new Complex("4.16");
        Complex expResult = new Complex("2.03961");
        Complex result = instance.sqrt();
        assertEquals(expResult.getReal(), result.getReal(), 0.00001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.00001);
    }

    @Test
    public void testSqrt4() {
        System.out.println("sqrt");
        Complex instance = new Complex("-1-3j");
        Complex expResult = new Complex("1.03978-1.44262j");
        Complex result = instance.sqrt();
        assertEquals(expResult.getReal(), result.getReal(), 0.00001);
        assertEquals(expResult.getImaginary(), result.getImaginary(), 0.00001);
    }

    /**
     * Test of isComplex method, of class Complex.
     */
    @Test
    public void testIsComplex1() {
        System.out.println("isComplex");
        String s = "3.21+5j";
        boolean expResult = true;
        boolean result = Complex.isComplex(s);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsComplex2() {
        System.out.println("isComplex");
        String s = "a";
        boolean expResult = false;
        boolean result = Complex.isComplex(s);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsComplex3() {
        System.out.println("isComplex");
        String s = "prova";
        boolean expResult = false;
        boolean result = Complex.isComplex(s);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsComplex4() {
        System.out.println("isComplex");
        String s = "32.71j";
        boolean expResult = true;
        boolean result = Complex.isComplex(s);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Complex.
     */
    @Test
    public void testToString1() {
        System.out.println("toString");
        Complex instance = new Complex("0.0+0.0j");
        String expResult = "0";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testToString2() {
        System.out.println("toString");
        Complex instance = new Complex(".5+3j");
        String expResult = "0.5+3j";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testToString3() {
        System.out.println("toString");
        Complex instance = new Complex("4.21+1j");
        String expResult = "4.21+j";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testToString4() {
        System.out.println("toString");
        Complex instance = new Complex("0+3.2j");
        String expResult = "3.2j";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
