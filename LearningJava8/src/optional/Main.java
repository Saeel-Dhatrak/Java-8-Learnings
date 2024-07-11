package optional;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<String> name = getName(2);
        Optional<String> upperCaseName = name.map(x -> x.toUpperCase());
        upperCaseName.ifPresent(System.out::println); // SAEEL

    }

    private static Optional<String> getName(int id){
        return Optional.of("saeel");
    }
}
