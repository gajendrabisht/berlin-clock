package com.hive;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class BerlinClock {

    private String time;

    public BerlinClock(String standardTime) {
        LocalTime localTime = LocalTime.parse(standardTime, DateTimeFormatter.ISO_TIME);
        this.time = convertToBerlinClockTime(localTime);
    }

    private String convertToBerlinClockTime(LocalTime locaTime) {
        return null;
    }

    public String display() {
        return this.time;
    }

}
