public class PrimeNUmberChecker {
//    A prime number is any whole number greater
//        than 1 whose only factors are 1 and itself. For example, 7 is a prime number
//    because it’s only divisible by 1 and 7.
//
//    Create a function that returns TRUE if an input number is
//    prime. The first few prime numbers are 2, 3, 5, 7, 11, 13, 17, and 19.
//


    static class CheckPrime{
        public int number=8;
private boolean checkP(){
        if(number<=1){
            return false;
        }

        for(int i=2;i<=Math.sqrt(number); i++){
            if(number%i==0){
                return false;
            }
        }
    return true;
}


    }
    public static void main(String[] args) {
        CheckPrime checkPrime= new CheckPrime();
        boolean isPrime=checkPrime.checkP();
        System.out.println(isPrime);
    }
}
