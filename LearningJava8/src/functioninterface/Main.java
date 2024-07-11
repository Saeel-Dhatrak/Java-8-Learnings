package functioninterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Main {

    public static void main(String[] args){
        Function<String, Integer> function1 = x -> x.length();
        System.out.println(function1.apply("Saeel"));

        Function<String, String> function2 = x -> x.substring(0,3);
        Function<List<Student>, List<Student>> studentsWithSaeAsPrefix = li -> {
          List<Student> result = new ArrayList<>();
          for(Student s : li){
              if (function2.apply(s.getName()).equalsIgnoreCase("sae")) {
                  result.add(s);
              }
          }
          return result;
        };

        Student s1 = new Student("Saeel", 10);
        Student s2 = new Student("Vedant", 13);
        Student s3 = new Student("Atharva", 20);
        Student s4 = new Student("Saeeeeel", 100);
        List<Student> students = Arrays.asList(s1, s2, s3, s4);
        List<Student> filteredStudents = studentsWithSaeAsPrefix.apply(students);
        System.out.println(filteredStudents);
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

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    '}';
        }
    }
}
