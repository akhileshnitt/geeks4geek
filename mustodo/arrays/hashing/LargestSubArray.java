package mustodo.arrays.hashing;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArray {


    public static void main(String[] args) {
        int a [] ={15, -2, 2, -8, 1, 7, 10, 23};

        int larget = largestSubArray(a);
       System.out.println(larget);

        int larget1 = largestSubArray1(a);
        System.out.println(larget1);
    }

    private static int largestSubArray1(int[] a) {
        Map<Integer,Integer> map = new HashMap<>();

        int sum=0;
        int longest =0;
        for(int i=0;i<a.length;i++){
            sum = sum+a[i];
            if(map.get(sum) == null){
                map.put(sum,i);
            }
            else{
                int length = i- map.get(sum);
                if(length >longest){
                    longest = length;
                }
            }
        }
        return longest;

    }

    private static int largestSubArray(int[] a) {

        int maxLength  = Integer.MIN_VALUE;

        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(isSumZero(a,i,j)){
                    if((j-i) >maxLength){
                        maxLength = j-i+1;
                    }
                }
            }
        }
        return maxLength == Integer.MIN_VALUE ?0:maxLength;
    }

    private static boolean isSumZero(int[] a, int i, int j) {
        int sum =0;
        for(int k=i;k<=j;k++){
            sum +=a[k];
        }
        return sum ==0;
    }
}
