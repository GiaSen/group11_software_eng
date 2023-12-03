package ComplexCalculator;

import java.util.Scanner;
import ComplexCalculatorOperation.Calculator;

public class StackComplexCalculator {

    public static void main(String[] args) {
        Calculator c = new Calculator();
        
        while(true){
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
        
            c.interpreter(input);
            c.stampaStack();
        }
    }
}
