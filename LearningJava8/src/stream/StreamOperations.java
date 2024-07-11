package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperations {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,4,54,78,45,22,34,65,29,56,99,200,54,2,22,34);
        List<Integer> filteredList = list.stream().filter(x -> x % 2 == 0).map(x -> x / 2).distinct().sorted((a,b) -> (b-a)).limit(4).skip(1).collect(Collectors.toList());
        System.out.println(filteredList);

        List<Integer> collect = Stream.iterate(0, x -> x + 1).limit(101).
                skip(1).filter(x -> x % 2 == 0).map(x -> x / 10).distinct().
                sorted().peek(x -> System.out.println(x)).
                collect(Collectors.toList());
        System.out.println(collect);
    }
}


