package io.github.dwin357.euler;

import io.github.dwin357.tools.struct.Histogram;
import io.github.dwin357.tools.xfrm.PrimeDecomposer;

import java.util.Map;

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

    private PrimeDecomposer decomposer;

    public Euler005_SmallestMultiple() {

        this.decomposer = new PrimeDecomposer();
    }

    public int smallestCommonFactor(int rangeStart, int rangeEnd) {
        Histogram<Integer> setOfPrimes = new Histogram<>();
        for(int num=rangeStart; num<=rangeEnd; num++) {
            expandSet(decomposeNumToPrimeHistogram(num), setOfPrimes);
        }
        return multiplyAllFactors(setOfPrimes);
    }

    private Histogram<Integer> decomposeNumToPrimeHistogram(int num) {
        return new Histogram<>(decomposer.decompose(num));
    }

    private void expandSet(Histogram<Integer> newHistogram, Histogram<Integer> existingSet) {
        Integer oldSetValue;
        Integer newSetValue;
        Integer differenec;
        for(Map.Entry<Integer,Integer> newPrime : newHistogram.entrySet()) {
            oldSetValue = existingSet.get(newPrime.getKey());
            newSetValue = newPrime.getValue();
            if(newSetValue > oldSetValue) {
                differenec = newSetValue - oldSetValue;
                existingSet.add(newPrime.getKey(), differenec);
            }
        }
    }

    public int multiplyAllFactors(Histogram<Integer> histogram) {
        if(histogram.isEmpty()) {
            return 0;
        }
        int runningTotal = 1;
        for(Map.Entry<Integer, Integer> factor : histogram.entrySet()) {
            runningTotal *= raiseToPower(factor.getKey(), factor.getValue());
        }
        return runningTotal;
    }

    private int raiseToPower(int base, int power) {
        return (int)Math.floor(Math.pow(base, power));
    }
}
