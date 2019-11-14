package recursion;

import java.util.Arrays;

public class KSubSetWithEqualSum {

    public static void main(String[] args) {
        int a [] = {1,2,4,5,3,3};
        int k=3;

        boolean isKSubsetSum = isKSubsetSum(a,k);
        System.out.println(isKSubsetSum);
    }

    private static boolean isKSubsetSum(int[] a, int k) {

        if(k ==1){
            return true;
        }

       int arraySum =  Arrays.stream(a).sum();
       if(arraySum %k !=0){
           return false;
       }

       int subSetArray [] = new int[k];
       boolean [] taken = new boolean[a.length];
       int subsetSum = arraySum/k;

       int currIndex = 0;
       int lastIndex = a.length-1;
       subSetArray[currIndex] = a[lastIndex];
       taken[lastIndex] = true;

       return  isKSubsetSumRec(a,lastIndex,subSetArray,currIndex,taken,subsetSum,k);

    }

    private static boolean isKSubsetSumRec(int[] a, int lastIndex, int[] subSetArray, int currIndex, boolean[] taken, int subsetSum, int k) {

        if(subSetArray[currIndex] == subsetSum){
            if(currIndex == k-2){
                return true;
            }

            return isKSubsetSumRec(a,lastIndex,subSetArray,currIndex+1,taken,subsetSum,k);
        }

        else{

            for(int i=lastIndex;i>=0;i--){
                if(taken[i]) {
                    continue;
                }
                else {
                    int tempSum = subSetArray[currIndex]+a[i];
                    if(tempSum <= subsetSum){
                        subSetArray[currIndex] = subSetArray[currIndex]+a[i];
                        taken[i] = true;
                        return isKSubsetSumRec(a,i,subSetArray,currIndex,taken,subsetSum,k);
                    }

                    subSetArray[currIndex] = subSetArray[currIndex] - a[i];
                    taken[i] = false;

                }
            }
        }
        return false;
    }

}
