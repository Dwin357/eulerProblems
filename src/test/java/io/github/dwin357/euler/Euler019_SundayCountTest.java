package io.github.dwin357.euler;

import io.github.dwin357.concepts.DayOfWeek;
import org.junit.Test;

import java.text.ParseException;

import static io.github.dwin357.concepts.DayOfWeek.*;
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
    public void mondayPlusFourteenDays_twoSundays() {
        DayOfWeek dayOfWk = MONDAY;
        int numOfDays = 14;
        int expectedCount = 2;
        Euler019_SundayCount impl = new Euler019_SundayCount();

        int actual = impl.countSundays(dayOfWk, numOfDays);

        assertEquals(expectedCount, actual);
    }

    @Test
    public void fridayPlusTwoDays_oneSunday() {
        DayOfWeek dayOfWk = FRIDAY;
        int numOfDays = 2;
        int expectedCount = 1;
        Euler019_SundayCount impl = new Euler019_SundayCount();

        int actual = impl.countSundays(dayOfWk, numOfDays);

        assertEquals(expectedCount, actual);
    }

    @Test
    public void countDays_sevenDays() throws ParseException {
        String startDay = "2020.01.03";
        String endDay = "2020.01.10";
        int expectedCount = 7;
        Euler019_SundayCount impl = new Euler019_SundayCount();

        int actualCount = impl.countDays(startDay, endDay);

        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void run() throws ParseException {
        String startDay = "1901.01.01";
        String endDay = "2000.12.31";
        int expectedCt = 5217; // not right?
        Euler019_SundayCount impl = new Euler019_SundayCount();

        int dayCt = impl.countDays(startDay, endDay);
        int sunCt = impl.countSundays(MONDAY, dayCt);

//        System.out.println(sunCt);
        assertEquals(expectedCt, sunCt);
    }
}