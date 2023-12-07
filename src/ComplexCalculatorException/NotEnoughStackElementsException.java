package ComplexCalculatorException;

public class NotEnoughStackElementsException extends ComplexCalculatorException {

    public NotEnoughStackElementsException() {
    }
    public NotEnoughStackElementsException(String msg) {
        super(msg);
    }
}
