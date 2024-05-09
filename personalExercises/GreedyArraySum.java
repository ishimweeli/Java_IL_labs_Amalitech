package personalExercises;

public class GreedyArraySum {
    public static int arraySum(int[] nums) {
        int total = 0;

        // Iterate through the array and sum up the numbers
        for (int num : nums) {
            total += num;
        }

        return total;
    }

    public static void main(String[] args) {
        // Example array of numbers
        int[] nums = {5, 10, 3, 8, 12};

        // Find the total of all numbers in the array
        int sum = arraySum(nums);
        System.out.println("Total sum of numbers in the array: " + sum);
    }
}
