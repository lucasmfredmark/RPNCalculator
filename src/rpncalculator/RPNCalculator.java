package rpncalculator;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author lucasmfredmark
 */
public class RPNCalculator {
    private static final Stack<Double> stack = new Stack();

    public static void handleInput(String input) {
        String[] inputArray = input.split(" ");

        for (String ch : inputArray) {
            try {
                Double number = Double.parseDouble(ch);
                stack.push(number);
            } catch (NumberFormatException ex) {
                Double last = stack.pop();
                Double newLast = stack.peek();
                
                switch (ch) {
                    case "+":
                        stack.set(stack.size() - 1, last + newLast);
                        break;
                    case "-":
                        stack.set(stack.size() - 1, last - newLast);
                        break;
                    case "*":
                        stack.set(stack.size() - 1, last * newLast);
                        break;
                    case "/":
                        stack.set(stack.size() - 1, last / newLast);
                        break;
                }
            }
        }

        for (Double ch : stack) {
            System.out.println("> " + ch);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("QUIT")) {
            handleInput(input);
            input = scanner.nextLine();
        }
    }

}
