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
public class RecursivePrime {
    
    private static Set<Long> primeSeed;
    private static long highestSeededPrime;
    private static long smallestPrime;
    
    static {
        primeSeed = new HashSet<Long>();
        primeSeed.add(2L);
        primeSeed.add(3L);
        primeSeed.add(5L);
        primeSeed.add(7L);
        
        highestSeededPrime = 7L;
        smallestPrime = 2L;
    }
    
    private static boolean isFactor(long possibleFactor, long base){
        long modulus = base % possibleFactor;
        return (modulus == 0L);
    }
    
    private static boolean isPrime(long base){
        // break conditions
        if(primeSeed.contains(base)){
            return true;
        }
        if(highestSeededPrime > base) {
            return false;
        }
        // evaluation
        for(long eval=base; eval > highestSeededPrime; eval--){
            if(isFactor(eval, base)) {
                if(isPrime(eval)){
                    return false;
                }
            }                
        }
        primeSeed.add(base);
        highestSeededPrime = base;
        return true;
    }
    
    public long largestPrime(long evaluatedBase) {
        long evaluatedFactor = smallestPrime;
        long compFactor = complementFactor(evaluatedFactor, evaluatedBase);
        long largestPrime = -1L;
        long increment = 1L;

        do {
            if(RecursivePrime.isFactor(evaluatedFactor, evaluatedBase)) {
                if(RecursivePrime.isPrime(evaluatedFactor)) {
                    largestPrime = evaluatedFactor;
                }
            }
            evaluatedFactor = evaluatedFactor + increment;
            compFactor = complementFactor(evaluatedFactor, evaluatedBase);
            
        } while(evaluatedFactor < compFactor);
        
        return largestPrime;
    }
    
    private long complementFactor(long factor, long base) {
        return (base / factor);
    }
    
    
}
