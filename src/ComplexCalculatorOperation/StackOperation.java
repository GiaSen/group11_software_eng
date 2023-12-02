package ComplexCalculatorOperation;

import java.util.ArrayDeque;
import ComplexCalculator.Complex;

public class StackOperation extends Operation {

    public StackOperation (ArrayDeque stack) {
        super(stack);
    }

    @Override
    public void operationInterpreter(String input){
        if(input.equals("clear"))
            clear();
        else if(input.equals("drop"))
            drop();
        else if(input.equals("dup"))
            dup();
        else if(input.equals("swap"))
            swap();
        else if(input.equals("over"))
            over();
    }
    
    public void clear(){
        stack.clear();
    }

    public void drop() {
        stack.removeFirst();
    }
    
    public void dup() {
        stack.push(stack.peek());
    }
    
    public void swap() {
        Complex n1 = stack.pop();
        Complex n2 = stack.pop();
        stack.push(n1);
        stack.push(n2);
    }
    
    public void over() {
        Complex n1 = stack.pop();
        Complex n2 = stack.peek();
        stack.push(n1);
        stack.push(n2);
    }
    
}
