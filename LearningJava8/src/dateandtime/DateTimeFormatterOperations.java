package dateandtime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterOperations {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now); // 2024-07-10
        DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String format = now.format(myFormatter);
        System.out.println(format); // 10/07/2024

        // If suppose we have a string "1996-03-10" then we would have converted it to LocalDate using the parse.
        // but here we now we have string "10/03/1996" and we cannot use the parse method.

        String date = "10/03/1996";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate parse = LocalDate.parse(date, dateTimeFormatter);
        System.out.println(parse);
    }
}
