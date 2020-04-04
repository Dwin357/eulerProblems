package io.github.dwin357.euler;

import io.github.dwin357.concepts.DaysOfWeek;
import org.junit.Test;

import static io.github.dwin357.concepts.DaysOfWeek.*;
import static org.junit.Assert.*;

/*
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
    April, June and November.
    All the rest have thirty-one,
    Saving February alone,
    Which has twenty-eight, rain or shine.
    And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 *
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 *
 *
 */

public class Euler019_SundayCountTest {



    @Test
    public void mondayPlusFifteenDays_twoSundays() {
        DaysOfWeek dayOfWk = MONDAY;
        int numOfDays = 15;
        int expectedCount = 2;
        Euler019_SundayCount impl = new Euler019_SundayCount();

        int actual = impl.countSundays(dayOfWk, numOfDays);

        assertEquals(actual, expectedCount);
    }
}