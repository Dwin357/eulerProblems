/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dwin357.euler.largestPrime;

import java.util.Set;

/**
 *
 * @author dwin
 */
public class PerFactorArgs {
    private long eval;
    private long base;
    private long quotient;
    private int count;
    private Set<Long> collection;
    private boolean notPrime;

    public long getEval() {
        return eval;
    }

    public void setEval(long eval) {
        this.eval = eval;
    }

    public long getBase() {
        return base;
    }

    public void setBase(long base) {
        this.base = base;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Set<Long> getCollection() {
        return collection;
    }

    public void setCollection(Set<Long> collection) {
        this.collection = collection;
    }

    public boolean isNotPrime() {
        return notPrime;
    }

    public void setNotPrime(boolean isNotPrime) {
        this.notPrime = isNotPrime;
    }



    public long getQuotient() {
        return quotient;
    }

    public void setQuotient(long quotient) {
        this.quotient = quotient;
    }
        
        
}
