package ComplexCalculatorOperation;

import java.util.ArrayDeque;
import ComplexCalculator.Complex;
import ComplexCalculatorException.InvalidInputException;
import ComplexCalculatorException.NotEnoughStackElementsException;

/**
 * The StackOperation class manages the operations on the stack.
 * It provides an operationInterpreter method, which calls the needed function
 * given the input.
 * The class also defines methods to manipulate the Stack, such as Clear, Drop,
 * Dup, Swap and Over.
 * @author group11
 */
public class StackOperation extends Operation {

    /** Initializes the StackOperation class.
     *
     * @param stack the stack data structure on which the operation will work.
     */
    public StackOperation(ArrayDeque stack) {
        super(stack);
    }

    /**
     * Calls the function suited to the type of Stack operation entered as
     * input.
     *
     * @param input the String to analize.
     * @throws InvalidInputException if the String doesn't correspond to any of
     * the supported operations.
     */
    @Override
    public void operationInterpreter(String input) {
        if (input.equalsIgnoreCase("clear")) {
            clear();
        } else if (input.equalsIgnoreCase("drop")) {
            drop();
        } else if (input.equalsIgnoreCase("dup")) {
            dup();
        } else if (input.equalsIgnoreCase("swap")) {
            swap();
        } else if (input.equalsIgnoreCase("over")) {
            over();
        } else {
            throw new InvalidInputException();
        }
    }

    /**
     * Removes all elements from the Stack.
     */
    public void clear() {
        stack.clear();
    }

    /**
     * Removes the first element from the Stack.
     * 
     * @throws NotEnoughStackElementsException if the Stack doesn't contain
     * enough elements for the operation.
     */
    public void drop() {
        if (stack.size() < 1) {
            throw new NotEnoughStackElementsException();
        }
        stack.removeFirst();
    }

    /**
     * Copies the top element of the Stack and pushes it on top of it.
     * 
     * @throws NotEnoughStackElementsException if the Stack doesn't contain
     * enough elements for the operation.
     */
    public void dup() {
        if (stack.size() < 1) {
            throw new NotEnoughStackElementsException();
        }
        stack.push(stack.peek());
    }

    /**
     * Swaps the first 2 elements of the Stack.
     * 
     * @throws NotEnoughStackElementsException if the Stack doesn't contain
     * enough elements for the operation.
     */
    public void swap() {
        if (stack.size() < 2) {
            throw new NotEnoughStackElementsException();
        }
        Complex n1 = stack.pop();
        Complex n2 = stack.pop();
        stack.push(n1);
        stack.push(n2);
    }

    /**
     * Copies the second Stack element and pushes it on top of the Stack.
     * 
     * @throws NotEnoughStackElementsException if the Stack doesn't contain
     * enough elements for the operation.
     */
    public void over() {
        if (stack.size() < 2) {
            throw new NotEnoughStackElementsException();
        }
        Complex n1 = stack.pop();
        Complex n2 = stack.peek();
        stack.push(n1);
        stack.push(n2);
    }

}
