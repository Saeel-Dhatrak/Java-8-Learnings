package bipredicate;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class Main {
    public static void main(String[] args){
//        BiPredicate<Integer, Integer> areBothValueEven = (x, y) -> x % 2 == 0 && y % 2 == 0;
//        System.out.println(areBothValueEven.test(2,4));
//        System.out.println(areBothValueEven.test(3,4));
//
//        BiPredicate<String, Integer> biPredicate = (str, y) -> str.length() == y;
//        System.out.println(biPredicate.test("Saeel", 5));
//        System.out.println(biPredicate.test("Vedant", 4));

        BiFunction<String, String, Integer> biFunction = (x, y) -> x.length() + y.length();
        System.out.println(biFunction.apply("Hi", "Hello"));



    }
}
