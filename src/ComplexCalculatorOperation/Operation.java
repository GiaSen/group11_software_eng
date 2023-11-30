package ComplexCalculatorOperation;

import ComplexCalculator.Complex;
import java.util.ArrayDeque;

public abstract class Operation {

    protected final ArrayDeque<Complex> stack;
    
    public Operation(ArrayDeque stack){
        this.stack = stack;
    }

    public abstract void interpreter(String s);

}