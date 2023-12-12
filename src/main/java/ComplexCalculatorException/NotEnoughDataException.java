package ComplexCalculatorException;

/**
 * Exception thrown when user asks for an operation that requires more operands
 * than are available.
 */
public class NotEnoughDataException extends RuntimeException {

    /** Constructs a NotEnoughDataException with no detail message.
     *
     */
    public NotEnoughDataException() {
    }

    /**
     * Constructs a NotEnoughDataException with the specified detail message.
     *
     * @param string the detail message.
     */
    public NotEnoughDataException(String string) {
        super(string);
    }

}
