public class SmilingMonkey {


        public static void main(String[] args) {
            // Example usage
            boolean aSmile = true;
            boolean bSmile = true;
            boolean result = monkeyTrouble(aSmile, bSmile);
            System.out.println(result);
        }

        public static boolean monkeyTrouble(boolean aSmile, boolean bSmile) {

            return (aSmile && bSmile) || (!aSmile && !bSmile);
        }


}
