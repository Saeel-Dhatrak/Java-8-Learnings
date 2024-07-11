### What is the Purpose of Java 8.

- Concise and minimal coding.
- We were missing functional programming benefits in OOP's nature.
- To utilize functional programming benefits in java, JAVA 8 came.
- But still it is OOP language.
- To enabale parallel programming.
- More compatible code for multi core processors.

### Features of Java 8

- `Lambda Expression`
    - Also can be told as anonymous function. We don't need to define it, wherever we want we can just keep it.
    - Lambda Expression are similar to methods, but they do not need a name and they can be implemented right in the body of a method.
    - Example of a lamda expression is:
    - (x,y) -> x+y

- `Stream API`
    - Java stream api for bulk data operations on Collection

- `Date and Time API`
    - Under the packagejava.time, Java8 offer a new date-time API.

- `Base64 encode and decode`
    - For Base64 encoding, Java 8 has built-in encode and decode functions. The Base64 encoding class in Java.util.Base64.

- `Method reference and constructor reference` 
    - :: operator

- `Default methods in interfaces`
    - Untill now in our interfaces we had only public abstract methods but now defaults methods are also available
    - Also static methods are available in interfaces

- `Functional Interface`
    - A Functional Interface is an interface that has exactly one abstract method. To designate an interface as a Functional Interface, we don't need to use the @Functionallnterface annotation.
    - Functional Interface also known as Single Abstract Method

- `Optional Class`
- `Java IO Improvements`
- `Collection API Improvements`

### Lambda Expression in Java 8

- Lambda expression is an anonymous function.
    - Not having any name
    - Not having any return type
    - Not having modifier
- ```java
    package lambda;
    public class Main {
        private void sayHello(){
            System.out.println("Hello !");
        }
    }
  ```
- We can convert the above expression into lambda expression
- Steps to make any function lambda expression
    - 1.Remove modifier
    - 2.Remove return type
    - 3.Remove method name
    - 4.Place arrow
- so the above methods becomes `() -> { System.out.println("Hello !"); }`
- ```java
    private void add(int a, int b){
        System.out.println(a + b);
    }
  ```
- so the above methods becomes `(int a, int b) -> { System.out.println(a+b); }`
- ```java
    private int getStringLength(String str){
        return str.length();
    }
  ```
- so the above methods becomes `(String str) - > { return str.length();}`
- Ok now we can make the lambda statement more beautiful by
    - 1. If body has just one statement then we can remove curly brackets.
    - 2. Use type inference, compiler guesses the situation or context.
    - ```java
        private void add(int a, int b){
            System.out.println(a + b);
        }
      ```
    - converted to
    - `(int a, int b) -> { System.out.println(a+b); }`
    - converted to
    - `(a,  b) ->  System.out.println(a+b);`
    - In the above converted form we didn't specified the data type of a & b and compiler guessed it on its own.
    - 3. No return keyword
    - ```java
        private int getStringLength(String str){
            return str.length();
        }
      ```
    - Converted to
    -  `(String str) - > { return str.length();}`
    - Converted to
    - `(str) -> str.length();`
    - 4. If only one param remove small brackets
    - `(str) -> str.length();`
    - - Converted to
    - `str -> str.length();`
- Benefits of Lambda Expression
    - To enables functional programming in java
    - To make code more readable, maintatinable and concise.
    - To enable parallel programming.
    - JAR file size reduction.
    - Elimination of shadows variables.

### Functional Interface in Java 8

- Earlier we learnt about lambda expression, but where to use it? We need to see that and for this we need to learn about functional interface.
- Interface having `exactly one abstract method` but can have any number of defaults and static methods. We can invoke lambda expression by using functional interface.
- Before java 1.8 version only `public abstract` methods were allowed in interfaces, But from 1.8 onwards `default and static` were allowed.
- That means in functional interface the boundation is only on `abstract method`
- ```java
    package functionalInterface;

    @FunctionalInterface
    public interface MyInterface {
        public void sayHello();
    }
  ```
- Here in the above example we used the annoation `@FunctionalInterface` which is not compulsory to use.
- It is to specify that this interface should only contain `one abstract` method. If in future we modify and try to add some more abstract methods then this annotation will command compiler to give error that this is the functional Interface and should only contain one abstract method only.
- This annotation will not give any error or warning when we will add more static or default methods. For example the below code will not give any error
- ```java
    package functionalInterface;
    @FunctionalInterface
    public interface MyInterface {
        public void sayHello();

        //public void sayBye(); If we un-comment this line then error

        default void sayGoodMorning(){};

        public static void sayGoodNight(){};
    }
  ```
- What is the advantage of this annotation ?
    - It restrict the interface to be a Functional Interface. So if people have already used some lambda expression and some new team member added another abstract method in the Interface all lambda expression will have errors.

### Inheritance in Functional Interface

- ```java
    // Parent.java
    package functionalInterface;

    public interface Parent {
        public void sayHello();
    }
    // Child.java
    package functionalInterface;

    @FunctionalInterface
    public interface Child extends Parent{
        //public void sayHello();
        //public void sayBye();
    }
  ```
- Here in `Child.java` interface we do not write any method then also it is a FunctionalInterface because it is inheriting a single abstract method sayHello(). Also even if we uncomment the method sayHello() in the Child interface itself then also it will be a FunctionalInterface.
- But if we try to write any othe abstract method inside the child interface then it will not be a FunctionalInterface and the compiler will thorw an error.

