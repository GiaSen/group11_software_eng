package ComplexCalculatorException;

/**
 * Exception thrown when the user enters an invalid input.
 */
public class InvalidInputException extends RuntimeException {

    /** Constructs an ArithmeticException with no detail message.
     *
     */
    public InvalidInputException() {
    }

    /**
     * Constructs an InvalidInputException with the specified detail message.
     *
     * @param string the detail message.
     */
    public InvalidInputException(String string) {
        super(string);
    }

}
