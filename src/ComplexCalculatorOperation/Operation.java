package ComplexCalculatorOperation;

import ComplexCalculator.Complex;
import java.util.ArrayDeque;

/**
 *
 * @author group11
 */
public abstract class Operation {

    /**
     *
     */
    protected final ArrayDeque<Complex> stack;
    
    /**
     *
     * @param stack
     */
    public Operation(ArrayDeque stack){
        this.stack = stack;
    }

    /**
     *
     * @param s
     */
    public abstract void operationInterpreter(String s);

}