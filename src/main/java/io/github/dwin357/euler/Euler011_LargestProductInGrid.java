package io.github.dwin357.euler;

import io.github.dwin357.tools.plucker.PluckBackslashDiagonal;
import io.github.dwin357.tools.plucker.PluckHorizontal;
import io.github.dwin357.tools.plucker.PluckSlashDiagonal;
import io.github.dwin357.tools.plucker.PluckVertical;
import io.github.dwin357.tools.stream.StreamConsumer;
import io.github.dwin357.tools.stream.consumer.*;
import io.github.dwin357.tools.stream.junction.Switch;
import io.github.dwin357.tools.stream.producer.IntegerProducer;
import io.github.dwin357.tools.struct.Triple;
import io.github.dwin357.tools.struct.Tupal;
import io.github.dwin357.tools.xfrm.StringSplitter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

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

    //TODO:
    // add interface to pluck-tools
    // make a producer which ticks through index positions 0 - masterSet.length + delegates to 3 pluckers
    // add generic wrapper class for pluckers so they can pass their outputs to a "board" class
    // "board" class ignores nulls, or else xfrm index-ary into real-data ary (for num @ indexs)
    // "board" class passes data-ary to a cache which maintains data-ary w/ highest product
    // after producer has pushed through all indexs, retreive+return global-maximum from cache


    public static Integer solve(String masterSet, int edgeSz, int subSetSz, Comparator<Triple<int[],int[],Integer>> select) {
        int[] mSet = StringSplitter.splitIntString(masterSet, " "); // format the input
        LocalExtremaConsumer<Triple<int[],int[],Integer>> terminus = new LocalExtremaConsumer<>(select);
        Switch<Integer> swtch = new Switch<>(
                                        buildProducer(mSet),
                                        buildConsumers(mSet, edgeSz, subSetSz, terminus));

        swtch.flip();
        Triple<int[],int[],Integer> picked = terminus.getCachedElement();
//        System.out.println(Arrays.toString(picked.getOne()));
//        System.out.println(Arrays.toString(picked.getTwo()));
//        System.out.println(picked.getThree());
        return picked.getThree();
    }

    private static IntegerProducer buildProducer(int[] masterSet) {
        return new IntegerProducer(0, masterSet.length);
    }
    private static List<StreamConsumer<Integer>> buildConsumers(int[] masterSet, int edgeSz, int subSetSz, StreamConsumer<Triple<int[],int[],Integer>> terminus) {
        // This feels like a builder pattern...  maybe on the refactor
        Function<Tupal<int[],int[]>,Triple<int[],int[],Integer>> appendProduct = (tupal) ->{
            int[] positions = tupal.getTwo();
            Integer product = 1;
            for(int i=0; i<positions.length; i++) {
                product *= positions[i];
            }
            return new Triple<>(tupal, product);
        };
        XfrmConsumer<Tupal<int[],int[]>,Triple<int[],int[],Integer>> productFinder = new XfrmConsumer<>(appendProduct, terminus);
        AryValueEnricher board = new AryValueEnricher(masterSet, productFinder);
        NullFilter<int[]> filter = new NullFilter<>(board);

        PluckConsumer hor = new PluckConsumer(new PluckHorizontal(edgeSz,edgeSz,subSetSz), filter);
        PluckConsumer ver = new PluckConsumer(new PluckVertical(edgeSz,edgeSz,subSetSz), filter);
        PluckConsumer slsh = new PluckConsumer(new PluckSlashDiagonal(edgeSz,edgeSz,subSetSz), filter);
        PluckConsumer bslh = new PluckConsumer(new PluckBackslashDiagonal(edgeSz,edgeSz,subSetSz), filter);

        return Arrays.asList(hor,ver,slsh,bslh);
    }
}