### Default methods in Interface (methods with body)

- Until 1.7 only public abstract methods (i.e methods without implementation) were allowed whether we declare by writing or not.
- Similarly public static final variable were allowed.
- Since java 8 we can have concrete methods as well inside interface
- ```java
    interface A{
        default void sayHello(){
            System.out.println("hello !");
        }
    }
  ```
- Here in the above method if we remove the default keyword then the compiler will throw error that the `Abstract method do not specify a body`. That is to keep the body we need to make the method default.
- ```java
    package defaultMethods;

    interface Parent{
        default void sayHello(){
            System.out.println("hello !");
        }
    }

    class Child implements Parent {
        /* @Override
        public void sayHello() {
            System.out.println("Parent Says Hello !!");
        } */
    }

    public class MyClass{
        public static void main(String[] args){
            Child c = new Child();
            c.sayHello();
        }
    }
  ```
- Here in MyClass we are able to use the interface method directly.
- If it would not have been default method(i.e abstract method) then we would had to write the implementation of the abstract method in Child class and then use that implementation in MyClass
- If we override the `sayHello()` in Parent class then the method will return Parent implemented repsonse.
- Below is the most asked question in interview
- ```java
    package functionalInterface;

    interface A{
        default void sayHello(){
            System.out.println("A says Hellow");
        }
    }

    interface B{
        default void sayHello(){
            System.out.println("B says Hellow");
        }
    }
    public class MultipleInheritance implements A, B {
        public static void main(String[] args){
            MultipleInheritance mi = new MultipleInheritance();
            mi.sayHello(); // here it will get confuse to call which sayHello i,e A or B
        }
    }
  ```
- In this case we can just give our own implementation to the sayHello method and the call it. Or we can override the method in MultipleInheritance class itself to call whicherver interface we want to.
- ```java
    @Override
    public void sayHello(){
        A.super.sayHello(); // same can be done for B
    }
  ```

### Static methods in Interface Java 8

- Static methods in interface are those methods which are defined in the interface with keyword static.
- Static methods contain the complete definition of the functio
- Cannot be overrriden or changed in the implementation class
- ```java
    package staticmethods;

    interface A{
        static void sayHello(){
            System.out.println("Hello !");
        }

        default void sayBye(){
            System.out.println("bye");
        }
    }
    public class MyStaticClass implements A {
        public static void main(String[] args){
            MyStaticClass msc = new MyStaticClass();
            // msc.sayHello(); // static method cannot be called on object
            A.sayHello(); // static methods can only be called using interface names
            msc.sayBye(); // non static method can be called on the object
        }
    }
  ```
- Now we can see that our class is unable to see the static method present inside the interface. So even if we create a same method with same signature and name in our implementation class then we will not get any error because the method will be treated as a new method of the class itself.
- That is there will no concept of overriding if the method is static in interface.
- ```java
    package staticmethods;

    interface A{
        static void sayHello(){
            System.out.println("Hello !");
        }
    }

    public class MyStaticClass implements A {
        static void sayHello(){
            System.out.println("Hello !");
        }
    }
  ```
- Can we write the main function inside the interface? Yes, from java 1.8 onwards.
- ```java
    interface A{
        public static void main(String[] args){
            System.out.println("Hello from interface !");
        }
    }
  ```

### How to use Lambda expression in Java 8

- ```java
    // Employee.java
    package lambdaUsage;

    public interface Employee {
        String getName();
    }

    // SoftwareEngineer.java
    package lambdaUsage;

    public class SoftwareEngineer implements Employee{

        @Override
        public String getName(){
            return "Robert Downey Junior";
        }
    }


    // Main.java
    package lambdaUsage;

    public class Main {
        public static void main(String[] args){
            Employee employee = new SoftwareEngineer();
            System.out.println(employee.getName());
        }
    }
  ```
- We created Employee,  a separate SoftwareEngineer class to implement the abstract method of Employee interface and then finally used it in the Main class. So 3 things interface, implementationa and then use.
- Instead of doing this, we can make use of functional interface and lambda expression because functional interface and lambda expression goes hand in hand
- Functional Interface i.e Employee, act as datatype for lambda expression. So now we no longer need the SoftwareEngineer class.
- ```java
    package lambdaUsage;

    public class Main {
        public static void main(String[] args){
            Employee employee = () -> "Robert Downey";
            System.out.println(employee.getName());
        }
    }
  ```
- So interface reference can be used to hold lambda expression.
- Using lambda expression we don't need to use any separate implementation class.

### How to create thread using lambda expression in Java 8

- ```java
    // MyClass.java
    package lambdaUsage.thread;

    public class MyClass implements Runnable{
        @Override
        public void run() {
            for(int i =0; i < 10; i++){
                System.out.println("Hello " + i);
            }
        }
    }

    // Main.java
    package lambdaUsage.thread;

    public class Main {
        public static void main(String[] args){
            MyClass myClass = new MyClass();
            Thread thread = new Thread(myClass);
            thread.run();
        }
    }
  ```
