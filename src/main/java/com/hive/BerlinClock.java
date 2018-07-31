package com.hive;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class BerlinClock {

    public static final String YELLOW = "Y";
    public static final String OFF = "0";
    public static final String NEW_LINE = "\n";

    private String time;

    public BerlinClock(String standardTime) {
        LocalTime localTime = LocalTime.parse(standardTime, DateTimeFormatter.ISO_TIME);
        this.time = convertToBerlinClockTime(localTime);
    }

    private String convertToBerlinClockTime(LocalTime localTime) {
        String seconds = (localTime.getSecond() % 2 == 0) ? YELLOW : OFF;
        String hours = "0000\n0000";
        String minutes = "00000000000\n0000";
        return StringUtils.join(Arrays.asList(seconds, hours, minutes), NEW_LINE);
    }

    public String display() {
        return this.time;
    }

}
