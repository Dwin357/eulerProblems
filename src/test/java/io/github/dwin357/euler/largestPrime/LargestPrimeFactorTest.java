/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.dwin357.euler.largestPrime;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dwin
 */
public class LargestPrimeFactorTest {
    
//    private LargestPrimeFactor classUnderTest;
//    private RecursivePrime classUnderTest;
//    private FactorCount classUnderTest;
    private FinalSolution classUnderTest;
    
    public LargestPrimeFactorTest() {
    }
    
    
    @Before
    public void setUp() {
//        classUnderTest = new LargestPrimeFactor();
//        classUnderTest = new RecursivePrime();
//        classUnderTest = new FactorCount();
        classUnderTest = new FinalSolution();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void given13195_rtn29() {
        long input = 13195L;
        long expected = 29L;
        long actual = classUnderTest.largestPrime(input);
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void given600851475143_rtnX() {
        long input = 600851475143L;
        long expected = 3L; // not the acutal answer
        long actual = classUnderTest.largestPrime(input);
        
        assertEquals(expected, actual);
    }
}
