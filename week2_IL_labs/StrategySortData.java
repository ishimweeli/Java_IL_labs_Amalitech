    // Strategy interface
    interface SortingStrategy {
        void sort(int[] array);
    }

    // Concrete strategy: Bubble Sort
    class BubbleSort implements SortingStrategy {
        public void sort(int[] array) {
            int n = array.length;
            for (int i = 0; i < n-1; i++) {
                for (int j = 0; j < n-i-1; j++) {
                    if (array[j] > array[j+1]) {
                        // swap array[j+1] and array[j]
                        int temp = array[j];
                        array[j] = array[j+1];
                        array[j+1] = temp;
                    }
                }
            }
            for(int number:array){
                System.out.println(number);
            }
            System.out.println("Sorted using Bubble Sort");
        }
    }

    // Concrete strategy: Quick Sort
    class QuickSort implements SortingStrategy {
        public void sort(int[] array) {
            quickSort(array, 0, array.length - 1);
            for(int number:array){
                System.out.println(number);
            }
            System.out.println("Sorted using Quick Sort");
        }

        private void quickSort(int[] array, int low, int high) {
            if (low < high) {
                int pi = partition(array, low, high);

                quickSort(array, low, pi - 1);
                quickSort(array, pi + 1, high);
            }
        }

        private int partition(int[] array, int low, int high) {
            int pivot = array[high];
            int i = (low - 1);

            for (int j = low; j < high; j++) {
                if (array[j] < pivot) {
                    i++;

                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }

            int temp = array[i + 1];
            array[i + 1] = array[high];
            array[high] = temp;

            return i + 1;
        }
    }

    // Context class
    class SortingContext {
        private SortingStrategy strategy;

        public SortingContext() {
            // Default strategy
            this.strategy = new BubbleSort();
        }

        public void setStrategy(SortingStrategy strategy) {
            this.strategy = strategy;
        }

        public void executeSort(int[] array) {
            this.strategy.sort(array);
        }
    }

    // Client code
    public class StrategySortData {
        public static void main(String[] args) {
            // Create a context object
            SortingContext context = new SortingContext();

            // Sample array
            int[] data = {
                    54, 23, 87, 12, 56, 90, 34, 78, 45, 67, 32, 88, 76, 43, 21, 65, 89, 98, 10, 55,
                    77, 19, 31, 80, 44, 68, 11, 66, 100, 57, 33, 79, 24, 58, 91, 46, 22, 99, 13, 69,
            };


            // Determine sorting strategy based on data size
            if (data.length < 100) {
                context.setStrategy(new BubbleSort());
            } else {
                context.setStrategy(new QuickSort());
            }

            // Execute sorting
            context.executeSort(data);
        }
    }


