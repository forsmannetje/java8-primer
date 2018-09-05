package nl.forsmannetje.java8.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TimeDemo {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    public static void main(String[] args) {
        localDate();
        localDateTime();
        zonedDateTime();
        parseAndFormat();
    }

    public static void localDate() {
        LocalDate birthday = LocalDate.of(1985, Month.JANUARY, 30);
        LocalDate now = LocalDate.now();
        LocalDate nextYear = now.plusYears(1);

        System.out.println(now);
        System.out.println(nextYear);
        System.out.println(birthday);

        // Will fail
        now.plus(24, ChronoUnit.HOURS);
    }

    public static void localDateTime() {
        LocalDate now = LocalDate.now();
        LocalDateTime dateTimeNow = now.atTime(LocalTime.now());

        System.out.println(dateTimeNow);
        System.out.println(dateTimeNow.minusHours(1));
    }

    public static void zonedDateTime() {
        LocalDateTime now = LocalDateTime.now();
        ZonedDateTime zonedNow = now.atZone(ZoneId.systemDefault());

        System.out.println(zonedNow);
        System.out.println(ZonedDateTime.now(ZoneId.of("America/New_York")));

        System.out.println(zonedNow.withZoneSameInstant(ZoneId.of("UTC+01:00")));
        System.out.println(zonedNow.withZoneSameInstant(ZoneId.of("Z")));

        System.out.println(OffsetDateTime.now(ZoneId.ofOffset("", ZoneOffset.ofHours(2))));
    }

    public static void parseAndFormat() {
        ZonedDateTime now = ZonedDateTime.now();

        System.out.println(now.format(FORMATTER));

        ZonedDateTime.parse("2018-07-26T09:38:52.309+02:00", FORMATTER);
    }
}
