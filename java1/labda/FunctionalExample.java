package java1.labda;

import java.util.function.Function;

public class FunctionalExample {

    public static void main(String[] args) {
        Function<Integer,Double> half = e->e/2.0;
        Function<Integer,Double> triple = e->e*3.0;



        System.out.println(half.andThen(null).apply(10));
    }
}
