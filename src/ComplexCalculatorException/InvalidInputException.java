package ComplexCalculatorException;

/**
 * Exception thrown when the user enters an invalid input.
 */
public class InvalidInputException extends RuntimeException {

    /**
     *
     */
    public InvalidInputException() {
    }

    /**
     *
     * @param string
     */
    public InvalidInputException(String string) {
        super(string);
    }

}
