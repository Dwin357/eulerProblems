package io.github.dwin357.euler;


/*
 * 2020.04.26:1531 - init obs
 *  so the way I am seeing this, I want to
 *   - treat every num as an ary, where we process pos-n of all nums
 *      as "slices" (n:0 -> 49)
 *   - we hold a memo which is the running total of all the slices so far processed (starts @ 0)
 *   - for each slice { sum slice -> add to memo -> count digits of result<break condition> }
 *   - assuming the break condition isn't met, memo*=10 & move to next slice
 *   - assuming the break condition is me, return fist X digits of memo as ans
 *  ...but this leaves open the Q, "how far past the X rtn do you want to keep calculating"?
 *  Logically, if we only care about the first 10 digits of a 50 digit num, calculating the ones
 *  position isn't going to change our ans; the biggest change they could have on the outcome is
 *  900 (100 nums * all having a 9) and so as long as our Xth position is thousandths place or above
 *  these can be ignored.  So the fact the formula is you need to calculate...
 *      nums * 9 -> take scale of num -> this+1 is how many places you need to go past X
 *
 */
public class Euler013_LargeSum {

    public static long solve(String nums) {
        return -1;
    }
}
