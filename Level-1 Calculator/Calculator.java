import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // We use a Scanner to read input from the console
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        System.out.println("--- Simple Console Calculator ---");
        System.out.println("Available operations: +, -, *, /");
        System.out.println("Enter 'exit' at any time to quit.");

        // Main application loop
        while (running) {
            try {
                // --- Input First Number ---
                System.out.print("\nEnter first number (or 'exit'): ");
                if (scanner.hasNext("exit")) {
                    running = false;
                    break;
                }
                // Check if the next token is a valid number
                if (!scanner.hasNextDouble()) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); // Consume the invalid input
                    continue; // Restart the loop
                }
                double num1 = scanner.nextDouble();

                // --- Input Operator ---
                System.out.print("Enter operation (+, -, *, /): ");
                String operator = scanner.next();

                // --- Input Second Number ---
                System.out.print("Enter second number (or 'exit'): ");
                if (scanner.hasNext("exit")) {
                    running = false;
                    break;
                }
                // Check if the next token is a valid number
                if (!scanner.hasNextDouble()) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next(); // Consume the invalid input
                    continue; // Restart the loop
                }
                double num2 = scanner.nextDouble();

                double result;

                // --- Perform Calculation 
                switch (operator) {
                    case "+":
                        result = Calculator.add(num1, num2);
                        System.out.printf("Result: %.2f + %.2f = %.2f\n", num1, num2, result);
                        break;
                    case "-":
                        result = Calculator.subtract(num1, num2);
                        System.out.printf("Result: %.2f - %.2f = %.2f\n", num1, num2, result);
                        break;
                    case "*":
                        result = Calculator.multiply(num1, num2);
                        System.out.printf("Result: %.2f * %.2f = %.2f\n", num1, num2, result);
                        break;
                    case "/":
                        try {
                            result = Calculator.divide(num1, num2);
                            System.out.printf("Result: %.2f / %.2f = %.2f\n", num1, num2, result);
                        } catch (IllegalArgumentException e) {
                            // Catch the specific exception thrown by the divide method
                            System.err.println("Error: " + e.getMessage());
                        }
                        break;
                    default:
                        System.out.println("Invalid operator. Please use +, -, *, or /.");
                        break;
                }
            } catch (Exception e) {
                // General catch block for unexpected errors
                System.err.println("An unexpected error occurred: " + e.getMessage());
                scanner.nextLine();
            }
        }

        scanner.close(); // Close the scanner to release system resources
        System.out.println("\nCalculator application exited. Goodbye!");
    }
}
class Calculator {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        if (b == 0) {
            // Throw an exception for the main method to catch and handle
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        return a / b;
    }
}