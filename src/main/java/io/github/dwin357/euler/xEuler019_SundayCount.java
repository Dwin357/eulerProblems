package io.github.dwin357.euler;

import io.github.dwin357.concepts.DayOfWeek;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// not right?...
public class xEuler019_SundayCount {

    public int countSundays(DayOfWeek dayOfWk, int numOfDays) {
        return (numOfDays+dayOfWk.ordinal()) / 7;
    }

    public int countDays(String firstDay, String lastDay) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        Date start = formatter.parse(firstDay);
        Date end = formatter.parse(lastDay);
        long difOfDays = (end.getTime() - start.getTime()) / (24*60*60*1000);
        return (int) difOfDays;
    }
}
