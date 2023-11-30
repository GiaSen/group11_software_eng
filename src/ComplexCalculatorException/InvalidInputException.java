package ComplexCalculatorException;

public class InvalidInputException extends RuntimeException {

    public InvalidInputException() {
    }

    public InvalidInputException(String string) {
        super(string);
    }
    
}
