package org.adostic.meetup.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LightweightStrategy {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(totalValues(list, e -> true));
        System.out.println(totalValues(list, e -> e % 2 == 0));
        System.out.println(totalValues(list, e -> e % 2 != 0));
    }

    private static int totalValues(List<Integer> list, Predicate<Integer> selector) {
        return list.stream()
                .filter(selector)
                .reduce(0, Integer::sum);
    }
}

class LightweightStrategyNonFunctional{
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(totalValues(list));
        System.out.println(totalEvenValues(list));
        System.out.println(totalOddValues(list));
    }

    private static int totalValues(List<Integer> list) {
        int result = 0;
        for (int e : list) {
            result += e;
        }
        return result;
    }

    private static int totalEvenValues(List<Integer> list) {
        int result = 0;
        for (int e : list) {
            if(e % 2 == 0)
                result += e;
        }
        return result;
    }

    private static int totalOddValues(List<Integer> list) {
        int result = 0;
        for (int e : list) {
            if(e % 2 == 0)
                result += e;
        }
        return result;
    }
}
