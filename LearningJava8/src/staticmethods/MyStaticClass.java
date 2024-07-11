package staticmethods;

interface A{
    public static void main(String[] args){
        System.out.println("Hello from interface !");
    }
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
        msc.sayBye();
    }
}
