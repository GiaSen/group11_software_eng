package ComplexCalculatorOperation;

import java.util.ArrayDeque;
import ComplexCalculator.Complex;
import ComplexCalculatorException.NotEnoughStackElementsException;

public class StackOperation extends Operation {

    public StackOperation (ArrayDeque stack) {
        super(stack);
    }

    @Override
    public void operationInterpreter(String input){
        if(input.equalsIgnoreCase("clear"))
            clear();
        else if(input.equalsIgnoreCase("drop"))
            drop();
        else if(input.equalsIgnoreCase("dup"))
            dup();
        else if(input.equalsIgnoreCase("swap"))
            swap();
        else if(input.equalsIgnoreCase("over"))
            over();
    }
    
    public void clear(){
        stack.clear();
    }

    public void drop() {
        if(stack.size() < 1)
            throw new NotEnoughStackElementsException();
        stack.removeFirst();
    }
    
    public void dup() {
        if(stack.size() < 1)
            throw new NotEnoughStackElementsException();
        stack.push(stack.peek());
    }
    
    public void swap() {
        if(stack.size() < 2)
            throw new NotEnoughStackElementsException();
        Complex n1 = stack.pop();
        Complex n2 = stack.pop();
        stack.push(n1);
        stack.push(n2);
    }
    
    public void over() {
        if(stack.size() < 2)
            throw new NotEnoughStackElementsException();
        Complex n1 = stack.pop();
        Complex n2 = stack.peek();
        stack.push(n1);
        stack.push(n2);
    }
    
}
