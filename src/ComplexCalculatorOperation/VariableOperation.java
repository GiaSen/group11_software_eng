package ComplexCalculatorOperation;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import ComplexCalculator.Complex;
import ComplexCalculatorException.NotEnoughStackElementsException;

public class VariableOperation extends Operation {
    private HashMap<String,Complex> map;
    
    public VariableOperation (ArrayDeque stack) {
        super(stack);
        map = new LinkedHashMap<>();
    }
    
    @Override
    public void operationInterpreter(String input) {
        String fields[] = input.split("[><+-]");
        if (input.contains(">")) {
            fromStackToVar(fields[1]);
        }
        else if (input.contains("<")) {
            fromVarToStack(fields[1]);
        }
        else if (input.contains("+")) {
            sumVar(fields[1]);
        }
        else if (input.contains("-")) {
            subVar(fields[1]);
        }
        else if (input.equals("varMap")) {
            printVarMap();
        }
        else setVar(input);
    }
    
    public void fromVarToStack(String s) {
        stack.push(map.get(s));
    }

    public void setVar(String input) {
        map.put(input, null);}
    
    public void fromStackToVar(String s) {
        if(stack.size() < 1)
            throw new NotEnoughStackElementsException();
        map.put(s, stack.pop());
    }

    public void sumVar(String s) {
        if(stack.size() < 1)
            throw new NotEnoughStackElementsException();
        map.put(s, map.get(s).sum(stack.pop()));
    }

    public void subVar(String s) {
        if(stack.size() < 1)
            throw new NotEnoughStackElementsException();
        map.put(s, map.get(s).sub(stack.pop()));
    }
    
    public void printVarMap(){
        map.keySet().forEach(l -> {
            System.out.println(l + ": " + map.get(l));
        });
    }
    
    public void printVar(String var){
        System.out.println(var + ": "+ map.get(var));
    }
}