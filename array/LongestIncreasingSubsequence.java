package array;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int a [] = {50,3,10,7,40,30};

       // int a [] = {2,3};

        int dp [] = new int [a.length];
        Arrays.fill(dp,1);
        for(int i=1;i<a.length;i++){
            for(int j=0;j<i;j++){
                if(a[i] >a[j]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
        }

        System.out.println(dp[a.length-1]);
    }
}
