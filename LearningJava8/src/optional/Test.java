package optional;

import java.util.NoSuchElementException;
import java.util.Optional;

public class Test {
    public static void main(String[] args) {
        Optional<String> name = getName(2);
        String nameToBeUsed = name.isPresent() ? name.get() : "NA";
        // Above can be done using orElse() as shoen below
        nameToBeUsed = name.orElse("NA");
        System.out.println(nameToBeUsed); // NA
        String nameThrowExceptiom = name.orElseThrow(() -> new NoSuchElementException());
        // above can also be done using constructor reference
        String nameThrowException= name.orElseThrow(NoSuchElementException::new);
        System.out.println(nameThrowExceptiom); // Exception in thread "main" java.util.NoSuchElementException
    }


    private static Optional<String> getName(int id){
        return Optional.empty();
    }
}
