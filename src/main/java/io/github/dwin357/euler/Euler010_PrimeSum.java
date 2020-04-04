package io.github.dwin357.euler;

import java.util.HashSet;
import java.util.Set;

public class Euler010_PrimeSum {

    private int limit;
    private Set<Integer> knownPrimes;

    private int highestCheckedPrime;

    public Euler010_PrimeSum(int limit) {
        this.limit = limit;
        this.knownPrimes = new HashSet<>();
        notePrime(2);
        setHighestCheckedPrime(2);
    }

    public int primeSum() {
        int position = 2;
        while(position <= limit) {
            isPrime(position);
            position++;
        }
        return knownPrimes.stream().reduce(0, Integer::sum);
    }

    private boolean isPrime(int num) {
        if(knownPrimes.contains(num)) {
            return true;
        }
        if(num <= highestCheckedPrime) {
            return false;
        }
        return bruteForcePrime(num);
    }

    private boolean bruteForcePrime(int num) {
        setHighestCheckedPrime(num);
        for(Integer knownPrime : knownPrimes) {
            if(isFactor(knownPrime, num)) {
                return false;
            }
        }
        notePrime(num);
        return true;
    }

    private boolean isFactor(int possibleFactor, int baseNum) {
        return baseNum % possibleFactor == 0;
    }

    private void notePrime(int prime) {
        this.knownPrimes.add(prime);
    }

    private void setHighestCheckedPrime(int highestCheckedPrime) {
        this.highestCheckedPrime = highestCheckedPrime;
    }
}
