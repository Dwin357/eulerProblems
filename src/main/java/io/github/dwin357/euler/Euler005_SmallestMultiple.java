package io.github.dwin357.euler;

/*
 * So ran the given number (2520) through my prime decomposer and I got this [2, 2, 2, 3, 3, 5, 7]
 * Which I think is interesting b/c every number 2-10 can be built from a subset of those factors
 *
 * as a consequence of this, the approach that I can think of is
 * - create an (initially empty) superset of factors
 * -for each num-X in [2 -> n]
 *  -- decompose X into factor list
 *  -- ck that superset of factors contains all listed factors (if not, add to superset until true)
 * - multiple all factors in the superset together
 */
public class Euler005_SmallestMultiple {

    public int smallestCommonFactor(int rangeStart, int rangeEnd) {
        return 0;
    }
}
