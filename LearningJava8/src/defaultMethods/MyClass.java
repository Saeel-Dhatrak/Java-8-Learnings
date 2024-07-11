package defaultMethods;

interface Parent{
    default void sayHello(){
        System.out.println("hello !");
    }
}
class Child implements Parent {
    @Override
    public void sayHello() {
        System.out.println("Parent Says Hello !!");
    }
}

