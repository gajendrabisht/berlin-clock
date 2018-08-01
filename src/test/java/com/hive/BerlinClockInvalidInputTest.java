package com.hive;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BerlinClockInvalidInputTest {

    private String localTime;

    public BerlinClockInvalidInputTest(String localTime) {
        this.localTime = localTime;
    }

    @Parameterized.Parameters(name = "{index}: {0}")
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {"25:00:00"},
                {"00:60:00"},
                {"00:00:60"},
                {"00:00:-1"},
                {"00:aa:00"},
                {"2x:00:00"},
                {"00:-22:00"},
                {"00:00:00.0"},
                {"00:00:00.000"},
                {"00:00:00:00"},
                {"00:00:00:00:00"},
        });
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentException() {
        new BerlinClock(localTime).getTime();
    }

}