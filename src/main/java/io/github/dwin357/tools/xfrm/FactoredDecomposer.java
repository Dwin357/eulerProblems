package io.github.dwin357.tools.xfrm;

import java.util.HashSet;
import java.util.Set;

public class FactoredDecomposer {

    public Set<Integer> decompose(int given) {
        Set<Integer> factors = new HashSet<>();
        int posibleFactor = 1;
        int corespondingFactor = given;
        while(posibleFactor <= corespondingFactor) {
            if(isFactor(posibleFactor, given)) {
                factors.add(posibleFactor);
                factors.add(corespondingFactor);
            }
            posibleFactor++;
            corespondingFactor = given / posibleFactor;
        }
        return factors;
    }

    private boolean isFactor(int num, int base) {
        return base % num == 0;
    }
}
