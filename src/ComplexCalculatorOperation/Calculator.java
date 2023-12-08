package ComplexCalculatorOperation;

import java.util.ArrayDeque;
import ComplexCalculator.Complex;
import ComplexCalculatorException.*;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    private final ArrayDeque<Complex> stack;
    private final Operation arithmeticOperation;
    private final Operation stackOperation;
    private final Operation variableOperation;
    
    
    public Calculator(){
        stack = new ArrayDeque<>();
        arithmeticOperation = new ArithmeticOperation(stack);
        stackOperation = new StackOperation(stack);
        variableOperation = new VariableOperation(stack);
    }
    
    public void interpreter(String input){       
        //List<String> variableOperations = Arrays.asList("+","-","<",">");
        List<String> stackOperations = Arrays.asList("clear", "drop", "dup", "swap", "over");
        List<String> operations = Arrays.asList("+","-","*","/","+-","sqrt");
       
        if (input.matches("[<+\\->][a-z]$"))
            variableOperation.operationInterpreter(input);
        
        else if(operations.contains(input.toLowerCase()))
            arithmeticOperation.operationInterpreter(input);

        else if(stackOperations.contains(input.toLowerCase()))
            stackOperation.operationInterpreter(input);

        else if(Complex.isComplex(input)){
            stack.push(new Complex(input));
        }
        else{
            throw new InvalidInputException();
        }
    }

    public ArrayDeque<Complex> getStack() {
        return stack;
    }
    
    
}
