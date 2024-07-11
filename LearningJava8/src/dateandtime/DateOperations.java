package dateandtime;

import java.time.LocalDate;
import java.time.Month;

public class DateOperations {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now); // 2024-07-10
        LocalDate birthDate = LocalDate.of(1996, 3, 10);
        System.out.println(birthDate); // 1996-03-10
        int dayOfMonth = now.getDayOfMonth();
        Month month = now.getMonth();
        int year = now.getYear();
        System.out.println(dayOfMonth); // 10
        System.out.println(month); // JULY
        System.out.println(year); // 2024
    }
}
