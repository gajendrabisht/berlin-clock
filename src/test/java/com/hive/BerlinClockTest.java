package com.hive;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BerlinClockTest {

    @Test
    public void shouldDisplaySecondsEven() {
        assertThat(new BerlinClock("00:00:02").getTime(), is("Y\n0000\n0000\n00000000000\n0000"));
    }

    @Test
    public void shouldDisplaySecondsOdd() {
        assertThat(new BerlinClock("00:00:01").getTime(), is("0\n0000\n0000\n00000000000\n0000"));
    }

    @Test
    public void shouldDisplayHoursEven() {
        assertThat(new BerlinClock("10:00:01").getTime(), is("0\nRR00\n0000\n00000000000\n0000"));
    }

    @Test
    public void shouldDisplayHoursOdd() {
        assertThat(new BerlinClock("11:00:01").getTime(), is("0\nRR00\nR000\n00000000000\n0000"));
    }

    @Test
    public void shouldDisplayMinutesEven() {
        assertThat(new BerlinClock("00:20:01").getTime(), is("0\n0000\n0000\nYYRY0000000\n0000"));
    }

    @Test
    public void shouldDisplayMinutesOdd() {
        assertThat(new BerlinClock("00:21:01").getTime(), is("0\n0000\n0000\nYYRY0000000\nY000"));
    }

}