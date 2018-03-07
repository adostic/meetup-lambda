package org.adostic.meetup.lambda;

import java.util.function.Function;

public class Intro {
    private static int inc(int i){
        return i + 1;
    }

    public static void main(String[] args) {
        System.out.println(inc(5));

        Function<Integer, Integer> inc = i -> i + 1;
        System.out.println(inc.apply(5));
    }
}
