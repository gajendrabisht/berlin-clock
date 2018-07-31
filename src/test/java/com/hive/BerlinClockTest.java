package com.hive;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BerlinClockTest {

    @Test
    public void shouldDisplayEvenSeconds() {
        assertThat(new BerlinClock("00:00:00").display(), is("Y\n0000\n0000\n00000000000\n0000"));
    }

    @Test
    public void shouldDisplayOddSeconds() {
        assertThat(new BerlinClock("00:00:01").display(), is("0\n0000\n0000\n00000000000\n0000"));
    }

}