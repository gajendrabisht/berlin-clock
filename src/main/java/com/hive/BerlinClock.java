package com.hive;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BerlinClock {

    public static final String OFF = "0";
    public static final String YELLOW = "Y";
    public static final String RED = "R";
    public static final String NEW_LINE = "\n";
    public static final String BLANK = "";

    private String time;

    public BerlinClock(String standardTime) {
        LocalTime localTime = LocalTime.parse(standardTime, DateTimeFormatter.ISO_TIME);
        this.time = convertToBerlinClockTime(localTime);
    }

    public String displayTime() {
        return this.time;
    }

    private String convertToBerlinClockTime(LocalTime localTime) {
        String seconds = (localTime.getSecond() % 2 == 0) ? YELLOW : OFF;
        String hoursFirstRow = turnOnRowOfLamps(4, localTime.getHour() / 5, RED);
        String hoursSecondRow = turnOnRowOfLamps(4, localTime.getHour() % 5, RED);
        String minutesFirstRow = flipToRedAfterConsecutiveYellows(turnOnRowOfLamps(11, localTime.getMinute() / 5, YELLOW));
        String minutesSecondRow = turnOnRowOfLamps(4, localTime.getMinute() % 5, YELLOW);
        return StringUtils.join(Arrays.asList(seconds, hoursFirstRow, hoursSecondRow, minutesFirstRow, minutesSecondRow), NEW_LINE);
    }

    private String turnOnRowOfLamps(int numberOfLamps, int LampsTurnedOn, String colour) {
        return StringUtils.rightPad(turnOnLamps(LampsTurnedOn, colour), numberOfLamps, OFF);
    }

    private String turnOnLamps(int totalLampsTurnedOn, String colour) {
        return combine(IntStream.range(0, totalLampsTurnedOn).mapToObj(i -> colour).collect(Collectors.toList()));
    }

    private String flipToRedAfterConsecutiveYellows(String time) {
        return StringUtils.replaceAll(time, combine(YELLOW, YELLOW, YELLOW), combine(YELLOW, YELLOW, RED));
    }

    private String combine(String... strings) {
        return StringUtils.join(strings, BLANK);
    }

    private String combine(List<String> strings) {
        return StringUtils.join(strings, BLANK);
    }

}
