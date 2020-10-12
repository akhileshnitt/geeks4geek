package mustodo.arrays.arrys;

import java.util.Arrays;

public class ChoclateDist {
    public static void main(String[] args) {
       /* int a[] = {3 ,4 ,1 ,9 ,56 ,7 ,9 ,12};
        int k = 5;*/

        int a[] = {7 ,3, 2, 4 ,9 ,12, 56};
        int k = 3;

        Arrays.sort(a);

        //1 3 4 7 9 9  12  56
        int minDiff = Integer.MAX_VALUE;

        for(int i=0;i<a.length-k;i++){
            int diff = a[i+k-1]-a[i];
            /*if(diff<minDiff)
                minDiff = diff;*/
            minDiff = Math.min(diff,minDiff);
        }
        System.out.println(minDiff);

    }
}
