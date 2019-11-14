package array;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "BAA";


        int lcsLength = lcs(s1,s2,s1.length(),0,s2.length(),0);
        System.out.println(lcsLength);


        lcsDP(s2,s1);
    }

    private static void lcsDP(String s1, String s2) {
        String res = "";

        int [][] dp = new int [s1.length()+1][s2.length()+1];

        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    res +=s1.charAt(i-1);
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);

                }
            }
        }

        for(int i=0;i<=s1.length();i++){
            System.out.println();
            for(int j=0;j<=s2.length();j++){
                System.out.print(dp[i][j] +",");

            }
        }
        System.out.println();
        System.out.println(dp[s1.length()][s2.length()]);




        printLCS(dp,s1,s2,s1.length(),s2.length());
    }

    private static void printLCS(int[][] dp, String s1, String s2, int s1Length, int s2Length) {

        int i=s1Length,j=s2Length;
        StringBuffer sb = new StringBuffer();

        while(i>0 && j>0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else{
                if(dp[i-1][j]>dp[i][j-1]){
                    i--;
                }
                else{
                    j--;
                }
            }
        }
        System.out.println(sb.reverse());


    }

    private static int lcs(String s1, String s2, int s1Length, int s1Index, int s2Length,int s2Index) {

        if(s1Length == 0 || s2.length() ==0){
            return 0;
        }
        if(s1Index >s1Length-1 || s2Index >s2Length-1){
            return 0;
        }

        if(s1.charAt(s1Index) == s2.charAt(s2Index)){
            return 1+lcs(s1,s2,s1Length,s1Index+1,s2Length,s2Index+1);
        }
        else {
            return Math.max(lcs(s1,s2,s1Length,s1Index+1,s2Length,s2Index),
                            lcs(s1,s2,s1Length,s1Index,s2Length,s2Index+1));
        }
    }
}