- But again here we are using the implementation class, and as we know that Runnable is a functional interface and we can make use of functional interface. And as shown below we won't require the MyClass anymore
- ```java
    package lambdaUsage.thread;

    public class Main {
        public static void main(String[] args){
            Runnable r = () -> {
                for(int i = 0; i < 10; i++){
                    System.out.println("Hello Hi !!" + i);
                }
            };
            Thread thread = new Thread(r);
            thread.run();
        }
    }
  ```

### How to use comparator in java using lambda expression

- ```java
    // MyClass.java
    package lambdaUsage.comparator;
    import java.util.Comparator;

    public class MyClass implements Comparator<Integer> {
        @Override
        public int compare(Integer a, Integer b) {
            return b-a;
        }
    }

    // Main.java
    package lambdaUsage.comparator;
    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.List;

    public class Main {
        public static void main(String[] args){
            List<Integer> list = new ArrayList<>();
            list.add(10);
            list.add(13);
            list.add(25);
            list.add(20);
            list.add(22);
            list.add(17);
            list.add(13);
            Collections.sort(list, new MyClass());
            // Collections.sort(list, (a, b) -> b - a);
            System.out.println(list);
        }
    }
  ```
- Again we created the implementation class as MyClass which implements the functional interface Comparator.
- So we can delete the MyClass and we have to change the above line in the code as
- `Collections.sort(list, (a, b) -> b - a);`
- Other examples
- ```java
    package lambdaUsage.comparator;
    import com.sun.source.util.Trees;
    import java.util.*;

    public class Main {
        public static void main(String[] args){
            Set<Integer> s = new TreeSet<>();
            s.add(21);
            s.add(1);
            s.add(13);
            System.out.println("Before Sorting " + s);
            Set<Integer> ss = new TreeSet<>((a,b) -> b - a);
            ss.add(21);
            ss.add(1);
            ss.add(13);
            System.out.println("After Sorting " + ss);
        }
    }
  ```
- ```java
    public static void main(String[] args){
        Map<Integer, String> map = new TreeMap<>();
        map.put(2, "z");
        map.put(3, "f");
        map.put(1, "y");
        System.out.println(map);
        Map<Integer, String> smap = new TreeMap<>((a, b) -> b - a);
        smap.put(2, "z");
        smap.put(3, "f");
        smap.put(1, "y");
        System.out.println(smap);
    }
  ```
- Now according to above examples we will create our own objects and we will sort our custom objects
- ```java
    // Student.java
    package lambdaUsage.student;

    public class Student {
        public Integer id;
        public String name;

        public Student(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name=" + name +
                    '}';
        }
    }

    // Main.java
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
  ```

### Difference between lambda expression and anonymous inner class

- We cannot create Interface object
- ```java
    // Employee.java
    package innerclass;

    interface Employee {
        String getSalary();
        String getDesignation();

    }

    // Main.java
    package innerclass;

    public class Main{
        public static void main(String[] args){
            Employee emp = new Employee() { // this is anonymous class started here
                @Override
                public String getSalary() {
                    return "100";
                }
                @Override
                public String getDesignation() {
                    return "Software Engineer";
                }
            }; // anonymous class ended here
        }
    }
  ```
- In the employee interface we had 2 methods and hence it is not a functional interface, so as we were using lambda expression in case of single abstract method, in the same way we can make use of anonymous inner class if the interface has more than one abstract method.

- **Variables and *this* in lambda expression**

- We will see how to use local variable inside lambda expression
- ```java
    // Employee.java
    package localvariables;

    public interface Employee {
        public String getSalary();
    }

    // Main.java
    package localvariables;

    public class Main {
        private void doSomething(){
            int b =2;
            Employee emp = () -> {
                b = 3; // here we canot do the re-assignment becoz 
                return "1000";
            };
            System.out.println(emp.getSalary());
        }
    }
  ```
- As we have written the variable inside lambda expression the variable has become final and we cannot change it. But we can change the value if the variable is an instance variable.
- *this*
- ```java
    // Main.java
    package localvariables;

    public class Main {
        int b = 2;
        private void doSomething(){ 
            Employee emp = () -> {
                System.out.println(this.b);
                return "100";
            };
            
            Employee emp1 = new Employee() {
                int x = 8;
                @Override
                public String getSalary() {
                    System.out.println(this.x);
                    return "100";
                }
            };
        }
    }
  ```

### Mastering Java 8 Predicates: AND, OR, and isEqual

- Predicate is a fucntional interface present inside java.util.package introduced in version 1.8 and it has one abstract method `test`. It has many other methods which are not abstract.
- Predicate is also called boolean valued function.
- Upon pressing double shift and searching for Predicate we will be able to see the Predicate Interface in the java.util package as shown below.
- ```java
    @FunctionalInterface
    public interface Predicate<T> {
   
        boolean test(T t); // This is only abstract method

        default Predicate<T> and(Predicate<? super T> other) {
            Objects.requireNonNull(other);
            return (t) -> test(t) && other.test(t);
        }

        default Predicate<T> negate() {
            return (t) -> !test(t);
        }

        default Predicate<T> or(Predicate<? super T> other) {
            Objects.requireNonNull(other);
            return (t) -> test(t) || other.test(t);
        }

        static <T> Predicate<T> isEqual(Object targetRef) {
            return (null == targetRef)
                    ? Objects::isNull
                    : object -> targetRef.equals(object);
        }

        @SuppressWarnings("unchecked")
        static <T> Predicate<T> not(Predicate<? super T> target) {
            Objects.requireNonNull(target);
            return (Predicate<T>)target.negate();
        }
    }
  ```
