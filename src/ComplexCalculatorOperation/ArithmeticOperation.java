package ComplexCalculatorOperation;

import ComplexCalculatorException.NotEnoughDataException;
import java.util.ArrayDeque;
import ComplexCalculator.Complex;

/**
 *
 * @author group11
 */
public class ArithmeticOperation extends Operation {

    /**
     *
     * @param stack
     */
    public ArithmeticOperation (ArrayDeque stack) {
        super(stack);
    }

    /**
     * Calls the function suited to the type of Arithmetic operation
     * entered as input.
     * @param input
     */
    @Override
    public void operationInterpreter(String input){
       if(input.equals("+"))
            sum();
        else if(input.equals("-"))
            sub();
        else if(input.equals("*"))
            product();
        else if(input.equals("/"))
            division();
        else if(input.equalsIgnoreCase("sqrt"))
            sqrt();
        else if(input.equals("+-"))
            inversion();
    }
    
    /**
     * Pops out of the Stack the first two elements and pushes in the Stack 
     * the result of their sum.
     */
    public void sum(){
        if(stack.size()<2)
            throw new NotEnoughDataException();
        Complex n1 = stack.pop();
        Complex n2 = stack.pop();
        stack.push(n2.sum(n1));
    }
    
    /**
     * Pops out of the Stack the first two elements and pushes in the Stack 
     * the result of their subtraction.
     */
    public void sub(){
        if(stack.size()<2)
            throw new NotEnoughDataException();
        Complex n1 = stack.pop();
        Complex n2 = stack.pop();
        stack.push(n2.sub(n1));
    }
    
    /**
     * Pops out of the Stack the first two elements and pushes in the Stack 
     * the result of their product.
     */
    public void product(){
        if(stack.size()<2)
            throw new NotEnoughDataException();
        Complex n1 = stack.pop();
        Complex n2 = stack.pop();
        stack.push(n2.product(n1));
    }
    
    /**
     * Pops out of the Stack the first two elements and pushes in the Stack 
     * the result of their division.
     */
    public void division(){
        if(stack.size()<2)
            throw new NotEnoughDataException();
        Complex n1 = stack.pop();
        Complex n2 = stack.pop();
        
        stack.push(n2.division(n1));
    }
    
    /**
     * Pops out of the Stack the first element and pushes
     * in the Stack its square root.
     */
    public void sqrt(){
        if(stack.size()<1)
            throw new NotEnoughDataException();
        Complex n = stack.pop();
        stack.push(n.sqrt());
    }
    
    /**
     * Pops out of the Stack the first element and pushes in the Stack
     * its inverse.
     */
    public void inversion(){
        if(stack.size()<1)
            throw new NotEnoughDataException();
        Complex n = stack.pop();
        stack.push(n.negate());
    }
}
