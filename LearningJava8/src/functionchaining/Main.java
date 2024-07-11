package functionchaining;

import java.util.function.Function;

public class Main {
    public static void main(String[] args){
        Function<String, String> function1 = s -> s.toUpperCase();
        Function<String, String> function2 = s -> s.substring(0,3);
        System.out.println(function1.andThen(function2).apply("Saeel")); // SAE

        Function<Integer, Integer> function3 = x -> x * 2;
        Function<Integer, Integer> function4 = x -> x * x * x;
        System.out.println(function3.andThen(function4).apply(3)); // 216
        System.out.println(function4.andThen(function3).apply(3)); // 54
        System.out.println(function3.compose(function4).apply(3)); // 54

        Function<String, String> function5 = Function.identity();
        System.out.println(function5.apply("saeel")); // saeel

    }
}
