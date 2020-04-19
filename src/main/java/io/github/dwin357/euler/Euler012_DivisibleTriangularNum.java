package io.github.dwin357.euler;

/*
 * 2020.04.19:1056 - first observations
 * ...so now that I have the stream architecture setup,
 * x - it seems pretty trivial to create a "triangle num producer"...
 *
 * However this will force a new producer-component (working-name "breaker")
 *   This is needed b/c the trig-prod is an infinite stream/series
 *     so the breaker is a way short the infinite run
 *   This also then begs the question: the breaker needs to be constantly cking
 *     some measurement, and break flow when a certain condition is met...
 *  x - This implies to me another new consumer-component (working-name "terminal")
 *     which essentially implements a peek function
 *
 * x - Also, I clearly need a "factorer" which accepts a num and returns a list of factors
 *
 * Once we have those factor lists, it should be trivial to count the list size
 *
 * This list sz can then be pushed to a terminal (which will trip the breaker when 15 is hit)
 *
 *
 */
public class Euler012_DivisibleTriangularNum {
}
