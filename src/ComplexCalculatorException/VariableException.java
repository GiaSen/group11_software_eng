package ComplexCalculatorException;

/**
 * Exception thrown when the user asks for a variable operation
 * with a variable that has not been initialized.
 */
public class VariableException extends ComplexCalculatorException {

    /**
     *
     */
    public VariableException() {
    }

    /**
     *
     * @param string
     */
    public VariableException(String string) {
        super(string);
    }
    
}
