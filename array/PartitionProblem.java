package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionProblem {
    public static void main(String[] args) {
      //  int a [] = {1,5,11,5};
        int a [] = {3,1,5,9,12};
        int sum = Arrays.stream(a).sum()/2;
        List<Integer> sumList=  new ArrayList<>();

        boolean isSubset = isSubSetSum(a,0,0,sum,sumList);
        System.out.println(isSubset);

    }

    private static boolean isSubSetSum(int[] a, int index, int sum ,int tagetSum, List<Integer> sumList) {
        if(sum ==tagetSum){
            for(int a1: sumList){
                System.out.print(a1+",");
            }
            return true;
        }
        if(index >a.length-1){
            return false;
        }


        if(sum+a[index] >tagetSum){
            index = index+1;

        }
        else {
            sum = sum+a[index];
            sumList.add(a[index]);
            index = index+1;
        }

        return  isSubSetSum(a,index,sum ,tagetSum,sumList);
    }
}
