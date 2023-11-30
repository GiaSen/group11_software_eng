package ComplexCalculatorOperation;

import java.util.ArrayDeque;
import ComplexCalculator.Complex;

public class Calcolatrice {
    protected final ArrayDeque<Complex> stack;
    protected final Operation arithmeticOperation;
    protected final Operation stackOperation;
    protected final Operation variableOperation;
    
    
    public Calcolatrice(){
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
        
        if (input.matches(".*[a-z]") & input.length() == 2 | input.equals("varMap")) {
            for (String op : variableOperations) {
                if (input.contains(op)) {
                    variable = true;
                }
            }
        }
        
        if (!variable) {
            for (String op : operations){
                if (input.contains(op) && input.length() == 1)
                    operation = true;
            }
            if (input.equals("+-")||input.equals("sqrt"))
                operation = true;
        }
        
        for (String op:stackOperations) {
            if (input.contains(op)) {
                stackoperation = true;
            }
        }
        
        if (variable)
            variableOperation.interpreter(input);
        else if (operation)
            arithmeticOperation.interpreter(input);
        else if (stackoperation)
            stackOperation.interpreter(input);
        else {
            stack.push(new Complex(input));
        }
    }
    
    public void add(Complex n){
        stack.addFirst(n);
    }
    
    public void stampaStack(){
        System.out.println("Stack:");
        stack.forEach(e -> {
            System.out.println(e);
        });
    }
}
