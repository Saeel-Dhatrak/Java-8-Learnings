package binaryoperator;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public class Main {
    public static void main(String[] args) {
        BiFunction<String, String, String> biFunction = (str1, str2) -> str1 + str2;
        System.out.println(biFunction.apply("Hello", "World"));

        BinaryOperator<String> binaryOperator = (str1, str2) -> str1 + str2;
        System.out.println(binaryOperator.apply("Java8", "Features"));
    }
}
