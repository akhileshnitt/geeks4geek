package mustodo.arrays.greedy;

import java.util.Arrays;

public class MinimizeTheSumProduct {

    public static void main(String[] args) {
        /*int a[] = {3, 1, 1};
        int b [] = {6, 5, 4};
*/

        int a[] = {6 ,1 ,9 ,5 ,4};
        int b [] = {3, 4, 8, 2, 4};


        Arrays.sort(a);
        Arrays.sort(a);
        Arrays.sort(b);

        int sum =0;
        for(int i=0;i<a.length;i++){
            sum +=  a[i]*b[b.length-1-i];
        }

        System.out.println(sum);
    }

}
