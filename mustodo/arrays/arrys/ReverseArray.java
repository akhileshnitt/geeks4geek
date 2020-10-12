package mustodo.arrays.arrys;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int a[] = {10 ,20 ,30, 40 ,50 ,60};

       for( int k=1;k<=a.length;k++) {
           int temp [] = new int[a.length];
           for(int i=0;i<a.length;i++){
               temp[i] = a[i];
           }

           System.out.println("k ="+k);
           for (int i = 0; i < temp.length; i = i + k) {
           //    if (i < i + k) {
                   reverseIn(temp, i, k);
            //   }
           }
           Arrays.stream(temp).forEach(e -> System.out.print(e + ","));
           System.out.println();
       }
    }

    private static void reverseIn(int[] a,  int startIndex,int k) {
        int endIndex = startIndex+k>a.length-1?a.length-1:startIndex+k-1;
      //  endIndex = endIndex-1;

        for(int i=startIndex;i<=endIndex;i++){
            int temp = a[i];
            a[i] = a[endIndex];
            a[endIndex] = temp;
            endIndex--;

        }
    }
}
