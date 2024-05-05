package personalExercises;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StramApiSearch {
    public static void main(String[] args) {
        List<Integer> indexes= Arrays.asList(21,34,23,44,44,12,87,32,123,45,22,11,42,1);

     Stream<Integer> result=indexes.stream().filter(number->number.equals(12));
    result.forEach(number->System.out.println(number));
    }
}
