package ComplexCalculatorOperation;

import java.util.ArrayDeque;
import ComplexCalculator.Complex;
import ComplexCalculatorException.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/** The Calculator class initializes the various Operation objects and the Stack
 * data structure.
 * It's responsible for redirecting the user input to the various Operation
 * objects.
 *
 * @author group11
 */
public class Calculator {

    private final ArrayDeque<Complex> stack;
    private final Operation arithmeticOperation;
    private final Operation stackOperation;

    private final Operation variableOperation;

    /**
     * Initializes the Stack and the Constructors of all operation types.
     */
    public Calculator() {
        stack = new ArrayDeque<>();
        arithmeticOperation = new ArithmeticOperation(stack);
        stackOperation = new StackOperation(stack);
        variableOperation = new VariableOperation(stack);
    }

    /**
     * States what type of input has been entered and calls the relative
     * function to elaborate the operation.
     *
     * @param input the String to analize.
     */
    public void interpreter(String input) {
        //List<String> variableOperations = Arrays.asList("+","-","<",">");
        List<String> stackOperations = Arrays.asList("clear", "drop", "dup", "swap", "over");
        List<String> operations = Arrays.asList("+", "-", "*", "/", "+-", "sqrt");

        if (input.matches("[<+\\->][a-z]$")) {
            variableOperation.operationInterpreter(input);
        } else if (operations.contains(input.toLowerCase())) {
            arithmeticOperation.operationInterpreter(input);
        } else if (stackOperations.contains(input.toLowerCase())) {
            stackOperation.operationInterpreter(input);
        } else if (Complex.isComplex(input)) {
            stack.push(new Complex(input));
        } else {
            throw new InvalidInputException();
        }
    }

    /** Returns the Stack.
     * This method is used to show the Stack contents in the GUI.
     * 
     * @return the ArrayDeque data structure used for the Stack.
     */
    public ArrayDeque<Complex> getStack() {
        return stack;
    }
    
    /** Returns the Variables Map from VariableOperation.
     * This method is used to show the Variables Map contents in the GUI.
     * 
     * @return the HashMap data structure,
     */
    public HashMap<String, Complex> getMap() {
        VariableOperation vop= (VariableOperation) variableOperation;
        return vop.getMap();
    }

}
