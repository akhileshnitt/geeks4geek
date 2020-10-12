package mustodo.arrays.arrys;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LargestNumber {

    public static void main(String[] args) {
       // int a [] = {3, 30, 34, 5, 9};
        int a [] = {54 ,546, 548 ,60};

       List<Integer> list = Arrays.stream(a).boxed().collect(Collectors.toList());


        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1 +String.valueOf(o2);
                String s2 = o2 +String.valueOf(o1);
               if( Integer.parseInt(s1)>Integer.parseInt(s2)){
                   return -1;
               }
               return 1;
            }
        });

        String s ="";
        for(Integer i:list){
            s+=i;
        }
        System.out.println(s);
    }
}
