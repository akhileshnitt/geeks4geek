package mustodo.arrays.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestContigous {

    public static void main(String[] args) {
        int a [] = {2, 6, 1, 9, 4, 5, 3};

       // int a[] = {1, 9, 3, 10, 4 ,20, 2};
      //  method1(a);
        method2(a);
    }

    private static void method2(int[] a) {

        int minElement = findMin(a);
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<a.length;i++){
            if(a[i] != minElement) set.add(a[i]);
        }

        int largest =1;
        int j=0;
        while(j<a.length){
            if(set.contains(largest+1)){
                largest = largest+1;
            }
            j++;
        }
        System.out.println(largest);
    }

    private static int findMin(int[] a) {
        int minimum = a[0];
        for(int i=1;i<a.length;i++){
            if(a[i]<minimum){
                minimum = a[i];
            }
        }
        return minimum;
    }

    private static void method1(int[] a) {
        Arrays.sort(a);

        int intialElement = a[0];
        int largest =1 ;
        for(int i=1;i<a.length;i++){
            if(intialElement+1 == a[i]){
                intialElement = a[i];
                largest = largest+1;
            }
        }
        System.out.println(largest);
    }
}
