package ComplexCalculator;

import ComplexCalculatorException.InvalidInputException;
import ComplexCalculatorException.ZeroDivisionException;
import java.io.Serializable;

/**
 *
 * @author vince
 */
public final class Complex implements Serializable  {
    
    private static final double SQRT_SAFE_UPPER = Double.MAX_VALUE / 8;
    private static final double ONE_OVER_ROOT2 = 0.7071067811865476;

    private final double imaginary;
    private final double real;

    /**
     * Initializes a new Complex number given its real and imaginary part.
     * @param real
     * @param imaginary
     */
    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    /**
     * Initializes a new Complex number given a String.
     * @param s
     */
    public Complex(String s) {
        double a = 0.0;
        double b = 0.0;
        s = s.replaceAll("\\s", "");

        String[] parts = s.split("[+-]");
        String[] posParts = s.split("[+]");
        String[] negParts = s.split("[-]");

        if (parts.length == 1) {
            // numero complesso bj
            if (s.equals("j")) {
                a = 0.0;
                b = 1.0;
            }
            else if (s.contains("j")) {
                s = s.replace("j", "");
                a = 0.0;
                b = Double.parseDouble(s);
            } // numero complesso a
            else {
                a = Double.parseDouble(s);
                b = 0.0;
            }
        } else if (parts.length == 2) {
            if (posParts.length == 2) {
                // numero complesso +bj
                if (posParts[0].equals("")) {
                    if (posParts[1].contains("j")) {
                        String j = posParts[1].replace("j", "");
                        a = 0.0;
                        b = Double.parseDouble(j);
                    } // numero complesso +a
                    else {
                        a = Double.parseDouble(posParts[1]);
                        b = 0.0;
                    }
                } // numero complesso bj+a
                else if (posParts[0].contains("j")) {
                    String j = posParts[0].replace("j", "");
                    a = Double.parseDouble(posParts[1]);
                    b = Double.parseDouble(j);
                } // numero complesso a+bj
                else if (posParts[1].equals("j")) {
                    a = Double.parseDouble(posParts[0]);
                    b = 1.0;
                } else {
                    String j = posParts[1].replace("j", "");
                    a = Double.parseDouble(posParts[0]);
                    b = Double.parseDouble(j);
                }
            } else if (negParts.length == 2) {
                if (negParts[0].equals("")) {
                    // numero complesso -bj
                    if (negParts[1].contains("j")) {
                        String j = negParts[1].replace("j", "");
                        a = 0.0;
                        b = -Double.parseDouble(j);
                    } // numero complesso -a
                    else {
                        a = -Double.parseDouble(negParts[1]);
                        b = 0.0;
                    }
                } // numero complesso bj-a 
                else if (negParts[0].contains("j")) {
                    String j = negParts[0].replace("j", "");
                    a = -Double.parseDouble(negParts[1]);
                    b = Double.parseDouble(j);
                } // numero complesso a-bj
                else if (negParts[1].equals("j")) {
                    a = Double.parseDouble(negParts[0]);
                    b = -1.0;
                } else {
                    String j = negParts[1].replace("j", "");
                    a = Double.parseDouble(negParts[0]);
                    b = -Double.parseDouble(j);
                }
            }
        } else if (parts.length == 3) {
            if (posParts.length == 3 & posParts[0].equals("")) {
                // numero complesso +bj+a
                if (posParts[1].contains("j")) {
                    String j = posParts[1].replace("j", "");
                    a = Double.parseDouble(posParts[2]);
                    b = Double.parseDouble(j);
                } // numero complesso +a+bj
                else if (posParts[2].equals("j")) {
                    a = Double.parseDouble(posParts[1]);
                    b = 1.0;
                } else {
                    String j = posParts[2].replace("j", "");
                    a = Double.parseDouble(posParts[1]);
                    b = Double.parseDouble(j);
                }
            } else if (negParts.length == 3 & negParts[0].equals("")) {
                // numero complesso -bj-a
                if (negParts[1].contains("j")) {
                    String j = negParts[1].replace("j", "");
                    a = -Double.parseDouble(negParts[2]);
                    b = -Double.parseDouble(j);
                } // numero complesso -a-bj
                else if (negParts[2].equals("j")) {
                    a = -Double.parseDouble(negParts[1]);
                    b = -1.0;
                } else {
                    String j = negParts[2].replace("j", "");
                    a = -Double.parseDouble(negParts[1]);
                    b = -Double.parseDouble(j);
                }
            } else if (posParts[0].equals("") & posParts[1].contains("-")) {
                String[] w = posParts[1].split("[-]");
                // numero complesso +bj-a
                if (w[0].contains("j")) {
                    a = -Double.parseDouble(w[1]);
                    b = Double.parseDouble(w[0].replace("j", ""));
                } // numero complesso +a-bj
                else if (w[1].equals("j")) {
                    a = Double.parseDouble(w[0]);
                    b = -1.0;
                } else {
                    a = Double.parseDouble(w[0]);
                    b = -Double.parseDouble(w[1].replace("j", ""));
                }
            } else if (negParts[0].equals("") & negParts[1].contains("+")) {
                String[] w = negParts[1].split("[+]");
                // numero complesso -bj+a
                if (w[0].contains("j")) {
                    a = Double.parseDouble(w[1]);
                    b = -Double.parseDouble(w[0].replace("j", ""));
                } // numero complesso -a+bj
                else if (w[1].equals("j")) {
                    a = -Double.parseDouble(w[0]);
                    b = 1.0;
                } else {
                    a = -Double.parseDouble(w[0]);
                    b = Double.parseDouble(w[1].replace("j", ""));
                }
            }
        } else if (parts.length > 3) {
            throw new InvalidInputException("Scrivere il numero nella rappresentazione cartesiana a+bj");
        }

        this.real = a;
        this.imaginary = b;
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
     * @return Complex
     */
    public Complex negate() {
        return new Complex(-real, -imaginary);
    }

    /**
     * Returns the sum of 2 Complex numbers.
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
     * Returns the square root of a Complex number.
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
            // Potential over/underflow. First check infinites and real/imaginary only.

            // Check for infinite
            if (isPosInfinite(y)) {
                return new Complex(Double.POSITIVE_INFINITY, imaginary);
            } else if (isPosInfinite(x)) {
                if (real == Double.NEGATIVE_INFINITY) {
                    return new Complex(0, Math.copySign(Double.POSITIVE_INFINITY, imaginary));
                }
                return new Complex(Double.POSITIVE_INFINITY, Math.copySign(0, imaginary));
            } else if (y == 0) {
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
     * Record whether the Complex number is positive infinite.
     * @param d
     * @return boolean
     */
    private static boolean isPosInfinite(double d) {
        return d == Double.POSITIVE_INFINITY;
    }
    
    /**
     * Record whether an operation will record an overflow.
     * @param x
     * @param y
     * @param min
     * @param max
     * @return boolean
     */
    private static boolean inRegion(double x, double y, double min, double max) {
        return x < max && x > min && y < max && y > min;
    }

    /**
     * Returns the absolute of 2 double numbers.
     * @param a
     * @param b
     * @return double
     */
    private static double abs(double a, double b) {
        return (Math.sqrt(a * a + b * b));
    }

    /**
     * If the parameter is an integer it prints the number as an integer;
     * If the parameter is a double it prints the number as a float.
     * @param n
     * @return String
     */
    private String printNumber(double n) {
        if (n % 1.0 == 0) {
            return String.valueOf((int) n);
        }
        return String.valueOf((float) n);
    }

    /**
     * States if the input String is a Complex number.
     * @param s
     * @return boolean
     */
    public static boolean isComplex(String s) {
        return s.matches("^(?=[j.\\d+-])([+-]?(?:\\d+(?:\\.\\d*)?|\\.\\d+)(?![j.\\d]))([+-]?(?:(?:\\d+(?:\\.\\d*)?|\\.\\d+))?[j])?$")
                || s.matches("^(?=[j.\\d+-])([+-]?(?:(?:\\d+(?:\\.\\d*)?|\\.\\d+))?[j])?$")
                || s.matches("^(?=[j.\\d+-])([+-]?(?:\\d+(?:\\.\\d*)?|\\.\\d+)(?![j.\\d]))([+-]?[j])$");
    }

    @Override
    public String toString() {
        if (imaginary == 0) {
            return printNumber(real);
        } else if (real == 0) {
            return (imaginary != 1 && imaginary != 0 && imaginary != -1 ? printNumber(imaginary) : "")
                    + (imaginary == -1 ? "-" : "") + "j";
        } else {
            return printNumber(real) + (imaginary > 0 ? "+" : "")
                    + (imaginary != 1 && imaginary != 0 && imaginary != -1 ? printNumber(imaginary) : "")
                    + (imaginary == -1 ? "-" : "") + (imaginary != 0 ? "j" : "");
        }

    }

}
