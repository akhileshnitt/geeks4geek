package misc;

import java.util.ArrayList;
import java.util.List;

public class SubSetSum {

    public static void main(String[] args) {
        int a[] = {3, 34, 4, 12, 5, 2};

        int sum = 13;

        List<Integer> out = new ArrayList<>();
        boolean found = subsetSum(a, sum, 0, 0);
        System.out.println(found);
    }



    private static boolean subsetSum(int[] a, int sum,int targetSum , int index) {

        if(targetSum == sum) {
            System.out.println("found");
            return true;
        }


        if(targetSum > sum || index >=a.length)  return false;

       return subsetSum(a,sum,targetSum+a[index],index+1)||
        subsetSum(a,sum,targetSum,index+1);


    }
}
