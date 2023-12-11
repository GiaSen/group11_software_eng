package ComplexCalculatorOperation;

import ComplexCalculator.Complex;
import java.util.ArrayDeque;

/**
 * The Operation class abstracts the concept of operation providing the basics
 * methods to handle different types of operations on the calculator such as
 * ArithmeticOperation, StackOperation or VariableOperation.
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
    public Operation(ArrayDeque stack) {
        this.stack = stack;
    }

    /**
     *
     * @param s
     */
    public abstract void operationInterpreter(String s);

}
