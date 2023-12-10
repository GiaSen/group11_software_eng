package ComplexCalculator;

import ComplexCalculatorException.InvalidInputException;
import ComplexCalculatorException.ZeroDivisionException;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Complex class represents complex numbers given their imaginary and real
 * part; The class provides all methods for operations such as sum, subtraction,
 * product and division.
 *
 * @author group11
 */
public final class Complex implements Serializable {

    /**
     * The safe maximum double value {@code x} to avoid overflow in sqrt.
     */
    private static final double SQRT_SAFE_UPPER = Double.MAX_VALUE / 8;

    /**
     * {@code 1.0 / sqrt(2)}. This is pre-computed to the closest double from
     * the exact result. It is 1 ULP different from 1.0 / Math.sqrt(2) but equal
     * to Math.sqrt(2) / 2.
     */
    private static final double ONE_OVER_ROOT2 = 0.7071067811865476;
    private static final String complexRegex = "^(?=[j.\\d+-])([+-]?(?:\\d+(?:\\.\\d*)?|\\.\\d+)(?![j.\\d]))([+-]?(?:(?:\\d+(?:\\.\\d*)?|\\.\\d+))?)?[j]$";
    private static final String realRegex = "^([+-]?[0-9]*\\.?[0-9]*)$";
    private static final String imaginaryRegex = "^(?=[j.\\d+-])([+-]?(?:(?:\\d+(?:\\.\\d*)?|\\.\\d+))?)[j]+$";
    private double imaginary;
    private double real;

    /**
     * Initializes a new Complex number given its real and imaginary part.
     *
     * @param real
     * @param imaginary
     */
    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    /**
     * Initializes a new Complex number given a String Splits a string from its
     * matched regex and parses the input into doubles.
     *
     * @param s
     */
    public Complex(String s) {
        // Deletes the white spaces.
        String numberNoWhiteSpace = s.replaceAll("\\s", "");

        // Matches complex number with BOTH real AND imaginary parts.  
        Pattern patternA = Pattern.compile(complexRegex);

        // Matches ONLY real number.
        Pattern patternB = Pattern.compile(realRegex);

        // Matches ONLY imaginary number.
        Pattern patternC = Pattern.compile(imaginaryRegex);

        // Creates a matcher that will match the given input against this
        // pattern.
        // Splits the string as dictated by the regex.
        Matcher matcherA = patternA.matcher(numberNoWhiteSpace);
        Matcher matcherB = patternB.matcher(numberNoWhiteSpace);
        Matcher matcherC = patternC.matcher(numberNoWhiteSpace);

        // Checks which pattern was matched and assigns the right value to real 
        // and imaginary part.
        if (matcherA.find()) {
            real = Double.parseDouble(matcherA.group(1));
            if (matcherA.group(2).equals("+")) {
                imaginary = 1.0;
            } else if (matcherA.group(2).equals("-")) {
                imaginary = -1.0;
            } else {
                imaginary = Double.parseDouble(matcherA.group(2));
            }
        } else if (matcherB.find()) {
            real = Double.parseDouble(matcherB.group(1));
            imaginary = 0.0;
        } else if (matcherC.find()) {
            if (s.equals("j")) {
                real = 0.0;
                imaginary = 1.0;
            } else {
                real = 0.0;
                imaginary = Double.parseDouble(matcherC.group(1));
            }
        } else {
            throw new InvalidInputException();
        }

    }

    /**
     *
     * @return double
     */
    public double getReal() {
        return real;
    }

    /**
     *
     * @return double
     */
    public double getImaginary() {
        return imaginary;
    }

    /**
     * Returns the negate of a Complex number.
     *
     * @return Complex
     */
    public Complex negate() {
        return new Complex(-real, -imaginary);
    }

    /**
     * Returns the sum of 2 Complex numbers.
     *
     * @param n
     * @return Complex
     */
    public Complex sum(Complex n) {
        double a = real;
        double b = imaginary;
        double c = n.getReal();
        double d = n.getImaginary();

        return new Complex(a + c, b + d);
    }

    /**
     * Returns the subtraction of 2 Complex numbers.
     *
     * @param n
     * @return Complex
     */
    public Complex sub(Complex n) {
        double a = real;
        double b = imaginary;
        double c = n.getReal();
        double d = n.getImaginary();

        return new Complex(a - c, b - d);
    }

    /**
     * Returns the product of 2 Complex numbers.
     *
     * @param n
     * @return Complex
     */
    public Complex product(Complex n) {
        double a = real;
        double b = imaginary;
        double c = n.getReal();
        double d = n.getImaginary();

        return new Complex((a * c) - (b * d), (a * d) + (b * c));
    }

    /**
     * Returns the division of 2 Complex numbers.
     *
     * @param n
     * @return Complex
     */
    public Complex division(Complex n) {
        double a = real;
        double b = imaginary;
        double c = n.getReal();
        double d = n.getImaginary();

        double ac = a * c;
        double bd = b * d;
        double bc = b * c;
        double ad = a * d;

        double z = abs(c, d) * abs(c, d);

        if (z == 0) {
            throw new ZeroDivisionException();
        }

        return new Complex((ac + bd) / (z), (bc - ad) / (z));
    }

