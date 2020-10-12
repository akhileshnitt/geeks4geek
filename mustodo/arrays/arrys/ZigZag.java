package mustodo.arrays.arrys;

import java.util.Arrays;

public class ZigZag {
    public static void main(String[] args) {
        int a [] = {4, 3, 7, 8, 6, 2, 1};

        Arrays.sort(a);
        // 1 2 3 4 6 7 8
        // 2 1 4 3 7 6 8

        swapInPair(a);

        Arrays.stream(a).forEach(e-> System.out.print(e+","));

    }

    private static void swapInPair(int[] a) {

        for(int i=0;i<a.length-1;i=i+2){
            int temp = a[i];
            a[i] = a[i+1];
            a[i+1] = temp;
        }
    }
}