- We know that functional interface act as type for lambda expression and this lambda expression will be the implementation of the `boolean test(T t)` method as it is the only abstract method. This will return true or false.
- ```java
    package predicateexamples;
    import java.util.function.Predicate;

    public class Main {
        public static void main(String[] args){
            Predicate<Integer> salaryGreaterThanOneLac = x -> x > 100000;
            System.out.println(salaryGreaterThanOneLac.test(100)); // false
            System.out.println(salaryGreaterThanOneLac.test(20000000)); // true
        }
    }
  ```
- The variable `salaryGreaterThanOneLac` is a predicate, it can be named anything like `mySalary` or anything that we eant to name, it just holds a condition and evaluate it.
- With the help of predicate we are storing a condition in a variable
- Now this looks very similar to a boolean function getting called but this predicate will be more useful in stream.
- Stream is way of playing any collection in functional style. We will take an example below.
- ```java
    package predicateexamples;

    import java.util.Arrays;
    import java.util.List;
    import java.util.function.Predicate;

    public class Main {
        public static void main(String[] args){
            Predicate<Integer> salaryGreaterThanOneLac = x -> x > 100000;
            System.out.println(salaryGreaterThanOneLac.test(100)); // false
            System.out.println(salaryGreaterThanOneLac.test(20000000)); // true

            List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
            int sum = numbers.stream().filter(n -> n % 2 == 0).mapToInt(n -> n).sum();
            System.out.println(sum); // 30

            Predicate<Integer> isEven = x -> x%2 == 0;
            for(Integer i : numbers){
                if(isEven.test(i)){
                    System.out.print(i + " "); // 2 4 6 8 10
                }
            }

            Predicate<String> startsWithLetterS = x -> x.toLowerCase().charAt(0) == 's';
            System.out.println(startsWithLetterS.test("Saeel")); // true
        }
    }
  ```

- **Default and Static methods inside Predicate interface**

- Appart form test method, the predicate interface also contains default and static methods such as and, negate, or, isEqual, not 
- And Or Example
- ```java
    Predicate<String> startsWithLetterS = x -> x.toLowerCase().charAt(0) == 's';
    Predicate<String> endsWithLetterL  = x -> x.toLowerCase().charAt(x.length() - 1) == 'l';
    Predicate<String> bothConditions = startsWithLetterS.and(endsWithLetterL);
    Predicate<String> anyOneCondition = startsWithLetterS.or(endsWithLetterL);
    System.out.println(bothConditions.test("Saeel")); // true
    System.out.println(bothConditions.test("Vedant")); // false
    System.out.println(anyOneCondition.test("Saeel")); // true
    System.out.println(anyOneCondition.test("Atharva")); // false
    Predicate<Object> doesMatch = Predicate.isEqual("Saeel");
    System.out.println(doesMatch.test("Saeel")); // true this will check does the provided dtring is equal or not
  ```
- Negate Example. Consider a example of of club in which the men are not allowed whose names starts with s.
- ```java
    System.out.println(bothConditions.negate().test("Saeel")); // false
  ```
- we will create a class object
- ```java
    Student s1 = new Student("Saeel", 10);
        Student s2 = new Student("Vedant", 13);
        Predicate<Student> studentPredicate = x -> x.getId() > 10;
        System.out.println(studentPredicate.test(s1)); // salse
    }

    private static class Student{
        String name;
        int id;

        public Student(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }
  ```

### Java 8 in Function interface Explained : How to use apply(), andThen(), compose() and identity()

- Function is also a functional interface which contains abstract method called `apply(T t)`. As the test() method always returned boolean in a similar way we can pass in any type of parameter and then we can return anything.
- Function will do some kind of work that we specify it to do unlike predicate which just provide boolean value.
- Example from list of 100 students, 50 have failed which means they have scored less than 33 marks, so bring back the list of passed students only. Another example provided a string with lowercase character, bring back all the characters in uppercase.
- Upon pressing double shift and searching for Predicate we will be able to see the Predicate Interface in the java.util.function package as shown below.
- ```java       
    package java.util.function;
    import java.util.Objects;

    @FunctionalInterface
    public interface Function<T, R> {
        R apply(T t);

        default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
            Objects.requireNonNull(before);
            return (V v) -> apply(before.apply(v));
        }

        default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
            Objects.requireNonNull(after);
            return (T t) -> after.apply(apply(t));
        }

        static <T> Function<T, T> identity() {
            return t -> t;
        }
    }
  ```
- The below example will take string and will provide integer as output
- ```java
    package functioninterface;
    import java.util.function.Function;

    public class Main {
        public static void main(String[] args){
            Function<String, Integer> function = x -> x.length(); // string input & integer as output
            System.out.println(function.apply("Saeel")); // 5
        }
    }
  ```
- Another exzmple
- ```java
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

            @Override
            public String toString() {
                return "Student{" +
                        "name='" + name + '\'' +
                        ", id=" + id +
                        '}';
            }
        }
    }
    // Output
    // 5
    // [Student{name='Saeel', id=10}, Student{name='Saeeeeel', id=100}]
  ```
