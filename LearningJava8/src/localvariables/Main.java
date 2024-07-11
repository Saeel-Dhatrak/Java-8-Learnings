package localvariables;

public class Main {
    int b = 2;
    private void doSomething(){

        Employee emp = () -> {
            System.out.println(this.b);
            return "1000";
        };

        Employee emp1 = new Employee() {
            int x = 8;
            @Override
            public String getSalary() {
                System.out.println(this.x);
                return "1000";
            }
        };
    }
}
