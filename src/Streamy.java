import java.util.*;
import java.util.function.*;

public class Streamy {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        int totalOfValuesDoubled = 0;
        for(int number : numbers) {
            totalOfValuesDoubled += number * 2;
        }

        System.out.println(totalOfValuesDoubled);

        System.out.println(
                numbers.stream()
                        .mapToInt(e -> e*2)
                        .sum());

        System.out.println(
            numbers.stream()
                .map(e -> e*2)
                .reduce(0,(c,e) -> c+e)
        );
    }
}