- **Function Chaining**, Inside the Function interface there are other methods also like compose(), andThen(), identity().
- ```java
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
  ```
- If we want to reverse `function3.andThen(function4)` then we can use `function3.compose(function4)`. So basically compose fuction is useless because same can be achieved by doing the reverse in the anThen only like `function4.andThen(function3)`.
- The remaining method from the function interface is a static method called `identity()`. And as it is static method we have to make call to it using the interface name as `Function.identity()`.
- The meaning of identity() is whatever we give input the output will be same as input.

### Java 8 Consumer Interface

- Upon pressing double shift and searching for Consumer we will be able to see the Consumer Interface in the java.util.function package as shown below.
- ```java
    package java.util.function;
    import java.util.Objects;

    @FunctionalInterface
    public interface Consumer<T> {

        void accept(T t);

        default Consumer<T> andThen(Consumer<? super T> after) {
            Objects.requireNonNull(after);
            return (T t) -> { accept(t); after.accept(t); };
        }
    }
  ```
- Consumer interface consumes and does not return anything, mostly the consumer gets used when we provide some data and told consumer to save the data in the database.
- ```java
    package consumer;

    import java.util.Arrays;
    import java.util.List;
    import java.util.function.Consumer;

    public class Main {
        public static void main(String[] args){
            Consumer<String> consumer = s -> System.out.println(s);
            consumer.accept("Saeel");

            Consumer<List<Integer>> listConsumer1 = li -> {
            for(Integer i : li){
                System.out.print(i + 100 + " ");
            }
            };
            // listConsumer1.accept(Arrays.asList(1,2,3,4)); // 101 102 103 104

            Consumer<List<Integer>> listConsumer2 = li -> {
                for(Integer i : li){
                    System.out.print(i + " ");
                }
            };

            listConsumer2.andThen(listConsumer1).accept(Arrays.asList(1,2,3,4)); // // 1 2 3 4 101 102 103 104
        }
    }    
  ```

### Supplier in Java 8

- - Upon pressing double shift and searching for Supplier we will be able to see the Supplier Interface in the java.util.function package as shown below.
- ```java
    package java.util.function;

    @FunctionalInterface
    public interface Supplier<T> {
        T get();
    }
  ```
- Supplier does not take anything in argument but returns.
- ```java
    package supplier;
    import java.util.function.Supplier;

    public class Main {
        public static void main(String[] args){
            Supplier<Integer> supplier1 = () -> 1;
            System.out.println(supplier1.get());
        }
    }
  ```
- Now we will use all learnt concepts in one code.
- ```java
    package supplier;
    import java.util.function.Consumer;
    import java.util.function.Function;
    import java.util.function.Predicate;
    import java.util.function.Supplier;

    public class Main {
        public static void main(String[] args){
            Predicate<Integer> predicate = x -> x % 2 == 0;
            Function<Integer, Integer> function = x -> x * x;
            Consumer<Integer> consumer = x -> System.out.println(x);
            Supplier<Integer> supplier = () -> 100;

            if(predicate.test(supplier.get())){
                consumer.accept(function.apply(supplier.get())); // 10000
            }
        }
    }
  ```

### BiPredicate, BiFunction and BiConsumer in Java 8

- Predicate that takes two arguments unlike predicate which only takes one argument
- ```java
    package bipredicate;
    import java.util.function.BiPredicate;

    public class Main {
        public static void main(String[] args){
            BiPredicate<Integer, Integer> areBothValueEven = (x, y) -> x % 2 == 0 && y % 2 == 0;
            System.out.println(areBothValueEven.test(2,4)); // true
            System.out.println(areBothValueEven.test(3,4)); // false

            BiPredicate<String, Integer> biPredicate = (str, y) -> str.length() == y;
            System.out.println(biPredicate.test("Saeel", 5)); // true
            System.out.println(biPredicate.test("Vedant", 4)); // false
        }
    }
  ```
- Check if the provided string length is equal to the second provided integer?
- ```java
    package bipredicate;
    import java.util.function.BiFunction;
    import java.util.function.BiPredicate;

    public class Main {
        public static void main(String[] args){
            BiFunction<String, String, Integer> biFunction = (x, y) -> x.length() + y.length();
            System.out.println(biFunction.apply("Hi", "Hello")); // 7
        }
    }
  ```
- Similarly BiConsumer
- ```java
    BiConsumer<Integer, Integer> biConsumer = (x, y) -> {
            System.out.println(x+y);
        };
        biConsumer.accept(20,20);
  ```

### UnaryOperator & BinaryOperator Interface in Java 8

- If the input type and output type is same then we will use unary operator.
- ```java
    package operator;
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
  ```
- BinaryOperator extends BiFunction
- ```java
    package binaryoperator;

    import java.util.function.BiFunction;
    import java.util.function.BinaryOperator;

    public class Main {
        public static void main(String[] args) {
            BiFunction<String, String, String> biFunction = (str1, str2) -> str1 + str2;
            System.out.println(biFunction.apply("Hello", "World"));
            // Above can be done as below using BinaryOperator
            BinaryOperator<String> binaryOperator = (str1, str2) -> str1 + str2;
            System.out.println(binaryOperator.apply("Java8", "Features"));
        }
    }
  ```

### Java 8 Method and Constructor Reference: Simplifying Code and Boosting Efficiency

