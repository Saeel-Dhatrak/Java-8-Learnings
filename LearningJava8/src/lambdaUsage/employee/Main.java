package lambdaUsage.employee;

public class Main {
    public static void main(String[] args){
        Employee employee = () -> "Robert Downey";
        System.out.println(employee.getName());
    }
}
