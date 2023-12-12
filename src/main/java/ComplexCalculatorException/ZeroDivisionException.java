package ComplexCalculatorException;

/**
 * Exception thrown when the user tries to do divide a number by 0.
 */
public class ZeroDivisionException extends RuntimeException {

    /** Constructs a ZeroDivisionException with no detail message.
     *
     */
    public ZeroDivisionException() {
    }

    /**
     * Constructs a ZeroDivisionException with the specified detail message.
     *
     * @param string the detail message.
     */
    public ZeroDivisionException(String string) {
        super(string);
    }

}
