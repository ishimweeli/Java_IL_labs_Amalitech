import java.util.InputMismatchException;
import java.util.Scanner;

public class MortgageCalculator {
    private double loanAmount;
    private double annualInterestRate;
    private int periodInYears;

    public MortgageCalculator(double loanAmount, double annualInterestRate, int periodYears) {
        this.loanAmount = loanAmount;
        this.annualInterestRate = annualInterestRate;
        this.periodInYears = periodYears;
    }

    public double calculateMortgage() {
        double monthlyInterestRate = (annualInterestRate / 100) / 12;
        int monthsOfPayment = periodInYears * 12;
        double denominator = Math.pow((1 + monthlyInterestRate), monthsOfPayment) - 1;
        return loanAmount * (monthlyInterestRate * Math.pow((1 + monthlyInterestRate), monthsOfPayment)) / denominator;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the mortgage calculator!");

        do {
            try {
                System.out.print("Enter loan amount: ");
                double loanAmount = scanner.nextDouble();

                System.out.print("Enter annual interest rate: ");
                double annualInterest = scanner.nextDouble();

                System.out.print("Enter loan period in years: ");
                int periodYears = scanner.nextInt();

                if (loanAmount <= 0 || annualInterest <= 0 || periodYears <= 0) {
                    System.out.println("Please enter valid credentials");
                    scanner.nextLine();
                    continue;
                }

                MortgageCalculator mortgageCalculator = new MortgageCalculator(loanAmount, annualInterest, periodYears);
                double monthlyMortgage = mortgageCalculator.calculateMortgage();

                System.out.println("Your monthly mortgage is: " + monthlyMortgage);

                System.out.print("Do you want to calculate another mortgage? (yes/no): ");
                String response = scanner.next();

                if (response.equalsIgnoreCase("no")) {
                    System.out.println("Thank you for using our mortgage calculator!");
                    break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter valid credentials");
                scanner.nextLine();
            }
        } while (true);

        scanner.close();
    }
}
