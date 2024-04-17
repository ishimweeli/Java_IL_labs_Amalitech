import java.util.InputMismatchException;
import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter a number (or any non-integer to exit): ");

                if (scanner.hasNextInt()) {
                    int number = scanner.nextInt();

                    if (isFizzBuzz(number)) {
                        System.out.println("FizzBuzz");
                    } else if (isFizz(number)) {
                        System.out.println("Fizz");
                    } else if (isBuzz(number)) {
                        System.out.println("Buzz");
                    } else {
                        System.out.println(number);
                    }
                } else {
                    String nonIntegerInput = scanner.next();
                    if (nonIntegerInput.equalsIgnoreCase("exit")) {
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter a valid integer or type 'exit' to end the program.");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer or type 'exit' to end the program.");
                scanner.nextLine(); // consume the invalid input
            }
        }

        scanner.close();
        System.out.println("Exiting FizzBuzzApp. Goodbye!");
    }

    private static boolean isFizz(int number) {
        return number % 3 == 0;
    }

    private static boolean isBuzz(int number) {
        return number % 5 == 0;
    }

    private static boolean isFizzBuzz(int number) {
        return isFizz(number) && isBuzz(number);
    }
}
