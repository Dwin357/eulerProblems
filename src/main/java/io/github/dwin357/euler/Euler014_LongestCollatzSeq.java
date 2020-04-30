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
 */
public class Euler014_LongestCollatzSeq {
    public static int solve(int startingRange, int endingRange) {
        Map<Integer,Integer> cache = new HashMap<>();
        int bestCount = 0;
        int position;
        for(int i=startingRange; i<=endingRange; i++) {
            position = recurseFunction(i, cache);
            if(position > bestCount) {
                bestCount = position;
            }
        }
        return bestCount;
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
        Integer objResult = result;
        cache.put(objNum, objResult);
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
