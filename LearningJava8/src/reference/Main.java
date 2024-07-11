package reference;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void print(String s){
        System.out.println(s);
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("saeel", "vedant", "nihal");
        // names.forEach(x -> System.out.println(x));
        //names.forEach(Main::print);

        List<Student> students1 = names.stream().map(x-> new Student(x)).collect(Collectors.toList());
        // similar can be done using
        List<Student> students2 = names.stream().map(Student::new).collect(Collectors.toList());
    }

}
