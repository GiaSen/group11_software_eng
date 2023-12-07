package ComplexCalculatorOperation;

import java.util.ArrayDeque;
import ComplexCalculator.Complex;
import ComplexCalculatorException.*;

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
        boolean operation = false;
        boolean stackoperation = false;
        boolean variable = false;
        
        String[] variableOperations = {"+","-","<",">","varMap"};
        String[] stackOperations = {"clear", "drop", "dup", "swap", "over"};
        String[] operations = {"+","-","*","/","+-","sqrt"};
        
        if (input.matches("[<+\\->][a-z]$")) {
            for (String op : variableOperations) {
                if (input.contains(op)) {
                    variable = true;
                }
            }
        }
        
        if (!variable) {
            for (String op : operations){
               if (input.equalsIgnoreCase(op))
                     operation = true;
            }
        }
        
        for (String op:stackOperations) {
            if (input.equalsIgnoreCase(op)) {
                stackoperation = true;
            }
        }
        
        if (variable)
            variableOperation.operationInterpreter(input);
        else if (operation)
            arithmeticOperation.operationInterpreter(input);
        else if (stackoperation)
            stackOperation.operationInterpreter(input);
        else if(Complex.isComplex(input)){
            stack.push(new Complex(input));
        }
        else{
            throw new InvalidInputException();
        }
    }

    public void stampaStack(){
        System.out.println("Stack:");
        stack.forEach(e -> {
            System.out.println(e);
        });
    }

    public ArrayDeque<Complex> getStack() {
        return stack;
    }
    
    
}
