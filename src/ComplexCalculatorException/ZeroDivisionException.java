package ComplexCalculatorException;

/**
 * Exception thrown when the user tries to do divide a number by 0.
 */
public class ZeroDivisionException extends ComplexCalculatorException {

    /**
     *
     */
    public ZeroDivisionException() {
    }

    /**
     *
     * @param string
     */
    public ZeroDivisionException(String string) {
        super(string);
    }

}
