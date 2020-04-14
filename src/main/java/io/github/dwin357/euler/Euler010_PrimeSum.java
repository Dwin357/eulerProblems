package io.github.dwin357.euler;

import io.github.dwin357.tools.PrimeDecomposer;

import java.util.HashSet;
import java.util.Set;

public class Euler010_PrimeSum {

    private int limit;
    private Set<Integer> knownPrimes;
    private PrimeDecomposer decomp;

    public Euler010_PrimeSum(int limit) {
        this.limit = limit;
        this.knownPrimes = new HashSet<>();
        this.decomp = new PrimeDecomposer();
        buildPrimeList(limit);
    }

    public long primeSum() {
        long sum = 0;
        for(Integer prime : knownPrimes) {
            sum += prime.longValue();
        }
        return sum;
    }

    private void buildPrimeList(int limit) {
        knownPrimes.add(2);
        int position = 3;
        while(limit >= position) {
            if(isPrime(position)) {
                knownPrimes.add(position);
            }
            position += 2;
        }
    }

    private boolean isPrime(int num) {
        return decomp.decompose(num).size() == 1;
    }
}
