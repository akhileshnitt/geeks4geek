package dp;

public class LCS {

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2= "GXTXAYB";

        int lcsLength = lcs(s1,s2,s1.length(),s2.length());
        System.out.println(lcsLength);
    }

    private static int lcs(String s1, String s2,int m,int n) {

        if(m ==0||n==0) return 0;

        if(s1.charAt(s1.length() - m) == s2.charAt(s2.length() -n)){
            return 1+ lcs(s1,s2,m-1,n-1);
        }
        return Math.max( lcs(s1,s2,m-1,n),lcs(s1,s2,m,n-1));
    }
}
