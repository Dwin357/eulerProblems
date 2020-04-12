package io.github.dwin357.euler;

import java.util.function.IntFunction;

/*
 * so...  this really sounds like huberis talking, but this doesn't seem that bad to me
 * go from x -> y maintaining 2 running totals :: += num & += (num * num)
 * then at the end square the linear total and subtract
 */
public class Euler006_DifSumSq {
    public long difSum(int st, int fin) {
        long sum = sumNum(st, fin, i -> {return i;});
        long sqSum = sum * sum;
        long sumSq = sumNum(st, fin, i ->{ return i * i;});
        return sqSum - sumSq;
    }

    public long sumNum(int st, int fin, IntFunction<Integer> f) {
        long runningTotal = 0;
        for(int i=st; i<=fin; i++) {
            runningTotal += f.apply(i);
        }
        return runningTotal;
    }


}
