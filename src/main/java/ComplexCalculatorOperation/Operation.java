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

    /** Initializes the Operation class.
     *
     * @param stack the stack data structure on which the operation will work.
     */
    public Operation(ArrayDeque stack) {
        this.stack = stack;
    }

    /**
     * Calls the function suited to the type of operation entered as
     * input.
     *
     * @param input the String to analize.
     */
    public abstract void operationInterpreter(String input);

}
