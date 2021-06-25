package lego.codility;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeTest {

    public static void main(String[] args) {

        ZonedDateTime now1 = ZonedDateTime.now(ZoneId.of("Europe/Warsaw"));




        LocalDateTime now = LocalDateTime.of(now1.getYear(), now1.getMonth(), now1.getDayOfMonth(), now1.getHour(), now1.getMinute(), now1.getSecond(), now1.getNano());



        System.out.println(now.toString());

        //2018-06-06T21:59:36Z
    }
}
