package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apples", "bananas", "mangoes");
        Stream<String> stream = list.stream();

        String[] array = {"apple", "banana", "mango"};
        Stream<String> stream1 = Arrays.stream(array);

        // We can create stream directcly
         Stream<Integer> numbers = Stream.of(1,2,3);

         // We can create stream and iterate it from 0 to 100
        Stream<Integer> limit = Stream.iterate(0, n -> n + 1).limit(100);

        // We can create stream using generate
        Stream<Integer> generate = Stream.generate(() -> (int)Math.random() * 100).limit(5);
    }
}
