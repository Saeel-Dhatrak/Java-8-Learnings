package dateandtime;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateTimeOperations {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now); // 2024-07-10T19:34:41.080655300
        LocalDateTime parsedDateTime = LocalDateTime.parse("1996-10-03T20:20:20:038399");
        System.out.println(parsedDateTime); // 2024-04-12T22:10:21
    }
}
