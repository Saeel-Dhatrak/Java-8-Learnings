package dateandtime;

import java.time.LocalTime;

public class TimeOperations {
    public static void main(String[] args) {
        System.out.println(LocalTime.now());
        LocalTime customTime = LocalTime.of(20, 20);
        System.out.println(LocalTime.parse("20:25:10"));
        LocalTime parsedTime = LocalTime.parse("20:25:10");
        LocalTime now = LocalTime.now();
        if(now.isBefore(customTime)){
            System.out.println("yesss");
        }
        if(now.isAfter(customTime)){
            System.out.println("Han bhai");
        }

    }
}
