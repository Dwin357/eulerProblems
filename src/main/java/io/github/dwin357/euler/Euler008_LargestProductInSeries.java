package io.github.dwin357.euler;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * so, what I am thinking here is...
 *  - split string into an array
 *  - start at position in ary so that the first x are the first set
 *  - calculate the product of that set
 *  - tick through the ary
 *   -- ck value of new/current set
 *   -- if more than cache, replace cache
 *  - return cached value
 *
 *  So, had an insight -- b/c of the product of the set, any set which has
 *   a 0 in it is functionally dropped...
 *  Under this idea, the new strategy would be
 *   -- build a set of all indexs
 *   -- loop ary once, id-zeros
 *      - where zero is found, remove indexs +/- size from the zero-id pos
 *   -- loop remaining zeros in set (should be much smaller) to calc product
 *
 * ...so in the end, this just boiled down to making good sub-obj
 * w/ propper tests & building up behavior.  Live and learn.
 */
public class Euler008_LargestProductInSeries {
    public long solve(int size, String masterSet) {
        Impl impl = getImpl(size, masterSet);
        return impl.getMaxSubSet().getProduct();
    }

    public Impl getImpl(int size, String masterSet) {
        return new Impl(size, masterSet);
    }

    public SubSet getSubSet(int[] set) {
        return new SubSet(set);
    }

    public class Impl {
        int[] masterSet;
        int setSize;
        SubSet[] subSets;
        public Impl(int sz, String stringSet) {
            setSize = sz;
            masterSet = getMasterSet(stringSet);
            subSets = getSubSet(sz, masterSet);
        }

        private int[] getMasterSet(String stringSet) {
            String[] strings = stringSet.split("");
            int[] mstrSet = new int[strings.length];
            for(int i=0; i<strings.length; i++) {
                mstrSet[i] = Integer.parseInt(strings[i]);
            }
            return mstrSet;
        }

        private SubSet[] getSubSet(int sz, int[] masterSet) {
            SubSet[] sets = new SubSet[masterSet.length - sz + 1];
            for(int i=0; i < sets.length; i++) {
                sets[i] = new SubSet(i, sz, masterSet);
            }
            return sets;
        }

        public SubSet getMaxSubSet() {
            SubSet max = subSets[0];
            SubSet current;
            for(int i=1; i<subSets.length; i++) {
                current = subSets[i];
                if(max.getProduct() < current.getProduct()) {
                    max = current;
                }
            }
            return max;
        }
    }

    public class SubSet {
        int[] subSet;
        Long process;

        public SubSet(int[] set) {
            subSet = set;
        }
        public SubSet(int strt, int sz, int[] masterSet) {
            subSet = new int[sz];
            int pos = 0;
            for(int i=strt; i<strt+sz; i++) {
                subSet[pos] = masterSet[i];
                pos++;
            }
        }
        public long getProduct() {
            if(process == null) {
                long sum = 1;
                for(int i=0; i<subSet.length; i++) {
                    sum *= subSet[i];
                }
                process = sum;
            }
            return process;
        }
        @Override
        public String toString() {
            return Arrays.toString(subSet);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            SubSet subSet1 = (SubSet) o;

            return Arrays.equals(subSet, subSet1.subSet);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(subSet);
        }
    }
}
