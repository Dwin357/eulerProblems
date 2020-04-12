package io.github.dwin357.euler;

import org.junit.Test;

import static org.junit.Assert.*;

public class Euler009_PythagoreanTipleTest {
/*
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
    @Test
    public void givenExample_345() {
        Euler009_PythagoreanTiple impl = new Euler009_PythagoreanTiple();
        int givenSum = 12;
        int expectedProduct = 60;

        int actualProduct = impl.solve(givenSum);

        assertEquals(expectedProduct, actualProduct);
    }
    
    @Test
    public void givenProblem_unkn() {
        Euler009_PythagoreanTiple impl = new Euler009_PythagoreanTiple();
        int givenSum = 1000;
        int expectedProduct = 60;

        int actualProduct = impl.solve(givenSum);

        assertEquals(expectedProduct, actualProduct);
    }
}