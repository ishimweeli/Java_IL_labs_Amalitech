package personalExercises;

public class CustomErrorHandling {
    // Custom Exception class for Division by Zero error
    static class DivisionByZeroException extends Exception {
        public DivisionByZeroException(String message) {
            super(message);
        }
    }

    // Custom Exception class for Negative Number error
    static class NegativeNumberException extends Exception {
        public NegativeNumberException(String message) {
            super(message);
        }
    }

    // Class representing mathematical operations with error handling
    class MathOperations {
        // Method to perform division operation with error handling
        public static double divide(double numerator, double denominator) throws DivisionByZeroException {
            if (denominator == 0) {
                throw new DivisionByZeroException("Error: Division by zero is not allowed!");
            }
            return numerator / denominator;
        }

        // Method to perform square root operation with error handling
        public static double squareRoot(double number) throws NegativeNumberException{
            if(number<0){
                throw new NegativeNumberException("squareroot of negative number not allowed");
            }
            return Math.sqrt(number);
        }
    }

    // Main class
        public static void main(String[] args) {
            double numerator = 10.0;
            double denominator = 0.0;
            double number = -25.0;

            try {
                // Division operation with error handling
                double result1 = MathOperations.divide(numerator, denominator);
                System.out.println("Result of division: " + result1);
            } catch (DivisionByZeroException e) {
                System.out.println(e.getMessage());
            }

            try {
                // Square root operation with error handling
                double result2 = MathOperations.squareRoot(number);
                System.out.println("Result of square root: " + result2);
            } catch (NegativeNumberException e) {
                System.out.println(e.getMessage());
            }
        }
    }

