package ComplexCalculatorOperation;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import ComplexCalculator.Complex;
import ComplexCalculatorException.NotEnoughStackElementsException;
import ComplexCalculatorException.VariableException;

/**
 *
 * @author group11
 */
public class VariableOperation extends Operation {

    private HashMap<String, Complex> map;

    /**
     *
     * @param stack
     */
    public VariableOperation(ArrayDeque stack) {
        super(stack);
        map = new LinkedHashMap<>();
    }

    /**
     * Calls the function suited to the type of Variable operation entered as
     * input.
     *
     * @param input
     */
    @Override
    public void operationInterpreter(String input) {
        String fields[] = input.split("[><+-]");
        if (input.contains(">")) {
            fromStackToVar(fields[1]);
        } else if (input.contains("<")) {
            fromVarToStack(fields[1]);
        } else if (input.contains("+")) {
            sumVar(fields[1]);
        } else if (input.contains("-")) {
            subVar(fields[1]);
        }

    }

    /**
     * Pushes a number from a Variable into the Stack.
     *
     * @param s
     */
    public void fromVarToStack(String s) {
        if (!map.containsKey(s)) {
            throw new VariableException();
        }
        stack.push(map.get(s));
    }

    /**
     * Pushes a number from the Stack into a Variable.
     *
     * @param s
     */
    public void fromStackToVar(String s) {
        if (stack.size() < 1) {
            throw new NotEnoughStackElementsException();
        }
        map.put(s, stack.pop());
    }

    /**
     * Updates the value of the Variable by adding to it the value on top of the
     * Stack.
     *
     * @param s
     */
    public void sumVar(String s) {
        if (!map.containsKey(s)) {
            throw new VariableException();
        } else if (stack.size() < 1) {
            throw new NotEnoughStackElementsException();
        }
        map.put(s, map.get(s).sum(stack.pop()));
    }

    /**
     * Updates the value of the Variable by subtracting to it the value on top
     * of the Stack.
     *
     * @param s
     */
    public void subVar(String s) {
        if (!map.containsKey(s)) {
            throw new VariableException();
        } else if (stack.size() < 1) {
            throw new NotEnoughStackElementsException();
        }
        map.put(s, map.get(s).sub(stack.pop()));
    }

}
