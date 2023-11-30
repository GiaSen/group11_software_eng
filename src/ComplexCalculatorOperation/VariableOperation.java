package ComplexCalculatorOperation;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import ComplexCalculator.Complex;

public class VariableOperation extends Operation {
    private HashMap<String,Complex> map;
    
    public VariableOperation (ArrayDeque stack) {
        super(stack);
        map = new LinkedHashMap<>();
    }
    
    public void setVar(String input) {
        map.put(input, null);}
    
    @Override
    public void interpreter(String s) {
        String fields[] = s.split("[><+-]");
        if (s.contains(">")) {
            fromStackToVar(fields[1]);
        }
        if (s.contains("<")) {
            fromVarToStack(fields[1]);
        }
        if (s.contains("+")) {
            sumVar(fields[1]);
        }
        if (s.contains("-")) {
            subVar(fields[1]);
        }
        if (s.equals("varMap")) {
            printVarMap();
        }
    }
    
    public void fromVarToStack(String s) {
        stack.push(map.get(s));
    }

    public void fromStackToVar(String s) {
        map.put(s, stack.pop());
    }

    public void sumVar(String s) {
        map.put(s, map.get(s).sum(stack.pop()));
    }

    public void subVar(String s) {
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