package justpractice;

public class One {
    public static void main(String[] args){
        try{
            System.out.println(10/0);
        }catch (ArithmeticException e){
            System.out.println(10/0);
            System.out.println("abcd");
        }
        finally {
            String s = null;
            System.out.println(s.length());
            System.out.println("dfgj");
        }
    }
}
