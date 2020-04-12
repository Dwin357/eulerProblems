package io.github.dwin357.euler;

import org.junit.Ignore;
import org.junit.Test;

import java.util.function.IntFunction;

import static org.junit.Assert.*;

/*
 * The sum of the squares of the first ten natural numbers is,
 * 1^2+2^2+...+10^2=385
 * The square of the sum of the first ten natural numbers is,
 * (1+2+...+10)^2=55^2=3025
 * Hence the difference between the sum of the squares of the first ten
 * natural numbers and the square of the sum is 3025−385=2640.
 *
 * Find the difference between the sum of the squares of the first one hundred
 * natural numbers and the square of the sum.
 *
 */

public class Euler006_DifSumSqTest {

    @Test
    public void givenExample_1to10_is2640() {
        int st = 1;
        int fin = 10;
        long expected = 2640L;
        Euler006_DifSumSq impl = new Euler006_DifSumSq();

        long actual = impl.difSum(st, fin);

        assertEquals(expected, actual);
    }

    @Test
    public void givenProblem_1to100_isUnknown() {
        int st = 1;
        int fin = 100;
        long expected = 25164150;
        Euler006_DifSumSq impl = new Euler006_DifSumSq();

        long actual = impl.difSum(st, fin);

        assertEquals(expected, actual);
    }

///////////  By Hand Impl  ///////////////
    @Test
    public void sumNum_simpleAdd_100() {
        long expected = 5050;
        int st = 1;
        int fin = 100;
        IntFunction<Integer> f = (i) -> { return i; };
        Euler006_DifSumSq impl = new Euler006_DifSumSq();

        long actual = impl.sumNum(st, fin, f);

        assertEquals(expected, actual);
    }


    @Test
    public void sumNum_simpleAdd() {
        long expected = 55;
        int st = 1;
        int fin = 10;
        IntFunction<Integer> f = (i) -> { return i; };
        Euler006_DifSumSq impl = new Euler006_DifSumSq();

        long actual = impl.sumNum(st, fin, f);

        assertEquals(expected, actual);
    }
    @Test
    public void sumNum_simpleSquare() {
        long expected = 385;
        int st = 1;
        int fin = 10;
        IntFunction<Integer> f = (i) -> { return i * i; };
        Euler006_DifSumSq impl = new Euler006_DifSumSq();

        long actual = impl.sumNum(st, fin, f);

        assertEquals(expected, actual);
    }
    @Test
    public void sumNum_simpleSquare_100() {
        long expected = 338350;
        int st = 1;
        int fin = 100;
        IntFunction<Integer> f = (i) -> { return i * i; };
        Euler006_DifSumSq impl = new Euler006_DifSumSq();

        long actual = impl.sumNum(st, fin, f);

        assertEquals(expected, actual);
    }
    @Test
    public void square_100() {
        long expected = 25_502_500L;
        long given = 5050;

        long actual = given * given;

        assertEquals(expected, actual);
    }

    @Test
    public void simple_by_hand() {
        long expected = 25164150; // this was right...  but is there a better way

        long sumSquared = 25_502_500L;
        long squaresSummed = 338350L;

        long actual = 25_502_500L - 338350L;

        assertEquals(expected, actual);
    }


}