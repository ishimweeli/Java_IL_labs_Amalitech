package personalExercises;

import java.util.Arrays;

public class SortNumbersStreamApi {

    public static void main(String[] args) {
        int[] numbers={12,23,12,31,12,12,34,34,56,33,221,156,32,11,34,23,56,886,876,556,65,64,32,23,42,21,1,23,2,3,53,3};

        int[] sorted= Arrays.stream(numbers).sorted().toArray();

      for(int num:sorted){
          System.out.println(num);
      }
    }
}
