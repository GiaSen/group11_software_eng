package ComplexCalculator;

import java.util.Scanner;
import ComplexCalculatorOperation.Calcolatrice;

public class StackComplexCalculator {

    public static void main(String[] args) {
        Calcolatrice c = new Calcolatrice();
        
        while(true){
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
        
            c.interpreter(input);
            c.stampaStack();
        }
    }
}
