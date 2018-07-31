package com.hive;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BerlinClock {

    public static final String OFF = "0";
    public static final String YELLOW = "Y";
    public static final String RED = "R";
    public static final String NEW_LINE = "\n";

    private String time;

    public BerlinClock(String standardTime) {
        LocalTime localTime = LocalTime.parse(standardTime, DateTimeFormatter.ISO_TIME);
        this.time = convertToBerlinClockTime(localTime);
    }

    private String convertToBerlinClockTime(LocalTime localTime) {
        String seconds = (localTime.getSecond() % 2 == 0) ? YELLOW : OFF;
        String hoursFirstRow = turnOnRowOfLamps(4, localTime.getHour() / 5, RED);
        String hoursSecondRow = turnOnRowOfLamps(4, localTime.getHour() % 5, RED);
        String minutes = "00000000000\n0000";
        return StringUtils.join(Arrays.asList(seconds, hoursFirstRow, hoursSecondRow, minutes), NEW_LINE);
    }

    public String turnOnRowOfLamps(int numberOfLamps, int LampsTurnedOn, String colour) {
        return StringUtils.rightPad(turnOnLamps(LampsTurnedOn, colour), numberOfLamps, OFF);
    }

    public String turnOnLamps(int totalLampsTurnedOn, String colour) {
        return StringUtils.join(IntStream.range(0, totalLampsTurnedOn).mapToObj(i -> colour).collect(Collectors.toList()), "");
    }

    public String display() {
        return this.time;
    }

}
