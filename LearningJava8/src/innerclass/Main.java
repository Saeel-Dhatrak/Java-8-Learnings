package innerclass;

public class Main{
    public static void main(String[] args){
        Employee emp = new Employee() {
            @Override
            public String getSalary() {
                return "100";
            }
            @Override
            public String getDesignation() {
                return "Software Engineer";
            }
        };
    }
}
