package dateandtime;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class ZonedDateTimeOperations {
    public static void main(String[] args) {
        ZonedDateTime indiaTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println(indiaTime); // 2024-07-10T20:11:07.932647300+05:30[Asia/Kolkata]
        ZonedDateTime americaTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(americaTime); // 2024-07-10T10:41:07.934705200-04:00[America/New_York]
        System.out.println(indiaTime.getZone());
    }
}
