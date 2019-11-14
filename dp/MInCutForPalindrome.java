package dp;

import java.util.Arrays;

public class MInCutForPalindrome {


    public static void main(String[] args) {
        String s = "ababbbabbababa";


        int dp[][] = new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }

        for(int i=0;i<s.length();i++){
            dp[i][i] =0;
        }

        for(int l=2;l<=s.length();l++){
            for(int i=0;i<=s.length()-l;i++){
                int j = l+i-1;

                if(isPalindrome(s,i,j)){
                    dp[i][j]= 0;
                }

                for(int k=i;k<j;k++){
                    int minCut = 1+ dp[i][k]+dp[k+1][j];
                    if(minCut <dp[i][j]){
                        dp[i][j] = minCut;
                    }
                }
            }

        }
        System.out.println(dp[0][s.length()-1]);


    }


    private static boolean isPalindrome(String sub, int i, int j) {

        while(i<=j){
            if(sub.charAt(i) != sub.charAt(j)){
                return false;
            }
            else{
                i++;
                j--;

            }
        }
        return true;
    }

}
