package com.hive;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
public class BerlinClockExhaustiveTest {

    private String localTime;
    private String expectedBerlinClockTime;

    public BerlinClockExhaustiveTest(String localTime, String expectedBerlinClockTime) {
        this.localTime = localTime;
        this.expectedBerlinClockTime = expectedBerlinClockTime;
    }

    @Parameterized.Parameters(name = "{index}: {0} = {1}")
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                // seconds
                {"00:00:00", "Y\n0000\n0000\n00000000000\n0000"},
                {"00:00:01", "0\n0000\n0000\n00000000000\n0000"},
                {"00:00:02", "Y\n0000\n0000\n00000000000\n0000"},
                {"00:00:03", "0\n0000\n0000\n00000000000\n0000"},
                // hours
                {"01:00:00", "Y\n0000\nR000\n00000000000\n0000"},
                {"02:00:00", "Y\n0000\nRR00\n00000000000\n0000"},
                {"03:00:00", "Y\n0000\nRRR0\n00000000000\n0000"},
                {"04:00:00", "Y\n0000\nRRRR\n00000000000\n0000"},
                {"05:00:00", "Y\nR000\n0000\n00000000000\n0000"},
                {"06:00:00", "Y\nR000\nR000\n00000000000\n0000"},
                {"07:00:00", "Y\nR000\nRR00\n00000000000\n0000"},
                {"08:00:00", "Y\nR000\nRRR0\n00000000000\n0000"},
                {"09:00:00", "Y\nR000\nRRRR\n00000000000\n0000"},
                {"10:00:00", "Y\nRR00\n0000\n00000000000\n0000"},
                {"11:00:00", "Y\nRR00\nR000\n00000000000\n0000"},
                {"12:00:00", "Y\nRR00\nRR00\n00000000000\n0000"},
                {"13:00:00", "Y\nRR00\nRRR0\n00000000000\n0000"},
                {"14:00:00", "Y\nRR00\nRRRR\n00000000000\n0000"},
                {"15:00:00", "Y\nRRR0\n0000\n00000000000\n0000"},
                {"16:00:00", "Y\nRRR0\nR000\n00000000000\n0000"},
                {"17:00:00", "Y\nRRR0\nRR00\n00000000000\n0000"},
                {"18:00:00", "Y\nRRR0\nRRR0\n00000000000\n0000"},
                {"19:00:00", "Y\nRRR0\nRRRR\n00000000000\n0000"},
                {"20:00:00", "Y\nRRRR\n0000\n00000000000\n0000"},
                {"21:00:00", "Y\nRRRR\nR000\n00000000000\n0000"},
                {"22:00:00", "Y\nRRRR\nRR00\n00000000000\n0000"},
                {"23:00:00", "Y\nRRRR\nRRR0\n00000000000\n0000"},
                // 24 hour is the same as 00 hour.. auto converted by java time (ambiguous in berlin clock format)
                {"24:00:00", "Y\n0000\n0000\n00000000000\n0000"},
                // minutes
                {"00:01:00", "Y\n0000\n0000\n00000000000\nY000"},
                {"00:02:00", "Y\n0000\n0000\n00000000000\nYY00"},
                {"00:03:00", "Y\n0000\n0000\n00000000000\nYYY0"},
                {"00:04:00", "Y\n0000\n0000\n00000000000\nYYYY"},
                {"00:05:00", "Y\n0000\n0000\nY0000000000\n0000"},
                {"00:06:00", "Y\n0000\n0000\nY0000000000\nY000"},
                {"00:07:00", "Y\n0000\n0000\nY0000000000\nYY00"},
                {"00:08:00", "Y\n0000\n0000\nY0000000000\nYYY0"},
                {"00:09:00", "Y\n0000\n0000\nY0000000000\nYYYY"},
                {"00:10:00", "Y\n0000\n0000\nYY000000000\n0000"},
                {"00:11:00", "Y\n0000\n0000\nYY000000000\nY000"},
                {"00:12:00", "Y\n0000\n0000\nYY000000000\nYY00"},
                {"00:13:00", "Y\n0000\n0000\nYY000000000\nYYY0"},
                {"00:14:00", "Y\n0000\n0000\nYY000000000\nYYYY"},
                {"00:15:00", "Y\n0000\n0000\nYYR00000000\n0000"},
                {"00:16:00", "Y\n0000\n0000\nYYR00000000\nY000"},
                {"00:17:00", "Y\n0000\n0000\nYYR00000000\nYY00"},
                {"00:18:00", "Y\n0000\n0000\nYYR00000000\nYYY0"},
                {"00:19:00", "Y\n0000\n0000\nYYR00000000\nYYYY"},
                {"00:20:00", "Y\n0000\n0000\nYYRY0000000\n0000"},
                {"00:21:00", "Y\n0000\n0000\nYYRY0000000\nY000"},
                {"00:22:00", "Y\n0000\n0000\nYYRY0000000\nYY00"},
                {"00:23:00", "Y\n0000\n0000\nYYRY0000000\nYYY0"},
                {"00:24:00", "Y\n0000\n0000\nYYRY0000000\nYYYY"},
                {"00:25:00", "Y\n0000\n0000\nYYRYY000000\n0000"},
                {"00:26:00", "Y\n0000\n0000\nYYRYY000000\nY000"},
                {"00:27:00", "Y\n0000\n0000\nYYRYY000000\nYY00"},
                {"00:28:00", "Y\n0000\n0000\nYYRYY000000\nYYY0"},
                {"00:29:00", "Y\n0000\n0000\nYYRYY000000\nYYYY"},
                {"00:30:00", "Y\n0000\n0000\nYYRYYR00000\n0000"},
                {"00:31:00", "Y\n0000\n0000\nYYRYYR00000\nY000"},
                {"00:32:00", "Y\n0000\n0000\nYYRYYR00000\nYY00"},
                {"00:33:00", "Y\n0000\n0000\nYYRYYR00000\nYYY0"},
                {"00:34:00", "Y\n0000\n0000\nYYRYYR00000\nYYYY"},
                {"00:35:00", "Y\n0000\n0000\nYYRYYRY0000\n0000"},
                {"00:36:00", "Y\n0000\n0000\nYYRYYRY0000\nY000"},
                {"00:37:00", "Y\n0000\n0000\nYYRYYRY0000\nYY00"},
                {"00:38:00", "Y\n0000\n0000\nYYRYYRY0000\nYYY0"},
                {"00:39:00", "Y\n0000\n0000\nYYRYYRY0000\nYYYY"},
                {"00:40:00", "Y\n0000\n0000\nYYRYYRYY000\n0000"},
                {"00:41:00", "Y\n0000\n0000\nYYRYYRYY000\nY000"},
                {"00:42:00", "Y\n0000\n0000\nYYRYYRYY000\nYY00"},
                {"00:43:00", "Y\n0000\n0000\nYYRYYRYY000\nYYY0"},
                {"00:44:00", "Y\n0000\n0000\nYYRYYRYY000\nYYYY"},
                {"00:45:00", "Y\n0000\n0000\nYYRYYRYYR00\n0000"},
                {"00:46:00", "Y\n0000\n0000\nYYRYYRYYR00\nY000"},
                {"00:47:00", "Y\n0000\n0000\nYYRYYRYYR00\nYY00"},
                {"00:48:00", "Y\n0000\n0000\nYYRYYRYYR00\nYYY0"},
                {"00:49:00", "Y\n0000\n0000\nYYRYYRYYR00\nYYYY"},
                {"00:50:00", "Y\n0000\n0000\nYYRYYRYYRY0\n0000"},
                {"00:51:00", "Y\n0000\n0000\nYYRYYRYYRY0\nY000"},
                {"00:52:00", "Y\n0000\n0000\nYYRYYRYYRY0\nYY00"},
                {"00:53:00", "Y\n0000\n0000\nYYRYYRYYRY0\nYYY0"},
                {"00:54:00", "Y\n0000\n0000\nYYRYYRYYRY0\nYYYY"},
                {"00:55:00", "Y\n0000\n0000\nYYRYYRYYRYY\n0000"},
                {"00:56:00", "Y\n0000\n0000\nYYRYYRYYRYY\nY000"},
                {"00:57:00", "Y\n0000\n0000\nYYRYYRYYRYY\nYY00"},
                {"00:58:00", "Y\n0000\n0000\nYYRYYRYYRYY\nYYY0"},
                {"00:59:00", "Y\n0000\n0000\nYYRYYRYYRYY\nYYYY"},
        });
    }

    @Test
    public void shouldDisplayExpectedTime() {
        assertThat(new BerlinClock(localTime).getTime(), is(expectedBerlinClockTime));
    }

}