package io.github.dwin357.euler;

import io.github.dwin357.tools.struct.Triple;

import java.util.function.Predicate;

/*
 * so the way I am seeing this is we have all these dif rules
 *  - a < b < c
 *  - a+b+c = X
 *  - a^2 + b^2 = c^2
 * and essentially what we are trying to do is find the intersection
 * between them...
 *
 * the part that is less obvious to me is that, in order to brute-force
 * this, I need to generate a stream of [a,b,c], and I'm not super clear
 * on how to do this (there is no logical start location).
 *
 * 2020.04.12:2011 - so I now have a producer which generates a stream
 * of triples.  I think this basically covers what I had in mind.
 * My next thought is to create
 *  - a "consumer" which just pulls 1 object (should be simple)
 *  - a "filter" which throws elements out and "repulls" (like the consumer)
 */
public class Euler009_PythagoreanTiple {
    private Impl impl;

    public Euler009_PythagoreanTiple() {
        impl = new Impl();
    }

    public int solve(int givenSum) {
        Filter strm = impl.getFullImpl(givenSum);
        Triple<Integer,Integer,Integer> trip = strm.getNext();
//        System.out.println(trip);
        Integer product = trip.getOne() * trip.getTwo() * trip.getThree();
        return product;
    }

    public TripleProducer getProducer(int lim) {
        return impl.getProducer(lim);
    }

    public Filter getOrderFilter(Upstream upstream) {
        return impl.getOrderFilter(upstream);
    }

    public Filter getPythagFilter(Upstream upstream) {
        return impl.getPythagFilter(upstream);
    }

    public Filter getSumFilter(Upstream upstream, int lim) {
        return impl.getSumFilter(upstream, lim);
    }

    public class Impl {

        public Filter getOrderFilter(Upstream upstream) {
            return new Filter(upstream, possible ->{
                return (possible.getOne() >= possible.getTwo())
                        || (possible.getTwo() >= possible.getThree());
            });
        }
        public Filter getSumFilter(Upstream upstream, int sum) {
            return new Filter(upstream, possible ->{
                Integer total = possible.getOne() + possible.getTwo() + possible.getThree();
                return !total.equals(new Integer(sum));
            });
        }

        public Filter getPythagFilter(Upstream upstream) {
            return new Filter(upstream, possible ->{
                Integer aSq = possible.getOne() * possible.getOne();
                Integer bSq = possible.getTwo() * possible.getTwo();
                Integer cSq = possible.getThree() * possible.getThree();
                return (aSq + bSq) != cSq;
            });
        }

        public TripleProducer getProducer(int lim) {
            return new TripleProducer(lim);
        }

        public Filter getFullImpl(int lim) {
            return getPythagFilter(
                        getOrderFilter(
                            getSumFilter(
                                getProducer(lim),
                                lim)));
        }
    }



    public interface Upstream {
        Triple<Integer, Integer, Integer> getNext();
    }

    public class Filter implements Upstream {

        private Upstream upstream;
        private Predicate<Triple<Integer, Integer, Integer>> filter;

        public Filter(Upstream upstream, Predicate<Triple<Integer,Integer,Integer>> filter) {
            this.upstream = upstream;
            this.filter = filter;
        }
        @Override
        public Triple<Integer, Integer, Integer> getNext() {
            Triple<Integer,Integer,Integer> possible;
            do {
                possible = upstream.getNext();
            } while (filter.test(possible));
            return possible;
        }
    }

    public class TripleProducer implements Upstream {

        private final int limit;
        private int a;
        private int b;
        private int c;
        private boolean outOfBounds;

        public TripleProducer(int lim) {
            limit = lim;
            outOfBounds = false;
            a = 0;
            b = 0;
            c = 0;
        }

        @Override
        public Triple<Integer, Integer, Integer> getNext() {
            if(!hasNext()) {
                throw new RuntimeException("Out of bounds");
            }
            Triple<Integer, Integer, Integer> next = new Triple<>(a, b, c);
            increment();
            return next;
        }
        public boolean hasNext() {
            return !outOfBounds;
        }

        private boolean pastLimit() {
            return (a+b+c) > limit;
        }

        private void increment() {
            c++;
            if(pastLimit()) {
                c = 0;
                b++;
            }
            if(pastLimit()) {
                b = 0;
                a++;
            }
            if(pastLimit()) {
                outOfBounds = true;
            }
        }
    }


}
