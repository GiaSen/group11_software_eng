package ComplexCalculatorException;

/**
 * Exception thrown when the user asks for a variable operation with a variable
 * that has not been initialized.
 */
public class VariableException extends RuntimeException {

    /** Constructs a VariableException with no detail message.
     *
     */
    public VariableException() {
    }

    /**
     * Constructs a VariableException with the specified detail message.
     *
     * @param string the detail message.
     */
    public VariableException(String string) {
        super(string);
    }

}
