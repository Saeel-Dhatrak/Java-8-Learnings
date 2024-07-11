package dateandtime;

import java.time.Instant;

public class InstantOperations {
    public static void main(String[] args) {
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println(currentTimeMillis); // 1720622851327
        // Above line tells total milliseconds from the date 1 jaunuary 1970 midnight UTC
        Instant now = Instant.now();
        System.out.println(now); // 2024-07-10T14:47:31.328097700Z
        // This gives total nonoseconds from the date 1 jaunuary 1970 midnight UTC

    }
}
