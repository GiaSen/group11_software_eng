package ComplexCalculatorException;

public class NotEnoughDataException extends RuntimeException {

    public NotEnoughDataException() {
    }

    public NotEnoughDataException(String string) {
        super(string);
    }
    
}
