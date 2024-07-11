package lambdaUsage.student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Student s1 = new Student(18, "Virat");
        Student s2 = new Student(7, "Dhoni");
        Student s3 = new Student(10, "Sachin");
        List<Student> list = new ArrayList<Student>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        Collections.sort(list, (a,b) -> b.id - a.id);
        System.out.println(list);
    }
}
