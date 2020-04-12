package io.github.dwin357.tools;

import java.util.ArrayList;
import java.util.List;

 /*
  * Credit where credit is due, I totally ripped this class
  * off from the internet.  This isn't the site I used, but is
  * the exact same impl so I will use it as my citation
  * https://www.tutorialspoint.com/Prime-factors-in-java
  */

public class PrimeDecomposer {
    public List<Integer> decompose(int given) {
        List<Integer> primes = new ArrayList<>();
        int remainder = extractTwos(given, primes);
        return extractOddPrimes(remainder, primes);
    }

    private int extractTwos(int num, List<Integer> primes) {
        while (num%2 == 0) {
            primes.add(2);
            num /= 2;
        }
        return num;
    }

    private List<Integer> extractOddPrimes(int num, List<Integer> primes) {
        for(int i=3; i <= Math.sqrt(num); i+= 2) {
            while(num%i == 0) {
                primes.add(i);
                num /= i;
            }
        }
        if(num > 2) {
            primes.add(num);
        }
        return primes;
    }

}
