package io.github.dwin357.euler;

public class Euler001_FizzBuzzSum {
    private int limit;

    private final int FIZZ = 3;
    private final int BUZZ = 5;

    public Euler001_FizzBuzzSum(int limit) {
        this.limit = limit;
    }

    public int fizzBuzzSum() {
        int sum = 0;
        int num = 1;
        while (num < limit) {
            if(isFizzBuzzNumber(num)) {
                sum+= num;
            }
            num++;
        }
        return sum;
    }

    private boolean isFizzBuzzNumber(int num) {
        return (num % FIZZ == 0) || (num % BUZZ == 0);
    }
}
