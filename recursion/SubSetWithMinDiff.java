package recursion;

import java.util.Arrays;

public class SubSetWithMinDiff {

    static int diff = Integer.MAX_VALUE;
    public static void main(String[] args) {
        int a [] = {3, 1, 4, 2, 2, 1};
        int sum = Arrays.stream(a).sum();

        findMinDiff(a,0,sum,0);
        System.out.println(diff);
    }

    private static int findMinDiff(int[] a, int sum1,int sum2,int index) {


        if(index == a.length) {
            int diffA = Math.abs(sum1 - sum2);
            if (diffA < diff) {
                diff = diffA;
            }
         //   System.out.println(diff);
            return diff;
        }


        return  Math.min(findMinDiff(a,sum1+a[index],sum2-a[index],index+1),
                findMinDiff(a,sum1,sum2,index+1));
    }
}
