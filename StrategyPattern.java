package personalExercises;

public class StrategyPattern {

    interface PaymentStrategy{

       void pay(double amount);
    }

    public static class PaymentContext{
        private PaymentStrategy paymentStrategy;
         public PaymentContext(PaymentStrategy paymentStrategy){
             this.paymentStrategy=paymentStrategy;
         }
       public void processPayment(double amount){
             paymentStrategy.pay(amount);
       }

        public static class CreditCard implements PaymentStrategy{
            private String cardNumber;
            private String cvv;
            private String expirationDate;

            public CreditCard(String cardNumber,String cvv,String expirationDate){
                this.cardNumber=cardNumber;
                this.cvv=cvv;
                this.expirationDate=expirationDate;
            }
            @Override
            public void pay(double amount) {
                System.out.println("Paying $"+amount+"Using credit card");
            }

        }
    }



    public static void main(String[] args) {
        PaymentContext.CreditCard creditCard=new PaymentContext.CreditCard("2334","EF","324");
        PaymentContext paymentContext=new PaymentContext(creditCard);
        paymentContext.processPayment(100);
    }

}
