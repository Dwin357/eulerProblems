package io.github.dwin357.euler;
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
}
