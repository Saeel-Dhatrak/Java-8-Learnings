package dateandtime;

import java.time.LocalDate;
import java.time.Period;

public class PeriodOperations {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate dateOfBirth = LocalDate.of(1996, 3, 10);
        Period period = Period.between(now, dateOfBirth);
        System.out.println(period);
    }
}
