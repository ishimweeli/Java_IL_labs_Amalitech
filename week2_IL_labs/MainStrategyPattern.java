
    // Strategy interface
    interface PaymentStrategy {
        void pay(double amount);
    }

    // Concrete strategy: Credit Card payment
    class CreditCardPayment implements PaymentStrategy {
        private String cardNumber;
        private String expirationDate;
        private String cvv;

        public CreditCardPayment(String cardNumber, String expirationDate, String cvv) {
            this.cardNumber = cardNumber;
            this.expirationDate = expirationDate;
            this.cvv = cvv;
        }

        @Override
        public void pay(double amount) {
            System.out.println("Paying " + amount + " via Credit Card.");
            // Logic for processing credit card payment
        }
    }

    // Concrete strategy: PayPal payment
    class PayPalPayment implements PaymentStrategy {
        private String email;
        private String password;

        public PayPalPayment(String email, String password) {
            this.email = email;
            this.password = password;
        }

        @Override
        public void pay(double amount) {
            System.out.println("Paying " + amount + " via PayPal.");
            // Logic for processing PayPal payment
        }
    }

    // Concrete strategy: Cash payment
    class CashPayment implements PaymentStrategy {
        @Override
        public void pay(double amount) {
            System.out.println("Paying " + amount + " in cash.");
            // Logic for processing cash payment
        }
    }

    // Context class
    class PaymentProcessor {
        private PaymentStrategy paymentStrategy;

        public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void processPayment(double amount) {
            paymentStrategy.pay(amount);
        }
    }

    // Main class
    public class MainStrategyPattern {
        public static void main(String[] args) {
            PaymentProcessor paymentProcessor = new PaymentProcessor();

            // Select payment method
            paymentProcessor.setPaymentStrategy(new CreditCardPayment("1234567890123456", "12/25", "123"));
            paymentProcessor.processPayment(100.50); // Paying 100.5 via Credit Card.

            paymentProcessor.setPaymentStrategy(new PayPalPayment("example@example.com", "password"));
            paymentProcessor.processPayment(75.25); // Paying 75.25 via PayPal.

            paymentProcessor.setPaymentStrategy(new CashPayment());
            paymentProcessor.processPayment(50.0); // Paying 50.0 in cash.
        }
    }

