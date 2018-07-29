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
 * 
 * I think I have pretty much trimmed all the fat in this solution...
 * but I think FactorCount is easier to understand.  I wish java had a 
 * clearer way to pass lambdas to loops
 */
public class FinalSolution {
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
        PerFactorArgs args = perform(number, (onEach) -> {
            if(isFactor(onEach.getEval(), onEach.getBase())) {
                long quotient = onEach.getBase() / onEach.getEval();                
                onEach.getCollection().add(onEach.getEval());
                onEach.getCollection().add(quotient);
                onEach.setQuotient(quotient);
            }
            if(onEach.getEval() < onEach.getQuotient()) {
                return false;
            } else {
                return true;
            }
        });
        return args.getCollection();
    }
    
    private boolean isFactor(long possibleFactor, long base) {
        return (base % possibleFactor == 0L);
    }
    
    private boolean isPrime(Long number) {
        PerFactorArgs args = perform(number, (onEach) -> {
            int factorCount = onEach.getCount();
            if(isFactor(onEach.getEval(), onEach.getBase())){
                factorCount = factorCount + 1;
            }
            if(factorCount > 2) {
                onEach.setNotPrime(true);
                return true;
            } else {
                onEach.setCount(factorCount);
                return false;
            }
        });
        if(args.isNotPrime()) {
            return false;
        } else {
            return true;
        }
    }

    public PerFactorArgs perform(long number, OnEachFactorRedux onEach) {
        PerFactorArgs args = new PerFactorArgs();
        args.setBase(number);
        args.setQuotient(number);
        args.setCount(0);
        args.setCollection(new HashSet<Long>());
        boolean exit = false;

        for(long factor=1L; factor<number; factor++){
            args.setEval(factor);
            exit = onEach.execute(args);
            if(exit) {
                return args;
            }
        }
        return args;
    }    


}

