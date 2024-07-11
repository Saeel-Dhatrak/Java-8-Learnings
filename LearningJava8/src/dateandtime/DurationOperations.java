package dateandtime;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class DurationOperations {
    public static void main(String[] args) {
        Instant start = Instant.now();
        int sum = 0;
        for (int i = 0; i < 100000000; i++){
            sum += i +1;
        }
        Instant end = Instant.now();
        Duration d1 = Duration.between(start, end);
        Duration d2 = Duration.of(1, ChronoUnit.MILLIS);
        System.out.println(d1); // PT0.0389947S
        System.out.println(d2); // PT0.001S
        int i = d1.compareTo(d2);
        System.out.println(i); // 37994700
        int i1 = d2.compareTo(d1);
        System.out.println(i1); // -33999400
    }
}
