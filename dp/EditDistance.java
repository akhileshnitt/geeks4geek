package dp;

public class EditDistance {

    public static void main(String[] args) {
        String s1 = "sunday";
        String s2 = "saturday";

        int minDistance = editDistance(s1,s2,s1.length(),s2.length());
        System.out.println(minDistance);
    }

    private static int editDistance(String s1, String s2, int m, int n) {

        if(n==0) return m;
        if(m==0) return n;

        if(s1.charAt(m-1) == s2.charAt(n-1)){
            return editDistance(s1,s2,m-1,n-1);
        }

        return 1+ Math.min(Math.min(editDistance(s1,s2,m,n-1),editDistance(s1,s2,m-1,n)),editDistance(s1,s2,m-1,n-1));
    }
}