- Method reference allow us to refer to a method without invoking it, making our code cleaner and more readable. They can be used in place of a lambda expression when the lambda expression only calls an existing method.
- ```java
    package reference;

    import java.util.Arrays;
    import java.util.List;

    public class Main {

        public static void print(String s){
            System.out.println(s);
        }

        public static void main(String[] args) {
            List<String> students = Arrays.asList("saeel", "vedant", "nihal");
            // students.forEach(x -> System.out.println(x));
            // above line is by way of lambda expression
            students.forEach(Main::print);
        }
    }
  ```
- When we want to give function as parameter then we can use lambda expression or method reference.
- Constructor refernce.
- ```java
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

    // Student.java
    package reference;

    public class Student {
        private String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" + "name='" + name + '\'' + '}';
        }
    }
  ```

### Java 8 Streams 

- We can create a stream from a collection. After converting it to a stream we can use declarative and functional programming
- Basically if we want to use keywords such as map, filter, redeuce then we have to convert collection to stream then only we can use this keywords
- Meaning of declarative is that we define what we want to do and we don't care about how we want to do it
- Why Stream?
- ```java
    public class Main {
        public static void main(String[] args) {
            // imeprative approach
            int[] array = {1, 2, 3, 4, 5};
            int sum = 0;
            for(int i =0; i < array.length; i++){
                if(array[i] % 2 == 0){
                    sum += array[i];
                }
            }

            // stream or decalrative approach

            int[] array2 = {1,2,3,4,5,6,7,8,9,10};
            int sum2 = Arrays.stream(array2).filter(n -> n % 2 == 0)
        }
    }
  ```
- Readability: Streams provide a more readable and expressive way to perform operations on collections. The syntax is concise and easy to understand, making it easier for other developers to read and maintain your code.
- Flexibility: Streams allow you to perform a variety of operations on collections, such as filtering, mapping, and reducing, without having to write multiple loops or methods. This can save time and make your code more flexible.
- Parallelism: Streams can be processed in parallel, which can provide a significant performance boost for large collections. With a for loop, you would have to write your own multi-threaded code to achieve parallelism.
- Encapsulation: Streams encourage encapsulation, as you can perform a series of operations on a collection without modifying the original data. This can help prevent bugs and improve code reliability.
- How to create a stream?
- ```java
    package stream;

    import java.util.Arrays;
    import java.util.List;
    import java.util.stream.Stream;

    public class Main {
        public static void main(String[] args) {
            List<String> list = Arrays.asList("apples", "bananas", "mangoes");
            Stream<String> stream = list.stream();

            String[] array = {"apple", "banana", "mango"};
            Stream<String> stream1 = Arrays.stream(array);

                    
            // We can create stream directcly
            Stream<Integer> numbers = Stream.of(1,2,3);
            
            // We can create stream and iterate it from 0 to 100
            Stream<Integer> limit = Stream.iterate(0, n -> n + 1).limit(100);
            
            // We can create stream using generate
            Stream<Integer> generate = Stream.generate(() -> (int)Math.random() * 100).limit(5);
        }
    }
  ```
- **Stream Operations**
- ```java
    package stream;

    import java.util.Arrays;
    import java.util.List;
    import java.util.stream.Collectors;

    public class StreamOperations {
        public static void main(String[] args) {
            List<Integer> list = Arrays.asList(1,2,4,54,78,45,22,34,65,29,56,99,200);
            List<Integer> filteredList = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
            System.out.println(filteredList); // [2, 4, 54, 78, 22, 34, 56, 200]

            List<Integer> mappedList = filteredList.stream().map(x -> x / 2).collect(Collectors.toList());
            System.out.println(mappedList); // [1, 2, 27, 39, 11, 17, 28, 100]

            // all the above work can be done in a single line also
            List<Integer> filteredList = list.stream().filter(x -> x % 2 == 0).map(x -> x / 2).collect(Collectors.toList());

            // If there are any duplicated and we want to avoid the duplicates from the list then use distict
            List<Integer> filteredList = list.stream().filter(x -> x % 2 == 0).map(x -> x / 2).distinct().collect(Collectors.toList());

            // distinct and sorted
            List<Integer> filteredList = list.stream().filter(x -> x % 2 == 0).map(x -> x / 2).distinct().sorted().collect(Collectors.toList());

            // sorted in descending order
            List<Integer> filteredList = list.stream().filter(x -> x % 2 == 0).map(x -> x / 2).distinct().sorted((a,b) -> (b-a)).collect(Collectors.toList());

            // limit to only 4 elements and skip the first element from the start
            List<Integer> filteredList = list.stream().filter(x -> x % 2 == 0).map(x -> x / 2).distinct().sorted((a,b) -> (b-a)).limit(4).skip(1).collect(Collectors.toList());
        }
    }
  ```
- Another example
- ```java
    package stream;

    import java.util.Arrays;
    import java.util.List;
    import java.util.stream.Collectors;
    import java.util.stream.Stream;

    public class StreamOperations {
        public static void main(String[] args) {
            List<Integer> list = Arrays.asList(1,2,4,54,78,45,22,34,65,29,56,99,200,54,2,22,34);
            List<Integer> filteredList = list.stream().filter(x -> x % 2 == 0).map(x -> x / 2).distinct().sorted((a,b) -> (b-a)).limit(4).skip(1).collect(Collectors.toList());
            System.out.println(filteredList);

            List<Integer> collect = Stream.iterate(0, x -> x + 1).limit(101).
                    skip(1).filter(x -> x % 2 == 0).map(x -> x / 10).distinct().
                    sorted().peek(x -> System.out.println(x)).
                    collect(Collectors.toList());
            System.out.println(collect);
        }
    }
  ```
