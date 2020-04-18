package io.github.dwin357.euler;

import io.github.dwin357.tools.StringSplitter;

/*
  * 2020.04.13:2210 - First thoughts...
  *   So... Observations
  *   - there are zero's in the mix, which will from "dead spots"
  *   - prob-8 was essentially this, but along a single dimension
  *   - if I tick through each position, and at every position
  *       I generate between 3 (top left) and 0 (bottom right)
  *       N-sized subsets where the cur position is the "first" el of
  *       the subset, then I will cover every possible subset.
  *   - if I am processing this stream of sub-sets, it is trivial to
  *       cache the local-max & compare+?update on every tick
  *   - if I know the edge size of the theoretical grid (and it is regular),
  *       I could even represent the data as a single ary using edge-multiplication
  *   - Given that this is the second time I'm seeing this,
  *       a compositional solution with higher re-usability is prob in order
  */
public class Euler011_LargestProductInGrid {

    private final int subSetSz;
    private final int[] masterSet;
    private final int setEdge;


    public Euler011_LargestProductInGrid(int subSetSz, String masterSet, int setEdge) {
        this.subSetSz = subSetSz;
        this.setEdge = setEdge;
        this.masterSet = StringSplitter.splitIntString(" ", masterSet);
    }

    //TODO:
    // add interface to pluck-tools
    // make a producer which ticks through index positions 0 - masterSet.length + delegates to 3 pluckers
    // add generic wrapper class for pluckers so they can pass their outputs to a "board" class
    // "board" class ignores nulls, or else xfrm index-ary into real-data ary (for num @ indexs)
    // "board" class passes data-ary to a cache which maintains data-ary w/ highest product
    // after producer has pushed through all indexs, retreive+return global-maximum from cache


}
