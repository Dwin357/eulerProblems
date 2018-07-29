/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dwin357.euler.largestPrime;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author dwin
 * First working solution
 */
public class FactorCount {

    public long largestPrime(long evaluatedBase) {
        Set<Long> factors = getFactors(evaluatedBase);
        Long largestPrimeFactor = -1L;
        for(Long factor : factors) {
            if(largestPrimeFactor < factor) {
                if(isPrime(factor)) {
                    largestPrimeFactor = factor;
                }
            }
        }
        return largestPrimeFactor;
    }
    
    private Set<Long> getFactors(long number) {
        Set<Long> factors = new HashSet<Long>();
        Long divisor = 1L;
        Long dividend = number;
        do {
            if(isFactor(divisor, number)) {
                dividend = number / divisor;
                factors.add(divisor);
                factors.add(dividend);
            }
            divisor++;
        } while (divisor < dividend);

        return factors;                
    }
    
    private boolean isFactor(long possibleFactor, long base) {
        return (base % possibleFactor == 0L);
    }
    
    private boolean isPrime(Long number) {
        Set<Long> factors = new HashSet<Long>();
        for(long factor=1L; factor<number; factor++){
            if(isFactor(factor, number)) {
                factors.add(factor);
                if(factors.size() > 2) {
                    return false;
                }
            }
        }
        return true;
    }
    
}
