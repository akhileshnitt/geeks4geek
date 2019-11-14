package array;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayDiffSort {
    public static void main(String[] args) {
       /* Integer a[] = {10, 5, 3, 9, 2};
        //5, 9, 10, 3, 2
        int b = 7;*/

        Integer a[] = {2, 6, 8, 3};
        int b = 5;

        Arrays.sort(a,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1-b)<Math.abs(o2-b)){
                    return -1;
                }
                else {

                    return 1;
                }
            }
        });

        for(Integer a1:a)
        System.out.print(a1+",");
    }
}
