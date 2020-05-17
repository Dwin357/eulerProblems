package io.github.dwin357.euler;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/*
 * 2020.04.29:2054 - first obs
 * First observation, wow that last problem sure resolved fast
 * & a lot simpler than I was making it at first..
 *
 * So, for this one, the presentation suggests an infinite recursive/loop
 * impl with a break condition of "ends in 1"
 *
 * The other the thing I can see (which lends to a recursive I think)
 * is that, once you id that "8 goes to 1 in 3 jumps", you never need
 * to calculate that again, just store val-3 under key-8
 *   so by doing this recursive, we could cache any result before returning it
 *    (which would allow caching at every step up a long call chain)
 *
 * 2020.04.29:2132
 *   - perhaps unsurprisingly, straight recursive led to a SO
 *
 * 2020.05.16:2028
 *  Q 1: where does the SO happen
 *      13->13: fine
 *      1->1_000_000: SO
 *      1->500_000: SO
 *      1->250_000: SO
 *      1->125_000: SO
 *      1->75_000: answer (longest chain was 340)
 *      1->100_000: answer (longest chain was 351)
 *      1->110_000: answer (longest chain was 354)
 *      1->120_000: SO
 *      1->115_000: SO
 *      1->112_000: answer (longest chain was 354)
 *      1->113_000: answer (longest chain was 354)
 *      1->114_000: SO
 *   Q 2: the winning number I can calculate: 106_239 is 354 jumps (best under 113_000)
 *
 *   So...  cacheing is (potentially) causing a SO, so what if we limit the size of the cache?
 *      ... 354 jumps == 230_540 items in cache
 *   Limiting the size of the cache did not allow me to extend the range any...
 *
 */
public class Euler014_LongestCollatzSeq {
    public static int solve(int startingRange, int endingRange) {
        Map<Integer,Integer> cache = new HashMap<>();
        int bestCount = 0;
        int bestI = -1;
        int position;
        for(int i=startingRange; i<=endingRange; i++) {
            position = recurseFunction(i, cache);
            if(position > bestCount) {
                bestCount = position;
                bestI = i;
            }
        }
//        return bestCount;
        return bestI;
    }

    private static int recurseFunction(int num, Map<Integer,Integer> cache) {
        // break
        if(num == 1) {
            return 1;
        }
        // is cached
        Integer objNum = num;
        if(cache.containsKey(objNum)) {
            return cache.get(objNum);
        }
        // is not chached
        int result = recurseFunction(next(num), cache) + 1; // +1 b/c "next" was called
        //// only cache the first 230_540 entries (which seems to be my SO limit)
        if(cache.size() <= 230_540) {
            Integer objResult = result;
            cache.put(objNum, objResult);
        }
        return result;
    }

    private static int next(int num) {
        if(isEven(num)) {
            return onEven.apply(num);
        } else {
            return onOdd.apply(num);
        }
    }


    private static final Function<Integer,Integer> onEven = (n) -> {
        int autoUnbox = n;
        return autoUnbox/2;
    };
    private static final Function<Integer,Integer> onOdd = (n) -> {
        int autoUnbox = n;
        return (autoUnbox * 3) + 1;
    };
    private static boolean isEven(int num) {
        return num % 2 == 0;
    }
}
