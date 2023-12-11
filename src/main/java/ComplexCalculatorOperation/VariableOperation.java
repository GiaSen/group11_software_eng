package ComplexCalculatorOperation;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import ComplexCalculator.Complex;
import ComplexCalculatorException.InvalidInputException;
import ComplexCalculatorException.NotEnoughStackElementsException;
import ComplexCalculatorException.VariableException;

/**
 * The VariableOperation class manages the operations on variables. It provides
 * an operationInterpreter method, which calls the needed function given the
 * input. The class also defines an HashMap data structure, which contains the
 * variable names as keys and complex numbers as values. The class implements
 * four methods to operate on the map: fromVarToStack, fromStackToVar, sumVar,
 * subVar.
 */
public class VariableOperation extends Operation {

    private HashMap<String, Complex> map;

    /** Initializes the VariableOperation class.
     *
     * @param stack the stack data structure on which the operation will work.
     */
    public VariableOperation(ArrayDeque stack) {
        super(stack);
        map = new LinkedHashMap<>();
    }

    /**
     * Calls the function suited to the type of Variable operation entered as
     * input.
     *
     * @param input the String to analize.
     * @throws InvalidInputException if the String doesn't correspond to any of
     * the supported operations.
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
        } else {
            throw new InvalidInputException();
        }

    }

    /**
     * Pushes a number from the Stack into a Variable.
     *
     * @param s the name of the Variable in which to push the top value of
     * the Stack.
     * @throws NotEnoughStackElementsException if the Stack doesn't contain
     * enough elements for the operation.
     */
    public void fromStackToVar(String s) {
        if (stack.size() < 1) {
            throw new NotEnoughStackElementsException();
        }
        map.put(s, stack.pop());
    }

    /**
     * Pushes a number from a Variable into the Stack.
     *
     * @param s the name of the Variable to push into the Stack.
     * @throws NotEnoughStackElementsException if the Stack doesn't contain
     * enough elements for the operation.
     */
    public void fromVarToStack(String s) {
        if (!map.containsKey(s)) {
            throw new VariableException();
        }
        stack.push(map.get(s));
    }

    /**
     * Updates the value of the Variable by adding to it the value on top of the
     * Stack using the sum method defined in the Complex class.
     *
     * @param s the name of the Variable to sum to the top value of the Stack.
     * @throws VariableException if the Variable isn't initialized.
     * @throws NotEnoughStackElementsException if the Stack doesn't contain
     * enough elements for the operation.
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
     * of the Stack using the sub method defined in the Complex class.
     *
     * @param s the name of the Variable to get subtracted by the top value of
     * the Stack.
     * @throws VariableException if the Variable isn't initialized.
     * @throws NotEnoughStackElementsException if the Stack doesn't contain
     * enough elements for the operation.
     */
    public void subVar(String s) {
        if (!map.containsKey(s)) {
            throw new VariableException();
        } else if (stack.size() < 1) {
            throw new NotEnoughStackElementsException();
        }
        map.put(s, map.get(s).sub(stack.pop()));
    }

    public HashMap<String, Complex> getMap() {
        return map;
    }

}
