package functionalInterface;

interface Parent1{
    default void sayHello(){
        System.out.println("hello !");
    }
}
class Child1 implements Parent1 {
    @Override
    public void sayHello() {
        System.out.println("Parent Says Hello !!");
    }
}

public class MyClass{
    public static void main(String[] args){
        Child1 c = new Child1();
        c.sayHello();
    }
}
