package mustodo.arrays.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SwappingPair {
    public static void main(String[] args) {
        /*int a[] ={4 ,1, 2, 1, 1, 2};
        int b[]={3 ,6, 3, 3};*/

        int a[] ={5, 7, 4, 6};
        int b[]={1,2,3,8};

        method1(a, b);
        System.out.println("*******");

        method2(a,b);
    }

    private static void method2(int[] a, int[] b) {
        int sumA = Arrays.stream(a).sum();
        int sumB = Arrays.stream(b).sum();
        int diff = (sumA-sumB)/2;

        /**
         * sumA-a+b  = sumB-b+a
         * sumA-sumB = 2a - 2b
         * a-b = (sumA-sumB)/2
         *
         * a-b = diff;
         *
         * if(a - diff = b )
         * found
         */

        Set<Integer> set = new HashSet<>();
        Arrays.stream(b).forEach(e->set.add(e));

        for(int i=0;i<a.length;i++){
            if(set.contains(a[i] -diff)){
                System.out.println(a[i]+","+(a[i]-diff));
            }
        }

    }

    private static void method1(int[] a, int[] b) {
        int sumA = Arrays.stream(a).sum();
        int sumB = Arrays.stream(b).sum();

        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){
                if(sumA-a[i]+b[j] == sumB-b[j]+a[i]){
                    System.out.println(a[i]+","+b[j]);
                }
            }
        }
    }
}
