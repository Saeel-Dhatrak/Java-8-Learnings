package functionalInterface;
@FunctionalInterface
public interface MyInterface {
    public void sayHello();

    //public void sayBye();

    default void sayGoodMorning(){

    };

    public static void sayGoodNight(){

    };
}
