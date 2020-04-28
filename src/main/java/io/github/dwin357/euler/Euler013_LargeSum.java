package io.github.dwin357.euler;


/*
 * 2020.04.26:1531 - init obs
 *  so the way I am seeing this, I want to
 *   - treat every num as an ary, where we process pos-n of all nums
 *      as "slices" (n:0 -> 49)
 *   - we hold a memo which is the running total of all the slices so far processed (starts @ 0)
 *   - for each slice { sum slice -> add to memo -> count digits of result<break condition> }
 *   - assuming the break condition isn't met, memo*=10 & move to next slice
 *   - assuming the break condition is met, return fist X digits of memo as ans
 *  ...but this leaves open the Q, "how far past the X rtn do you want to keep calculating"?
 *  Logically, if we only care about the first 10 digits of a 50 digit num, calculating the ones
 *  position isn't going to change our ans; the biggest change they could have on the outcome is
 *  900 (100 nums * all having a 9) and so as long as our Xth position is thousandths place or above
 *  these can be ignored.  So the formula is you need to calculate...
 *      nums-ct * 9 -> take scale -> this+1 is how many places you need to go past X
 *
 * 2020.04.27:1902 - outline
 *  goal: take in N integers of size L, and return first X digits of sum
 *  - integer producer 0 -> (L-1)
 *      * needs L @ init
 *  - breaker ... terminal? -> terminal brk (producer >= X+2)
 *  - switch <breaker,splitter>
 *  - splitter
 *  - S.1 simple terminal (for brk)
 *  - S.2 pluck vertical consumer
 *      * needs N & L @ init
 *  - refactor "AryValueEnricher" to be a generic ary-reference (make sure old test still passes)
 *      * needs master-set (as single arg) @ init
 *  - collection consumer <need to write>
 *      * needs seed balue at init
 *
 *   *************
 *  This will need setup (parsing various values for int)
 *  & tear down (taking first X digits of cached value)...
 *  How can you do that?
 *
 */
public class Euler013_LargeSum {

    public static long solve(String nums) {
        return -1;
    }
}
