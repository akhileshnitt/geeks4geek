package java1.labda;

import java.util.function.IntBinaryOperator;

public class BegiinerFunctional {

    public static void main(String[] args) {
        int a=10;int b=15;

       MyFunctionalInterface sum = (p,q) ->p+q;
        System.out.println(sum.add(a,b));
        IntBinaryOperator  predefined = (p,q) ->p - q;
        System.out.println(predefined.applyAsInt(a,b));

    }
}