- Example
- ```java
    package stream;
    import java.util.stream.Stream;

    public class StreamOperations2 {
        public static void main(String[] args) {
            Integer i = Stream.iterate(0, x -> x + 1).limit(101).map(x -> x / 20).distinct().peek(System.out::println).max((a, b) -> (a - b)).get();
            System.out.print(i + " "); // o 1 2 3 4 5 5

            long count = Stream.iterate(0, x -> x + 1).limit(101).map(x -> x / 10).distinct().count();
            System.out.println(count); // 11
        }
    }
  ```
- max returns optional and to get the value out of optional we have to use the method get();
- **ParallelStream**
- If the list is too long then Parallel Stream divides the list in chunks, then threads get assigned to chunk of lists.

### Java 8 Date & Time API

- LocalDate: Represents a date without a time zone.
- LocalTime: Represents a time without a date or time zone.
- LocalDateTime: Represents a date and time without a time zone.
- ZonedDateTime: Represents a date and time with a time zone.
- Instant: Represents an instantaneous point on the timeline, typically used for machine timestamps.
- Duration: Represents a duration of time between two points in time.
- Period: Represents a period of time between two dates.
- DateTimeFormatter. Formats and parses dates and times.
- Examples
- ```java
    package dateandtime;
    import java.time.LocalDate;
    import java.time.Month;

    public class Test {
        public static void main(String[] args) {
            LocalDate now = LocalDate.now();
            System.out.println(now); // 2024-07-10
            LocalDate birthDate = LocalDate.of(1996, 3, 10);
            System.out.println(birthDate); // 1996-03-10
            int dayOfMonth = now.getDayOfMonth();
            Month month = now.getMonth();
            int year = now.getYear();
            System.out.println(dayOfMonth); // 10
            System.out.println(month); // JULY
            System.out.println(year); // 2024
        }
    }
  ```
- Now we will look at LocalTime
- ```java
    package dateandtime;

    import java.time.LocalTime;

    public class TimeOperations {
        public static void main(String[] args) {
            System.out.println(LocalTime.now());
            LocalTime customTime = LocalTime.of(20, 20);
            System.out.println(LocalTime.parse("20:25:10"));
            LocalTime parsedTime = LocalTime.parse("20:25:10");
            LocalTime now = LocalTime.now();
            if(now.isBefore(customTime)){
                System.out.println("yesss");
            }
            if(now.isAfter(customTime)){
                System.out.println("Han bhai");
            }

        }
    }
  ```
- Now we will look at LocalDateTime
- ```java
    package dateandtime;
    import java.time.LocalDate;
    import java.time.LocalDateTime;

    public class DateTimeOperations {
        public static void main(String[] args) {
            LocalDateTime now = LocalDateTime.now();
            System.out.println(now); // 2024-07-10T19:34:41.080655300
            LocalDateTime parsedDateTime = LocalDateTime.parse("1996-10-03T20:20:20:038399");
            System.out.println(parsedDateTime); // 2024-04-12T22:10:21
        }
    }
  ```
- Now we will look at ZonedDateTime.
- UTC Universal time co-ordinated, is a standard time which is same for everyone everywhere. Now we hae our timezones and these timezones rome around this UTC, some timezone will come before utc and some will come later. There are total 600 zones out of which 24 are primary and they have different times
- LocalDateTime does not consider zone time but it considers the current working system time, but if we want particular zone date and time the we will go for ZonedDateTime
- We can find all the Zone Id's in the java.time.ZoneId. Each zoneId represents different zone
- Examples
- ```java
    package dateandtime;

    import java.time.ZoneId;
    import java.time.ZonedDateTime;
    import java.util.Set;

    public class ZonedDateTimeOperations {
        public static void main(String[] args) {
            ZonedDateTime now = ZonedDateTime.now();
            System.out.println(now); // 2024-07-10T19:45:55.870318100+05:30[Asia/Calcutta]
            // This means that Asia/Calcutta time is running 05:30 aage
            Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
            availableZoneIds.forEach(System.out::println); // will get a list of 600 zones

            ZonedDateTime customeZonedDateTime = ZonedDateTime.of(2024, 12, 1, 14, 30, 30, 30, ZoneId.of("America/New_York"));
            System.out.println(customeZonedDateTime); // 2024-12-01T14:30:30.000000030-05:00[America/New_York]
        }
    }
  ```
- Now example to see live time of india and america
- ```java
    package dateandtime;
    import java.time.ZoneId;
    import java.time.ZonedDateTime;
    import java.util.Set;

    public class ZonedDateTimeOperations {
        public static void main(String[] args) {
            ZonedDateTime indiaTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
            System.out.println(indiaTime); // 2024-07-10T20:11:07.932647300+05:30[Asia/Kolkata]
            ZonedDateTime americaTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
            System.out.println(americaTime); // 2024-07-10T10:41:07.934705200-04:00[America/New_York]
        }
    }
  ```
