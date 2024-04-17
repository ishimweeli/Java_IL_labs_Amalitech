public class multthreding {
    public static void main(String[] args) {
        PrintPrimeNumbers Printing = new PrintPrimeNumbers();
        PrintPrimeNumbers Printing2 = new PrintPrimeNumbers();
        Printing.start();
        Printing2.start();

    }
}
