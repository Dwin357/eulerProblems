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
 */
public class LargestPrimeFactor {

    private Set<Long> identifiedPrimes;
    
    public LargestPrimeFactor() {
        Set<Long> primeSeed = new HashSet<>();
        primeSeed.add(2L);
        primeSeed.add(3L);
        primeSeed.add(5L);
        primeSeed.add(7L);
        setIdentifiedPrimes(primeSeed);
    }
    
    /*
    logical premise, there are two aspects to this problem
    - identifying whether a number is prime
    - identifying factors of a number
    
    */
    public long largestPrime(long evaluated) {
        long largestPrime = 1L;
        for(long possible=2L; possible<evaluated; possible++){
            if(isNotFactor(possible, evaluated)) {
                continue;
            }            
            if(isPrime(possible)){
                largestPrime = possible;
            }
        }
        return largestPrime;
    }
    
    private boolean isPrime(long evaluated){
        if(isKnownPrime(evaluated)){
            return true;
        }
        return isPrimeBruteForce(evaluated);
    }
    
    private boolean isPrimeBruteForce(long evaluated){
        for(long possible=2L; possible < evaluated; possible++){
            if(isNotFactor(possible, evaluated)) {
                continue;
            }
            if(isKnownPrime(possible)){
                return false;
            }
        }
        getIdentifiedPrimes().add(evaluated);
        return true;
    }
    
    private boolean isKnownPrime(long possiblePrime){
        return getIdentifiedPrimes().contains(possiblePrime);
    }

    private boolean isFactor(long possibleFactor, long base){
        long modulus = base % possibleFactor;
        return (modulus == 0L);
    }
    
    private boolean isNotFactor(long possibleFactor, long base) {
        return !isFactor(possibleFactor, base);
    }
    
    protected Set<Long> getIdentifiedPrimes() {
        return identifiedPrimes;
    }

    private void setIdentifiedPrimes(Set<Long> identifiedPrimes) {
        this.identifiedPrimes = identifiedPrimes;
    }
    
    
}
