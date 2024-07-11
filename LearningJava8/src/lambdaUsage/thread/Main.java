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
