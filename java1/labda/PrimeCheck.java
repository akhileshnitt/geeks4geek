package java1.labda;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class PrimeCheck {

    public static void main(String[] args) {

        int number = 11;
        System.out.println(isPrime(number));
    }

   /* private static boolean isPrime(int number) {

        if(number<2) return false;
        for(int i=2;i<number;i++){
            if( number % i ==0) return false;
        }
        return true;
    }*/

    private static boolean isPrime(int number) {
        IntPredicate predicate = e->number%e==0;



        return number>1 && IntStream.range(2,number).noneMatch(predicate);
    }
}
