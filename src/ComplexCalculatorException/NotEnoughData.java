package ComplexCalculatorException;

public class NotEnoughData extends RuntimeException {

    public NotEnoughData() {
    }

    public NotEnoughData(String string) {
        super(string);
    }
    
}
