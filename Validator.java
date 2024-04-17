import java.util.function.Predicate;

public class Validator {
    public static <T> boolean validate(T data, Predicate<T> validationCriteria) {
        return validationCriteria.test(data);
    }

    public static void main(String[] args) {
        String text = "Hello, world!";
        boolean isValidStringLength = Validator.validate(text, str -> str.length() >= 5 && str.length() <= 15);
        System.out.println("Is string length valid? " + isValidStringLength);

        int number = 10;
        boolean isValidNumberRange = Validator.validate(number, num -> num >= 0 && num <= 100);
        System.out.println("Is number range valid? " + isValidNumberRange);
    }
}
