package ComplexCalculatorException;

public class NotEnoughStackElementsException extends RuntimeException {

    public NotEnoughStackElementsException() {
    }
    public NotEnoughStackElementsException(String msg) {
        super(msg);
    }
}
