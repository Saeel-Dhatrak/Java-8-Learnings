package unaryoperator;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args){
        Function<Integer, Integer> function1 = x -> x * x;
        Function<String, String> function2 = x -> x.toUpperCase();
        // The same can be done using one input
        UnaryOperator<Integer> unaryOperator1 = x -> x * x;
        System.out.println(unaryOperator1.apply(5)); // 25
        UnaryOperator<String> unaryOperator2 = str -> str.toUpperCase();
        System.out.println(unaryOperator2.apply("saeel")); // SAEEL
    }
}