package org.adostic.meetup.lambda;

import java.util.Arrays;
import java.util.List;

public class InternalExternal {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) % 2 == 0)
                sum += list.get(i) * 2;
        }
        System.out.println(sum);

        sum = 0;
        for (Integer e : list) {
            if (e % 2 == 0)
                sum += e * 2;
        }
        System.out.println(sum);

        sum = list.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }
}