- Now we will look at InstantDateTime.
- ```java
    package dateandtime;

    import java.time.Instant;

    public class InstantOperations {
        public static void main(String[] args) {
            long currentTimeMillis = System.currentTimeMillis();
            System.out.println(currentTimeMillis); // 1720622851327
            // Above line tells total milliseconds from the date 1 jaunuary 1970 midnight UTC
            Instant now = Instant.now();
            System.out.println(now); // 2024-07-10T14:47:31.328097700Z
            // This gives total nonoseconds from the date 1 jaunuary 1970 midnight UTC
        }
    }
  ```
- Now we will look at Duration
- ```java
    package dateandtime;

    import java.time.Duration;
    import java.time.Instant;
    import java.time.temporal.ChronoUnit;

    public class DurationOperations {
        public static void main(String[] args) {
            Instant start = Instant.now();
            int sum = 0;
            for (int i = 0; i < 100000000; i++){
                sum += i +1;
            }
            Instant end = Instant.now();
            Duration d1 = Duration.between(start, end);
            Duration d2 = Duration.of(1, ChronoUnit.MILLIS);
            System.out.println(d1); // PT0.0389947S
            System.out.println(d2); // PT0.001S
            int i = d1.compareTo(d2);
            System.out.println(i); // 37994700
            int i1 = d2.compareTo(d1);
            System.out.println(i1); // -33999400
        }
    }
  ```
- Period Examples
- ```java
    package dateandtime;

    import java.time.LocalDate;
    import java.time.Period;

    public class PeriodOperations {
        public static void main(String[] args) {
            LocalDate now = LocalDate.now();
            LocalDate dateOfBirth = LocalDate.of(1996, 3, 10);
            Period period = Period.between(now, dateOfBirth);
            System.out.println(period);
        }
    }
  ```
- DateTimeFormatter Examples. We can only give the date in yyyy-MM-dd format until now, to give in our own format like dd/MM/yyyy then use DateTimeFormatter 
- ```java
    package dateandtime;
    import java.time.LocalDate;
    import java.time.format.DateTimeFormatter;

    public class DateTimeFormatterOperations {
        public static void main(String[] args) {
            LocalDate now = LocalDate.now();
            System.out.println(now); // 2024-07-10
            DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String format = now.format(myFormatter);
            System.out.println(format); // 10/07/2024

            // If suppose we have a string "1996-03-10" then we would have converted it to LocalDate using the parse.
            // but here we now we have string "10/03/1996" and we cannot use the parse method.

            String date = "10/03/1996";
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate parse = LocalDate.parse(date, dateTimeFormatter);
            System.out.println(parse);
        }
    }
  ```

### Optional in Java 8

- To handle null pointer exception optional came into picture.
- ```java
    package optional;

    public class Test {
        public static void main(String[] args) {
            String name = getName(2);
            System.out.println(name.toUpperCase()); // then here we will get NullPointerException
        }

        private static String getName(int id){
            return null; // Here its returning null
        }
    }
  ```
- So
- ```java
    package optional;
    import java.util.Optional;

    public class Test {
        public static void main(String[] args) {
            Optional<String> name = getName(2);
            if(name.isPresent()){
                System.out.println(name.get()); // Ram
            }

            name.ifPresent(x -> System.out.println(x)); // This is consumer // op- Ram
            // Here we haven't use get() becoz if name has value then the value which will get passed to the
            // lambda expression that value will be from the inside of optional only

            // Above line can also be done using operator
            name.ifPresent(System.out::println); // Ram
        }

        //    private static Optional<String> getName(int id){
        //        String name = "Ram";
        //        return Optional.of(name);
        //    }

        private static Optional<String> getName(int id){
            String name = null;
            return Optional.ofNullable(name); // it will check here is it nullable
        }
    }
  ```
- OrELse function in optional
- ```java
    package optional;

    import java.util.Optional;

    public class Test {
        public static void main(String[] args) {
            Optional<String> name = getName(2);
            String nameToBeUsed = name.isPresent() ? name.get() : "NA";
            // Above can be done using orElse() as shoen below
            nameToBeUsed = name.orElse("NA");
            System.out.println(nameToBeUsed); // NA
            String orElseGetName = name.orElseGet(() -> "NA");
            System.out.println(orElseGetName); // Shyam
        }


        private static Optional<String> getName(int id){
            // return Optional.empty(); // this line returns null hence op will be NA
            return Optional.of("Shyam");
        }
    }
  ```
- orElseGet() is a supplier that is gives and does not take anything.
- orElseThrow()
- ```java
    package optional;

    import java.util.NoSuchElementException;
    import java.util.Optional;

    public class Test {
        public static void main(String[] args) {
            Optional<String> name = getName(2);
            String nameThrowExceptiom = name.orElseThrow(() -> new NoSuchElementException());
            // above can also be done using constructor reference as shown below
            String nameThrowExceptiom = name.orElseThrow(NoSuchElementException::new);
            System.out.println(nameThrowExceptiom); // Exception in thread "main" java.util.NoSuchElementException
        }

        private static Optional<String> getName(int id){
            return Optional.empty();
        }
    }
  ```
- Even before taking out the value out from the optional, we can do some work on the value present inside the optional
- ```java
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
  ```