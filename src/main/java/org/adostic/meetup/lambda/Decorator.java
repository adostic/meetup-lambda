package org.adostic.meetup.lambda;

import java.awt.*;
import java.util.function.Function;
import java.util.stream.Stream;

class DecoratorIntro {
    public static void main(String[] args) {
        Function<Integer, Integer> inc = i -> i + 1;
        System.out.println(inc.apply(5));

        Function<Integer, Integer> doubleIt = i -> i * 2;
        System.out.println(doubleIt.apply(5));

        int temp = inc.apply(5);
        System.out.println(doubleIt.apply(5));

        System.out.println(inc.andThen(doubleIt).apply(5));

        System.out.println(inc.compose(doubleIt).apply(5));

    }
}

class Camera {
    private Function<Color, Color> filter;
    public Camera(Function<Color, Color> ... filters) {
        setFilters(filters);
    }

    private void setFilters(Function<Color,Color>[] filters) {
        filter = Stream.of(filters)
            .reduce(Function.identity(), Function::andThen);
    }

    public Color snap(Color color) {
        return filter.apply(color);
    }
}

public class Decorator {
    private static void printSnap(Camera camera){
        System.out.println(camera.snap(new Color(125, 125, 125)));
    }

    public static void main(String[] args) {
        printSnap(new Camera());

        printSnap(new Camera(Color::brighter));
        printSnap(new Camera(Color::darker));

        printSnap(new Camera(Color::brighter, Color::darker));
    }
}


