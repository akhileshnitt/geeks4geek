package java1.labda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Strategy {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 5, 4, 2, 3, 6, 7, 8, 9, 10, 11, 12);

        //add of list
        int sum1 = sumofList(list, e -> true);
        System.out.println(sum1);
        // add of even number
        int sum2 = sumofList(list, e -> e % 2 == 0);
        System.out.println(sum2);
        // sun of odd number
        int sum = sumofList(list, e -> e % 2 != 0);
        System.out.println(sum);



        //add of list
        int sum4 = sumofListWithPredicate(list, e -> true);
        System.out.println(sum4);

        sum4 = sumofListWithPredicate1(list, e -> true);
        System.out.println(sum4);



        int  maxOddNumber = list.stream()
                .filter(Conditions::isOdd)
                .filter(Conditions::isGreater)
                .filter(Conditions::isLess)
                .max(Comparator.naturalOrder())
                .map(Conditions::squareIt)
                .get();

        System.out.println(maxOddNumber);
        System.out.println("square");

        Function<Integer,String> squareIt = x-> String.valueOf(x*x);
        System.out.println(squareIt.apply(10));


    }

    static class Conditions{

        public boolean isEven(int number){
            return number %2 ==0;
        }
        public static boolean isOdd(int number){
            return number %2 !=0;
        }
        public static boolean isGreater(int number){
            return number>=3;
        }
        public static boolean isLess(int number){
            return number<=11;
        }

        public static int squareIt(int number){
            return number*number;
        }

    }

    private static int sumofListWithPredicate(List<Integer> list, Predicate<Integer> predicate) {

        return list.stream()
                .filter(predicate)
                .reduce(0,Integer::sum);
    }

    private static int sumofListWithPredicate1(List<Integer> list, Function<Integer,Boolean> selector) {

        return list.stream()
                .filter(selector::apply)
                .reduce(0,Integer::sum);
    }


    private static int sumofList(List<Integer> list, Function<Integer, Boolean> selector) {
        int resul = 0;
        for (int i = 0; i < list.size(); i++) {
            if (selector.apply(list.get(i))) {
                resul += list.get(i);
            }
        }
        return resul;
    }

  /*  private static int sumofListPredicate(List<Integer> list, Predicate<Integer> predicate) {
        int resul =0;
        for(int i=0;i<list.size();i++){
            if(predicate.test(list.get(i))) {
                resul += list.get(i);
            }
        }
        return resul;
    }
*/


}
