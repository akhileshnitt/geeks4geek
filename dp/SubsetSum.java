package dp;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum {

    public static void main(String[] args) {
        int a[] = {3,34,4,12,5,2};

        int sum = 18;
        List<Integer> list = new ArrayList<>();
        boolean isFound = subSetSum(a,sum,0,list);
        System.out.println(isFound +" "+list);
    }

    private static boolean subSetSum(int[] a, int sum, int i,List<Integer> list) {

        if(sum ==0){
            return true;
        }

        if( i>a.length-1 || i<0) {

            return false;
        }


        if(sum-a[i] >=0){
          //  list.add(a[i]);
            return subSetSum(a,sum-a[i],i+1,list) || subSetSum(a,sum,i+1,list);
        }

        else {

            return  subSetSum(a, sum, i + 1,list);
        }

    }
}
