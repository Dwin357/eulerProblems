package io.github.dwin357.euler;

/*
 * As near as I can tell, the key here is to be able to efficiently generate
 * a stream of prime numbers ...I don't think there is really any more to it,
 * and the real key is how quickly / easily you can test
 *
 * I'm thinking my prime decomposer is my best bet to id primes (decompose.size() == 1)
 * after that
 *  - start from prime<pos> 3<2>
 *  - ck if pos == desired pos
 *   -- if yes, rtn prime
 *   -- if no, find nxt prime
 *     -- prime +=2
 *     -- ck if prime
 *       -- if no, continue
 *       -- if yes, rtn next prime
 */


import io.github.dwin357.tools.xfrm.PrimeDecomposer;

public class Euler007_10001Prime {
    private PrimeDecomposer primeDecomposer;

    public Euler007_10001Prime() {
        primeDecomposer = new PrimeDecomposer();
    }

    public long getPrimeNumber(int primePosition) {
        Prime prime = getSeedPrime();
        while(prime.position < primePosition) {
            prime = getNextPrime(prime);
        }
        return prime.num;
    }


    private Prime getSeedPrime() {
        return new Prime(2, 3);
    }

    private Prime getNextPrime(Prime currentPrime) {
        long testedNumber = currentPrime.num + 2;
        while(!isPrime(testedNumber)) {
            testedNumber += 2;
        }
        return new Prime(currentPrime.position+1, testedNumber);
    }

    private boolean isPrime(long num) {
        if(num > (long)Integer.MAX_VALUE) {
            throw new RuntimeException("need to use longs");
        }
        return primeDecomposer.decompose((int) num).size() == 1;
    }


    private class Prime {
        int position;
        long num;

        Prime(int pos, long prm) {
            position = pos;
            num = prm;
        }
    }
}
