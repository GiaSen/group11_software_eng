package ComplexCalculatorException;

/**
 * Exception thrown when user asks for an operation that requires more stack
 * element than are available.
 */
public class NotEnoughStackElementsException extends RuntimeException {

    /** Constructs a NotEnoughStackElementsException with no detail message.
     *
     */
    public NotEnoughStackElementsException() {
    }

    /**
     * Constructs a NotEnoughStackElementsException with the specified detail message.
     *
     * @param string the detail message.
     */
    public NotEnoughStackElementsException(String string) {
        super(string);
    }
}
