package ComplexCalculatorException;

/**
 * Exception thrown when user asks for an operation that requires more stack
 * element than are available.
 */
public class NotEnoughStackElementsException extends RuntimeException {

    /**
     *
     */
    public NotEnoughStackElementsException() {
    }

    /**
     *
     * @param msg
     */
    public NotEnoughStackElementsException(String msg) {
        super(msg);
    }
}