    /**
     * Returns the square root of a Complex number. from package
     * org.apache.commons.numbers.complex;
     *
     * @return Complex
     */
    public Complex sqrt() {

        // Compute with positive values and determine sign at the end
        final double x = Math.abs(real);
        final double y = Math.abs(imaginary);

        // Compute
        double t;

        // This alters the implementation of Hull et al (1994) which used a standard
        // precision representation of |z|: sqrt(x*x + y*y).
        // This formula should use the same definition of the magnitude returned
        // by Complex.abs() which is a high precision computation with scaling.
        // Worry about overflow if 2 * (|z| + |x|) will overflow.
        // Worry about underflow if |z| or |x| are sub-normal components.
        if (inRegion(x, y, Double.MIN_NORMAL, SQRT_SAFE_UPPER)) {
            // No over/underflow
            t = Math.sqrt(2 * (abs(x, y) + x));
        } else {
            if (y == 0) {
                // Real only
                final double sqrtAbs = Math.sqrt(x);
                if (real < 0) {
                    return new Complex(0, Math.copySign(sqrtAbs, imaginary));
                }
                return new Complex(sqrtAbs, imaginary);
            } else if (x == 0) {
                // Imaginary only. This sets the two components to the same magnitude.
                // Note: In polar coordinates this does not happen:
                // real = sqrt(abs()) * Math.cos(arg() / 2)
                // imag = sqrt(abs()) * Math.sin(arg() / 2)
                // arg() / 2 = pi/4 and cos and sin should both return sqrt(2)/2 but
                // are different by 1 ULP.
                final double sqrtAbs = Math.sqrt(y) * ONE_OVER_ROOT2;
                return new Complex(sqrtAbs, Math.copySign(sqrtAbs, imaginary));
            } else {
                // Over/underflow.
                // Full scaling is not required as this is done in the hypotenuse function.
                // Keep the number as big as possible for maximum precision in the second sqrt.
                // Note if we scale by an even power of 2, we can re-scale by sqrt of the number.
                // a = sqrt(b)
                // a = sqrt(b/4) * sqrt(4)

                double rescale;
                double sx;
                double sy;
                if (Math.max(x, y) > SQRT_SAFE_UPPER) {
                    // Overflow. Scale down by 16 and rescale by sqrt(16).
                    sx = x / 16;
                    sy = y / 16;
                    rescale = 4;
                } else {
                    // Sub-normal numbers. Make them normal by scaling by 2^54,
                    // i.e. more than the mantissa digits, and rescale by sqrt(2^54) = 2^27.
                    sx = x * 0x1.0p54;
                    sy = y * 0x1.0p54;
                    rescale = 0x1.0p-27;
                }
                t = rescale * Math.sqrt(2 * (abs(sx, sy) + sx));
            }
        }

        if (real >= 0) {
            return new Complex(t / 2, imaginary / t);
        }
        return new Complex(y / t, Math.copySign(t / 2, imaginary));
    }

    /**
     * Checks if both x and y are in the region defined by the minimum and maximum.
     *
     * @param x  x value
     * @param y y value
     * @param min the minimum (exclusive)
     * @param max the maximum (exclusive)
     * @return true true if inside the region.
     */
    private static boolean inRegion(double x, double y, double min, double max) {
        return x < max && x > min && y < max && y > min;
    }

    /**
     * Returns the absolute value of the Complex number.
     *
     * @param a
     * @param b
     * @return double
     */
    private static double abs(double a, double b) {
        return (Math.sqrt(a * a + b * b));
    }

    /**
     * If the parameter is an integer until +-10^7 it prints the number as an
     * integer; If the parameter is a double it prints the number as a double.
     *
     * @param n
     * @return String
     */
    private String printNumber(double n) {
        /*if the number doesn't have a decimal part and is included in the range that the "Double" class prints
        without simplifying it gets printed as an int*/
        if (n % 1.0 == 0 && n < 10000000 && n > -10000000) {
            return String.valueOf((int) n);
        } //if the number has a decimal part and is still included in the range that the "Double" class prints without simplifying it gets printed as a double with a maximum of three decimal digits.
        else if (n < 10000000 && n > -10000000) {
            DecimalFormat df = new DecimalFormat("#.#####");
            return df.format(n);
        }
        //else, the number gets printed normally
        return String.valueOf(n);
    }

    /**
     * States if the input String is a Complex number.
     *
     * @param s
     * @return boolean
     */
    public static boolean isComplex(String s) {
        return s.matches(complexRegex)
                || s.matches(realRegex)
                || s.matches(imaginaryRegex);
    }

    @Override
    public String toString() {
        //if the number doesn't have an imaginary part only the real part gets printed
        if (imaginary == 0) {
            return printNumber(real);
        } //if the number doesn't have a real part only the imaginary part gets printed, making sure that if the number is -1 or 1 just -j or j get printed
        else if (real == 0) {
            return (imaginary != 1 && imaginary != 0 && imaginary != -1 ? printNumber(imaginary) : "")
                    + (imaginary == -1 ? "-" : "") + "j";
        } //else the whole complex number gets printed, making the same checks for the imaginary part as before
        else {
            return printNumber(real) + (imaginary > 0 ? "+" : "")
                    + (imaginary != 1 && imaginary != 0 && imaginary != -1 ? printNumber(imaginary) : "")
                    + (imaginary == -1 ? "-" : "") + (imaginary != 0 ? "j" : "");
        }

    }

}
