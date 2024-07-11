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
        mi.sayHello();
    }

    // Can Override the existing
    @Override
    public void sayHello(){
        A.super.sayHello();
    }

    // Can give our own implementation
    //    @Override
    //    public void sayHello() {
    //        A.super.sayHello();
    //    }
}
