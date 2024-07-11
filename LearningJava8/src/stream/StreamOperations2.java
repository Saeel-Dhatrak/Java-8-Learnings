package stream;

import java.util.stream.Stream;

public class StreamOperations2 {
    public static void main(String[] args) {
        Integer i = Stream.iterate(0, x -> x + 1).limit(101).map(x -> x / 20).distinct().peek(System.out::println).max((a, b) -> (a - b)).get();
        System.out.print(i + " "); // o 1 2 3 4 5 5

        long count = Stream.iterate(0, x -> x + 1).limit(101).map(x -> x / 10).distinct().count();
        System.out.println(count); // 11
    }
}
