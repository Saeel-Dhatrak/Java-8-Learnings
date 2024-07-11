package predicateexamples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args){
        Predicate<Integer> salaryGreaterThanOneLac = x -> x > 100000;
        System.out.println(salaryGreaterThanOneLac.test(100));
        System.out.println(salaryGreaterThanOneLac.test(20000000));

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int sum = numbers.stream().filter(n -> n % 2 == 0).mapToInt(n -> n).sum();
        System.out.println(sum);

        Predicate<Integer> isEven = x -> x%2 == 0;
        for(Integer i : numbers){
            if(isEven.test(i)){
                System.out.print(i + " ");
            }
        }
        System.out.println();

        Predicate<String> startsWithLetterS = x -> x.toLowerCase().charAt(0) == 's';
        Predicate<String> endsWithLetterL  = x -> x.toLowerCase().charAt(x.length() - 1) == 'l';
        Predicate<String> bothConditions = startsWithLetterS.and(endsWithLetterL);
        Predicate<String> anyOneCondition = startsWithLetterS.or(endsWithLetterL);
        System.out.println(bothConditions.test("Saeel")); // true
        System.out.println(bothConditions.test("Vedant")); // false
        System.out.println(anyOneCondition.test("Saeel")); // true
        System.out.println(anyOneCondition.test("Atharva")); // false
        System.out.println(bothConditions.negate().test("Saeel")); // false
        System.out.println("-----------------");
        Predicate<Object> doesMatch = Predicate.isEqual("Saeel");
        System.out.println(doesMatch.test("Saeel"));

        Student s1 = new Student("Saeel", 10);
        Student s2 = new Student("Vedant", 13);
        Predicate<Student> studentPredicate = x -> x.getId() > 10;
        System.out.println(studentPredicate.test(s1));
    }

    private static class Student{
        String name;
        int id;

        public Student(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
