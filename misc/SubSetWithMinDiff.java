package misc;

import java.util.Arrays;

public class SubSetWithMinDiff {

    public static void main(String[] args) {
       // int a []= {3,1,4,2,2,1};
        int a []= {37,43,7,54};
        int sum = Arrays.stream(a).sum();

        int mindiff = findMinDiff(a,a.length,0,sum);
        System.out.println(mindiff);
    }

    private static int findMinDiff(int[] a, int index, int sum1, int sum) {


        if(index ==0){
            return  Math.abs(sum1-sum);
        }
        return Math.min(findMinDiff(a,index-1,sum1+a[index-1],sum-a[index-1]),
                       findMinDiff(a,index-1,sum1,sum));
    }
}
