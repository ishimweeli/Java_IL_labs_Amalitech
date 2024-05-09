package personalExercises;
import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {


    static class Item {
        int weight;
        int value;
        double ratio; // Ratio of value to weight

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.ratio = (double) value / weight;
        }
    }

    public class Fractional {
        public static double getMaxValue(int capacity, Item[] items) {
            // Sort items by value-to-weight ratio in descending order
            Arrays.sort(items, Comparator.comparingDouble((Item item) -> item.ratio).reversed());

            double totalValue = 0;
            int remainingCapacity = capacity;

            // Iterate through sorted items and fill the knapsack
            for (Item item : items) {
                if (remainingCapacity <= 0)
                    break;

                // Take the whole item if possible
                if (item.weight <= remainingCapacity) {
                    totalValue += item.value;
                    remainingCapacity -= item.weight;
                } else { // Take a fraction of the item to fill the remaining capacity
                    double fraction = (double) remainingCapacity / item.weight;
                    totalValue += fraction * item.value;
                    remainingCapacity = 0;
                }
            }

            return totalValue;
        }

    }

    public static void main(String[] args) {
        int capacity = 50; // Capacity of the knapsack
        Item[] items = {
                new Item(10, 60),
                new Item(20, 100),
                new Item(30, 120)
        };

        double maxValue = Fractional.getMaxValue(capacity, items);
        System.out.println("Maximum value that can be obtained = " + maxValue);
    }



}
