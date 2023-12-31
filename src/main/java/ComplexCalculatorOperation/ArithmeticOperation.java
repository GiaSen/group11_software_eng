package ComplexCalculatorOperation;

import ComplexCalculatorException.NotEnoughDataException;
import java.util.ArrayDeque;
import ComplexCalculator.Complex;
import ComplexCalculatorException.InvalidInputException;
import ComplexCalculatorException.ZeroDivisionException;

/**
 * The ArithmeticOperation class manages the arithmetic operations on the stack.
 * It provides an operationInterpreter method, which calls the needed function given
 * the input.
 * The class also defines methods to do the operations, such as sum, sub, product and division, 
 * which operate on the stack and use the methods defined in the Complex class.
 * @author group11
 */
public class ArithmeticOperation extends Operation {

    /** Initializes the ArithmeticOperation class.
     *
     * @param stack the stack data structure on which the operation will work.
     */
    public ArithmeticOperation(ArrayDeque stack) {
        super(stack);
    }

    /**
     * Calls the function suited to the type of Arithmetic operation entered as
     * input.
     *
     * @param input the String to analize.
     * @throws InvalidInputException if the String doesn't correspond to any of
     * the supported operations.
     */
    @Override
    public void operationInterpreter(String input) {
        if (input.equals("+")) {
            sum();
        } else if (input.equals("-")) {
            sub();
        } else if (input.equals("*")) {
            product();
        } else if (input.equals("/")) {
            division();
        } else if (input.equalsIgnoreCase("sqrt")) {
            sqrt();
        } else if (input.equals("+-")) {
            inversion();
        } else{
            throw new InvalidInputException();
        }
    }

    /**
     * Pops out of the Stack the first two elements and pushes in the Stack the
     * result of their sum.
     * 
     * @throws NotEnoughDataException if the Stack doesn't contain enough
     * elements for the operation.
     */
    public void sum() {
        if (stack.size() < 2) {
            throw new NotEnoughDataException();
        }
        Complex n1 = stack.pop();
        Complex n2 = stack.pop();
        stack.push(n2.sum(n1));
    }

    /**
     * Pops out of the Stack the first two elements and pushes in the Stack the
     * result of their subtraction.
     * 
     * @throws NotEnoughDataException if the Stack doesn't contain enough
     * elements for the operation.
     */
    public void sub() {
        if (stack.size() < 2) {
            throw new NotEnoughDataException();
        }
        Complex n1 = stack.pop();
        Complex n2 = stack.pop();
        stack.push(n2.sub(n1));
    }

    /**
     * Pops out of the Stack the first two elements and pushes in the Stack the
     * result of their product.
     * 
     * @throws NotEnoughDataException if the Stack doesn't contain enough
     * elements for the operation.
     */
    public void product() {
        if (stack.size() < 2) {
            throw new NotEnoughDataException();
        }
        Complex n1 = stack.pop();
        Complex n2 = stack.pop();
        stack.push(n2.product(n1));
    }

    /**
     * Pops out of the Stack the first two elements and pushes in the Stack the
     * result of their division.
     * 
     * @throws NotEnoughDataException if the Stack doesn't contain enough
     * elements for the operation.
     * @throws ZeroDivisionException if the number on top of the stack is 0.
     */
    public void division() {
        if (stack.size() < 2) {
            throw new NotEnoughDataException();
        }
        
        if (stack.getFirst().equals(new Complex(0, 0))) {
            throw new ZeroDivisionException();
        }
        
        Complex n1 = stack.pop();
        Complex n2 = stack.pop();

        stack.push(n2.division(n1));
    }

    /**
     * Pops out of the Stack the first element and pushes in the Stack its
     * square root.
     * 
     * @throws NotEnoughDataException if the Stack doesn't contain enough
     * elements for the operation.
     */
    public void sqrt() {
        if (stack.size() < 1) {
            throw new NotEnoughDataException();
        }
        Complex n = stack.pop();
        stack.push(n.sqrt());
    }

    /**
     * Pops out of the Stack the first element and pushes in the Stack its
     * inverse.
     * 
     * @throws NotEnoughDataException if the Stack doesn't contain enough
     * elements for the operation.
     */
    public void inversion() {
        if (stack.size() < 1) {
            throw new NotEnoughDataException();
        }
        Complex n = stack.pop();
        stack.push(n.negate());
    }
}
